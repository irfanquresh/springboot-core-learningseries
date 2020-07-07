package com.intellocent.springboot.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intellocent.springboot.dao.EmployeeDAO;
import com.intellocent.springboot.entity.Employee;
import com.intellocent.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(@Qualifier("employeeServiceImpl") EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{theId}")
	public Employee findById(@PathVariable int theId) {
		Employee mEmployee = employeeService.findById(theId);

		if (mEmployee == null) {
			throw new RuntimeException("Employee id not found - " + theId);
		}

		return mEmployee;
	}

	@PostMapping("/employees")
	public Employee save(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}

	@PutMapping("/employees")
	public Employee update(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}

	@DeleteMapping("/employees/{theId}")
	public String update(@PathVariable int theId) {

		Employee mEmployee = employeeService.findById(theId);

		if (mEmployee == null) {
			throw new RuntimeException("Employee id not found - " + theId);
		}
		employeeService.deleteById(theId);

		return "Success";
	}

}