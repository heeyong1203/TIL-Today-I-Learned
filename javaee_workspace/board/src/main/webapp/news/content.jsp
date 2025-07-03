<%@page import="java.util.List"%>
<%@page import="com.sinse.boardapp.model.Comment"%>
<%@page import="com.sinse.boardapp.repository.CommentDAO"%>
<%@page import="com.sinse.boardapp.model.News"%>
<%@page import="com.sinse.boardapp.repository.NewsDAO"%>
<%@page import="com.sinse.boardapp.util.Paging" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%! 
	NewsDAO newsDAO = new NewsDAO(); 
	CommentDAO commentDAO = new CommentDAO();
%>
<%
	// 내장 객체
	int news_id = Integer.parseInt(request.getParameter("news_id"));
	out.print("넘겨 받은 파라미터는 "+news_id);
	News news = newsDAO.select(news_id);
	List<Comment> commentList = commentDAO.selectByNewsId(news_id);
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
		font-family: Arial, Helvetica, sans-serif;
	}
	* {box-sizing: border-box;}
	
	input[type=text], select, textarea {
	  width: 100%;
	  padding: 12px;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  box-sizing: border-box;
	  margin-top: 6px;
	  margin-bottom: 16px;
	  resize: vertical;
	}
	
	input[type=button] {
	  background-color: #04AA6D;
	  color: white;
	  padding: 12px 20px;
	  border: none;
	  border-radius: 4px;
	  cursor: pointer;
	}
	
	input[type=button]:hover {
	  background-color: #45a049;
	}
	
	.container {
	  border-radius: 5px;
	  background-color: #f2f2f2;
	  padding: 20px;
	}
	  
	table {
		border-collapse: collapse;
		border-spacing: 0;
		width: 100%;
		color: black;
		border: 1px solid #ddd;
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
}
</style>
<%@ include file="/inc/head_link.jsp" %>
<script type="text/javascript">
	$(()=>{		
		$("#content").summernote({ height:250 });	//서머노트 연동 
		$("#content").summernote("code", "<%=news.getContent()%>");
		
		//버튼에 이벤트 연결 
		$("#bt_news_edit").click(()=>{
		});
		
		//버튼에 이벤트 연결 
		$("#bt_news_list").click(()=>{
			location.href="/news/list.jsp";
		});
		
		//댓글에 이벤트 연결 
		$("#bt_comment_regist").click(()=>{
			$("#comment_form").attr({
				method: "POST", 						  // HTTP 프로토콜 통신에 사용되는 데이터 구성(Payload) body에 탑재됨...
				action: "/comment/regist" 
			});
			$("#comment_form").submit(); // 전송
		});
				
	});
</script>
</head>
<body>

<h3>Contact Form</h3>

<div class="container">
	<form>
		<label for="title">Title</label>
		<input type="text" id="title" name="title" value="<%=news.getTitle() %>">
		
		<label for="writer">Writer</label>
		<input type="text" id="writer" name="writer" value="<%=news.getWriter() %>">
		
		<label for="content">Content</label>
		<textarea id="content" name="content" value="내용입력" style="height:200px"></textarea>
		
		<input type="button" id="bt_news_edit" value="수정">
		<input type="button" id="bt_news_del" value="삭제">
		<input type="button" id="bt_news_list" value="목록">
		
	</form>
	<div id="comment_header">
		<form id="comment_form">
			<input type="text" style="width:73%" name="msg">
			<input type="text" style="width:20%" name="user">
			<input type="hidden" name="news_id" value="<%=news.getNews_id() %>">
			<input type="button" id="bt_comment_regist" value="등록">
		</form>
	</div>
	
		<div id="comment_content">
			<table>
				<tr>
					<th>댓글 제목</th>
					<th>작성자</th>
					<th>등록일</th>
				</tr>
				<%for(Comment comment : commentList){ %>
				<tr>
					<td><%=comment.getMsg() %></td>
					<td><%=comment.getUser() %></td>
					<td><%=comment.getMsgdate().subSequence(0, 10) %></td>
				</tr>
				<%} %>
			</table>
		</div>
</div>


</body>
</html>