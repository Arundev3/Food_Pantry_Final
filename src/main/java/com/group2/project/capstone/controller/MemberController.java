package com.group2.project.capstone.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group2.project.capstone.entity.Member;
import com.group2.project.capstone.service.MemberService;
import com.group2.project.capstone.web.dto.MemberRegistrationDto;

@Controller
@RequestMapping("members")
public class MemberController {
	
	private MemberService memberService;
	
	public MemberController(MemberService theMemberService) {
		memberService = theMemberService;
	}
	
	@ModelAttribute("member")
	public MemberRegistrationDto memberRegistrationDto() {
		return new MemberRegistrationDto();
	}
	
	@GetMapping("/Community_Registration")
	public String Community_Registration(Model theModel) {
		
		// create model attribute to bind form data
		Member theMember = new Member();
		
		theModel.addAttribute("member", theMember);
		
		return "members/Community_Registration";
	}
	
	@GetMapping("/Community_Login")
	public String login() {
		return "members/Community_Login";
	}
	
	@GetMapping("/LoginOrRegistration")
	public String loginOrRegistration() {
		return "members/LoginOrRegistration";
	}
	
	@PostMapping("/Community_Registration")
	public String registerMember(@ModelAttribute("member") MemberRegistrationDto registrationDto) {
		
		memberService.save(registrationDto);
		return "redirect:/members/Community_Registration?success";
	}
}
