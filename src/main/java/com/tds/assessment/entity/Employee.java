package com.tds.assessment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private int id;

	@Column(name="firstname") 
	private String firstName;
	
	@Column(name="lastname") 
	private String lastName;
	
	@Column(name="badge_number") 
	private int badgeNumber;

	@Column(name="country") 
	private String country;

	@Column(name="job_title") 
	private String jobTitle;
	
	@Column(name="department") 
	private String department;
	
	@Column(name="start_date") 
	private String startDate;
	
	@Column(name="leave_date") 
	private String leaveDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBadgeNumber() {
		return badgeNumber;
	}

	public void setBadgeNumber(int badgeNumber) {
		this.badgeNumber = badgeNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}
	
}
