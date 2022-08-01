package com.group2.project.capstone.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.group2.project.capstone.entity.Food;
import com.group2.project.capstone.entity.Store;

public interface FoodRepository extends JpaRepository<Food, Integer> {
	
	//@Query("select stor_id from food, nativeQuery = true")
	public List<Food> findAllByOrderByFoodName();
	
//	public Food saveFood(Food food);
}
