<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	/*
	웹 요청 처리 흐름에서, 데이터를 저장할 수 있는 객체의 종류에는 다음과 같은 것들이 있다.
	1) HttpServletRequest: 요청 처리가 끝날 때까지
	2) HttpSession: 세션의 유지 시간까지
	3) ServletContext: 애플리케이션이 실행되는 동안 유지 (톰캣 켤 때, 톰캣 끌 때)
	*/
	request.setAttribute("age", "28");
	session.setAttribute("name", "희용");
	application.setAttribute("nick", "HY");
%>
