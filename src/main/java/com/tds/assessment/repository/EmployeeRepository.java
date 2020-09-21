package com.tds.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tds.assessment.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	/*
	SELECT * FROM AAATable1 WHERE TO_DATE(DATA,'YYYY/MM/DD hh24:mi:ss') < TO_DATE('2020/09/21' ,'YYYY/MM/DD');
	SELECT TO_TIMESTAMP(update_date, 'yy.mm.dd') FROM PERSON;
	SELECT * FROM AAATable1 WHERE DATA is not null;
	*/
	
	/*** List ***/
	@Query(value = "select * from Employee ", nativeQuery = true)
	List<Employee> getAllEmployee();

	/*** List ***/
	@Query(value = "select * from Employee ", nativeQuery = true)
	List<Employee> getActiveEmployee();
	
}

