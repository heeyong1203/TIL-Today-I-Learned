<%@page import="com.sinse.practiceapp.model.Comment"%>
<%@page import="java.util.List"%>
<%@page import="com.sinse.practiceapp.repository.CommentDAO"%>
<%@page import="com.sinse.practiceapp.model.PracticeNotice"%>
<%@page import="com.sinse.practiceapp.repository.PracticeNoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%! 
	PracticeNoticeDAO noticeDAO = new PracticeNoticeDAO(); 
	CommentDAO commentDAO = new CommentDAO();
%>
<%
	int notice_id = Integer.parseInt(request.getParameter("notice_id"));
	PracticeNotice notice = noticeDAO.select(notice_id);
	List<Comment> commentList = commentDAO.selectByNoticeId(notice_id);
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
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
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote.min.js"></script>
<script type="text/javascript">
	$(()=>{		
		$("#content").summernote({
			height:250,
		});	//서머노트 연동 
		$("#content").summernote('code', "<%=notice.getContent()%>");
		
	
		$("#bt_edit").click(()=>{
			$("form").attr({
				method: "POST",
				action: "/notice/edit"
			});
			$("form").submit();
		});
	
		$("#bt_delete").click(()=>{
			if(confirm("삭제하시겠습니까?")){
				location.href="/notice/del?notice_id=<%=notice_id%>";
			}
		});
	
		$("#bt_list").click(()=>{
			location.href="/notice/list.jsp"
		});
		
		$("#bt_comment_regist").click(()=>{
			method: "POST",
			action: "/comment/regist"
		});
		$("comment_form").submit();
	});
		
</script>
</head>
<body>

<h3>Contact Form</h3>

<div class="container">
  <form>
  <!-- hidden: html의 컴포넌트의 역할을 수행하나 눈에 보이지는 않게 처리 노출되지 않은 상태로 데이터를 전송할 때 사용 -->
    <input type="hidden" id="notice_id" name="notice_id" value="<%=notice.getNotice_id() %>">
    
    <label for="title">Title</label>
    <input type="text" id="title" name="title" value="<%=notice.getTitle() %>">

    <label for="writer">Writer</label>
    <input type="text" id="writer" name="writer" value="<%=notice.getWriter() %>">

    <label for="content">Content</label>
    <textarea id="content" name="content" placeholder="내용 입력" style="height:200px"></textarea>

    <input type="button" value="수정" id="bt_edit">
    <input type="button" value="삭제" id="bt_delete">
    <input type="button" value="목록" id="bt_list">
  </form>
  
 	<div id="comment_header">
		<form id="comment_form">
			<input type="text" style="width:73%" name="msg">
			<input type="text" style="width:20%" name="user">
			<input type="hidden" name="notice_id" value="<%=notice.getNotice_id()%>">
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
				<td><%=comment.getUser() %></td>
				<td><%=comment.getMsg() %></td>
				<td><%=comment.getMsgdate().substring(0, 10) %></td>
			</tr>
			<% }%>
		</table>
	</div>
</div>


</body>
</html>

