package mvcproject.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//모든 하위 컨트롤러들의 최상위 인터페이스
public interface Controller {
	
	//DispatcherServlet 대신 요청을 처리하므로 request, response가 필요하다.
	public void execute(ServletRequest request, ServletResponse response) throws ServletException, IOException;
	
	// 포워딩, 리다이렉트 방식 설정 요청
	public boolean isForward();
	
	//5단계 업무를 수행할 DispatcherServlet에게 뷰 페이지를 검색할 수 있는 검색어 반환
	public String getViewName();
	
}
