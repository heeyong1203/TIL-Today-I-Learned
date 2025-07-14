<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
			height: 250
		});
		
		$("input[type='button']").click(()=>{
			$("form").attr({
				action: "/notice/regist",
				method: "POST",
			});
			$("form").submit();
		});
		
	})
</script>
</head>
<body>

<h3>Contact Form</h3>

<div class="container">
  <form>
	<label for="title">제목</label>
    <input type="text" id="title" name="title" placeholder="제목을 입력해주세요...">

    <label for="writer">작성자</label>
    <input type="text" id="writer" name="writer" placeholder="작성자를 입력해주세요...">

    <label for="content">내용</label>
    <textarea id="content" name="content" placeholder="내용을 입력해주세요..." style="height:200px"></textarea>

    <input type="button" value="글 쓰기">
  </form>
</div>

</body>
</html>