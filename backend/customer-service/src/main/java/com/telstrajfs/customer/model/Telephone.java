package com.telstrajfs.customer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Telephone {

	@Id
	private int telephoneId;
	private long telephoneNumber;
	private int countryCode;
	public Telephone() {
		
	}
	public Telephone(int telephoneId, long telephoneNumber, int countryCode) {
		super();
		this.telephoneId = telephoneId;
		this.telephoneNumber = telephoneNumber;
		this.countryCode = countryCode;
	}
	public int getTelephoneId() {
		return telephoneId;
	}
	public void setTelephoneId(int telephoneId) {
		this.telephoneId = telephoneId;
	}
	public long getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(long telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public int getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}
	@Override
	public String toString() {
		return "Telephone [telephoneId=" + telephoneId + ", telephoneNumber=" + telephoneNumber + ", countryCode="
				+ countryCode + "]";
	}
	
	
	
}
