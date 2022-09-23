package com.telstrajfs.customer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	private int customerId;
	private String customerName;
	private String city;
	private String country;
	public Customer () {
		
	}
	public Customer(int customerId, String customerName, String city, String country) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.city = city;
		this.country = country;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", city=" + city + ", country="
				+ country + "]";
	}
	
	

}
