package com.tds.assessment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Department_Code")
	private int department_code;

	@Column(name = "Department_Name")
	private String department_name;

	public int getDepartment_code() {
		return department_code;
	}

	public void setDepartment_code(int department_code) {
		this.department_code = department_code;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

}
