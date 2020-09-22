package com.tds.assessment.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tds.assessment.entity.JobTitle;
import com.tds.assessment.repository.JobTitleRepository;

@Service
public class JobTitleService {

	@Autowired
	JobTitleRepository jobTitleRepository;

	@Autowired
	EntityManager em;

	public List<JobTitle> getAllJobTitles() {
		return jobTitleRepository.getAllJobTitles();
	}

	//Uses EntityManager for Join Tables. We could also use a repository that returns an Object
	public List<Object[]> getJobTitle(String department) {
		String select = "select Job_Title.Job_Title_Code, Job_Title.Job_Title_Name, Department.Department_Name "
				+ "from Job_Title " + "inner join Department on Job_Title.Department_Code = Department.Department_Code "
				+ "where Department.Department_name = '" + department + "'";
		List<Object[]> jobTitles = em.createNativeQuery(select).getResultList();
		return jobTitles;
	}

}
