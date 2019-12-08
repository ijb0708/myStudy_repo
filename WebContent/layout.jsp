<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
</style>

</head>
<body>
	<c:choose>
		<c:when test="${isAdmin == true}">
			<jsp:include page="navs/memberNav.jsp" />
		</c:when>
		<c:when test="${isAdmin == false}">
			<jsp:include page="navs/adminNav.jsp" />
		</c:when>
		<c:otherwise>
			<jsp:include page="navs/noneNav.jsp" />
		</c:otherwise>
	</c:choose>
	<jsp:include page="${page}" />
</body>
</html>