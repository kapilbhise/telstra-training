package com.telstrajfs.employeewebflux.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telstrajfs.employeewebflux.exception.EmployeeNotFoundException;
import com.telstrajfs.employeewebflux.model.Employee;
import com.telstrajfs.employeewebflux.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository= employeeRepository;
		
	}

	@Override
	public Optional<Employee> getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> empOpt=employeeRepository.findById(employeeId);
		if(empOpt.isEmpty()) {
			throw new EmployeeNotFoundException();
		}
		return empOpt;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
		
	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee>  empOpt=employeeRepository.findById(employeeId);
		
		if(empOpt.isEmpty()) {
			throw new EmployeeNotFoundException();
		}
		employeeRepository.deleteById(employeeId);
	}

	@Override
	public void updateEmployee(int employeeId, Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee>  empOpt=employeeRepository.findById(employeeId);
		if(empOpt.isEmpty()) {
			throw new EmployeeNotFoundException();
		}
		employeeRepository.updateEmployee(employee.getName(), employee.getDesignation(), employee.getSalary(),employeeId);
	}

}
