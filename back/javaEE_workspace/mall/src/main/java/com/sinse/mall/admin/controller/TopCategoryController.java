package com.sinse.mall.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinse.mall.model.category.TopCategoryService;

//스프링이 관리하는 Beans 중 특별히 그 용도가 정해진 Bean을 가리켜 Component라고 한다.
//잘 알려진 Component에는 @Controller, @Server, @Repository, @Component
//이 컴포넌트들은 ComponentScan의 대상이 될 수 있으며, 일일이 @Bean 등록하지 않아도 된다.
@Controller
public class TopCategoryController {
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	@GetMapping("/admin/topcategory/list")
	@ResponseBody //응답 데이터 형식이 html 문서가 아닌 json 등의 순수 데이터인 경우에 사용한다.
	public List selectAll() {
		//@ResoponseBody 선언시 ViewResolver인 InternalResourceViewResolver가 동작하지 않는다.
		// 접두어, 접미어의 조합을 시도하지 않으므로, response.setContentType("application/json")의 효과를 낸다.
		
		List topList = topCategoryService.selectAll();
		//스프링을 사용하지 않을 경우, 개발자가 List를 Gson 또는 직접 json문자열로 응답 정보를 만들어야 한다.
		//스프링은 개발에 필요한 모든 것을 지원하는 프레임워크이므로 코드를 단순화 시켜준다.
		//스프링은 List를 반환형으로 지정한다면 자체적으로 변환해준다.(ResponseBody이용)
		//단 이 때, List를 어떻게 변환할 것인지 converter가 필요한데, 외부 라이브러리(jackson databind)가 필요하다.
		return topList;
	}
}
