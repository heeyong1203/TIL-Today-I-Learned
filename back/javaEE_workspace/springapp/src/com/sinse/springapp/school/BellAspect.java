package com.sinse.springapp.school;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
  	Aspect 지향 프로그래밍의 개념 및 라이브러리는 스프링의 것이 아니다.
  	
  	스프링이 개발되기 이전부터 IT분야에 있던 개념이며, 자바 기반의 AOP 라이브러리도 aspectj라고 불리던 것이 있었다.

*/

@Aspect
@Component //스프링이 이 객체를 자동으로 메모리에 올림
public class BellAspect {
	@Autowired //자동 주입 (스프링 컨테이너가 보유한 Bell 빈을 아래 멤버 변수에 자동으로 주입)
	private Bell bell; //공통코드, 횡단적 관심사
	
	@Before("execution(* com.sinse.springapp.school.Student.*(..))")
	// @Before("execution(public void Student의 모든 메서드(매개변수가 몇개든지))")
	public void ringBell() {
		bell.sound();
	}
}
