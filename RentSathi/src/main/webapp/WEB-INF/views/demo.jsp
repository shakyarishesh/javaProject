<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%
String login = (String) session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>rent demo</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/intro.css">
</head>
<body>

	<div class="services-container">
		<c:forEach items="${rentDetails }" var="rentDetail">
			<div class="box">
				<div class="box-img">
					<!--  -->
					<img src="data:image/jpeg;base64,${rentDetail.imgpath}" alt="Image">

				</div>
				<p>${rentDetail.created_at }</p>
				<h3>${rentDetail.title }</h3>
				<h2>
					${rentDetail.price }<span>/per Month</span>
				</h2>
				<a href="#" class="btn">Rent Now</a>
			</div>
		</c:forEach>
	</div>
	<div class="container">
		<button
			style="font-size: 20px; background-color: #ff6600; color: white; border: none; padding: 10px 20px;">
			<a href="${pageContext.request.contextPath}/intro"
				style="text-decoration: none; color: inherit;">Back</a>
		</button>
	</div>


</body>
</html>