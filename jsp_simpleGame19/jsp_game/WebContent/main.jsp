<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=session.getAttribute("name")%>!
오늘은 심부름을 갔다와라
<img src="picture/<%=session.getAttribute("select")%>.png"> <br>
<form method action="scan1.jsp"><input type="submit" value="다음"></form>
</body>
</html>