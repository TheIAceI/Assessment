package com.tds.assessment.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tds.assessment.entity.Employee;
import com.tds.assessment.repository.EmployeeRepository;
import com.tds.assessment.util.CountrySingleton;
//import com.tds.assessment.util.CountrySingleton;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	CountrySingleton countruSingleton = CountrySingleton.getInstance();
	
	@Autowired
	CountryService countryService;
	
	public List<Employee> getAllEmployee() throws Exception {
		List<Employee> employeeList = employeeRepository.getAllEmployee();
		for (Employee emp : employeeList) {
			emp.setCountry(countruSingleton.getCoutryName(emp.getCountry().toUpperCase()));
			//emp.setCountry(countryService.getCountryName(emp.getCountry()));
		}
		return employeeList;
	}

	public List<Employee> getActiveEmployee() throws ParseException {
		String sDate1 = "2019-08-12";
		Date d = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
		return employeeRepository.getActiveEmployee(d);
	}

}
