package com.sinse.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 모든 컨트롤러들의 최상위 객체 정의
public interface Controller {
	// java의 is a 관계 이용
	
	// 모든 하위 컨트롤러들이 업무 수행할 때 호출 메서드 정의
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	// 모든 하위 컨트롤러들이, 어떤 페이지를 검색해야할 지를 DispatcherServlet에게 알려주기 위한 메서드 정의
	public String getViewPage();
}
