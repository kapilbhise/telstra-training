package com.telstrajfs.employeewebflux.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telstrajfs.employeewebflux.model.Employee;
import com.telstrajfs.employeewebflux.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("")
	public  List<Employee> getAllEmployees(){
		System.out.println("Hello Before...");
		List<Employee> empList= employeeService.getAllEmployees();
		System.out.println("Hello After...");
		return empList;
	}
	
	@GetMapping("/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		return employeeService.getEmployeeById(employeeId).get();
	}
	
	
	@PostMapping("")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
		employeeService.saveEmployee(employee);
		return new ResponseEntity<String>("Employee with id: "+employee.getEmployeeId()+"saved to db", HttpStatus.CREATED);
		
	}
	
}
