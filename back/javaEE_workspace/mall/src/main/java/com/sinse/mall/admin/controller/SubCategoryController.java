package com.sinse.mall.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinse.mall.model.category.SubCategoryDAO;
import com.sinse.mall.model.category.SubCategoryService;

@Controller
public class SubCategoryController {
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	//선택된 상위 카테고리에 소속된 하위 카테고리 목록 가져오기
	@GetMapping("/admin/subcategory/list")
	@ResponseBody //Response.setContentType("application/json"); 문서가 아닌 여러 데이터형으로 전달함 xml, json, memo, text...
	public List getList(int topcategory_id) { //클라이언트의 파라미터명과 컨트롤러 메서드의 변수명이 일치하면 자동으로 매핑이 된다.
		
		//3단계: 일 시키기
		List subList = subCategoryService.selectByTopCategoryId(topcategory_id);
		
		return subList;
	}
}
