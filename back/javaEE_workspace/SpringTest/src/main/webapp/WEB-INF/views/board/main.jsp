<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#wrapper{
	width:1400px;
	height:900px;
	background:yellow;
	margin:auto;
}
#west{
	width:200px;
	height:100%;
	background:aqua;
	float:left;
}
#content{
	width:1000px;
	height:100%;
	background:purple;
	float:left;
}
#east{
	width:200px;
	height:100%;
	background:green;
	float:left;
}
</style>
</head>
<body>
	
	<div id="wrapper">
		<div id="west">좌측</div>
		<div id="content">센터</div>
		<div id="east">우측</div>
	</div>
	
</body>
</html>