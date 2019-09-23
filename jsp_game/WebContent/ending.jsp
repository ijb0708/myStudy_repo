<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%
String istrue =request.getParameter("istrue");

if(istrue.equals("true")) {
	out.print("잘갔다오렴");
}else {
	out.print("죽어락 이악마야");
}
%>
<img src="picture/<%=session.getAttribute("select")%>.png">

