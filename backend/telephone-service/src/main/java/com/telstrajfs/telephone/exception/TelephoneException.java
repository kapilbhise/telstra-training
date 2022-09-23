package com.telstrajfs.telephone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class TelephoneException {
	@ExceptionHandler(value = TelephoneNotFoundException.class)
	public ResponseEntity<String> customerNotFound(TelephoneNotFoundException e){
		return new ResponseEntity<String>("Telephone Not found...",HttpStatus.NOT_FOUND);
	}

}
