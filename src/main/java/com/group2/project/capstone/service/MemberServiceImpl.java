package com.group2.project.capstone.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.group2.project.capstone.dao.MemberRepository;
import com.group2.project.capstone.entity.Member;
import com.group2.project.capstone.entity.Role;
import com.group2.project.capstone.web.dto.MemberRegistrationDto;

@Service 
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Lazy
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//Constructor injection
	@Autowired
	public MemberServiceImpl(MemberRepository theMemberRepository) {
		memberRepository = theMemberRepository;
	}

	@Override
	public List<Member> findAll() {
		return memberRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Member findById(int theId) {
		Optional<Member> result = memberRepository.findById(theId);
		
		Member theMember = null;
		if(result.isPresent()) {
			theMember = result.get();
		} else {
			// we didn't find the member
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		return theMember;
	}

//	@Override
//	public void save(Member theMember) {
//		memberRepository.save(theMember);
//	}

	@Override
	public void deleteById(int theId) {
		memberRepository.deleteById(theId);
	}
	
	@Override
	public Member save(MemberRegistrationDto registrationDto) {
		
		Member user = new Member(registrationDto.getFirstName(), registrationDto.getLastName(),
				    registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),
				    LocalDate.parse(registrationDto.getDob()), registrationDto.getEthnicity(), registrationDto.getAddress1(),
				    registrationDto.getAddress2(), registrationDto.getCity(), registrationDto.getState(),
				    registrationDto.getZip(), registrationDto.getCountry(), registrationDto.getPhone(), 
				    registrationDto.getPhoneType(), registrationDto.getFamilyMembers(), registrationDto.getNotification(), Arrays.asList(new Role("ROLE_USER")));
		
		return memberRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Member member = memberRepository.findByEmail(username);
		if(member == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		return new org.springframework.security.core.userdetails.User(member.getEmail(), member.getPassword(), mapRolesToAuthorities(member.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
