package com.group2.project.capstone.entity;

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
import javax.persistence.Table;


@Entity
@Table(name="store")
public class Store {
	
	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="store_name")
	private String storeName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "store_roles",
			joinColumns = @JoinColumn(
					name = "store_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id")
			)
	private Collection<Role> roles;
	
	// define constructors
	public Store() {
		
	}
	
	public Store(String storeName, String email, String password, Collection<Role> roles) {
		this.storeName = storeName;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	// define getters/setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	// define tostring
	@Override
	public String toString() {
		return "Store [id=" + id + ", storename=" + storeName + ", email=" + email + ", password=" + password
				+ ", roles=" + roles + "]";
	}	
}
