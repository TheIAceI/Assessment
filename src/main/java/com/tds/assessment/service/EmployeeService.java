package com.tds.assessment.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tds.assessment.entity.EmployeeDepartment;
import com.tds.assessment.repository.EmployeeDepartmentRepository;
import com.tds.assessment.repository.EmployeeRepository;
import com.tds.assessment.util.CountrySingleton;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
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
		String sDate1 = "2019-08-12";
		Date d = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
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
