<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device,initial-scale=1.0"/>
<% request.setCharacterEncoding("utf-8"); %>

<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	boolean flag=true;
	
	String log_id[] =new String[]
	{ "normalUser", "hardWorker"};
	String log_pwd[] =new String[]
	{ "1234", "abcd" };
	
	for (int i=0; i<2; i++) {
		if(id.equals(log_id[i])&&pwd.equals(log_pwd[i])) {
			response.sendRedirect("settingForm.jsp");
			flag=false;
		}
	}
	if(flag)
	response.sendRedirect("loginForm.jsp");
%>
  