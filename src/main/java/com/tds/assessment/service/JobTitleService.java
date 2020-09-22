package com.tds.assessment.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tds.assessment.entity.JobTitleDepartment;
import com.tds.assessment.repository.JobTitleDepartmentRepository;

@Service
public class JobTitleService {

	@Autowired
	JobTitleDepartmentRepository jobTitleDepartmentRepository;

	//@Autowired
	//EntityManager em;

	public List<JobTitleDepartment> getAllJobTitles() {
		return jobTitleDepartmentRepository.getAllJobTitlesDepartment();
	}

	public List<JobTitleDepartment> getJobTitle(String department_name) {
		return jobTitleDepartmentRepository.getJobTitlesDepartmentByDepartment(department_name);
		/*
		String select = "select Job_Title.Job_Title_Code, Job_Title.Job_Title_Name, Department.Department_Name "
				+ "from Job_Title " + "inner join Department on Job_Title.Department_Code = Department.Department_Code "
				+ "where Department.Department_name = '" + department + "'";
		List<Object[]> jobTitles = em.createNativeQuery(select).getResultList();
		return jobTitles;*/
	}

}
