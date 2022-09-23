package com.telstrajfs.telephone.exception;

public class TelephoneNotFoundException extends RuntimeException {
	public TelephoneNotFoundException() {

	}

	public TelephoneNotFoundException(String msg) {
		super(msg);
	}
}
