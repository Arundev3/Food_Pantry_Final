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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.group2.project.capstone.service.StoreServiceImpl;


@Entity
@Table(name="food")
public class Food {
	
	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="food_type")
	private String foodType;
	
	@Column(name="food_name")
	private String foodName;
	
	@Column(name="units")
	private String unit;
	
	@Column(name="value")
	private String value;
	
	@Column(name="weight")
	private String weight;
	
	@Column(name="quantity")
	private String quantity;
	
	@Column(name="status")
	private String status;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//	@JoinTable(
//			name = "food_stor",
//			joinColumns = @JoinColumn(
//					name = "food_id", referencedColumnName = "id"),
//			inverseJoinColumns = @JoinColumn(
//					name = "store_id", referencedColumnName = "id")
//			)
	private Store stor;

	
	// define constructors
	public Food() {
		
	}

	public Food(String foodType, String foodName, String unit, String value, String weight, String quantity,
			String status, Store stor) {
		this.foodType = foodType;
		this.foodName = foodName;
		this.unit = unit;
		this.value = value;
		this.weight = weight;
		this.quantity = quantity;
		this.status = status;
		this.stor = stor;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Store getStor() {
		return stor;
	}

	public void setStor(Store stor) {
		this.stor = stor;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", foodType=" + foodType + ", foodName=" + foodName + ", unit=" + unit + ", value="
				+ value + ", weight=" + weight + ", quantity=" + quantity + ", status=" + status + ", stor=" + stor
				+ "]";
	}
}
