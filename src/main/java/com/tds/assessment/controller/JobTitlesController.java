package com.tds.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tds.assessment.entity.JobTitle;
import com.tds.assessment.service.JobTitleService;
import com.tds.assessment.util.Routes;

@SuppressWarnings({"rawtypes", "unchecked" })
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
		List<Object[]> jobDepartment = jobTitleService.getJobTitle(department_name);
		if (jobDepartment.size() == 0) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(jobDepartment, HttpStatus.OK);
	}
	
}
