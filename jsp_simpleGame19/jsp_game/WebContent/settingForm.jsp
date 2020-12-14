<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<label>이름</label>
<form method="post" action="settingTest.jsp">
<input type="text" placeholder="미니언" id="name" name="name"> <br>
<label>캐릭터</label>
<input type="radio" id="select" name="select" value="boy">
<img src="picture/boy.png">
<input type="radio" id="select" name="select" value="girl">
<img src="picture/girl.png">
<input type="submit" value="작성">
</form>
</body>
</html>