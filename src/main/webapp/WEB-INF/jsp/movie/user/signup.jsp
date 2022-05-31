<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel = "stylesheet" href = "/static/css/style.css" type = "text/css">
</head>
<body>
	<div id = "wrap">
		<h1>회원가입</h1>
		<label>아이디</label>
		<input type = "text" id = "idInput" placeholder = "아이디">
		<button type = "button" id = "confirmBtn">중복검사</button>
		
		<label>비밀번호</label>
		<input type = "password" id = "passwordInput" placeholder = "비밀번호">
		<input type = "password" id = "confirmpassword" placeholder = "비밀번호 확인">
		
		<label>이메일</label>
		<input type = "text" id = "emailInput" placeholder = "이메일">
	
		<label>이름</label>
		<input type = "text" id = "nameInput" placeholder = "이름">
		
		<button type = "button" id ="signupBtn">회원가입 완료</button>
	
	</div>
	

	<script type="text/javascript">
	
		$(document).ready(function(){
			
			
			
			
			$("#signupBtn").on("click", function(){
				
				
				
				let loginid = $("#idInput").val();
				let password = $("#passwordInput").val();
				let confirmpassword = $("#confirmpassword").val();
				let email = $("#emailInput").val();
				let name = $("#nameInput").val();
			
			
				
				if(loginid == "") {
					alert("아이디를 입력하세요");
					return;
				}
				
				
				if(password == "") {
					alert("비밀번호를 입력하세요");
					return;
				}
				
				if(confirmpassword == "") {
					alert("비밀번호를 확인하세요");
					return;
				}
				
				if(password != confirmpassword) {
					alert("비밀번호가 일치하지않습니다");
					return;
				}
				
				if(email == "") {
					alert("이메일을 입력하세요");
					return;
				}
				
				if(name == "") {
					alert("이름을 입력하세요");
					return;
				}
				
				
				
				
				
			
				$.ajax({
					type:"post",
					url:"/movie/sign_up",
					data:{"loginid":loginid, "password":password, "email":email, "name":name, "hometown":hometown},
					success:function(data) {
						if(data.result == "success") {
							location.href= "/movie/signin_view";
						}else{
							alert("회원가입 실패");
						}
					},
						
					error:function() {
						alert("회원가입 에러");
					}
				
					
					
				});
			});
			
			
			$("#confirmBtn").on("click",function(){
				
				let loginid = $("#idInput").val();
				
				
				if(loginid == "") {
					alert("아이디를 입력하세요");
					return;
				}
			
			
				$.ajax({
				
					type :"get",
					url : "/project/duplicateid",
					data : {"loginid":loginid},
					success:function(data) {
						
					
						
						if(data.duplicate) {
							alert("사용할수없는 아이디입니다");
						}else{
							alert("사용할수있는 아이디입니다");
						}
					},
					
					error:function() {
						alert("아이디 중복체크 에러");
					}
		
				});
			
				
			});
		});
	</script>
	
</body>
</html>