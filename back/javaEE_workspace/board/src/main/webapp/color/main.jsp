<%@page import="java.awt.Color"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	// 이 main.jsp가 서블릿으로 변경되었을 때의 service() 메서드 영역
	String bg = request.getParameter("bg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(()=>{
		// 버튼을 누르면 서버의 jsp에게 색상 변경을 요청하자!
		$("button").click(()=>{
			location.href="/color/main.jsp?bg="+$("select").val(); // 링크는 Get방식의 요청이다.
		});
	});
</script>
</head>
<body bgcolor="<%=bg%>">
	<select>
		<option <%if (bg.equals("hotPink")){%>selected<%} %> value="hotPink">hotPink</option>
		<option <%if (bg.equals("pink")){%>selected<%} %> value="pink">pink</option>
		<option <%if (bg.equals("skyBlue")){%>selected<%} %> value="skyBlue">skyBlue</option>
		<option <%if (bg.equals("blue")){%>selected<%} %> value="blue">blue</option>
		<option <%if (bg.equals("orange")){%>selected<%} %> value="orange">orange</option>
		<option <%if (bg.equals("orangeRed")){%>selected<%} %> value="orangeRed">orangeRed</option>
		<option <%if (bg.equals("yellowGreen")){%>selected<%} %> value="yellowGreen">yellowGreen</option>
		<option <%if (bg.equals("Green")){%>selected<%} %> value="Green">green</option>
	</select>
	<button>배경색 바꾸기</button>
</body>
</html>