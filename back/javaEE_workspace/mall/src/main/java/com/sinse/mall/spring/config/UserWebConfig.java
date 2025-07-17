package com.sinse.mall.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
  스프링의 고전적 설정을 담당하는 xml을 대신하는 Config.java
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sinse.mall.shop.controller"})
public class UserWebConfig {
	
	/*하위 컨트롤러가 3, 4단계를 수행한 후, DispatcherServlet에게 정확한 파일명이 아닌
	 	파일명의 일부 단서만 반환한다. (ModelAndView에 심어서 반환) 
	 	따라서 이 객체를 넘겨받은 DispatcherSerlvet은 일부 단서를 직접 해석하는 것이 아니라,
	 	View에 대한 해석을 담당하는 전담객체(ViewResolver)에게 맡긴다.
	 	JSP 사용 시 주로 사용되는 ViewResolver는 InternalResourceViewResolver
	 	
	 	하위 컨트롤러가 notice/list를 심어 보내면 /WEB-INF/views/notice/list.jsp
 	*/
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
