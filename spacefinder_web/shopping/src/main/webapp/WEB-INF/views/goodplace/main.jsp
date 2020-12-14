<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<head>
<title>Space Finder</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="/resources/publishing-company-master/css/animate.css">

<link rel="stylesheet"
	href="/resources/publishing-company-master/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="/resources/publishing-company-master/css/owl.theme.default.min.css">
<link rel="stylesheet"
	href="/resources/publishing-company-master/css/magnific-popup.css">

<link rel="stylesheet"
	href="/resources/publishing-company-master/css/flaticon.css">
<link rel="stylesheet"
	href="/resources/publishing-company-master/css/style.css">
</head>

</head>

<body>

	<!-- Page Header -->
	<header>
		<%@ include file="../include/header.jsp"%>
	</header>

	<!-- Navigation -->
	<nav
		class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
		id="ftco-navbar">
		<%@ include file="../include/nav.jsp"%>
	</nav>

	<section class="hero-wrap hero-wrap-2"
		style="background-image: url('/resources/publishing-company-master/images/gp_1.jpg');"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-9 ftco-animate mb-0 text-center">
					<p class="breadcrumbs mb-0">
						<span class="mr-2"><a href="/" style="color: white;">SpaceFinder<i
								class="fa fa-chevron-right"></i></a></span> <span style="color: white;">굿플레이스
							<i class="fa fa-chevron-right"></i>
						</span>
					</p>
					<h1 class="mb-0 bread" style="color: white;">내가 만든 굿플레이스</h1>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section ftco-degree-bg">
			<div class="center-block">
				<div class="col-lg-12 ftco-animate">
					<div class="row">
						
						<c:forEach items="${gplist}" var="gplist">
							<div class="col-md-4 d-flex">
								<div class="book-wrap">
									<div class="img d-flex justify-content-end w-100"
										style="background-image: url(http://54.180.89.92:8080/img${gplist.GP_ThumbImg1});">
										<div class="in-text">
											<a href="#"
												class="icon d-flex align-items-center justify-content-center"
												data-toggle="tooltip" data-placement="left"
												title="Add to Wishlist"> <span class="flaticon-heart-1"></span>
											</a> <a href="#"
												class="icon d-flex align-items-center justify-content-center"
												data-toggle="tooltip" data-placement="left"
												title="Quick View"> <span class="flaticon-search"></span>
											</a>
										</div>
									</div>
									<div class="text px-4 py-3 w-100">
										<p class="mb-2">
											<span class="price">조회수 : ${gplist.GP_click}</span>
										</p>
										<h2>
											<a href="/goodplace/gpView?GP_id=${gplist.GP_id}">${gplist.GP_name }</a>
										</h2>
										<span class="position">${gplist.username }(${gplist.userId })</span>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>
					<div class="row mt-5">
						<div class="col">
							<div class="block-27"
								style="display: inline-flex; width: 100%; justify-content: space-between;">
								<ul>
									<li><a href="#">&lt;</a></li>
									<li class="active"><span>1</span></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#">&gt;</a></li>
								</ul>
								<button id="idChk" class="btn btn-primary" type="button"
									onclick="location.href='/goodplace/gpReg'">굿플등록</button>
							</div>
						</div>
					</div>
					<!-- .col-md-8 -->
				</div>
			</div>
	</section>

	<!-- Footer -->
	<footer>
		<%@ include file="../include/footer.jsp"%>
	</footer>

	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>

	<script src="/resources/publishing-company-master/js/jquery.min.js"></script>
	<script
		src="/resources/publishing-company-master/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="/resources/publishing-company-master/js/popper.min.js"></script>
	<script src="/resources/publishing-company-master/js/bootstrap.min.js"></script>
	<script
		src="/resources/publishing-company-master/js/jquery.easing.1.3.js"></script>
	<script
		src="/resources/publishing-company-master/js/jquery.waypoints.min.js"></script>
	<script
		src="/resources/publishing-company-master/js/jquery.stellar.min.js"></script>
	<script
		src="/resources/publishing-company-master/js/owl.carousel.min.js"></script>
	<script
		src="/resources/publishing-company-master/js/jquery.magnific-popup.min.js"></script>
	<script
		src="/resources/publishing-company-master/js/jquery.animateNumber.min.js"></script>
	<script src="/resources/publishing-company-master/js/scrollax.min.js"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<!-- ?????구글맵???? -->
	<script src="/resources/publishing-company-master/js/google-map.js"></script>
	<script src="/resources/publishing-company-master/js/main.js"></script>

</body>

</html>