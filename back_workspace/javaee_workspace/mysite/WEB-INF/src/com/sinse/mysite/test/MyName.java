package com.sinse.mysite.test;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException; // standard 패키지..
import java.io.PrintWriter;

// java의 클래스를 이용하여, 나의 이름을 웹브라우저에 출력해보자
// 자바의 클래스 중, 오직 java EE 기반의 서버에서만 해석 및 실행될 수 있는 클래스를 가리켜 서블릿(servlet)이라 함..
public class MyName extends HttpServlet {
								/* servlet으로 정의하려면 servlet을 상속받아야 함! */
	// 부모인 servlet의 doGet을 오버라이드 하자
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // servlet은 개발자가 임의로 메서드를 정의하는 것이 아니라 이미 정해진 메서드가 있음...
		// 웹브라우저에 보여질 html 문서를 작성해본다
		PrintWriter out = response.getWriter(); // 응답 정보를 출력할 스트림 얻기
		out.print("this is my first app!!");
	}
}