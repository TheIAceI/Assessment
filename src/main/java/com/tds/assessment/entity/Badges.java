package com.tds.assessment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Badges")
public class Badges {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="badge_number")
	private int badgeNumber;

	@Column(name="badge_status") 
	private String badgeStatus;

	@Column(name="badge_expiry_date")
	private String badgeExpiryDate;

	public int getBadgeNumber() {
		return badgeNumber;
	}

	public void setBadgeNumber(int badgeNumber) {
		this.badgeNumber = badgeNumber;
	}

	public String getBadgeStatus() {
		return badgeStatus;
	}

	public void setBadgeStatus(String badgeStatus) {
		this.badgeStatus = badgeStatus;
	}

	public String getBadgeExpiryDate() {
		return badgeExpiryDate;
	}

	public void setBadgeExpiryDate(String badgeExpiryDate) {
		this.badgeExpiryDate = badgeExpiryDate;
	}	
	
}
