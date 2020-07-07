package com.intellocent.springboot.dao;

import java.util.List;

import com.intellocent.springboot.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public Employee save(Employee theEmployee);

	public void deleteById(int theId);
}