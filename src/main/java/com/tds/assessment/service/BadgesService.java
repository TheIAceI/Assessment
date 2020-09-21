package com.tds.assessment.service;

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
	
	public List<Badges> getActiveBadges() {
		return badgesRepo.getAllBadges();
	}
	
	public List<Badges> getBadge(String badge_number) {
		return badgesRepo.getBadge(badge_number);
	}
	
}
