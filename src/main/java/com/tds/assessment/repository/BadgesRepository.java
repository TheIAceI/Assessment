package com.tds.assessment.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tds.assessment.entity.Badges;

public interface BadgesRepository extends JpaRepository<Badges, Integer>{
	
	@Query(value = "select * from badge", nativeQuery = true)
	List<Badges> getAllBadges();

	@Query(value = "select * from badge where badge_status = 'Active' and badge_expiry_date >= ?1 ", nativeQuery = true)
	List<Badges> getAllActive(Date date);
	
	@Query(value = "select * from badge where badge_number = ?1 ", nativeQuery = true)
	List<Badges> getBadge(String badge_number);
	
}


