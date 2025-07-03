<%@ page contentType="text/html; charset=UTF-8"%>
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
</style>
<%@ include file="/inc/head_link.jsp" %>
<script type="text/javascript">
	$(()=>{		
		$("#content").summernote({
			height:250
		});	//서머노트 연동 
		
		//버튼에 이벤트 연결 
		$("input[type='button']").click(()=>{
			$("form").attr({
				action:"/news/regist",
				
				//머리에 데이터를 실어 나르게 됨, 따라서 편지봉투에 나르는 겪, 문제1)노출 문제2)내용짤린다
				//body인 post로 보내자
				method:"POST",  
			});
			$("form").submit(); //전송
		});
		
	});
</script>
</head>
<body>

<h3>Contact Form</h3>

<div class="container">
  <form>
    <label for="title">Title</label>
    <input type="text" id="title" name="title" placeholder="제목입력..">

    <label for="writer">Writer</label>
    <input type="text" id="writer" name="writer" placeholder="작성자 입력..">

    <label for="content">Content</label>
    <textarea id="content" name="content" placeholder="내용입력" style="height:200px"></textarea>

    <input type="button" value="Submit">
  </form>
</div>

</body>
</html>