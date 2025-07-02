package com.sinse.practiceapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 클라이언트가 전송한 글쓰기 폼의 파라미터들을 받아 db에 insert 시키는 서블릿
public class RegistServlet extends HttpServlet {
	
	// 클라이언트인 브라우저가 전송한 변수 = 파라미터값을 받아 db에 넣기
	
	// 요청 객체에 들어있는 파라미터 꺼내기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		System.out.println(title);
		System.out.println(writer);
		System.out.println(content);
	}
}
