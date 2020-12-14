<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script  src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<script src="/jsp_test/logins/login.js"></script>
</head>
 <body class="bg-dark">

  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">로그인</div>
      <div class="card-body">
      
       
          <div class="form-group">
            <div class="form-label-group">
              <input type="text" id="id" class="form-control" name="id" placeholder="Id" required="required" autofocus="autofocus">

            </div>
          </div>
          <div class="form-group">
            <div class="form-label-group">
              <input type="password" id="pwd" class="form-control" name="pwd" placeholder="Password" required="required">
            </div>
          </div>
          <div class="form-group">
            <div class="checkbox">
              <label>
                <input type="checkbox" value="remember-me">
                Remember Password
              </label>
            </div>
          </div>
          <p id="check"></p>
          <input class="btn btn-primary btn-block" type="button" id="login" value="로그인하기">
        
        <div class="text-center">
          <a class="d-block small mt-3" href="#">회원가입</a>
          <a class="d-block small" href="#">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>



</body>
</html>