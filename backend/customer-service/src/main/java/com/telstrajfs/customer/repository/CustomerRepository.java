package com.telstrajfs.customer.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.telstrajfs.customer.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	@Transactional
	@Modifying
	@Query("update Customer c set c.customerName=?1 , c.city=?2 , c.country=?3 where"
			+ " c.customerId=?4")
	int updateCustomer(String customerName, String city, String country, int customerId);

}
