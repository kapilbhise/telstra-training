package com.telstrajfs.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerException {

	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<String> customerNotFound(CustomerNotFoundException e){
		return new ResponseEntity<String>("Customer Not found...",HttpStatus.NOT_FOUND);
	}
}
