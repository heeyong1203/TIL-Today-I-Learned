package com.sinse.mall.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sinse.mall.domain.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProductController {
		
	// localhost:8282/admin/admin/product/registform
	@RequestMapping(value = "/admin/product/registform")
	public ModelAndView registForm() {
		//상품 등록페이지를 보게 되는 초기에 상위 카테고리가 채워져있어야 한다.
		
		//4단계: 결과 저장
		ModelAndView mav = new ModelAndView();
		mav.setViewName("secure/product/regist");
		
		return mav;
	}
	
	//상품 등록 요청을 처리
	@PostMapping("admin/product/regist")
	public ModelAndView regist(Product product, HttpServletRequest request) {
		//MultipartFile 변수와 html 이름이 동일하면 매핑됨
		//모델 객체는 table을 반영한 객체이므로 컨트롤러 영역에서 바로 파라미터를 받는 용도로 사용해서는 안된다.
		//DB 컬럼명이 노출되어 보안상 문제가 생기기 때문이다. 해결책으로 클라이언트의 파라미터를 받는 용도로써의 객체를 별도로 두어야 한다.(DTO)
		//DTO: Data Transfer Object.. DTO에서 Model 객체로 옮겨야 한다.
		
		ModelAndView mav = new ModelAndView();
		//3단계: 일 시키기
		mav.setViewName("redirect:/admin/admin/product/list");
		
		ServletContext context = request.getServletContext(); //jsp에선 application 내장 객체
		String realPath = context.getRealPath("/data");
		log.debug("realPath is "+realPath);
		
		//4단계: DML은 저장할 것이 없음
		return mav;
	}
}
