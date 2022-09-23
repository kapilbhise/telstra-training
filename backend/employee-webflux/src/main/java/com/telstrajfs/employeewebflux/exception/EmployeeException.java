package com.telstrajfs.employeewebflux.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class EmployeeException {

	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<String> customerNotFound(EmployeeNotFoundException e){
		return new ResponseEntity<String>("Employee Not found...",HttpStatus.NOT_FOUND);
	}
}
