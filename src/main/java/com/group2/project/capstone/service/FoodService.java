package com.group2.project.capstone.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.group2.project.capstone.entity.Food;
import com.group2.project.capstone.entity.Member;
import com.group2.project.capstone.entity.Store;
import com.group2.project.capstone.web.dto.FoodRegistrationDto;
import com.group2.project.capstone.web.dto.MemberRegistrationDto;

public interface FoodService {

	public List<Food> findAll();
	
	public Food findById(int theId);
	
	Food save(FoodRegistrationDto registrationDto);
	
	public Food updateFood(FoodRegistrationDto theFood, Food food);
	
	public void deleteById(int theId);
}
