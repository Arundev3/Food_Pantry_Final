package com.group2.project.capstone.web.dto;

public class StoreRegistrationDto {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String dob;
	private String gender;
	private String ethnicity;
	private String size;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String phone;
	private String phoneType;
	private String familyMembers;
	private String income;
	
	
	public StoreRegistrationDto() {
		
	}

	public StoreRegistrationDto(String firstName, String lastName, String email, String password, String dob,
			String gender, String ethnicity, String size, String address1, String address2, String city, String state,
			String zip, String country, String phone, String phoneType, String familyMembers, String income) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.ethnicity = ethnicity;
		this.size = size;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.phone = phone;
		this.phoneType = phoneType;
		this.familyMembers = familyMembers;
		this.income = income;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(String familyMembers) {
		this.familyMembers = familyMembers;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}
}
