package com.tds.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tds.assessment.entity.Badges;
import com.tds.assessment.service.BadgesService;
import com.tds.assessment.util.Routes;

@RestController
public class BadgesController {
	
	@Autowired
	BadgesService badgeService;
	
	@RequestMapping(value = Routes.BA_GET_BADGES, method = RequestMethod.GET)  
	public ResponseEntity getBadgesAvailable() {		
		List<Badges> allBadges = (badgeService.getAllBadges());
		if(allBadges == null) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}		
		return new ResponseEntity(allBadges, HttpStatus.OK);
	}	

	@RequestMapping(value = Routes.BA_GET_BADGES_ACTIVE, method = RequestMethod.GET)  
	public ResponseEntity getBadgesActive() {		
		List<Badges> activeBadges = (badgeService.getActiveBadges());
		if(activeBadges == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity(activeBadges, HttpStatus.OK);
	}
	
}
