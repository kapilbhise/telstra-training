package com.telstrajfs.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telstrajfs.customer.model.Customer;
import com.telstrajfs.customer.repository.*;

@Service
public class CustomerServiceImpl  implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Optional<Customer> getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return (List<Customer>)customerRepository.findAll();
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
		
	}

	@Override
	public void deleteCustomerById(int customerId) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(customerId);
		
	}

	@Override
	public void updateCustomer(String customerName, String city, String country, int customerId) {
		// TODO Auto-generated method stub
		customerRepository.updateCustomer(customerName, city, country, customerId);
		
	}

	

}
