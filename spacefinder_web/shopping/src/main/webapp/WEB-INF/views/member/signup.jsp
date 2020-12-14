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

	<section>
		<div class="col-md-7">
			<div class="contact-wrap w-100 p-md-5 p-4">
				<h3 class="mb-4">회원가입</h3>
				<form id="contactForm" name="contactForm" class="contactForm"
					role="form" method="post" autocomplete="off">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label class="label" for="userId">아이디</label> <input
									type="email" class="form-control" name="userId" id="userId"
									placeholder="example@email.com" required="required">
								<button id="idChk" class="btn btn-primary" type="button">중복확인</button>
								<p class="result">
									<span class="msg">아이디를 확인하여 주십시오.</span>
								</p>
							</div>
						</div>

						<div class="col-md-12">
							<div class="form-group">
								<label class="label" for="userPass">패스워드</label> <input
									type="password" class="form-control" name="userPass"
									id="userPass" required="required" placeholder="패스워드">
							</div>
						</div>

						<div class="col-md-12">
							<div class="form-group">
								<label class="label" for="userName">닉네임</label> <input
									type="text" class="form-control" name="userName" id="userName"
									required="required" placeholder="닉네임을 입력해주세요">
							</div>
						</div>

						<div class="col-md-12">
							<div class="form-group">
								<label class="label" for="userPhon">연락처</label> <input
									type="text" class="form-control" name="userPhon" id="userPhon"
									required="required" placeholder="연락처를 입력해주세요">
							</div>
						</div>



						<div class="col-md-12">
							<div class="form-group">
								<input type="submit" id="signup_btn" name="signup_btn"
									value="회원가입" class="btn btn-primary" disabled="disabled">
							</div>
						</div>
					</div>
				</form>
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


	<script>
		$("#idChk").click(function() {
			if ($("#userId").val() != "") {
				if ($("#userId").val().indexOf("@") <= 0) {
					$(".result .msg").text("이메일 형식으로 사용해주세요");
					$(".result .msg").attr("style", "color:#f00");
				} else {
					var query = {
						userId : $("#userId").val()
					};

					$.ajax({
						url : "/member/idChk",
						type : "post",
						data : query,
						success : function(data) {

							if (data == 1) {
								$(".result .msg").text("사용 불가");
								$(".result .msg").attr("style", "color:#f00");

								$("#signup_btn").attr("disabled", "disabled");
							} else {
								$(".result .msg").text("사용 가능");
								$(".result .msg").attr("style", "color:#00f");

								$("#signup_btn").removeAttr("disabled");
							}
						}
					}); // ajax 끝
				}
			} else {
				$(".result .msg").text("아이디를 입력해주세요");
				$(".result .msg").attr("style", "color:#f00");
			}
		});

		$("#userId").keyup(function() {
			$(".result .msg").text("아이디를 확인해주십시오.");
			$(".result .msg").attr("style", "color:#000");

			$("#signup_btn").attr("disabled", "disabled");

		});
	</script>
</body>

</html>


<%-- 
<html>
<head>
<title>Shopping</title>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
</head>

<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="../include/header.jsp"%>
			</div>
		</header>

		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../include/nav.jsp"%>
			</div>
		</nav>

		<section id="container">
			<div id="container_box">
				<section id="content">
					<form role="form" method="post" autocomplete="off">
						<div class="input_area">
							<label for="userId">아이디</label> <input type="email" id="userId"
								name="userId" placeholder="example@email.com"
								required="required" />
							<button class="idChk" type="button">중복확인</button>
							
							<p class="result">
								<span class="msg">아이디를 확인하여 주십시오.</span>
							</p>
						</div>

						<div class="input_area">
							<label for="userPass">패스워드</label> <input type="password"
								id="userPass" name="userPass" required="required" />
						</div>

						<div class="input_area">
							<label for="userName">닉네임</label> <input type="text"
								id="userName" name="userName" placeholder="닉네임을 입력해주세요"
								required="required" />
						</div>

						<div class="input_area">
							<label for="userPhon">연락처</label> <input type="text"
								id="userPhon" name="userPhon" placeholder="연락처를 입력해주세요"
								required="required" />
						</div>

						<button type="submit" id="signup_btn" name="signup_btn" disabled="disabled">회원가입</button>

					</form>
				</section>
			</div>
		</section>

		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp"%>
			</div>
		</footer>

	</div>

	<P>  The time on the server is ${serverTime}. </P>
	<script> 
$("#idChk").click(function(){
 
 var query = {userId : $("#userId").val()};
 
 $.ajax({
  url : "/member/idChk",
  type : "post",
  data : query,
  success : function(data) {
  
   if(data == 1) {
    $(".result .msg").text("사용 불가");
    $(".result .msg").attr("style", "color:#f00");    

    $("#signup_btn").attr("disabled", "disabled");
   } else {
    $(".result .msg").text("사용 가능");
    $(".result .msg").attr("style", "color:#00f");

    $("#signup_btn").removeAttr("disabled");
   }
  }
 });  // ajax 끝
});

$("#userId").keyup(function(){
	 $(".result .msg").text("아이디를 확인해주십시오.");
	 $(".result .msg").attr("style", "color:#000");
	 
	 $("#signup_btn").attr("disabled", "disabled");
	 
	});
</script>
</body>
</html> --%>