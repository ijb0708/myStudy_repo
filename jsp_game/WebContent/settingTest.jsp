<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device,initial-scale=1.0"/>
<% request.setCharacterEncoding("utf-8"); %>
    
<%
	String name= request.getParameter("name");
	String select= request.getParameter("select");
	
	session.setAttribute("name", name);
	session.setAttribute("select", select);
	
	response.sendRedirect("main.jsp");
%>