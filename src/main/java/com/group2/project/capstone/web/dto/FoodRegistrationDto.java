package com.group2.project.capstone.web.dto;

public class FoodRegistrationDto {

	private String foodType;
	private String foodName;
	private String unit;
	private String value;
	private String weight;
	private String quantity;
	private String status;

	
	public FoodRegistrationDto() {
		
	}
	
	public FoodRegistrationDto(String foodType, String foodName, String unit, String value, String weight, String quantity,
			String status) {
		this.foodType = foodType;
		this.foodName = foodName;
		this.unit = unit;
		this.value = value;
		this.weight = weight;
		this.quantity = quantity;
		this.status = status;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
