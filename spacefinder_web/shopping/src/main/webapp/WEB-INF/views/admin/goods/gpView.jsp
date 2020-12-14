<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>shopping Admin</title>

<script src="/resources/jquery/jquery-3.5.1.min.js"></script>

<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet"
	href="/resources/bootstrap/bootstrap-theme.min.css">
<script src="/resources/bootstrap/bootstrap.min.js"></script>

<style>
body {
	font-family: '맑은 고딕', verdana;
	padding: 0;
	margin: 0;
}

ul {
	padding: 0;
	margin: 0;
	list-style: none;
}

div#root {
	width: 90%;
	margin: 0 auto;
}

header#header {
	font-size: 60px;
	padding: 20px 0;
}

header#header h1 a {
	color: #000;
	font-weight: bold;
}

nav#nav {
	padding: 10px;
	text-align: right;
}

nav#nav ul li {
	display: inline-block;
	margin-left: 10px;
}

section#container {
	padding: 20px 0;
	border-top: 2px solid #eee;
	border-bottom: 2px solid #eee;
}

section#container::after {
	content: "";
	display: block;
	clear: both;
}

aside {
	float: left;
	width: 200px;
}

div#container_box {
	float: right;
	width: calc(100% - 200px - 20px);
}

aside ul li {
	text-align: center;
	margin-bottom: 10px;
}

aside ul li a {
	display: block;
	width: 100%;
	padding: 10px 0;
}

aside ul li a:hover {
	background: #eee;
}

footer#footer {
	background: #f9f9f9;
	padding: 20px;
}

footer#footer ul li {
	display: inline-block;
	margin-right: 10px;
}
</style>


<style>
.inputArea {
	margin: 10px 0;
}

select {
	width: 100px;
}

label {
	display: inline-block;
	width: 70px;
	padding: 5px;
}

label[for='gdsDes'] {
	display: block;
}

input {
	width: 150px;
}

textarea#gdsDes {
	width: 400px;
	height: 180px;
}

.oriImg {
	width: 500px;
	height: auto;
}

.thumbImg {
	
}
</style>

<style>
 section.replyForm { padding:30px 0; }
 section.replyForm div.input_area { margin:10px 0; }
 section.replyForm textarea { font-size:16px; font-family:'맑은 고딕', verdana; padding:10px; width:500px;; height:150px; }
 section.replyForm button { font-size:20px; padding:5px 10px; margin:10px 0; background:#fff; border:1px solid #ccc; }
 
 section.replyList { padding:30px 0; }
 section.replyList ol { padding:0; margin:0; }
 section.replyList ol li { padding:10px 0; border-bottom:2px solid #eee; }
 section.replyList div.userInfo { }
 section.replyList div.userInfo .userName { font-size:24px; font-weight:bold; }
 section.replyList div.userInfo .date { color:#999; display:inline-block; margin-left:10px; }
 section.replyList div.replyContent { padding:10px; margin:20px 0; }
</style>

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
			<aside>
				<%@ include file="../include/aside.jsp"%>
			</aside>
			<div id="container_box">
				<h2>굿플 조회</h2>

				<form role="form" method="post" autocomplete="off">

					<input type="hidden" name="n" value="${gpView.GP_id}" />

					<!-- 					<div class="inputArea"> -->
					<!-- 						<label>1차 분류</label> <span class="category1"></span> <label>2차 -->
					<%-- 							분류</label> <span class="category2">${goods.cateCode}</span> --%>
					<!-- 					</div> -->

					<div class="inputArea">
						<label for="GP_name">주차장</label> <span>${gpView.GP_name}</span>
					</div>

					<div class="inputArea">
						<label for="GP_lat">위도</label> <span><fmt:formatNumber
								value="${gpView.GP_lat}" /></span>
					</div>

					<div class="inputArea">
						<label for="GP_long">경도 </label> <span>${gpView.GP_long}</span>
					</div>

					<div class="inputArea">
						<label for="GP_content">소개</label> <span>${gpView.GP_content}</span>
					</div>

					<div class="inputArea">
						<label for="GP_image">이미지</label>
						<p>원본 이미지</p>
						<img src="${gpView.GP_image}" class="GP_image" />
						<p>썸네일</p>
						<img src="${gpView.GP_image}" class="GP_image" />
					</div>

					<div class="inputArea">
						<label for="GP_restday">정기휴무일</label> <span>${gpView.GP_restday}</span>
					</div>

					<div class="inputArea">
						<label for="GP_parking">주차가능여부</label> <span>${gpView.GP_parking}</span>
					</div>

					<div id="reply">

						<c:if test="${member == null }">
							<p>
								소감을 남기시려면 <a href="/member/signin">로그인</a>해주세요
							</p>
						</c:if>

						<c:if test="${member != null}">
							<section class="replyForm">
								<form role="form" method="post" autocomplete="off">

									<input type="hidden" name="GP_id" value="${gpView.GP_id}">

									<div class="input_area">
										<textarea name="repCon" id="repCon"></textarea>
									</div>

									<div class="input_area">
										<button type="submit" id="reply_btn">댓글 남기기</button>
									</div>

								</form>
							</section>
						</c:if>

						<section class="replyList">
							<ol>
								<c:forEach items="${reply}" var="reply">

									<li>
										<div class="userInfo">
											<span class="userName">${reply.userName}</span> <span
												class="date"><fmt:formatDate value="${reply.repDate}"
													pattern="yyyy-MM-dd" /></span>
										</div>
										<div class="replyContent">${reply.repCon}</div>
									</li>
								</c:forEach>
							</ol>
						</section>
					</div>

					<div class="inputArea">
						<button type="button" id="modify_Btn" class="btn btn-warning">수정</button>
						<button type="button" id="delete_Btn" class="btn btn-danger">삭제</button>

						<script>
							var formObj = $("form[role='form']");

							$("#modify_Btn").click(function() {
								formObj.attr("action", "/admin/goods/modify");
								formObj.attr("method", "get")
								formObj.submit();
							});

							$("#delete_Btn").click(
									function() {

										var con = confirm("정말로 삭제하시겠습니까?");

										if (con) {
											formObj.attr("action",
													"/admin/goods/delete");
											formObj.submit();
										}
									});
						</script>

					</div>



				</form>

			</div>

		</section>

		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp"%>
			</div>
		</footer>

	</div>

</body>
</html>
