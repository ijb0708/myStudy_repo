<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- <div class="container">
      <a class="navbar-brand" href="/">SpaceFinder</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="/">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">굿플레이스</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">핫플레이스</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">플레이스클럽</a>
          </li>
        </ul>
      </div>
    </div> -->
    
    
<div class="container-fluid">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="fa fa-bars"></span> Menu
  </button>
  <div class="collapse navbar-collapse" id="ftco-nav">
    <ul class="navbar-nav m-auto">
    	<li class="nav-item active"><a href="/" class="nav-link">Home</a></li>
    	<li class="nav-item"><a href="/goodplace/main" class="nav-link">주차장 보기</a></li>
    	<li class="nav-item"><a href="#" class="nav-link">일정 관리</a></li>
    	<li class="nav-item"><a href="#" class="nav-link">이용 내역</a></li>
    </ul>
  </div>
</div>


	<%-- <div class="container">
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<c:if test="${member == null}">
				<li class="nav-item">
					<a href="/member/signin">로그인</a>
				</li>
				<li class="nav-item">
					<a href="/member/signup">회원가입</a>
				</li>
				</c:if>
				<c:if test="${member != null }">
			
				<c:if test="${member.verify == 9 }">
				<li class="nav-item">
					<a href="/admin/index">주차장 관리자 화면</a>
				</li>
				</c:if>
			
				<li class="nav-item" style="color:#68deed">
					${member.userName }님 환영합니다.
				</li>
				<li class="nav-item">
					<a href="/member/signout">로그아웃</a>
				</li>
				</c:if>
				
			</ul>
		</div>
	</div> --%>
