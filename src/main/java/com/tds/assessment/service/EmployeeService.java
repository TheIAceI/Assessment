package com.tds.assessment.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	public List<Employee> getActiveEmployee() throws ParseException{		
		String sDate1="2019-08-12";  
	    Date d = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);	    
		return employeeRepository.getActiveEmployee(d);
	}
	
}
