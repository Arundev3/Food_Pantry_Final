package com.group2.project.capstone.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.group2.project.capstone.dao.FoodRepository;
import com.group2.project.capstone.dao.MemberRepository;
import com.group2.project.capstone.dao.StoreRepository;
import com.group2.project.capstone.entity.Food;
import com.group2.project.capstone.entity.Member;
import com.group2.project.capstone.entity.Role;
import com.group2.project.capstone.entity.Store;
import com.group2.project.capstone.web.dto.FoodRegistrationDto;
import com.group2.project.capstone.web.dto.MemberRegistrationDto;

@Service 
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	//private FoodService foodService;
	
	//Constructor injection
	@Autowired
	public FoodServiceImpl(FoodRepository theFoodRepository) {
		foodRepository = theFoodRepository;
	}

	@Override
	public List<Food> findAll() {
		return foodRepository.findAllByOrderByFoodName();
	}
	
	@Override
	public Food findById(int theId) {
		Optional<Food> result = foodRepository.findById(theId);
		
		Food theMember = null;
		if(result.isPresent()) {
			theMember = result.get();
		} else {
			// we didn't find the member
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		return theMember;
	}


	@Override
	public Food save(FoodRegistrationDto registrationDto) {

//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        StoreServiceImpl store = (StoreServiceImpl) authentication.getPrincipal();
        
		Food food = new Food(registrationDto.getFoodType(), registrationDto.getFoodName(), registrationDto.getUnit(), registrationDto.getValue(),
				    registrationDto.getWeight(), registrationDto.getQuantity(), registrationDto.getStatus(), storeRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
	
//		storeRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
		
//		System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
//		
//		Store str = storeRepository.findByEmail("catch@gmail.com");
//		System.out.println();
//		
//		System.out.println(str.getId());
//		System.out.println(str.getStoreName());
//		System.out.println(str.getEmail());
//		System.out.println(str.getPassword());

		
		return foodRepository.save(food);
	}
	
	@Override
	public Food updateFood(FoodRegistrationDto theFood, Food existingFood) {
		
//		Food existingFood = foodService.findById(id);
//		System.out.println(theFood.toString());
		
		existingFood.setFoodType(theFood.getFoodType());
		existingFood.setFoodName(theFood.getFoodName());
		existingFood.setUnit(theFood.getUnit());
		existingFood.setValue(theFood.getValue());
		existingFood.setWeight(theFood.getWeight());
		existingFood.setQuantity(theFood.getQuantity());
		existingFood.setStatus(theFood.getStatus());


		foodRepository.save(existingFood);
		return existingFood;
	}
	
	@Override
	public void deleteById(int theId) {
		foodRepository.deleteById(theId);
	}

}
