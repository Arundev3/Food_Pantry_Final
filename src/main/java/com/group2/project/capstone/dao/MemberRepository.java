package com.group2.project.capstone.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group2.project.capstone.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	// add a method to sort by last name 
	// Its part of Spring Data JPA feature
	public List<Member> findAllByOrderByLastNameAsc();
	
	Member findByEmail(String email);
}
