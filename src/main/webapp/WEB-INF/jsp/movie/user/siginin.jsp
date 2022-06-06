<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel = "stylesheet" href = "/static/css/style.css" type = "text/css">
</head>
<body>
	<div id = "wrap">
		<h1>로그인</h1> <br>
			<div id = "loginBox">		
				<h3>아이디</h3>
				<input type = "text" id = "loginidInput" class = "form-control" placeholder = "아이디">
				<h3>비밀번호</h3>
				<input type = "password" id = "passwordInput" class = "form-control" placeholder = "비밀번호">
				<button type = "submit" id = "loginBtn" class = "btn btn-info mt-3">로그인</button>
			</div>
				
				
				<div class = "text-center mt-3">
				<label><a href = "/project/signup_view" class = "justify-content-center">회원가입</a></label>
				</div>
				
	</div>
	
	
	<script>
			$(document).ready(function(){
				
				$("#loginBtn").on("click",function(){
					
					let loginid = $("#loginidInput").val();
					let password = $("#passwordInput").val();
					
					
					
				if(loginid == "") {
					alert("아이디를 입력하세요");
					return;
				}
				
				if(password == "") {
					alert("비밀번호를 입력하세요");
					return;
				}
					
				$.ajax({
					type: "post",
					url: "/project/signin",
					data: {"loginid":loginid, "password":password},
					success:function(data) {
						if (data.result == "success") {
							location.href = "/movietime/main_view";
						}else{
							alert("가입되지않은 유저입니다");
						}
						
					},
					error:function(){
						alert("로그인 에러");
					}
					
				});
				
					
					
				});
			});
	
	
	</script>
</body>
</html>