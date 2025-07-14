<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	// 자바 코드 내 로직이 아닌 설정 정보를 직접 작성하면 유지보수성이 떨어질 수 있다.
	// 데이터베이스 연동 정보, 이메일 설정 정보, 업로드 파일의 경로...등이 그러하다.
	// 이 때 개발자는 자바 코드 밖의 외부 설정 파일에 자원을 관리할 수 있으며, 이 기술을 가리켜 JNDI라고 부른다.
	// JNDI: Java Naming Directory Interface
	// 설정 정보를 외부에 두고서, 이름을 찾아 자원을 접근하는 기술이다.
	// 이 실습은 여러 자원들 중 jndi로 관리할 대상이 아파치에서 만든 커넥션풀이다.
	
	InitialContext context = new InitialContext();
	
	// server.xml에 명시된 jndi/mysql이라는 이름으로 검색 시작
	DataSource ds = (DataSource)context.lookup("java:comp/env/jndi/mysql"); // java component environment
	Connection con = ds.getConnection(); // 커넥션풀로부터 커넥션 하나 꺼내기
	out.print(con);
%>