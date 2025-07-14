<%@page import="com.sinse.memberapp.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	// 이 서블릿에 요청을 시도할 때 웹컨테이너에서는 세션 객체를 생성하면서, 세션 ID가 할당되어짐
	// 이 세션ID는 웹컨테이너가 보내는 응답정보에 쿠키형태로 존재하게 된다.
	// 단 세션과 세션ID는 매 요청마다 생성되는 것이 아니고, 클라이언트가 요청 시 웹컨테이너가 발급한 쿠키가 존재하지 않을 때 새로 만든다.
	// 요청 후 일정 시간동안 아무런 재요청이 없을 때는 사용하지 않는 것으로 간주하여 새롭게 session을 할당한다.
	
	// String id = session.getId(); // request, out과 더불어 내장객체로 존재하는 session
	// out.print("지금 이 요청에 의해서 할당된 세션 ID는 "+id);
	
	// 만일 클라이언트가 로그인에 성공하면 세션에 member라는 이름으로 Member가 담겨있을 것이다.
	Member member = (Member)session.getAttribute("member");
	out.print(session.getId());
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=member.getName() %>님 안녕하세요
</body>
</html>