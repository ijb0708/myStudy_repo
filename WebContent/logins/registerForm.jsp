<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body class="bg-dark">

  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Register an Account</div>
      <div class="card-body">
        <form>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="text" id="id" class="form-control" placeholder="아이디" required="required" autofocus="autofocus">

                </div>
              </div>
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="password" id="password" class="form-control" placeholder="비밀번호" required="required">
					
                </div>
              </div>
            </div>
          </div>
                    <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="text" id="name" class="form-control" placeholder="이름" required="required" autofocus="autofocus">

                </div>
              </div>
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="tel" id="tel" class="form-control" placeholder="휴대폰 번호" required="required">
					
                </div>
              </div>
            </div>
          </div>
                    <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="text" id="jumin" class="form-control" placeholder="주민번호(7자리)" required="required">
 		

                </div>
              </div>
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="email" id="email" class="form-control" placeholder="이메일" required="required">

                </div>
              </div>
            </div>
          </div>
                    <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="text" id="addr" class="form-control" placeholder="주소" required="required">
 		

                </div>
              </div>
              <div class="col-md-6">
                <div class="form-label-group">
                  <input type="text" id="addr2" class="form-control" placeholder="상세주소" required="required">

                </div>
              </div>
            </div>
          </div>


          <a class="btn btn-primary btn-block" href="login.html">가입</a>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="loginForm.jsp">로그인 </a>
          <a class="d-block small" href="forgot-password.html">비밀번호 찾기</a>
        </div>
      </div>
    </div>
  </div>


</body>
 </html>