package com.sinse.springmvc.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/* xml로 스프링이 관리할 bean을 설정하는 방식이 아닌, java 클래스 기반 설정 방식 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sinse.springmvc.spring.controller"})
public class WebConfig {
	/*
			<bean class="~~.InternalResourceViewResolver" id="resolver">
				<property name="prefix" value="">
				<property name="suffix" value="">				
			</bean>
	*/
	
	 @Bean
	 public InternalResourceViewResolver viewResolver() {
		 //하위 컨트롤러들이 DispatcherServlet에게 뷰의 이름을 반환하면 DispatcherServlet은 이 이름을 이용하여, jsp 페이지를 조합하게 된다.
		 InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		 viewResolver.setPrefix("/WEB-INF/views/");
		 viewResolver.setSuffix(".jsp");
		 return viewResolver;
	 }
	
}
