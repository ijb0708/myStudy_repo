<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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

	<section class="hero-wrap hero-wrap-2"
		style="background-image: url('/resources/publishing-company-master/images/bg_5.jpg');"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
				<div class="col-md-9 ftco-animate mb-0 text-center">
					<p class="breadcrumbs mb-0">
						<span class="mr-2"><a href="/" style="color: white;">SpaceFinder
								<i class="fa fa-chevron-right"></i>
						</a></span> <span class="mr-2"><a href="/goodplace/main"
							style="color: white;">굿플레이스 <i class="fa fa-chevron-right"></i></a></span>
						<span style="color: white;">${gpView.GP_name } <i
							class="fa fa-chevron-right"></i>
						</span>
					</p>
					<h1 class="mb-0 bread" style="color: white;">${gpView.GP_name }</h1>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section ftco-degree-bg">
		<div class="container">

				<div class="center-block">

					<h2 class="mb-3" style="text-align: center;">${gpView.GP_name}</h2>

					<div class="row ftco-animate">
						<div class="col-md-12">
							<div class="carousel-testimony owl-carousel ftco-owl">
								<div class="item">
									<img src="http://54.180.89.92:8080/img${gpView.GP_image1}"
										alt="" class="img-fluid" width="200">
								</div>
								<div class="item">
									<img src="http://54.180.89.92:8080/img${gpView.GP_image2}"
										alt="" class="img-fluid" width="200">
								</div>
								<div class="item">
									<img src="http://54.180.89.92:8080/img${gpView.GP_image3}"
										alt="" class="img-fluid" width="200">
								</div>
								<div class="item">
									<img src="http://54.180.89.92:8080/img${gpView.GP_image4}"
										alt="" class="img-fluid" width="200">
								</div>
							</div>
						</div>
					</div>

					<p>
						카테고리 : ${gpView.gp_ca_name }<br>
						<c:if test="${gpView.GP_category ne 'parking' }">
						주차장 유무 :
						<c:choose>
								<c:when test="${gpView.GP_parking eq 'parking'}"> 자체주차장 있음</c:when>
								<c:when test="${gpView.GP_parking eq 'none'}"> 없음</c:when>
							</c:choose>
						</c:if>
						<br>영업시간 : ${gpView.GP_Runtime }<br>정기 휴일 :
						${gpView.GP_restday }<br>
						<c:if
							test="${gpView.GP_parking eq 'parking' and gpView.GP_category ne 'parking' }">
						주차 면수 : ${gpView.GP_slot }
					</c:if>
						<c:if test="${gpView.GP_category eq 'parking' }">
						주차 면수 : ${gpView.GP_slot }<br>기본시간 : ${gpView.GP_basetime }<br>기본 요금 : ${gpView.GP_basepay }<br>기본시간 초과시 : ${gpView.GP_overtime } ${gpView.GP_overpay }<br>하루 요금 : ${gpView.GP_onepay }<br>한달 요금 : ${gpView.GP_monthpay }
					</c:if>
					</p>
					<br> <br>
					<p>${gpView.GP_content }</p>
					
					<label class="label">위치</label>
					<div id="map" style="width: 100%; height: 400px; margin: 10px"></div>
					<code id="snippet" class="snippet"></code>
					
					<div
                  style="display: flex; align-items: space-between; justify-content: space-between;">
                  <div class="in-text">
                     <a href="#"
                        class="icon d-flex align-items-center justify-content-center"
                        data-toggle="tooltip" data-placement="left"
                        title="주차장 바로가기 등록"> <span class="flaticon-heart-1"></span>
                     </a>
                  </div>
                  <button id="movemain" class="btn btn-primary" type="button"
                     style="margin-right: 10px"
                     onclick="location.href='/goodplace/main'">목록</button>
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
		$(function(){
			if(${member.userId eq null} || ${member.userId ne gpView.userId} ){
				$("#updategoodplace").hide();
				$("#deletegoodplace").hide();
			}
		});
			
		$("#submitReply").click(function() {
			if ($("#reply_content").val() != "") {
				const query = {
					userId : $("#userId").val(),
					GP_REF_ID : $("#GP_REF_ID").val(),
					reply_content : $("#reply_content").val()
				};

				$.ajax({
					url : "/goodplace/subReply",
					type : "post",
					data : query,
					success : function(data) {
						location.reload();
					}
				}); // ajax 끝
			} else {
				alert("내용을 입력하세요!");
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
		map.setCenter(new naver.maps.LatLng(${gpView.GP_lat}, ${gpView.GP_long}));
		map.setZoom(16);
		marker.setPosition(new naver.maps.LatLng(${gpView.GP_lat}, ${gpView.GP_long}));
		marker.setMap(map);
		/* naver.maps.Event.addListener(map, 'click', function(e) {
			marker.setPosition(e.coord);
			marker.setMap(map);
			console.log("위도 경도" + e.coord);
			$('input#GP_lat').val(e.coord.y);
			$('input#GP_long').val(e.coord.x);
		}); */
	</script>

</body>

</html>


<!-- 
<li class="comment">
	<div class="vcard bio">
		<img src="images/person_1.jpg" alt="Image placeholder">
	</div>
	<div class="comment-body">
		<h3>John Doe</h3>
		<div class="meta">April 12, 2020 at 1:21am</div>
		<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
			Pariatur quidem laborum necessitatibus, ipsam impedit vitae autem,
			eum officia, fugiat saepe enim sapiente iste iure! Quam voluptas
			earum impedit necessitatibus, nihil?</p>
		<p>
			<a href="#" class="reply">Reply</a>
		</p>
	</div>

	<ul class="children">
		<li class="comment">
			<div class="vcard bio">
				<img src="images/person_1.jpg" alt="Image placeholder">
			</div>
			<div class="comment-body">
				<h3>John Doe</h3>
				<div class="meta">April 12, 2020 at 1:21am</div>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Pariatur quidem laborum necessitatibus, ipsam impedit vitae autem,
					eum officia, fugiat saepe enim sapiente iste iure! Quam voluptas
					earum impedit necessitatibus, nihil?</p>
				<p>
					<a href="#" class="reply">Reply</a>
				</p>
			</div>


			<ul class="children">
				<li class="comment">
					<div class="vcard bio">
						<img src="images/person_1.jpg" alt="Image placeholder">
					</div>
					<div class="comment-body">
						<h3>John Doe</h3>
						<div class="meta">April 12, 2020 at 1:21am</div>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Pariatur quidem laborum necessitatibus, ipsam impedit vitae
							autem, eum officia, fugiat saepe enim sapiente iste iure! Quam
							voluptas earum impedit necessitatibus, nihil?</p>
						<p>
							<a href="#" class="reply">Reply</a>
						</p>
					</div>

					<ul class="children">
						<li class="comment">
							<div class="vcard bio">
								<img src="images/person_1.jpg" alt="Image placeholder">
							</div>
							<div class="comment-body">
								<h3>John Doe</h3>
								<div class="meta">April 12, 2020 at 1:21am</div>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Pariatur quidem laborum necessitatibus, ipsam impedit vitae
									autem, eum officia, fugiat saepe enim sapiente iste iure! Quam
									voluptas earum impedit necessitatibus, nihil?</p>
								<p>
									<a href="#" class="reply">Reply</a>
								</p>
							</div>
						</li>
					</ul>
				</li>
			</ul>
		</li>
	</ul>
</li> -->