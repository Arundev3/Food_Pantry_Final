package com.group2.project.capstone.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.group2.project.capstone.entity.Member;
import com.group2.project.capstone.entity.Store;
import com.group2.project.capstone.service.MemberService;
import com.group2.project.capstone.service.StoreService;
import com.group2.project.capstone.web.dto.MemberRegistrationDto;
import com.group2.project.capstone.web.dto.StoreRegistrationDto;

@Controller
@RequestMapping("stores")
public class PantryStoreController {
	
	private StoreService storeService;
	
	public PantryStoreController(StoreService theStoreService) {
		storeService = theStoreService;
	}
	
	@ModelAttribute("store")
	public StoreRegistrationDto storeRegistrationDto() {
		return new StoreRegistrationDto();
	}
	
	@GetMapping("/pantry_store_registration")
	public String ShareFest_Store_Registration(Model theModel) {
		
		// create model attribute to bind form data
		Store theStore = new Store();
		
		theModel.addAttribute("store", theStore);
		
		return "stores/pantry_store_registration";
	}
	
	@GetMapping("/pantry_store_login")
	public String ShareFest_Store_Login() {
		
		return "stores/pantry_store_login";
	}
	
	@PostMapping("/pantry_store_registration")
	public String ShareFest_Store_Register(@ModelAttribute("store") StoreRegistrationDto registrationDto) {
		
		storeService.save(registrationDto);
		return "redirect:/stores/pantry_store_registration?success";
	}
}
