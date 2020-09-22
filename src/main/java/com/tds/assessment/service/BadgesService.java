package com.tds.assessment.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tds.assessment.entity.Badges;
import com.tds.assessment.repository.BadgesRepository;

@Service
public class BadgesService {
	
	@Autowired
	BadgesRepository badgesRepo;
	
	public List<Badges> getAllBadges() {
		return badgesRepo.getAllBadges();
	}
	
	public List<Badges> getActiveBadges() throws ParseException {				
		Date d = new Date();
		return badgesRepo.getAllActive(d);
	}
	
	public List<Badges> getBadge(String badge_number) {
		return badgesRepo.getBadge(badge_number);
	}
	
}
