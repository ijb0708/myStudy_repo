<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid px-md-5  pt-4 pt-md-5">
	<div class="row justify-content-between">
		<div class="col-md-8 order-md-last">
			<div class="row">
				<div class="col-md-6 text-center">
					<a class="navbar-brand" href="/" style="font-size: 30px">Space
						<span>Finder</span> <small style="font-size: 20px">나에게 필요한
							주차공간</small>
					</a>
				</div>
				<div class="col-md-6 d-md-flex justify-content-end mb-md-0 mb-3">
					<div class="form-group d-flex">
						<div
							style="width: 100%; display: inline-flex; align-items: flex-end; justify-content: flex-end; margin: 10px;">
							<c:if test="${member == null}">
								<a href="/member/signin"
									class="d-flex align-items-center justify-content-center"
									style="display: inline; width: 60px; font-size: 15px; margin-right: 10px;">로그인</a>
								<a href="/member/signup"
									class="d-flex align-items-center justify-content-center"
									style="display: inline; width: 60px; font-size: 15px; margin-right: 10px;">회원가입</a>
							</c:if>
							<c:if test="${member != null }">
								<a href="/admin/index"
									class="d-flex align-items-center justify-content-center"
									style="display: inline; width: 160px; font-size: 15px; margin-right: 10px;">주차장
									관리자 화면</a>
								<p
									style="font-size: 15px; display: inline; margin-right: 10px; margin-bottom: 0;">${member.userName }님
									환영합니다.</p>
								<a href="/member/signout"
									class="d-flex align-items-center justify-content-center"
									style="display: inline; width: 60px; font-size: 15px; margin-right: 10px;">로그아웃</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-4 d-flex">
			<div class="social-media">
				<p class="mb-0 d-flex">
					<a href="#"
						class="d-flex align-items-center justify-content-center"><span
						class="fa fa-facebook"><i class="sr-only">Facebook</i></span></a> <a
						href="#" class="d-flex align-items-center justify-content-center"><span
						class="fa fa-twitter"><i class="sr-only">Twitter</i></span></a> <a
						href="#" class="d-flex align-items-center justify-content-center"><span
						class="fa fa-instagram"><i class="sr-only">Instagram</i></span></a> <a
						href="#" class="d-flex align-items-center justify-content-center"><span
						class="fa fa-dribbble"><i class="sr-only">Dribbble</i></span></a>
				</p>
			</div>
		</div>
	</div>
</div>