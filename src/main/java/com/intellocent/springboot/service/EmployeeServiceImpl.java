package com.intellocent.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intellocent.springboot.dao.EmployeeDAO;
import com.intellocent.springboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO theDAO;

	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJPAImpl") EmployeeDAO theEmployeeDAO) {
		super();
		theDAO = theEmployeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return theDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return theDAO.findById(theId);
	}

	@Override
	@Transactional
	public Employee save(Employee theEmployee) {
		return theDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		theDAO.deleteById(theId);
	}

	@Override
	public List<Employee> searchBy(String theName) {
		// TODO Auto-generated method stub
		return null;
	}

}
