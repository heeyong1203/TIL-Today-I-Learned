<%@page import="com.sinse.mvcapp.util.Paging"%>
<%@page import="com.sinse.mvcapp.model.Notice"%>
<%@page import="com.sinse.mvcapp.repository.NoticeDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	List<Notice> list = (List)session.getAttribute("noticeList");
  	System.out.println("JSP에서 가져온 list = " + list);
	Paging paging = new Paging();
	paging.init(list, request);
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<style>
body {
  background: #034694; /* 첼시 블루 */
  color: #ffffff;
  margin: 0;
  font-family: Arial, sans-serif;
}

#container {
  display: flex;
  gap: 40px;
  width: 1600px;
  height: 780px;
  margin: 0 auto;
}

#div1 {
  height: 100%;
  width: 17.5%;
  border: 1px solid #DBA111;
  background-color: #D8D8D8;
}

table {
  border-collapse: collapse;
  border-spacing: 0;
  color: black;
  width: 75%;
  border: 1px solid #DBA111;
}

a{
	text-decoration: none;
	color: black;
}

th, td {
  text-align: left;
  vertical-align: middle;
  padding: 10px;
  height: 40px;
}

tr:nth-child(even) {
   background-color: #FCFCFC;
  border-bottom: 1px solid #D1D3D4;
}

tr:nth-child(12) {
  border-bottom: none; /* 마지막 줄은 라인 생략도 가능 */
  background-color: #D8D8D8;
}

tr:last-child {
  border-bottom: none; /* 마지막 줄은 라인 생략도 가능 */
  background-color: #D8D8D8;
}

.pageNum{
	font-size:27;
	font-weight:bold;
	color:#DBA111;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(()=>{
		$("button").click(()=>{
			location.href="/notice/write.jsp"
		});
	});
</script>
</head>
<body>

	<h1 style="text-align:center">일반 게시판</h1>
	<h3 style="text-align:center">We Are The Blues</h3>
	
	<div id="container">
		<div id="div1"></div>
		<table>
		  	<tr>
				<th style="text-align:center">No</th>
				<th style="text-align:center">제목</th>
				<th style="text-align:center">작성자</th>
				<th style="text-align:center">작성일</th>
				<th style="text-align:center">조회수</th>
			</tr>
		<% 
			int curPos = paging.getCurPos();
			int num = paging.getNum();
			
			for(int i=0; i<paging.getPageSize(); i++){
				if(paging.getNum() > 0 && curPos <paging.getTotalRecord()){
				Notice notice = list.get(curPos++);
		%>
		 	<tr>
				<td style=	"text-align:center"><%=num-- %></td>
				<td style="text-align:center"><a href="/notice/content.do?notice_id=<%=notice.getNotice_id()%>"><%=notice.getTitle() %></a></td>
				<td style="text-align:center"><%=notice.getWriter() %></td>
				<td style="text-align:center"><%=notice.getRegdate() %></td>
				<td style="text-align:center"><%=notice.getHit() %></td>
			</tr>
			<%} else {%>
			<tr>
				<td style="text-align:center"></td>
				<td style="text-align:center"></td>
				<td style="text-align:center"></td>
				<td style="text-align:center"></td>
				<td style="text-align:center"></td>
			</tr>			
			<%
					}
				} 
			%>
		  	<tr>
				<td colspan="5" style="text-align:center">
				<%if(paging.getFirstPage() - 1 > 0){ %>
				<a href="/notice/list.jsp?currentPage=<%=paging.getFirstPage() - 1%>">[이전]</a>
				<%} %>
				<%for (int i = paging.getFirstPage() ; i <= paging.getLastPage() ; i++){ %>
				<a <%if (paging.getCurrentPage() == i){%>class = "pageNum"<% }%> href="/notice/list.jsp?currentPage=<%=i%>">[<%=i %>]</a>
				<%} %>
				<%if (paging.getLastPage() + 1 < paging.getTotalPage()){ %>
				<a href="/notice/list.jsp?currentPage=<%=paging.getLastPage() + 1%>">[다음]</a>
				<%} %>
				</td>
			</tr>
			<tr>
				<td style="text-align: right;" colspan="5">
					<button>글 등록</button>
				</td>
			</tr>
		</table>
</div>

</body>
</html>
