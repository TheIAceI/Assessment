package com.tds.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tds.assessment.entity.Department;
import com.tds.assessment.service.DepartmentService;
import com.tds.assessment.util.Routes;

@SuppressWarnings({"rawtypes", "unchecked" })
@RestController
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@RequestMapping(value = Routes.BA_GET_DEPARTMENT, method = RequestMethod.GET)
	public ResponseEntity getBadgesAvailable() {
		List<Department> allDepartment = (departmentService.getAllDepartments());
		if (allDepartment.size() == 0) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(allDepartment, HttpStatus.OK);
	}
}
