<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.sinse.memberapp.mybatis.MybatisConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	MybatisConfig comp = MybatisConfig.getInstance();
	SqlSession sqlSession = comp.getSqlSession();
	out.print(sqlSession);

%>
