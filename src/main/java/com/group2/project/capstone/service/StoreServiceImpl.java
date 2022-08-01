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
import com.group2.project.capstone.dao.StoreRepository;
import com.group2.project.capstone.entity.Food;
import com.group2.project.capstone.entity.Member;
import com.group2.project.capstone.entity.Role;
import com.group2.project.capstone.entity.Store;
import com.group2.project.capstone.web.dto.MemberRegistrationDto;
import com.group2.project.capstone.web.dto.StoreRegistrationDto;

@Service 
public class StoreServiceImpl implements StoreService {
	
	public StoreServiceImpl() {
		
	}
	

	@Autowired
	private StoreRepository storeRepository;
	
	@Lazy
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	//Constructor injection
	@Autowired
	public StoreServiceImpl(StoreRepository theStoreRepository) {
		storeRepository = theStoreRepository;
	}

	@Override
	public List<Store> findAll() {
		return storeRepository.findAllByOrderByFirstName();
	}

	@Override
	public Store findById(int theId) {
		Optional<Store> result = storeRepository.findById(theId);
		
		Store theStore = null;
		if(result.isPresent()) {
			theStore = result.get();
		} else {
			// we didn't find the member
			throw new RuntimeException("Did not find store id - " + theId);
		}
		return theStore;
	}

//	@Override
//	public void save(Member theMember) {
//		memberRepository.save(theMember);
//	}

	@Override
	public void deleteById(int theId) {
		storeRepository.deleteById(theId);
	}
	
	@Override
	public Store save(StoreRegistrationDto registrationDto) {
		
		Store store = new Store(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(), 
				passwordEncoder.encode(registrationDto.getPassword()), LocalDate.parse(registrationDto.getDob()), registrationDto.getGender(),
				registrationDto.getEthnicity(), registrationDto.getSize(), registrationDto.getAddress1(), registrationDto.getAddress2(),
				registrationDto.getCity(), registrationDto.getState(), registrationDto.getZip(), registrationDto.getCountry(),
				registrationDto.getPhone(), registrationDto.getPhoneType(), registrationDto.getFamilyMembers(),
				registrationDto.getIncome(), Arrays.asList(new Role("ROLE_STORE")), Arrays.asList(new Food()));
	
		return storeRepository.save(store);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Store store = storeRepository.findByEmail(username);
		if(store == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		return new org.springframework.security.core.userdetails.User(store.getEmail(), store.getPassword(), mapRolesToAuthorities(store.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
