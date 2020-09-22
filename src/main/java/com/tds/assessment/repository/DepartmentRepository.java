package com.tds.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tds.assessment.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
	@Query(value = "select * from Department ", nativeQuery = true)
	List<Department> getAllDepartment();
	
	@Query(value = "select * from Department where department_name = ?1 ", nativeQuery = true)
	Department getDepartmentByName(String department_name);
	
}

