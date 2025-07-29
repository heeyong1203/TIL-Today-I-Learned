package com.sinse.mall.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.sinse.mall.model.member.KakaoApi20;
import com.sinse.mall.model.member.NaverApi20;

/*
  스프링의 고전적 설정을 담당하는 xml을 대신하는 Config.java
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sinse.mall.advice", "com.sinse.mall.shop.controller"})
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
	
	//google 로그인 관련 서비스 객체 등록
	@Bean
	public OAuth20Service googleAuthService() {
		//클라이언트 ID, Secret, 리소스, Owner 콜백주소 접근 범위 등록
		ServiceBuilder builder = new ServiceBuilder("1087480722732-d8mgrvk8kpeef6hhpjg8fgakc5ahgns3.apps.googleusercontent.com"); 
		builder.apiSecret("");
		builder.defaultScope("email profile openid");
		builder.callback("http://localhost:8888/shop/callback/sns/google");
		return builder.build(GoogleApi20.instance());
	}
	
	//naver 로그인 관련 서비스 객체 등록
	@Bean
	public OAuth20Service naverAuthService() {
		//클라이언트 ID, Secret, 리소스, Owner 콜백주소 접근 범위 등록
		ServiceBuilder builder = new ServiceBuilder("wYVvvLJuGi572wwBSpyj"); //id가 naverAuthService에 심어진다.
		builder.apiSecret(""); //secret이 naverAuthService에 심어진다.
		builder.defaultScope("name email");
		builder.callback("http://localhost:8888/shop/callback/sns/naver");
		return builder.build(NaverApi20.instance());
	}

	//kakao 로그인 관련 서비스 객체 등록
	@Bean
	public OAuth20Service kakaoAuthService() {
		//클라이언트 ID, Secret, 리소스, Owner 콜백주소 접근 범위 등록
		ServiceBuilder builder = new ServiceBuilder("4dbad52140883e284aaf5e1ef4992f97"); //REST API의 id가 naverAuthService에 심어진다.
		builder.apiSecret(""); //secret이 naverAuthService에 심어진다.
		builder.defaultScope("profile_nickname profile_image");
		builder.callback("http://localhost:8888/shop/callback/sns/kakao");
		return builder.build(KakaoApi20.instance());
	}
}
