package com.tds.assessment.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tds.assessment.entity.Badges;
import com.tds.assessment.service.BadgesService;
import com.tds.assessment.util.Routes;
import com.tds.assessment.util.Util;

@SuppressWarnings({"rawtypes", "static-access", "unchecked" })
@RestController
public class BadgesController {

	@Autowired
	BadgesService badgeService;

	Util util = new Util();

	@RequestMapping(value = Routes.BA_GET_BADGES, method = RequestMethod.GET)
	public ResponseEntity getBadgesAvailable() {
		List<Badges> allBadges = (badgeService.getAllBadges());
		if (allBadges.size() == 0) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(allBadges, HttpStatus.OK);
	}

	@RequestMapping(value = Routes.BA_GET_BADGES_ACTIVE, method = RequestMethod.GET)
	public ResponseEntity getBadgesActive() throws ParseException {
		List<Badges> activeBadges = (badgeService.getActiveBadges());
		if (activeBadges.size() == 0) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(activeBadges, HttpStatus.OK);
	}

	@RequestMapping(value = Routes.BA_GET_BADGES, method = RequestMethod.GET, params = "badge_number")
	public ResponseEntity getBadge(@RequestParam(name = "badge_number") String badge_number) {
		Boolean is = util.isNumeric(badge_number);
		if (!is) {
			return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
		}

		List<Badges> badges = badgeService.getBadge(badge_number);
		if (badges.size() == 0) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(badges, HttpStatus.OK);
	}

}
