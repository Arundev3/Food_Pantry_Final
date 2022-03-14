package com.group2.project.capstone.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String sayHello(Model theModel) {
		
		return "home";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		
		return "welcome";
	}
	
	@GetMapping("/memberWelcome")
	public String newFile() {
		return "memberWelcome";
	}
	
}
