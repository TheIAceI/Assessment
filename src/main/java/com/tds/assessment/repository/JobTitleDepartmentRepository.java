package com.tds.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tds.assessment.entity.JobTitleDepartment;


public interface JobTitleDepartmentRepository extends JpaRepository<JobTitleDepartment, Integer>{
	
	@Query(value = "select j.job_title_code, j.Job_Title_Name, d.Department_Name from job_title j inner join Department d on j.department_code = d.department_code ", nativeQuery = true)
	List<JobTitleDepartment> getAllJobTitlesDepartment();
	
	@Query(value = "select j.job_title_code, j.Job_Title_Name, d.Department_Name from job_title j inner join Department d on j.department_code = d.department_code where d.department_name = ?1 ", nativeQuery = true)
	List<JobTitleDepartment> getJobTitlesDepartmentByDepartment(String department_name);
	
}

