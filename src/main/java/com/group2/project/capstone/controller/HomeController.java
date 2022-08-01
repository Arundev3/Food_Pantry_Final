package com.group2.project.capstone.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group2.project.capstone.entity.Food;
import com.group2.project.capstone.entity.Store;
import com.group2.project.capstone.service.FoodService;
import com.group2.project.capstone.service.StoreService;
import com.group2.project.capstone.web.dto.FoodRegistrationDto;

@Controller
public class HomeController {
	
	private FoodService foodService;
	
	@Autowired
	private StoreService storeService;
	
	static int foodId;
	
	public HomeController(FoodService theFoodService) {
		foodService = theFoodService;
	}
	
	@ModelAttribute("food")
	public FoodRegistrationDto foodRegistrationDto() {
		return new FoodRegistrationDto();
	}
	
	@GetMapping("/home")
	public String sayHello(Model theModel) {
		
		return "home";
	}
	
	@GetMapping("/pantry_store_account")
	public String welcome(Model theModel) {
		
		// get employees from db
		List<Store> theStores = storeService.findAll();
		List<Food> theFoods = foodService.findAll();
		
		// add to the spring model
		theModel.addAttribute("stores", theStores);
		theModel.addAttribute("foods", theFoods);
		
	
		return "pantry_store_account";
	}
	
	@GetMapping("/member_account")
	public String newFile(Model theModel) {
		
		List<Food> theFoods = foodService.findAll();
		
		// add to the spring model
		theModel.addAttribute("foods", theFoods);
		
		return "member_account";
	}
	
	@PostMapping("/pantry_store_account")
	public String registerFood(@ModelAttribute("food") FoodRegistrationDto registrationDto) {
		
		foodService.save(registrationDto);
		return "redirect:/pantry_store_account";
	}
	
	@PostMapping("/save")
	public String saveFood(@ModelAttribute("food") FoodRegistrationDto theFood) {
		
		Food existingFood = foodService.findById(foodId);

		// save the employee
		foodService.updateFood(theFood, existingFood);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/pantry_store_account";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("foodId") int theId, Model theModel) {
		
		foodId = theId;
		
		// get the employee from the service
		Food theFood = foodService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("food", theFood);
		
		// send over to our form
		return "/food_update_form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("foodId") int theId) {
		
		// delete the employee
		foodService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/pantry_store_account";
	}
}
