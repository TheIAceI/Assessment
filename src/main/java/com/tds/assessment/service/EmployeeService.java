package com.tds.assessment.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tds.assessment.entity.EmployeeDepartment;
import com.tds.assessment.repository.EmployeeDepartmentRepository;
import com.tds.assessment.util.CountrySingleton;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDepartmentRepository employeeDepartmentRepository;
	
	CountrySingleton countruSingleton = CountrySingleton.getInstance();

	public List<EmployeeDepartment> getAllEmployee() throws Exception {
		List<EmployeeDepartment> employeeList = employeeDepartmentRepository.getEmployeeDepartment();
		for (EmployeeDepartment emp : employeeList) {
			emp.setCountry(countruSingleton.getCoutryName(emp.getCountry().toUpperCase())); //Get the country name from the Singleton Class
		}
		return employeeList;
	}
	
	public List<EmployeeDepartment> getActiveEmployee() throws ParseException {
		Date d = new Date();
		return employeeDepartmentRepository.getActiveEmployee(d);
	}
		
	public List<EmployeeDepartment> getAllEmployeeByDepartment(String department_name) throws Exception {
		List<EmployeeDepartment> employeeList = employeeDepartmentRepository.getEmployeeByDepartment(department_name);
		for (EmployeeDepartment emp : employeeList) {
			emp.setCountry(countruSingleton.getCoutryName(emp.getCountry().toUpperCase())); //Get the country name from the Singleton Class
		}
		return employeeList;
	}
			
}
