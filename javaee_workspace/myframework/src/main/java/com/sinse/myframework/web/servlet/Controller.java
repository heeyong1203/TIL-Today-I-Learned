package com.sinse.myframework.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 하위 컨트롤러의 최상위 객체 정의
public interface Controller {
	
	//실행할 로직 내용
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	//매핑된 뷰네임 반환
	public String getViewName();
	
	//포워딩, 리다이렉트 방식 선택 
	public boolean isForward();
}
