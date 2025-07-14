package com.sinse.hiberasync2.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="store")
public class Store {
	@Id
	private int store_id;
	private String store_name;
	private String tel;
	@JoinColumn(name="food_type_id")
	private FoodType foodType;
}
