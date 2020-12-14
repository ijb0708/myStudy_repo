<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device,initial-scale=1.0"/>
<% request.setCharacterEncoding("utf-8"); %>
 
<%
	String dubu= request.getParameter("dubu");
	session.setAttribute("dubu", dubu);
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
다음 둘 중에 마음에 드는 것으로 하나만 선택해서 사야 해!<br> 
<form method="post" action="scan3.jsp">
<input type="radio" id="milk" name="milk" value="1">
<label>초코</label> <br>
<input type="radio" id="milk" name="milk" value="2">
<label>생우유</label> <br>
<input type="submit" value="다음">
</form>
<img src="picture/<%=session.getAttribute("select")%>.png"> <br>

</body>
</html>