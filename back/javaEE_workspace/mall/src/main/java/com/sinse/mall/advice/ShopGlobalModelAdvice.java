package com.sinse.mall.advice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sinse.mall.model.category.TopCategoryService;

//Shop에 존재하는 모든 컨트롤러의 공통 기능을 처리하는 전담 클래스
//즉 모든 컨트롤러마다, 코드를 중복시키지 않기 위함
@ControllerAdvice //Controller가 동작하기 전에 먼저 동작한다.
public class ShopGlobalModelAdvice {
	
	//쇼핑몰의 메인 네비게이션에 출력된 최상위 카테고리는 jsp를 매핑하는 모든 ~~컨트롤러에서 
	//처리해야할 공통 코드이므로 여기서 처리한다.
	@Autowired
	private TopCategoryService topCategoryService;
	

	@ModelAttribute("topList")	//모든 하위 컨트롤러에서 사용할 모델 데이터를 저장한다. model.setAttribute와 동일하게 동작
	public List getTopList() {		//동작 시점? 모든 @RequestMapping() 명시된 하위 컨트롤러의 메서드가 동작하기 전에 자동으로 실행된다.
		return topCategoryService.selectAll();
	}
}
