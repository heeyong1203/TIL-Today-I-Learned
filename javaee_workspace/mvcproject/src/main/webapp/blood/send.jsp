<%@page import="mvcproject.blood.model.BloodManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	/*
	모델1 방식: JSP 또는 서블릿이 MVC 중 VC를 담당하는 개발
	모델2 방식: MVC패턴을 JavaEE 기술로 구현해놓은 모델
					Model: 단순 .java파일(Plain Old Java Object)
					참조) POJO의 유래: 초창기 JAVA가 세상에 이름을 알리기 시작하자, 호기롭게 엔터프라이즈 시장을 노렸으나 참패하였다.
							컴포넌트 기반의 Java 기술 → 기업용 자바(JavaEE)...
							JavEE(Enterprise Java Bean 많이는 쓰였으나, 자바 기술을 너무 벗어났다. 순수 자바기술로 보기 어려웠음, 트랜잭션 자동처리 예외 이메일...)
							로드 존슨 책 (Export one on one) - EJB는 자바가 아니다!
							순수자바(POJO) + xml만으로도 자동 트랜잭션이 가능함을 증명하였고, 본인이 만든 프로그램을 가리켜 스프링이라고 하였음 
					View: 보여지는 부분은 jsp로 구현
					Controller: Servlet으로 구현
	*/
	// jsp 파일 하나로 모든 것을 처리하는 방법
	String msg=null;
	out.print(msg);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/blood.do" method="post">
		<select name="blood">
			<option value="">혈액형 선택</option>
			<option value="A">A형</option>
			<option value="B">B형</option>
			<option value="O">O형</option>
			<option value="AB">AB형</option>
		</select>
		<button>전송</button>
	</form>
	
</body>
</html>