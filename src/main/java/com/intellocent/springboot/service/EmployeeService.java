package com.intellocent.springboot.service;

import java.util.List;

import com.intellocent.springboot.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public Employee save(Employee theEmployee);

	public void deleteById(int theId);
	
	public List<Employee> searchBy(String theName);
}
