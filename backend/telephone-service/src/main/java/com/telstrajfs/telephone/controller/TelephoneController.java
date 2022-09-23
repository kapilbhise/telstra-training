package com.telstrajfs.telephone.controller;

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


import com.telstrajfs.telephone.exception.TelephoneNotFoundException;
import com.telstrajfs.telephone.model.Telephone;
import com.telstrajfs.telephone.service.TelephoneService;

@RestController
@RequestMapping("/telephone")
public class TelephoneController {
	@Autowired
	private TelephoneService telephoneService;

	@GetMapping("/{telephoneId}")
	public Telephone getTelephone(@PathVariable int telephoneId) {
		Optional<Telephone> custOpt = telephoneService.getTelephoneById(telephoneId);
		if (custOpt.isEmpty()) {
			throw new TelephoneNotFoundException();
		}
		return custOpt.get();

	}

	@GetMapping("")
	public List<Telephone> getAllTelephones() {
		return telephoneService.getAllTelephones();

	}

	@PostMapping("")
	public ResponseEntity<String> saveCustomer(@RequestBody Telephone telephone) {
		telephoneService.addTelephone(telephone);
		return new ResponseEntity<>("New telephone added with id:" + telephone.getTelephoneId(), HttpStatus.OK);

	}

	@DeleteMapping("/{telephoneId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int telephoneId) {
		Optional<Telephone> custOpt = telephoneService.getTelephoneById(telephoneId);
		if (custOpt.isEmpty()) {
			throw new TelephoneNotFoundException();
		}
		telephoneService.deleteTelephoneById(telephoneId);
		return new ResponseEntity<>("telephone deleted with id: "+telephoneId,HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<String> updateCustomer( @RequestBody Telephone updatedTelephone){
		int telephoneId= updatedTelephone.getTelephoneId();
		Optional<Telephone> custOpt = telephoneService.getTelephoneById(telephoneId);
		if (custOpt.isEmpty()) {
			throw new TelephoneNotFoundException();
		}
		telephoneService.updateTelephone(updatedTelephone.getTelephoneNumber(), updatedTelephone.getCountryCode(), telephoneId);
		return new ResponseEntity<>("telephone updatedTelephone with Id: "+telephoneId,HttpStatus.OK);
	}

}
