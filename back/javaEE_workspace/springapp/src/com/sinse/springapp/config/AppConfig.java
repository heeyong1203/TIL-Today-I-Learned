package com.sinse.springapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sinse.springapp.cook.Cook;
import com.sinse.springapp.cook.FryPan;
import com.sinse.springapp.cook.Induction;

/*
 	전통적인 스프링의 개발 방식에서는 주로 XML이 사용되었으나, spring 2.5버전부터 java 클래스에서도 설정이 가능한 
 	즉, 어노테이션 기반의 설정 방식을 지원하기 시작하여, 현재 스프링 부트에 이르러서는 주로 java 기반 설정이 대세
*/
@Configuration
public class AppConfig {
	
	//클래스 중 스프링의 관리 대상이 되는 클래스를 Bean이라 한다.
	@Bean
	public FryPan fryPan() {
		return new FryPan();
	}
	
	@Bean
	public Induction induction() {
		return new Induction();
	}
	
	@Bean
	//요리사 빈을 생성자 주입으로 위빙(weaving)
	public Cook cook() {
		return new Cook(induction());
	}
}
