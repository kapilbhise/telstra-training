package com.telstrajfs.employeewebflux.exception;

public class EmployeeNotFoundException extends RuntimeException {
	public  EmployeeNotFoundException() {
		
	}
	public EmployeeNotFoundException(String msg) {
		super(msg);
	}
}
	