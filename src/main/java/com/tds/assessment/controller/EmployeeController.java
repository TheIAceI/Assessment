package com.tds.assessment.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tds.assessment.entity.EmployeeDepartment;
import com.tds.assessment.service.EmployeeService;
import com.tds.assessment.util.Routes;

@RestController
public class EmployeeController {
			
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = Routes.BA_GET_EMPLOYEE, method = RequestMethod.GET)  
	public ResponseEntity getEmployeeAvailable() throws Exception {		
		List<EmployeeDepartment> allEmployee = (employeeService.getAllEmployee());
		if (allEmployee.size() == 0) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}		
		return new ResponseEntity(allEmployee, HttpStatus.OK);
	}	
	
	@RequestMapping(value = Routes.BA_GET_EMPLOYEE_ACTIVE, method = RequestMethod.GET)  
	public ResponseEntity getEmployeeActive() throws ParseException {		
		List<EmployeeDepartment> activeEmployee = (employeeService.getActiveEmployee());
		if (activeEmployee.size() == 0) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity(activeEmployee, HttpStatus.OK);
	}

	@RequestMapping(value = Routes.BA_GET_EMPLOYEE, method = RequestMethod.GET, params = "department_name")  
	public ResponseEntity getEmployeeByDepartment(@RequestParam(name = "department_name") String department_name) throws Exception {		
		List<EmployeeDepartment> allEmployee = (employeeService.getAllEmployeeByDepartment(department_name));
		if (allEmployee.size() == 0) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}		
		return new ResponseEntity(allEmployee, HttpStatus.OK);
	}	
	
}
