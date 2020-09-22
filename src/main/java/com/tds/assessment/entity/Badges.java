package com.tds.assessment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Badges {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "badge_number")
	private int badge_number;

	@Column(name = "badge_status")
	private String badge_status;

	@Column(name = "badge_expiry_date")
	private String badge_expiry_date;

	public int getBadge_number() {
		return badge_number;
	}

	public void setBadge_number(int badge_number) {
		this.badge_number = badge_number;
	}

	public String getBadge_status() {
		return badge_status;
	}

	public void setBadge_status(String badge_status) {
		this.badge_status = badge_status;
	}

	public String getBadge_expiry_date() {
		return badge_expiry_date;
	}

	public void setBadge_expiry_date(String badge_expiry_date) {
		this.badge_expiry_date = badge_expiry_date;
	}

}
