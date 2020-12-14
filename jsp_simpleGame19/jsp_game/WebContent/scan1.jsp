<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
다음 둘 중에 마음에 드는 것으로 하나만 선택해서 사야 해!<br> 
<form method="post" action="scan2.jsp">
<input type="radio" id="dubu" name="dubu" value="1">
<label>두부</label> <br>
<input type="radio" id="dubu" name="dubu" value="2">
<label>순두부</label> <br>
<input type="submit" value="다음">
</form>
<img src="picture/<%=session.getAttribute("select")%>.png"> <br>
</body>
</html>