package com.coding.springbootapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.springbootapi.model.Employee;
import com.coding.springbootapi.repository.EmployeeRepository;

@Service //define a business logic (DAO)
public class EmployeeDAO { //data, access, object
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	/* Saving an employee */
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}
	/* Searching all employees */
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	/* Get an employee by Id */
	public Employee findOne(Long empid) {
		return employeeRepository.getOne(empid);
	}
	/* Delete an employee */
	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}
}
