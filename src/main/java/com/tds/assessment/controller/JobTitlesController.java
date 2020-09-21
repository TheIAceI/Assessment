package com.tds.assessment.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tds.assessment.entity.Badges;
import com.tds.assessment.entity.Department;
import com.tds.assessment.entity.JobTitle;
import com.tds.assessment.service.BadgesService;
import com.tds.assessment.service.DepartmentService;
import com.tds.assessment.service.JobTitleService;
import com.tds.assessment.util.Routes;

@RestController
public class JobTitlesController {

	@Autowired
	JobTitleService jobTitleService;
	
	@RequestMapping(value = Routes.BA_GET_JOB_TITLES, method = RequestMethod.GET)  
	public ResponseEntity getAllJobTitles() {		
		List<JobTitle> allJobTitles = (jobTitleService.getAllJobTitles());
		if (allJobTitles.size() == 0) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}		
		return new ResponseEntity(allJobTitles, HttpStatus.OK);
	}
	
	@RequestMapping(value = Routes.BA_GET_JOB_TITLES, method = RequestMethod.GET, params = "department_name")
	public ResponseEntity getJobTitle(@RequestParam(name = "department_name") String department_name) {
		//if (!is) {
		//	return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
		//}

		List<Object[]> jobDepartment = jobTitleService.getJobTitle(department_name);
		if (jobDepartment.size() == 0) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(jobDepartment, HttpStatus.OK);
	}
	
}
