<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device,initial-scale=1.0"/>
<% request.setCharacterEncoding("utf-8"); %>
 
<%
	String[] meat= request.getParameterValues("meat");
%>  

<%
	if(meat!=null) {
	for(int i=0; i<meat.length; i++) {
		session.setAttribute("meatC"+i, meat[i]);
	}
		session.setAttribute("meatClen", meat.length);
	} else 
		session.setAttribute("meatClen", 0);

%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
다음 둘 중에 마음에 드는 것으로 하나만 선택해서 사야 해!<br> 
<form method="get" action="scanTest.jsp">

<input type="radio" id="dubu" name="dubu" value="1">
<label>두부</label> <br>
<input type="radio" id="dubu" name="dubu" value="2">
<label>순두부</label> <br><br>

<input type="radio" id="milk" name="milk" value="1">
<label>초코</label> <br>
<input type="radio" id="milk" name="milk" value="2">
<label>생우유</label> <br><br>

<input type="checkbox" id="meat" name="meat" value="1">
<label>돼지고기</label> <br>
<input type="checkbox" id="meat" name="meat" value="2">
<label>닭고기</label> <br>
<input type="checkbox" id="meat" name="meat" value="3">
<label>소고기</label> <br>
<input type="checkbox" id="meat" name="meat" value="4">
<label>오리고기</label> <br><br>

<input type="submit" value="다음">
</form>
<img src="picture/<%=session.getAttribute("select")%>.png"> <br>

</body>
</html>