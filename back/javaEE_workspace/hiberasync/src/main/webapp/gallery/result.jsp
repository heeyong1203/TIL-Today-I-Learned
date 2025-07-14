<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 서블릿과는 달리 jsp이므로 session을 내장객체로 접근해 얻어옴
		// session은 java.util.Map을 계승하였으므로, key와 value로 데이터 관리
		// 따라서 session에 넣을 수 있는 데이터의 종류는 한계가 없다.
		String img = (String)session.getAttribute("img");
		out.print(img);
	%>
	<img style="width:300px; height:300px" src="/data/<%=img %>">
</body>
</html>