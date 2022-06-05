<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    	<link rel = "stylesheet" href = "/static/css/style.css" type = "text/css">
</head>
<body>

<c:import url = "/WEB-INF/jsp/includes/header.jsp"></c:import>


	<div id = "wrap">
		<h3 class = "text-center mt-5">공지사항 작성</h3>
		<input type = "text" class = "form-control mt-5" id = "noticetitle">
		<textarea class = "form-control mt-3" id = "noticecontent"></textarea>
		<button type = "button" class = "form-control mt-3" id = "noticeBtn">업로드</button>
	
	</div>
	
	<c:import url= "/WEB-INF/jsp/includes/footer.jsp"></c:import>
	
	<script>
	$(document).ready(function(){
		
		$("#noticeBtn").on("click", function(){
			
			
			let noticetitle = $("#noticetitle").val();
			let noticecontent = $("#noticecontent").val();
			
			
			
			if(noticetitle == "") {
				alert("게시글 제목을 정하세요");
				return;
			}
			
			if(noticecontent == "") {
				alert("게시글 내용을 입력하세요");
				return;
			}
		
			
			$.ajax({
				type : "post",
				url : "/project/adminupload",
				data : {"noticetitle":noticetitle, "noticecontent":noticecontent},
				success:function(data) {
					if(data.result == "success") {
						
						location.href ="/project/notice_view"
					}else{
						alert("공지사항 업로드 실패");
					}
				},
				error:function() {
					alert("공지사항 업로드 에러");
				}
				
				
				
				
				
			});
			
			
			
			
		});
		
	});
	</script>
	
</body>
</html>