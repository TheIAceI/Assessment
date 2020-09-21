package com.tds.assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tds.assessment.entity.Employee;
import com.tds.assessment.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public List<Employee> getAllEmployee(){
		return employeeRepository.getAllEmployee();
	}
	
	public List<Employee> getActiveEmployee(){
		return employeeRepository.getActiveEmployee();
	}
	
}
