<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel = "stylesheet" href = "/static/css/style.css" type = "text/css">
     <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
</head>
<body>

	<c:import url = "/WEB-INF/jsp/includes/header.jsp"></c:import>
	
	<div id = "wrap">
		<h3 class = "text-center">공지사항</h3>
		<table class ="table table-hover form-control">
			<thead>
				<tr>
					<th>순번</th>
					<th>제목</th>
					<th>작성일</th>	
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "noticelist" items = "${noticelist}">
				 <tr>
					<td>${noticelist.id}</td>
					<td><a href = "/project/noticedetail_view?id=${noticelist.id}">${noticelist.noticetitle}</a></td>
					<td><fmt:formatDate pattern ="yyyy-MM-dd" value="${noticelist.createdAt}"/></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test = "${loginid == 'ashspell'}">

			<button class = "btn btn-info" onclick = "location.href=`/movie/noticeupload_view`">공지 업로드</button>
	

		</c:if>
	</div>
	
	<c:import url= "/WEB-INF/jsp/includes/footer.jsp"></c:import>



	
</body>
</html>