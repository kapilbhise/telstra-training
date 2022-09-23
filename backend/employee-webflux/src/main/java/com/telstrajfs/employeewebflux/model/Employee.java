package com.telstrajfs.employeewebflux.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Employee {

	@Id
	private int employeeId;
	private String name, designation;
	private int salary;
	public Employee () {
		
	}
	public Employee(int employeeId, String name, String designation, int salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", designation=" + designation + ", salary="
				+ salary + "]";
	}
	
	
}
