package com.group2.project.capstone.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group2.project.capstone.entity.Member;
import com.group2.project.capstone.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {
	
	// add a method to sort by last name 
	// Its part of Spring Data JPA feature
	public List<Store> findAllByOrderByStoreName();
	
	Store findByEmail(String email);

	public Store save(Store store);
}
