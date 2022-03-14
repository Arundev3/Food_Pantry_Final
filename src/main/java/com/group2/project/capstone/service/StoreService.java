package com.group2.project.capstone.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.group2.project.capstone.entity.Member;
import com.group2.project.capstone.entity.Store;
import com.group2.project.capstone.web.dto.MemberRegistrationDto;
import com.group2.project.capstone.web.dto.StoreRegistrationDto;

public interface StoreService extends UserDetailsService {

	public List<Store> findAll();
	
	public Store findById(int theId);
	
	//public void save(Member theEmployee);
	
	public void deleteById(int theId);
	
	Store save(StoreRegistrationDto registrationDto);
}
