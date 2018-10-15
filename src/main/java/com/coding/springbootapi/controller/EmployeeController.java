package com.coding.springbootapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coding.springbootapi.dao.EmployeeDAO;
import com.coding.springbootapi.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired // This means to get the bean called employeeDAO which calls employeeRepository
	private EmployeeDAO employeeDAO; 
	
	/*Saving employee*/
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee emp) { 
		Employee emply = employeeDAO.save(emp);
		return new ResponseEntity<Employee>(emply, HttpStatus.OK);
	}
	
	/*Get all employees*/
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){ //we don't need @ResponseBody since we are using @RestController
		return new ResponseEntity<List<Employee>>(employeeDAO.findAll(), HttpStatus.OK);
//		return employeeDAO.findAll();
	}
	
	/*Get employee by id*/
	@GetMapping("/employee")
	public ResponseEntity<Employee> getEmployeeById(@RequestParam(value="id") Long empid) {
		Employee employee = employeeDAO.findOne(empid);
		if (employee == null) {
			return ResponseEntity.badRequest().build();
//			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
//		return ResponseEntity.ok().body(employee);
	}
	
/* This option its with PathVariable */	
//	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empid) {
//		Employee employee = employeeDAO.findOne(empid);
//		if (employee == null) {
//			return ResponseEntity.notFound().build();
//		}
//		
//		return ResponseEntity.ok().body(employee);
//	}
	
	/*Update employee by id*/
	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployee(@RequestParam(value="id", defaultValue="17") Long empid, @Valid @RequestBody Employee empDetails) {
		Employee employee = employeeDAO.findOne(empid);
		if (employee == null) return ResponseEntity.notFound().build();
		
		employee.setName(empDetails.getName());
		employee.setDesignation(empDetails.getDesignation());
		employee.setExpertise(empDetails.getExpertise());
//		employee.setCreatedAt(empDetails.getCreatedAt());
		Employee updatedEmployee = employeeDAO.save(employee);
		return ResponseEntity.ok().body(updatedEmployee);
	}
	
	/*Delete employee*/
	@DeleteMapping("/employee")
	public ResponseEntity<Employee> deleteEmployee(@RequestParam(value="id") Long empid) {
		Employee employee = employeeDAO.findOne(empid);
		if (employee == null) return ResponseEntity.notFound().build();
		
		employeeDAO.delete(employee);
		return ResponseEntity.ok().build();				
	}
}
