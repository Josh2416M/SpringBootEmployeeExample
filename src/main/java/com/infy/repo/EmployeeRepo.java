package com.infy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Employee;


public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
	
	
	Employee findByEmployeeName(String employeeName);
	
	
	
	
	
	

}
