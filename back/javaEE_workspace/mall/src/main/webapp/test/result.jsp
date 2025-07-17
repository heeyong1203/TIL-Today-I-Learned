<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String age = (String)request.getAttribute("age");
	String name = (String)session.getAttribute("name");
	String nick = (String)application.getAttribute("nick");
	String tel = (String)application.getAttribute("tel");
			
	out.print("request에 담은 나의 나이는 " + age);
	out.print("<br>");
	out.print("session에 담은 나의 이름은 " + name);
	out.print("<br>");
	out.print("application에 담은 나의 별명은 " + nick);
	out.print("<br>");
	out.print("application에 담은 나의 연락처는 " + tel);
%>