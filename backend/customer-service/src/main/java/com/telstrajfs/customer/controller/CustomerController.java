package com.telstrajfs.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.telstrajfs.customer.exception.CustomerNotFoundException;
import com.telstrajfs.customer.model.Customer;
import com.telstrajfs.customer.model.Telephone;
import com.telstrajfs.customer.service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	private String baseUrl="http://telephone-service/telephone";

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient webClient;
	
	
	
	@GetMapping("/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Optional<Customer> custOpt = customerService.getCustomerById(customerId);
		if (custOpt.isEmpty()) {
			throw new CustomerNotFoundException();
		}
		return custOpt.get();

	}

	@GetMapping("")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();

	}

	@PostMapping("")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return new ResponseEntity<>("New customer added with id:" + customer.getCustomerId(), HttpStatus.OK);

	}

	@DeleteMapping("/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int customerId) {
		Optional<Customer> custOpt = customerService.getCustomerById(customerId);
		if (custOpt.isEmpty()) {
			throw new CustomerNotFoundException();
		}
		customerService.deleteCustomerById(customerId);
		return new ResponseEntity<>("Customer deleted with id: "+customerId,HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<String> updateCustomer( @RequestBody Customer updatedCustomer){
		int customerId=updatedCustomer.getCustomerId();
		Optional<Customer> custOpt = customerService.getCustomerById(customerId);
		if (custOpt.isEmpty()) {
			throw new CustomerNotFoundException();
		}
		customerService.updateCustomer(updatedCustomer.getCustomerName(), updatedCustomer.getCity(), updatedCustomer.getCountry(), customerId);
		return new ResponseEntity<>("Customer updated with Id: "+customerId,HttpStatus.OK);
	}
	
//	micro service call to telephone service
	@GetMapping("/telephone/{telephoneId}")
	public Telephone getTelephoneById(@PathVariable int telephoneId) {
//		ResponseEntity<Telephone> telephone=restTemplate.getForEntity(baseUrl+"/"+telephoneId, Telephone.class);
		
		System.out.println("Before get...");
		Telephone telephone=webClient.get()
								.uri("/"+telephoneId)
								.retrieve()
								.bodyToMono(Telephone.class)
								.block();
		System.out.println(telephone);
		System.out.println("After get...");
		
		return telephone;
	}
	
	// get all telephones data
	@GetMapping("/telephone")
	public Flux<Telephone> getAllTelephones(){
//		List<Telephone> telephones=(List<Telephone>)restTemplate.getForObject(baseUrl, List.class);
		Flux<Telephone> telephones=webClient.get().retrieve().bodyToFlux(Telephone.class);
		return telephones;
	}
	
	//post the telephone
	@PostMapping("/telephone")
	public ResponseEntity<String> addTelephone(@RequestBody Telephone telephone){
		String response=restTemplate.postForObject(baseUrl, telephone, String.class);
		return new ResponseEntity<String> (response, HttpStatus.OK);
		
	}
		
	
	

}
