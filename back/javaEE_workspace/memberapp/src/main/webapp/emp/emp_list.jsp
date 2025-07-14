<%@page import="com.sinse.memberapp.model.Emp"%>
<%@page import="java.util.List"%>
<%@page import="com.sinse.memberapp.repository.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%! EmpDAO empDAO= new EmpDAO(); %>

<%
	List<Emp> emps= empDAO.selectAll();

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
			<th style="text-align: center">empno</th>
			<th style="text-align: center">ename</th>
			<th style="text-align: center">job</th>
			<th style="text-align: center">mgr</th>
			<th style="text-align: center">hiredate</th>
			<th style="text-align: center">sal</th>
			<th style="text-align: center">comm</th>
			<th style="text-align: center">deptno</th>
			<th style="text-align: center">dname</th>
			<th style="text-align: center">loc</th>
		</tr>
		<%for(Emp emp : emps) {%>
		<tr>
			<td style="text-align: center"><%=emp.getEmpno() %></td>
			<td style="text-align: center"><%=emp.getEname() %></td>
			<td style="text-align: center"><%=emp.getJob() %></td>
			<td style="text-align: center"><%=emp.getMgr() %></td>			
			<td style="text-align: center"><%=emp.getHiredate()%></td>			
			<td style="text-align: center"><%=emp.getSal() %></td>			
			<td style="text-align: center"><%=emp.getComm() %></td>			
			<td style="text-align: center"><%=emp.getDept().getDeptno()%></td>			
			<td style="text-align: center"><%=emp.getDept().getDname() %></td>			
			<td style="text-align: center"><%=emp.getDept().getLoc() %></td>			
		</tr>
		<%} %>
	</table>
</body>
</html>