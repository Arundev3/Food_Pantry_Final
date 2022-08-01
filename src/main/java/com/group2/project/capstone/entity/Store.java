package com.group2.project.capstone.entity;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="store")
public class Store {
	
	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="date_of_birth")
	private LocalDate dob;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="ethnicity")
	private String ethnicity;
	
	@Column(name="size")
	private String size;
	
	@Column(name="address 1")
	private String address1;
	
	@Column(name="address 2")
	private String address2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zip_code")
	private String zip;
	
	@Column(name="country")
	private String country;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="phone_type")
	private String ptype;
	
	@Column(name="family_members")
	private String family;
	
	@Column(name="income")
	private String income;
	

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "store_roles",
			joinColumns = @JoinColumn(
					name = "store_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id")
			)
	private Collection<Role> roles;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "stor", cascade = CascadeType.ALL)
	private Collection<Food> foods;
	
	// define constructors
	public Store() {
		
	}
	
	public Store(String firstName, String lastName, String email, String password, LocalDate dob, String gender,
			String ethnicity, String size, String address1, String address2, String city, String state, String zip,
			String country, String phone, String ptype, String family, String income, Collection<Role> roles,
			Collection<Food> foods) {
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
		this.ptype = ptype;
		this.family = family;
		this.income = income;
		this.roles = roles;
		this.foods = foods;
	}


	// define getters/setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
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

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Collection<Food> getFoods() {
		return foods;
	}

	public void setFoods(Collection<Food> foods) {
		this.foods = foods;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", dob=" + dob + ", gender=" + gender + ", ethnicity=" + ethnicity
				+ ", size=" + size + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state="
				+ state + ", zip=" + zip + ", country=" + country + ", phone=" + phone + ", ptype=" + ptype
				+ ", family=" + family + ", income=" + income + ", roles=" + roles + ", foods=" + foods + "]";
	}
}
