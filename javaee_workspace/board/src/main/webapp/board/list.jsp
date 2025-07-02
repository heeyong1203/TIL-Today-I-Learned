<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- 페이징 : 데이터를 분할하는 기법 -->
<!-- 블럭처리 추가 -->
<%
	int totalRecord = 86; // 총 레코드 수
	int pageSize = 10; // 한 페이지 당 보여질 레코드 수
	int totalPage=(int)Math.ceil((float)totalRecord / pageSize); // 총 페이지 수
	int blockSize = 10; // 블럭 당 보여질 페이지 수
	int currentPage = 1; // 현재 유저가 보고 있는 페이지
	if(request.getParameter("currentPage") != null){
		currentPage=Integer.parseInt(request.getParameter("currentPage"));
	};		
	int firstPage = ((int)Math.ceil((float)currentPage/blockSize)-1)*blockSize+1; // 블럭 당 시작 페이지
	// int firstPage = currentPage - ((currentPage-1)%blockSize);
	int lastPage = firstPage+(blockSize-1); // 블럭 당 마지막 페이지
	if(lastPage>=totalRecord){lastPage=totalRecord;}
	
%>
	
<%="totalRecord="+totalRecord+"<br>"%>
<%="pageSize="+pageSize+"<br>"%>
<%="totalPage="+totalPage+"<br>"%>
<%="blockSize="+blockSize+"<br>"%>
<%="currentPage="+currentPage+"<br>"%>
<%="firstPage="+firstPage+"<br>"%>
<%="lastPage="+lastPage+"<br>"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
.pageNum{
	font-size:27;
	font-weight:bold;
	color:red;
}
</style>
</head>
<body>

<h2>Chelsea</h2>
<p>LeagueTable</p>

<table>
	<tr>
		<th>시즌</th>
		<th>순위</th>
		<th>유럽대항전</th>
	</tr>
	<% for(int i=1; i<=pageSize; i++){ %>
	<tr>
		<td>24-25</td>
		<td>4</td>
		<td>챔피언스리그 진출</td>
	</tr>
	<%} %>
	<tr>
	<td colspan="3" align="center">
	<%if(firstPage-1>0){ %>
	<a href="/board/list.jsp?currentPage=<%=firstPage-1%>">◀</a>
	<%} else { %>
	<a href="javascript:alert('이전 페이지가 없습니다.');">◀</a>
	<%} %>
	<% for(int i=firstPage; i<=lastPage; i++){%>
		<a <%if(currentPage==i){ %>class = "pageNum"<%} %> href="/board/list.jsp?currentPage=<%=i %>">[<%=i %>]</a>	
	<%} %>
	<%if(lastPage+1<totalRecord){ %>
	<a href="/board/list.jsp?currentPage=<%=lastPage+1 %>">▶</a>
	<%} else { %>
	<a href="javascript:alert('다음 페이지가 없습니다.');">▶</a>
	<%} %>
	</td>
	</tr>
</table>

</body>
</html>
