package com.sinse.springtest.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration //이 클래스는 설정 클래스임을 명시  
@EnableWebMvc //<mvc:annotation-driven/> 대체
/*
 * [ 기능 ]
 * 1.핸들러 매핑 & 어댑터 활성화 
 * 	    @RequestMapping 기반의 요청 처리를 가능하게 함
 *  
 * 2. @Valid, @RequestBody, @ResponseBody 등 지원 
 * 		
 * 		(1)@Valid, @ModelAttribute, @InitBinder, @ResponseBody, @RequestBody, @PathVariable 등의 
 * 			컨트롤러 매개변수 바인딩 관련 기능들을 사용 가능하게 해줌
 * 		(2) 메시지 컨버터(HttpMessageConver) 를 자동으로 등록하여 JSON/XML 자동 변환을 지원 
 * 
 * 3.기본 Validator, ConversionService 등록 
 * 4.MessageConverter 등록 
 * 		@ResponseBody 를 통해 객체를 JSON 으로 자동 변환하려면 이 설정이 필요함 
 * */
@ComponentScan(basePackages = "com.sinse.springtest")   // <context:component-scan> 대체
public class SpringConfig {
	
	//빈 등록 
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**") //url pattern 
					.addResourceLocations("/resources/"); //실제 위치 
	}
	
	//json, 문자열 처리 시 필요 
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new MappingJackson2HttpMessageConverter());
		converters.add(new StringHttpMessageConverter());
	}
	
	//파일 업로드 처리 
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		resolver.setMaxUploadSize(10*1024*1024); //10MB
		return resolver;
	}
}








