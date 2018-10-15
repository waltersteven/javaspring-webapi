package com.coding.springbootapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coding.springbootapi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
