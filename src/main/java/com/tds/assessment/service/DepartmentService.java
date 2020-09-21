package com.tds.assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tds.assessment.entity.Department;
import com.tds.assessment.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	public List<Department> getAllDepartments(){
		return departmentRepository.getAllDepartment();
	}
	
}
