package com.group2.project.capstone.web.dto;

public class StoreRegistrationDto {

	private String storeName;
	private String email;
	private String password;
	
	public StoreRegistrationDto() {
		
	}
	
	public StoreRegistrationDto(String storeName, String email, String password) {
		this.storeName = storeName;
		this.email = email;
		this.password = password;
	}
	
	
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
