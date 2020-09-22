package com.tds.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tds.assessment.entity.JobTitle;


public interface JobTitleRepository extends JpaRepository<JobTitle, Integer>{
	
	@Query(value = "select * from job_title ", nativeQuery = true)
	List<JobTitle> getAllJobTitles();
	
}

