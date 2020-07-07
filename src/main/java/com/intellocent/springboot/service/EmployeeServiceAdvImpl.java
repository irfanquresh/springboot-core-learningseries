package com.intellocent.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intellocent.springboot.entity.Employee;
import com.intellocent.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceAdvImpl implements EmployeeService {

	private EmployeeRepository theRepository;

	@Autowired
	public EmployeeServiceAdvImpl(EmployeeRepository theEmployeeRepository) {
		theRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return theRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> optEmployee = theRepository.findById(theId);

		Employee mEmployee = null;
		if (optEmployee.isPresent()) {
			mEmployee = optEmployee.get();
		}

		return mEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		return theRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		theRepository.deleteById(theId);
	}

}
