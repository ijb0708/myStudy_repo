<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<link rel="stylesheet" href="/shoppingmall/css/style.css" />

<div id="listHeader">
	<button id="bookMain">관리자 메인으로</button>
	<button id="bookList">목록으로</button>
<form action="itemRegister.do" method="post" >
<div id="RegistForm" class="box">
   <ul>
      <li><label for="title">제목</label>
          <input id="title" name="name" type="text" 
           size="50" placeholder="제목" maxlength="50">
      <li><label for="price">가격</label>
          <input id="price" name="price" type="text" 
           size="10" placeholder="가격" maxlength="9">원
      <li><label for="remain">수량</label>
          <input id="remain" name="remain" type="text" 
           size="10" placeholder="수량" maxlength="5">개
      <li><label for="image">책 이미지</label>
          <input id="image" name="image" enctype="multipart/form-data" type="file">  
      <li><label for="content">내용</label>
          <textarea id="content" name="content" rows="13" cols="50"></textarea>
          <input type="submit" id="registBook" value="책등록">
   </ul>
</div>
