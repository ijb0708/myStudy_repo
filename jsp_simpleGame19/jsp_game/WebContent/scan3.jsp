<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device,initial-scale=1.0"/>
<% request.setCharacterEncoding("utf-8"); %>
 
<%
	String milk= request.getParameter("milk");
	session.setAttribute("milk", milk);
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
다음 둘 중에 마음에 드는 것으로 하나만 선택해서 사야 해!<br> 
<form method="post" action="scan4.jsp">
<input type="checkbox" id="meat" name="meat" value="1">
<label>돼지고기</label> <br>
<input type="checkbox" id="meat" name="meat" value="2">
<label>닭고기</label> <br>
<input type="checkbox" id="meat" name="meat" value="3">
<label>소고기</label> <br>
<input type="checkbox" id="meat" name="meat" value="4">
<label>오리고기</label> <br>
<input type="submit" value="다음">
</form>
<img src="picture/<%=session.getAttribute("select")%>.png"> <br>

</body>
</html>