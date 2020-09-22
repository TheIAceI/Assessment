package com.tds.assessment.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.tds.assessment.entity.EmployeeDepartment;

public interface EmployeeDepartmentRepository extends JpaRepository<EmployeeDepartment, Integer>{
	
	@Query(value = " select e.ID, e.Firstname, e.Lastname, e.Badge_Number, e.Country_Code, j.Job_Title_Name, d.Department_Name, e.Start_Date, e.Leave_date from "+ 
			" employee e "+
			" inner join Job_Title j on e.Job_Title_Code = j.Job_Title_Code "+
			" inner join Department d on j.Department_Code = d.Department_Code", nativeQuery = true)
	List<EmployeeDepartment> getEmployeeDepartment();
	
	@Query(value = " select e.ID, e.Firstname, e.Lastname, e.Badge_Number, e.Country_Code, j.Job_Title_Name, d.Department_Name, e.Start_Date, e.Leave_date from "+ 
			" employee e "+
			" inner join Job_Title j on e.Job_Title_Code = j.Job_Title_Code "+
			" inner join Department d on j.Department_Code = d.Department_Code where (e.Leave_Date is null) or (e.Leave_Date > ?1) ", nativeQuery = true)
	List<EmployeeDepartment> getActiveEmployee(Date date);

	
	@Query(value = " select e.ID, e.Firstname, e.Lastname, e.Badge_Number, e.Country_Code, j.Job_Title_Name, d.Department_Name, e.Start_Date, e.Leave_date from "+ 
			" employee e "+
			" inner join Job_Title j on e.Job_Title_Code = j.Job_Title_Code "+
			" inner join Department d on j.Department_Code = d.Department_Code where d.Department_Name = ?1 ", nativeQuery = true)
	List<EmployeeDepartment> getEmployeeByDepartment(String department_name);
	
}

