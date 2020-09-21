package com.tds.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tds.assessment.entity.Badges;
import com.tds.assessment.entity.Employee;
import com.tds.assessment.service.EmployeeService;
import com.tds.assessment.util.Routes;

@RestController
public class EmployeeController {
			
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = Routes.BA_GET_EMPLOYEE, method = RequestMethod.GET)  
	public ResponseEntity getEmployeeAvailable() {		
		List<Employee> allEmployee = (employeeService.getAllEmployee());
		if(allEmployee == null) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}		
		return new ResponseEntity(allEmployee, HttpStatus.OK);
	}	
	
	@RequestMapping(value = Routes.BA_GET_EMPLOYEE_ACTIVE, method = RequestMethod.GET)  
	public ResponseEntity getEmployeeActive() {		
		List<Employee> activeEmployee = (employeeService.getActiveEmployee());
		if(activeEmployee == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity(activeEmployee, HttpStatus.OK);
	}

}