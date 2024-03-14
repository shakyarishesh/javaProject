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
<title>Header</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/intro.css">
</head>
<body>
	<header>
		<a href="#" class="logo"><img
			src="<c:url value="/resources/Images/logo3.jpg"/>" alt=""></a>
		<div class="bx bx-menu" id="menu-icon"></div>
		<ul class="navbar">
			<li><a href="${pageContext.request.contextPath}/intro">Home</a></li>
			<li><a href="${pageContext.request.contextPath}/search/housedetail">House</a></li>
			<li><a href="${pageContext.request.contextPath}/search/flatdetail">Flats</a></li>
			<li><a href="${pageContext.request.contextPath}/search/roomdetail">Rooms</a></li>
			<li><a href="#About">About Us</a></li>
		</ul>
		<div class="header-btn">
			<%-- <c:if test="${email == null}">
				<a href="${pageContext.request.contextPath}/registration/login"
					class="login">Log In</a>
				<a href="${pageContext.request.contextPath}/registration/register"
					class="signup">Sign Up</a>
			</c:if> --%>
			<%
			if (login == null) {
			%>
			<a href="${pageContext.request.contextPath}/registration/login"
				class="login">Log In</a> <a
				href="${pageContext.request.contextPath}/registration/register"
				class="signup">Sign Up</a>
			<%
			}
			%>
			<%
			if (login != null) {
			%>
			<a href="${pageContext.request.contextPath}/rent/upload"
				class="upload">Upload</a>
			<a href="${pageContext.request.contextPath}/registration/profile"
				class="login">Profile</a> <a
				href="${pageContext.request.contextPath}/registration/logout"
				class="signup">LogOut</a>
			<%
			}
			%>
		</div>
	</header>

</body>
</html>