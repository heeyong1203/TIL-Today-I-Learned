package com.sinse.springapp.school;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.sinse.springapp.school")
public class AppConfig {
	
	@Bean
	public Bell bell() { // <bean class="~[경로]~.Bell" id="bell"></bean>의 xml과 동일
		return new Bell();
	}
	
	@Bean
	public Student student() { // <bean class="~[경로]~.Student" id="student"/>의 xml과 동일
		return new Student();
	}
	
}
