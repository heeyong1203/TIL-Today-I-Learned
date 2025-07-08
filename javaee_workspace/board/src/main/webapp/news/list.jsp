<%@page import="com.sinse.boardapp.util.Paging"%>
<%@page import="com.sinse.boardapp.model.News"%>
<%@page import="com.sinse.boardapp.repository.NewsDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%! 
	NewsDAO newsDAO = new NewsDAO();
	Paging paging = new  Paging();
%>
<%
	List<News> newsList = newsDAO.selectAll();
	paging.init(newsList, request);
%>	


<!DOCTYPE html> <!-- out.print로 표기되는 일반 html 요소 -->
<html>
<head>
<%@ include file="/inc/head.jsp" %> <!-- 코드를 웹컨테이너가 알아서 불러와줌 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<style>
body {
	background: #034694; /* 첼시 블루 */
	color: #ffffff;
	font-family: Arial, sans-serif;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	color: black;
	border: 1px solid #ddd;
}

a{
	text-decoration: none;
	color: black;
}

.pageNum{
	font-size:27;
	font-weight:bold;
	color:#DBA111;
}

th, td {
	text-align: left;
	padding: 16px;
}

tr:nth-child(odd) {
	background-color: #D1D3D4; /* 회색 줄무늬 */
}

tr:nth-child(even) {
	background-color: #ffffff;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(()=>{
		$("button").click(()=>{
			location.href="/news/write.jsp"
		});
	});

</script>
</head>
<body>

	<h2>게시판</h2>
	<p>게시판입니당</p>

	<table>
		<tr>
			<th>No</th>
			<th>기사 제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<%
			int num = paging.getNum(); 
			int curPos = paging.getCurPos(); 
		%>
		<%for (int i = 0; i < paging.getPageSize(); i++) {%>
		<%if(num<1) break; // 페이지 번호가 1보다 작아지면 멈춰라 %>
		<%News news = newsList.get(curPos++); %> 
		<tr>
			<td><%=num-- %></td>
			<td><a href="/news/content.jsp?news_id=<%=news.getNews_id()%>"><%=news.getTitle() %></a>[<%=news.getCommentList().size() %>]</td>
			<td><%=news.getWriter() %></td>
			<td><%=news.getRegdate() %></td>
			<td><%=news.getHit() %></td>
		</tr>
		<%}%>
		<tr>
			<td style="text-align: center;" colspan="5">
				<a href="#">◀</a>
				<%for (int i = paging.getFirstPage(); i <= paging.getLastPage(); i++) {%>
				<%if(i>paging.getTotalPage()) break; // 총 페이지수를 넘어서면 그만두기 %> 
				<a <%if(paging.getCurrentPage()==i){ %>class="pageNum" <%} %> href="/news/list.jsp?currentPage=<%=i %>">[<%=i%>]</a> 
				<%}%>
				<a href="#">▶</a>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;" colspan="5">
				<button>글쓰기</button>
			</td>
		</tr>
	</table>
<%="currentPage="+paging.getCurrentPage() %>
<%="num="+paging.getNum() %>

</body>
</html>
