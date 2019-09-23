<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("utf-8"); %>
    
<%
String dubuC =request.getParameter("dubu");
String milkC =request.getParameter("milk");
String[] meat =request.getParameterValues("meat");
int len = (int) session.getAttribute("meatClen");

String[] arr =new String[len];

for(int i=0; i<len; i++) {
	arr[i] = ""+session.getAttribute("meatC"+i);
}

boolean istrue = true;

if(!(session.getAttribute("dubu")==null&&session.getAttribute("milk")==null)){
if(!(dubuC.equals(session.getAttribute("dubu"))&&milkC.equals(session.getAttribute("milk")))) {
	istrue=false;
}
}

if(arr!=null&&meat!=null) {
if(arr.length==meat.length) {
	for(int i=0; i<arr.length; i++) {
		if(!(arr[i].equals(meat[i])))
			istrue=false;
	}
} else {
	istrue=false;
}
}

%>
<jsp:include page="ending.jsp" flush="false"> 
	<jsp:param name="istrue" value="<%=istrue%>" />
</jsp:include>


