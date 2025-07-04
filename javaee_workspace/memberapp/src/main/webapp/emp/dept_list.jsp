<%@page import="com.sinse.memberapp.model.Dept"%>
<%@page import="java.util.List"%>
<%@page import="com.sinse.memberapp.repository.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%! DeptDAO deptDAO = new DeptDAO(); %>

<%
	List<Dept> deptList = deptDAO.selectAll();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width=100%>
		<tr>
			<th style="text-align: center">deptno</th>
			<th style="text-align: center">dname</th>
			<th style="text-align: center">loc</th>
			<th style="text-align: center">count(emp)</th>
		</tr>
		<%for(Dept dept : deptList) {%>
		<tr>
			<td style="text-align: center"><%=dept.getDeptno() %></td>
			<td style="text-align: center"><%=dept.getDname() %></td>
			<td style="text-align: center"><%=dept.getLoc() %></td>
			<td style="text-align: center"><%=dept.getEmps().size() %></td>			
		</tr>
		<%} %>
	</table>
</body>
</html>