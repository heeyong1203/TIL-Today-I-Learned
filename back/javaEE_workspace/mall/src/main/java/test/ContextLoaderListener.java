package test;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//Tomcat이 가동될 때, 감지 처리
public class ContextLoaderListener implements ServletContextListener {
	
	//Tomcat과 같은 웹컨테이너가 가동될 때 동작하는 메서드
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("서버 가동 완료");
		//application 수준 객체인 ServletContext에 내 연락처 저장
		ServletContext context = sce.getServletContext();
		context.setAttribute("tel", "010-5367-9037");
		//스프링에 사용될 beans들을 보관...
	}
	
	//Tomcat과 같은 웹컨테이너가 중단될 때 동작하는 메서드
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("서버 중단");	
	}

}
