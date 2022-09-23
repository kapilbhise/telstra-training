package com.telstrajfs.customer.service;

import java.util.List;
import java.util.Optional;



import com.telstrajfs.customer.model.Customer;


public interface CustomerService {
	
	public Optional<Customer> getCustomerById(int customerId);
	public List<Customer> getAllCustomers();
	public void addCustomer(Customer customer);
	public void deleteCustomerById(int customerId);
	public void updateCustomer(String customerName, String city, String country, int customerId);
	
	
}
