package com.tds.assessment.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employee {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "Firstname")
	private String firstName;

	@Column(name = "Lastname")
	private String lastName;

	@Column(name = "Badge_Number")
	private int badge_number;

	@Column(name = "Country_Code")
	private String country;

	@Column(name = "Job_Title_Code")
	private String job_title_code;

	@Column(name = "Start_Date")
	private Date start_date;

	@Column(name = "Leave_Date")
	private Date leave_date;

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

	public int getBadge_number() {
		return badge_number;
	}

	public void setBadge_number(int badge_number) {
		this.badge_number = badge_number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getJob_title_code() {
		return job_title_code;
	}

	public void setJob_title_code(String job_title_code) {
		this.job_title_code = job_title_code;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getLeave_date() {
		return leave_date;
	}

	public void setLeave_date(Date leave_date) {
		this.leave_date = leave_date;
	}

}
