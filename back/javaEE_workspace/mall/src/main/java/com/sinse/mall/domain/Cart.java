package com.sinse.mall.domain;

import javax.persistence.OneToMany;

import lombok.Data;

@Data
public class Cart {
	private int cart_id;
	private Product product;
	private int ea;
	private Member member;
	private Color color;	//선택한 색상
	private Size size;	//선택한 사이즈
}
