<%@page import="com.sinse.practiceapp.repository.PracticeNoticeDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.sinse.practiceapp.model.PracticeNotice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	PracticeNoticeDAO noticeDAO = new PracticeNoticeDAO();
	List<PracticeNotice> list = noticeDAO.selectAll();
	
	int totalRecord = noticeDAO.selectCount(); // 추후 전체 레코드 수로 반환받기
	int pageSize = 10; // 한 페이지 당 보여줄 레코드 수
	int totalPage = (int)Math.ceil((double)totalRecord/pageSize); // 전체 페이지 수
	int blockSize = 10; // 블럭 당 보여질 페이지 수
	int currentPage = 1; // 현재 유저가 보고 있는 페이지
	if(request.getParameter("currentPage")!=null){
		currentPage=Integer.parseInt(request.getParameter("currentPage"));
	};
	int firstPage = currentPage-((currentPage-1)%blockSize); // 블럭 당 첫 페이지
	int lastPage = firstPage + (blockSize-1); // 블럭 당 마지막 페이지
	if(lastPage>=totalRecord) lastPage=totalRecord; 
	
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
  margin: 0 auto;
}

#div1 {
  height: 680px;
  width: 280px;
  border: 1px solid #DBA111;
}

table {
  border-collapse: collapse;
  border-spacing: 0;
  color: black;
  width: 1200px;
  border: 1px solid #DBA111;
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
			location.href="/notice/write.jsp";		
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
				<th colspan="2" style="text-align:center">제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<%for(int i=firstPage; i<list.size(); i++){ %>
			<%PracticeNotice notice = list.get(i); %>
			<tr>
				<td><%=notice.getNotice_id() %></td>
				<td><a href="/notice/content.jsp?notice_id=<%=notice.getNotice_id()%>"><%=notice.getTitle() %></a></td>
				<td><%=notice.getWriter() %></td>
				<td><%=notice.getRegdate().substring(0, 10) %></td>
				<td><%=notice.getHit() %></td>
			</tr>
			<%} %>
			<tr>
				<td colspan="5"><button>글 등록</button></td>
				<a href="">[이전]</a>
				<a href="">[다음]</a>
			</tr>
		</table>
	</div>
	
	
	
	
<%="totalRecord="+totalRecord+"<br>"%>
<%="pageSize="+pageSize+"<br>"%>
<%="totalPage="+totalPage+"<br>"%>
<%="blockSize="+blockSize+"<br>"%>
<%="currentPage="+currentPage+"<br>"%>
<%="firstPage="+firstPage+"<br>"%>
<%="lastPage="+lastPage+"<br>"%>


</body>
</html>
