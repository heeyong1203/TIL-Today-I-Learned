<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	// jsp 파일 하나로 모든 것을 처리하는 방법
	String blood = request.getParameter("blood");
	String msg = null;
	
	if(blood != null){
		if(blood.equals("A")){
			msg="신중하고 꼼꼼함";
		} else if (blood.equals("B")){
			msg="자유롭고 개성이 강함";
		} else if (blood.equals("O")){
			msg="외향적이고 리더십이 강함";
		} else if (blood.equals("AB")){
			msg="이성적이고 독특함";
		}
		out.print(msg);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/blood/send.jsp" method="post">
		<select name="blood">
			<option value="">혈액형 선택</option>
			<option value="A">A형</option>
			<option value="B">B형</option>
			<option value="O">O형</option>
			<option value="AB">AB형</option>
		</select>
		<button>전송</button>
	</form>
	
</body>
</html>