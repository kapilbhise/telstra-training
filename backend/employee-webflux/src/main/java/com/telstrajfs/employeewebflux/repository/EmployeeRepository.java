package com.telstrajfs.employeewebflux.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.telstrajfs.employeewebflux.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	@Transactional
	@Modifying
	@Query("update Employee e set e.name=?1 ,e.designation=?2 , e.salary=?3 where"
			+ " e.employeeId=?4")
	int updateEmployee(String name, String designation, int salary, int employeeId);

}
