package com.group2.project.capstone.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.group2.project.capstone.entity.Member;
import com.group2.project.capstone.web.dto.MemberRegistrationDto;

public interface MemberService extends UserDetailsService {

	public List<Member> findAll();
	
	public Member findById(int theId);
	
	//public void save(Member theEmployee);
	
	public void deleteById(int theId);
	
	Member save(MemberRegistrationDto registrationDto);
}
