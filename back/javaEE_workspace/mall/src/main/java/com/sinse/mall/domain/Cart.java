package com.sinse.mall.domain;

import javax.persistence.OneToMany;

import lombok.Data;

@Data
public class Cart {
	private int cart_id;
	private int ea;
	private int member_id;
	private Product product;
	
	private String selectedColor;	//선택한 색상
	private String selectedSize;	//선택한 사이즈
}
