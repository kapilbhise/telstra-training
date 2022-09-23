package com.telstrajfs.employeewebflux.service;

import java.util.List;
import java.util.Optional;

import com.telstrajfs.employeewebflux.model.Employee;

public interface EmployeeService {
	
	Optional<Employee> getEmployeeById(int employeeId);
	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	void deleteEmployeeById(int employeeId);
	void updateEmployee(int employeeId, Employee employee);
}
