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
<script
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=rebzhg9z1c"></script>

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

	<section>
		<section class="hero-wrap hero-wrap-2"
			style="background-image: url('/resources/publishing-company-master/images/gp_1.jpg');"
			data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="container">
				<div
					class="row no-gutters slider-text align-items-center justify-content-center">
					<div class="col-md-9 ftco-animate mb-0 text-center">
						<p class="breadcrumbs mb-0">
							<span class="mr-2"><a href="/" style="color: white;">SpaceFinder <i
								class="fa fa-chevron-right"></i></a></span> <span class="mr-2"><a
							href="/goodplace/main" style="color: white;">굿플레이스 <i class="fa fa-chevron-right"></i></a></span> <span style="color: white;">굿플 등록
							<i class="fa fa-chevron-right"></i>
						</span>
						</p>
						<h1 class="mb-0 bread" style="color: white;">내가 만든 굿플레이스</h1>
					</div>
				</div>
			</div>
		</section>
	</section>

	<section class="ftco-section ftco-degree-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 sidebar pl-lg-3 ftco-animate">
					<div class="sidebar-box">
						<form action="#" class="search-form">
							<div class="form-group">
								<span class="fa fa-search"></span> <input type="text"
									class="form-control" placeholder="검색">
							</div>
						</form>
					</div>
					<div class="sidebar-box ftco-animate">
						<div class="categories">
							<h3>카테고리</h3>
							<ul>
								<c:forEach items="${catelist}" var="catelist">
									<li><a href="#" id="${catelist.gp_ca_id }">${catelist.gp_ca_name }
											<span class="fa fa-chevron-right"></span>
									</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>

					<div class="sidebar-box ftco-animate">
						<h3>인기 굿플</h3>
						<ul class="top">
							<li><a href="#">굿플1</a></li>
							<li><a href="#">굿플2</a></li>
							<li><a href="#">굿플3</a></li>
							<li><a href="#">굿플4</a></li>
							<li><a href="#">굿플5</a></li>
							<li><a href="#">굿플6</a></li>
							<li><a href="#">굿플7</a></li>
							<li><a href="#">굿플8</a></li>
							<li><a href="#">굿플9</a></li>
						</ul>
					</div>
				</div>

				<div class="col-md-7">
					<div class="contact-wrap w-100 p-md-5 p-4">
						<h3 class="mb-4">굿 플레이스 등록</h3>
						<form role="form" method="post" autocomplete="off"
							enctype="multipart/form-data" id="contactForm" name="contactForm"
							class="contactForm">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="label" for="GP_name">플레이스 이름</label> <input
											type="text" class="form-control" name="GP_name" id="GP_name"
											placeholder="PlaceName" required>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<div class="form-field">
											<div class="select-wrap">
												<div class="icon">
													<span class="fa fa-chevron-down"></span>
												</div>
												<select name="GP_category" id="GP_category"
													class="form-control" required>
													<c:forEach items="${catelist}" var="catelist">
														<option value="${catelist.gp_ca_id }">${catelist.gp_ca_name }</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-6" id="GP_parking_div">
									<div class="form-group">
										<div class="form-field">
											<div class="select-wrap">
												<div class="icon">
													<span class="fa fa-chevron-down"></span>
												</div>
												<select name="GP_parking" id="GP_parking"
													class="form-control">
													<option value="parking">자체주차장 있음</option>
													<option value="none">없음</option>
												</select>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="label" for="weekday_on_time">평일오픈시간</label> <input
											type="time" class="form-control" name="weekday_on_time"
											id="weekday_on_time" placeholder="평일오픈시간" required>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="label" for="weekday_close_time">평일마감시간</label> <input
											type="time" class="form-control" name="weekday_close_time"
											id="weekday_close_time" placeholder="평일마감시간" required>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="label" for="weekend_on_time">주말(휴일)오픈시간</label>
										<input type="time" class="form-control" name="weekend_on_time"
											id="weekend_on_time" placeholder="주말(휴일)오픈시간" required>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="label" for="weekend_close_time">주말(휴일)마감시간</label>
										<input type="time" class="form-control"
											name="weekend_close_time" id="weekend_close_time"
											placeholder="주말(휴일)마감시간" required>
									</div>
								</div>

								<div class="col-md-12">
									<label class="label">위치</label>
									<div id="map" style="width: 100%; height: 600px;"></div>
									<code id="snippet" class="snippet"></code>
								</div>

								<div style="display: none;">
									<label for="writer">작성자</label><input type="text" id="userId"
										name="userId" value="${member.userId}" required />
								</div>
								<div style="display: none;">
									<label for="GP_lat">위도</label>
									<!-- 상품가격 -->
									<input type="text" id="GP_lat" name="GP_lat" required />
								</div>
								<div style="display: none;">
									<label for="GP_long">경도</label>
									<!-- 수량 -->
									<input type="text" id="GP_long" name="GP_long" required />
								</div>

								<div class="col-md-12">
									<div class="form-group">
										<label class="label" for="GP_restday">정기휴무일</label> <input
											type="text" class="form-control" name="GP_restday"
											id="GP_restday" placeholder="둘째,넷째 일요일 쉽니다." required>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="label" for="GP_content">내용</label>
										<textarea name="GP_content" class="form-control"
											id="GP_content" cols="30" rows="6"
											placeholder="당신이 만든 굿플레이스에 대해 설명해주세요" required></textarea>
									</div>
								</div>

								<div class="col-md-12">
									<div class="form-group">
										<label class="label" for="GP_image1">대표이미지</label> <input
											class="form-control" type="file" id="GP_image1"
											name="GP_image" required />
										<div class="select_img1">
											<img src="" />
										</div>
									</div>
									<div class="form-group">
										<label class="label" for="GP_image2">이미지1</label> <input
											class="form-control" type="file" id="GP_image2"
											name="GP_image" required />
										<div class="select_img2">
											<img src="" />
										</div>
									</div>
									<div class="form-group">
										<label class="label" for="GP_image3">이미지2</label> <input
											class="form-control" type="file" id="GP_image3"
											name="GP_image" required />
										<div class="select_img3">
											<img src="" />
										</div>
									</div>
									<div class="form-group">
										<label class="label" for="GP_image4">이미지3</label> <input
											class="form-control" type="file" id="GP_image4"
											name="GP_image" required />
										<div class="select_img4">
											<img src="" />
										</div>
									</div>
								</div>


								<div class="col-md-6" id="GP_slot_div">
									<div class="form-group">
										<label class="label" for="GP_slot">주차 면수</label> <input
											type="number" min="1" max="500" class="form-control"
											name="GP_slot" id="GP_slot" placeholder="주차가능한 면수">
									</div>
								</div>
								<div class="col-md-6" id="GP_basetime_div">
									<div class="form-group">
										<label class="label" for="GP_basetime">기본 시간</label> <input
											type="text" class="form-control" name="GP_basetime"
											id="GP_basetime" placeholder="ex) 30분">
									</div>
								</div>
								<div class="col-md-6" id="GP_basepay_div">
									<div class="form-group">
										<label class="label" for="GP_basepay">기본 요금</label> <input
											type="text" class="form-control" name="GP_basepay"
											id="GP_basepay" placeholder="ex) 1000원">
									</div>
								</div>
								<div class="col-md-6" id="GP_overtime_div">
									<div class="form-group">
										<label class="label" for="GP_overtime">추가 시간</label> <input
											type="text" class="form-control" name="GP_overtime"
											id="GP_overtime" placeholder="ex) 10분당">
									</div>
								</div>
								<div class="col-md-6" id="GP_overpay_div">
									<div class="form-group">
										<label class="label" for="GP_overpay">추가 요금</label> <input
											type="text" class="form-control" name="GP_overpay"
											id="GP_overpay" placeholder="ex) 300원">
									</div>
								</div>
								<div class="col-md-6" id="GP_onepay_div">
									<div class="form-group">
										<label class="label" for="GP_onepay">하루 요금</label> <input
											type="text" class="form-control" name="GP_onepay"
											id="GP_onepay" placeholder="ex) 15000원">
									</div>
								</div>
								<div class="col-md-6" id="GP_monthpay_div">
									<div class="form-group">
										<label class="label" for="GP_monthpay">한달 요금</label> <input
											type="text" class="form-control" name="GP_monthpay"
											id="GP_monthpay" placeholder="ex) 250000원">
									</div>
								</div>
								
								<div class="col-md-12">
									<div class="form-group">
										<input type="submit" value="등록" class="btn btn-primary">
										<input type="button" value="취소" class="btn btn-primary"
											onclick="location.href='/goodplace/main'">
										<div class="submitting"></div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
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
	<
	<!-- script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script> -->
	<!-- ?????구글맵???? -->
	<script src="/resources/publishing-company-master/js/google-map.js"></script>
	<script src="/resources/publishing-company-master/js/main.js"></script>


	<script>
		$(function() {
			$("#GP_basetime_div").hide();
			$("#GP_basepay_div").hide();
			$("#GP_overtime_div").hide();
			$("#GP_overpay_div").hide();
			$("#GP_onepay_div").hide();
			$("#GP_monthpay_div").hide();
		});

		$("#GP_image1")
				.change(
						function() {
							const image = $("#GP_image1").val().toLowerCase();
							if (image.includes(".png")
									|| image.includes(".jpg")
									|| image.includes(".jpeg")) {
								if (image == $("#GP_image2").val()
										.toLowerCase()
										|| image == $("#GP_image3").val()
												.toLowerCase()
										|| image == $("#GP_image4").val()
												.toLowerCase()) {
									alert("이미지가 중복입니다. 다시선택해 주세요");
									$(".select_img1 img").removeAttr("src");
									$("#GP_image1").val("");
								} else if (this.files && this.files[0]) {
									const reader = new FileReader;
									reader.onload = function(data) {
										$(".select_img1 img").attr("src",
												data.target.result).width(100);
									}
									reader.readAsDataURL(this.files[0]);
								}
							} else {
								alert("이미지 확장자를 png,jpeg,jpg 로 해주세요");
								$(".select_img1 img").removeAttr("src");
								$("#GP_image1").val("");
							}

						});
		$("#GP_image2")
				.change(
						function() {
							const image = $("#GP_image2").val().toLowerCase();
							if (image.includes(".png")
									|| image.includes(".jpg")
									|| image.includes(".jpeg")) {
								if (image == $("#GP_image1").val()
										.toLowerCase()
										|| image == $("#GP_image3").val()
												.toLowerCase()
										|| image == $("#GP_image4").val()
												.toLowerCase()) {
									alert("이미지가 중복입니다. 다시선택해 주세요");
									$(".select_img2 img").removeAttr("src");
									$("#GP_image2").val("");
								} else if (this.files && this.files[0]) {

									const reader = new FileReader;
									reader.onload = function(data) {
										$(".select_img2 img").attr("src",
												data.target.result).width(100);
									}
									reader.readAsDataURL(this.files[0]);
								}
							} else {
								alert("이미지 확장자를 png,jpeg,jpg 로 해주세요");
								$(".select_img2 img").removeAttr("src");
								$("#GP_image2").val("");
							}

						});
		$("#GP_image3")
				.change(
						function() {
							const image = $("#GP_image3").val().toLowerCase();
							if (image.includes(".png")
									|| image.includes(".jpg")
									|| image.includes(".jpeg")) {
								if (image == $("#GP_image1").val()
										.toLowerCase()
										|| image == $("#GP_image2").val()
												.toLowerCase()
										|| image == $("#GP_image4").val()
												.toLowerCase()) {
									alert("이미지가 중복입니다. 다시선택해 주세요");
									$(".select_img3 img").removeAttr("src");
									$("#GP_image3").val("");
								} else if (this.files && this.files[0]) {

									const reader = new FileReader;
									reader.onload = function(data) {
										$(".select_img3 img").attr("src",
												data.target.result).width(100);
									}
									reader.readAsDataURL(this.files[0]);
								}
							} else {
								alert("이미지 확장자를 png,jpeg,jpg 로 해주세요");
								$(".select_img3 img").removeAttr("src");
								$("#GP_image3").val("");
							}

						});
		$("#GP_image4")
				.change(
						function() {
							const image = $("#GP_image4").val().toLowerCase();
							if (image.includes(".png")
									|| image.includes(".jpg")
									|| image.includes(".jpeg")) {
								if (image == $("#GP_image1").val()
										.toLowerCase()
										|| image == $("#GP_image2").val()
												.toLowerCase()
										|| image == $("#GP_image3").val()
												.toLowerCase()) {
									alert("이미지가 중복입니다. 다시선택해 주세요");
									$(".select_img4 img").removeAttr("src");
									$("#GP_image4").val("");
								} else if (this.files && this.files[0]) {

									const reader = new FileReader;
									reader.onload = function(data) {
										$(".select_img4 img").attr("src",
												data.target.result).width(100);
									}
									reader.readAsDataURL(this.files[0]);
								}
							} else {
								alert("이미지 확장자를 png,jpeg,jpg 로 해주세요");
								$(".select_img4 img").removeAttr("src");
								$("#GP_image4").val("");
							}

						});
		$("#GP_category").change(function() {
			if ($("#GP_category option:selected").text() == '주차장') {
				$("#GP_slot_div").show();
				$("#GP_basetime_div").show();
				$("#GP_basepay_div").show();
				$("#GP_overtime_div").show();
				$("#GP_overpay_div").show();
				$("#GP_onepay_div").show();
				$("#GP_monthpay_div").show();
				$("#GP_parking_div").hide();
			} else {
				if ($("#GP_parking option:selected").text() == '없음') {
					$("#GP_slot_div").hide();
				} else {
					$("#GP_slot_div").show();
				}
				$("#GP_basetime_div").hide();
				$("#GP_basepay_div").hide();
				$("#GP_overtime_div").hide();
				$("#GP_overpay_div").hide();
				$("#GP_onepay_div").hide();
				$("#GP_monthpay_div").hide();
				$("#GP_parking_div").show();
			}
		});

		$("#GP_parking").change(function() {
			if ($("#GP_parking option:selected").text() == '없음') {
				$("#GP_slot_div").hide();
			} else {
				$("#GP_slot_div").show();
			}
		});
	</script>

	<script id="code">
		//지도를 삽입할 HTML 요소 또는 HTML 요소의 id를 지정합니다.
		/* var mapDiv = document.getElementById('map'); // 'map'으로 선언해도 동일
		
		//옵션 없이 지도 객체를 생성하면 서울 시청을 중심으로 하는 16 레벨의 지도가 생성됩니다.
		var map = new naver.maps.Map(mapDiv); */
		var map = new naver.maps.Map('map', {
			center : new naver.maps.LatLng(35.896061, 128.621659),
			zoom : 16,
			mapTypeId : naver.maps.MapTypeId.NORMAL
		});

		var infowindow = new naver.maps.InfoWindow();

		function onSuccessGeolocation(position) {
			/* var location = new naver.maps.LatLng(position.coords.latitude,
			                                     position.coords.longitude); */
			var location = new naver.maps.LatLng(35.896061, 128.621659);

			map.setCenter(location); // 얻은 좌표를 지도의 중심으로 설정합니다.
			map.setZoom(16); // 지도의 줌 레벨을 변경합니다.

			/* infowindow.setContent('<div style="padding:20px;">' + 'geolocation.getCurrentPosition() 위치' + '</div>');

			infowindow.open(map, location); */
			console.log('Coordinates: ' + location.toString());
		}

		//지오로케이션 안내문
		/* function onErrorGeolocation() {
		    var center = map.getCenter();

		    infowindow.setContent('<div style="padding:20px;">' +
		        '<h5 style="margin-bottom:5px;color:#f00;">Geolocation failed!</h5>'+ "latitude: "+ center.lat() +"<br />longitude: "+ center.lng() +'</div>');

		    infowindow.open(map, center);
		} */

		$(window)
				.on(
						"load",
						function() {
							if (navigator.geolocation) {
								/**
								 * navigator.geolocation 은 Chrome 50 버젼 이후로 HTTP 환경에서 사용이 Deprecate 되어 HTTPS 환경에서만 사용 가능 합니다.
								 * http://localhost 에서는 사용이 가능하며, 테스트 목적으로, Chrome 의 바로가기를 만들어서 아래와 같이 설정하면 접속은 가능합니다.
								 * chrome.exe --unsafely-treat-insecure-origin-as-secure="http://example.com"
								 */
								navigator.geolocation.getCurrentPosition(
										onSuccessGeolocation,
										onErrorGeolocation);
							} else {
								var center = map.getCenter();
								infowindow
										.setContent('<div style="padding:20px;"><h5 style="margin-bottom:5px;color:#f00;">Geolocation not supported</h5></div>');
								infowindow.open(map, center);
							}
						});
		var marker = new naver.maps.Marker();
		naver.maps.Event.addListener(map, 'click', function(e) {
			marker.setPosition(e.coord);
			marker.setMap(map);
			console.log("위도 경도" + e.coord);
			$('input#GP_lat').val(e.coord.y);
			$('input#GP_long').val(e.coord.x);
		});
	</script>

</body>

</html>


<%-- <section id="container">
	<div id="container_box">
		<h2>굿플 등록</h2>

		<form role="form" method="post" autocomplete="off"
			enctype="multipart/form-data">

			<div class="inputArea">
				<label>1차 분류</label> <select class="category1">
					<option value="">전체</option>
				</select> <label>2차 분류</label> <select class="category2" name="cateCode">
					<option value="">전체</option>
				</select>
			</div>

			<div class="inputArea">
				<label for="writer">작성자</label><input type="text" id="userId"
					name="userId" value="${member.userId}" />
			</div>


			<div id="wrap" class="section">
				<div id="map" style="width: 50%; height: 600px;"></div>
				<code id="snippet" class="snippet"></code>
			</div>

			<div class="inputArea">
				<label for="GP_name">굿플 이름</label>
				<!-- 상품명 -->
				<input type="text" id="GP_name" name="GP_name" />
			</div>

			<div class="inputArea">
				<label for="GP_lat">위도</label>
				<!-- 상품가격 -->
				<input type="text" id="GP_lat" name="GP_lat" />
			</div>

			<div class="inputArea">
				<label for="GP_long">경도</label>
				<!-- 수량 -->
				<input type="text" id="GP_long" name="GP_long" />
			</div>

			<div class="inputArea">
				<label for="GP_Runtime">영업시간</label>
				<!-- 수량 -->
				<input type="text" id="GP_Runtime" name="GP_Runtime" />
			</div>

			<div class="inputArea">
				<label for="GP_content">내용</label>
				<textarea rows="5" cols="50" id="GP_content" name="GP_content"></textarea>
			</div>

			<div class="inputArea">
				<label for="GP_image">이미지</label> <input type="file" id="GP_image"
					name="file" />
				<div class="select_img">
					<img src="" />
				</div>

				<div class="inputArea">
					<label for="GP_restday">정기 휴무일</label>
					<!-- 수량 -->
					<input type="text" id="GP_restday" name="GP_restday" />
				</div>

				<div class="inputArea">
					<label for="GP_parking">주차 가능</label>
					<!-- 수량 -->
					<input type="text" id="GP_parking" name="GP_parking" />
				</div>

				<script>
							$("#GP_image")
									.change(
											function() {
												var image = $("#GP_image")
														.val();
												if (image.includes(".png")
														|| image
																.includes(".jpg")
														|| image
																.includes(".jpeg")) {
													if (this.files
															&& this.files[0]) {

														var reader = new FileReader;
														reader.onload = function(
																data) {
															$(".select_img img")
																	.attr(
																			"src",
																			data.target.result)
																	.width(500);
														}
														reader
																.readAsDataURL(this.files[0]);
													}
												} else {
													alert("이미지 확장자를 png,jpeg,jpg 로 해주세요");
													$(".select_img img")
															.removeAttr("src");
													$("#GP_image").val("");
												}

											});
						</script>

				 <%=request.getRealPath("/") %>
			</div>



			<script id="code">
						//지도를 삽입할 HTML 요소 또는 HTML 요소의 id를 지정합니다.
						/* var mapDiv = document.getElementById('map'); // 'map'으로 선언해도 동일
						
						//옵션 없이 지도 객체를 생성하면 서울 시청을 중심으로 하는 16 레벨의 지도가 생성됩니다.
						var map = new naver.maps.Map(mapDiv); */
						var map = new naver.maps.Map('map', {
							center : new naver.maps.LatLng(35.896061,
									128.621659),
							zoom : 16,
							mapTypeId : naver.maps.MapTypeId.NORMAL
						});

						var infowindow = new naver.maps.InfoWindow();

						function onSuccessGeolocation(position) {
							/* var location = new naver.maps.LatLng(position.coords.latitude,
							                                     position.coords.longitude); */
							var location = new naver.maps.LatLng(35.896061,
									128.621659);

							map.setCenter(location); // 얻은 좌표를 지도의 중심으로 설정합니다.
							map.setZoom(16); // 지도의 줌 레벨을 변경합니다.

							/* infowindow.setContent('<div style="padding:20px;">' + 'geolocation.getCurrentPosition() 위치' + '</div>');

							infowindow.open(map, location); */
							console.log('Coordinates: ' + location.toString());
						}

						//지오로케이션 안내문
						/* function onErrorGeolocation() {
						    var center = map.getCenter();

						    infowindow.setContent('<div style="padding:20px;">' +
						        '<h5 style="margin-bottom:5px;color:#f00;">Geolocation failed!</h5>'+ "latitude: "+ center.lat() +"<br />longitude: "+ center.lng() +'</div>');

						    infowindow.open(map, center);
						} */

						$(window)
								.on(
										"load",
										function() {
											if (navigator.geolocation) {
												/**
												 * navigator.geolocation 은 Chrome 50 버젼 이후로 HTTP 환경에서 사용이 Deprecate 되어 HTTPS 환경에서만 사용 가능 합니다.
												 * http://localhost 에서는 사용이 가능하며, 테스트 목적으로, Chrome 의 바로가기를 만들어서 아래와 같이 설정하면 접속은 가능합니다.
												 * chrome.exe --unsafely-treat-insecure-origin-as-secure="http://example.com"
												 */
												navigator.geolocation
														.getCurrentPosition(
																onSuccessGeolocation,
																onErrorGeolocation);
											} else {
												var center = map.getCenter();
												infowindow
														.setContent('<div style="padding:20px;"><h5 style="margin-bottom:5px;color:#f00;">Geolocation not supported</h5></div>');
												infowindow.open(map, center);
											}
										});
						var marker = new naver.maps.Marker();
						naver.maps.Event.addListener(map, 'click', function(e) {
							marker.setPosition(e.coord);
							marker.setMap(map);
							console.log("위도 경도" + e.coord);
							$('input#GP_lat').val(e.coord.y);
							$('input#GP_long').val(e.coord.x);
						});
					</script>

			<div class="inputArea">
				<button type="submit" id="register_Btn" class="btn btn-primary">등록</button>
			</div>

		</form>

	</div>
</section> --%>
