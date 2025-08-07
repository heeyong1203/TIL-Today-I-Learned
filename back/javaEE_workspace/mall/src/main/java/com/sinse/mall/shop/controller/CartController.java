package com.sinse.mall.shop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinse.mall.domain.Cart;
import com.sinse.mall.domain.Member;
import com.sinse.mall.exception.CartException;
import com.sinse.mall.model.order.CartService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	//장바구니 목록 요청
	@GetMapping("/shop/cart/list")
	public String getList(Model model) {
		return "shop/order/cart_list";
	}
	
	//장바구니 담기
	//detail.jsp는 응답정보를 원함. jsp 경로를 보내주는 것이 아니라 응답정보를 넘겨주어야 한다.
	//따라서 jsp응답을 막기 위해 @ResponseBody를 이용한다.
	@PostMapping("/cart/regist")
	@ResponseBody //jsp응답을 막고 json 기타 데이터 타입으로 응답 정보를 구성한다.
	public String regist(Cart cart, HttpSession session) {
		Member member = (Member)session.getAttribute("member");
		cart.setMember(member); //세션에서 얻어온 모델을 대입한다.
		
		log.debug("product_id는 " + cart.getProduct().getProduct_id());
		log.debug("ea는 " + cart.getEa());
		log.debug("member_id는 " + member.getMember_id());
		log.debug("선택한 색상은 " + cart.getColor().getColor_id());
		log.debug("선택한 사이즈는 " + cart.getSize().getSize_id());
		
		cartService.regist(cart);
		
		//실패 시에는 응답정보를 200이 아닌 실패코드로 보내주어야 한다.
		//return fail을 주어도 tomcat은 200으로 보내주기 때문이다. jsp에선 success로 받게됨
		return  "ok";
	}
}
