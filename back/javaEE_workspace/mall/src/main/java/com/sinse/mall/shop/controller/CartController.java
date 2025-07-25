package com.sinse.mall.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.sinse.mall.domain.Cart;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CartController {
	
	//장바구니 담기
	@PostMapping("/cart/regist")
	public String regist(Cart cart) {
		
		log.debug("product_id는 " + cart.getProduct().getProduct_id());
		//log.debug("ea는 " + cart.getEa());
		//log.debug("member_id는 " + cart.getMember_id());
		//log.debug("선택한 색상은 " + cart.getSelectedColor());
		//log.debug("선택한 사이즈는 " + cart.getSelectedSize());
		
		return null;
	}
	
}
