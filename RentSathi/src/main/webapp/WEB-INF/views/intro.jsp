<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Introduction page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/intro.css">
<%-- <link rel="stylesheet" href="<c:url value="/resources/css/intro.css"/>"> --%>
<link rel="stylesheet"
	href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
</head>
<body
	style="background-image: url('<c:url value="/resources/Images/Background4.png"/>')">
	<jsp:include page="header.jsp" />
	<!-- Home  -->
	<section class="home" id="home">
		<div class="text">
			<h1>
				<span>Discover Comfort,</span><br>Rent with Ease.
			</h1>
			<p>Seamless Rentals, Tailored for You. Find your perfect space
				hassle-free. Secure, convenient, and personalized living solutions
				at your fingertips.</p>
		</div>
		<!-- This below will show the flats or houses and when the person tries to click on the items they want they need to log in or signup to look into that product in more detailed way -->
		<div class="form-container">
			<form
				action="${pageContext.request.contextPath}/search/searchByDistrict"
				method=get>
				<div class="input-box">
					<span>Location:</span> <input type="search" name="district" id=""
						placeholder="Search Places">
				</div>
				<div class="input-box">
					<span>Type of Space:</span> <select id="dropdown" name="rentType">
						<option value="house">House</option>
						<option value="room">Rooms</option>
						<option value="flat">Flats</option>
					</select>
				</div>
				<!-- <div class="input-box">
					<span>No of peoples: </span> <input type="number" id="quantity"
						name="quantity" min="1" max="">
				</div> -->
				<input type="submit" name="" id="" class="btn">
			</form>
		</div>
	</section>
	<section class="rent" id="rent">
		<div class="heading">
			<span> How Its Done</span>
			<h1>Rent With 4 Easy Steps</h1>
		</div>
		<div class="rent-container">
			<div class="box">
				<i class='bx bx-log-in'></i>
				<h2>Log In or Register your Account</h2>
				<p>The first step is to create your account. Please fill up all
					the required fields nicely</p>
			</div>
			<div class="box">
				<i class='bx bx-map'></i>
				<h2>Choose a Location</h2>
				<p>The next step is to choose the location that you want to stay
					or prefer.</p>
			</div>
			<div class="box">
				<i class='bx bxs-home-heart'></i>
				<h2>Choose your preferred space</h2>
				<p>Then choose your choice of space, like do you want to rent a
					Apartment, house, flat or rooms.</p>
			</div>
			<div class="box">
				<i class='bx bxs-contact'></i>
				<h2>Contact with the Owner</h2>
				<p>Lastly, you can contact with the owner and the you can
					prepare for visit to your new home.</p>
			</div>
		</div>
	</section>
	<section class="services" id="service">
		<div class="heading">
			<h1>
				<br> <span> Our Top Picks </span><br>Explore Our Top Deals
				<br> <span> From Top Rated Dealers</span>
			</h1>
		</div>
		<div class="services-container">
			<c:forEach items="${rentDetails }" var="rentDetail">
				<div class="box">
					<div class="box-img">
						<!--  -->
						<img src="data:image/jpeg;base64,${rentDetail.imgpath}"
							alt="Image">

					</div>
					<p>${rentDetail.created_at }</p>
					<h3>${rentDetail.title }</h3>
					<h2>
						${rentDetail.price }<span>/per Month</span>
					</h2>
					<a href="${pageContext.request.contextPath}/book/rentNow/${rentDetail.rent_id}" class="btn">Rent Now</a>
				 	<p>${pageContext.request.contextPath}</p>
				</div>
			</c:forEach>
			<h2>${error }</h2>

		</div>
	</section>
	<script src="<c:url value="/resources/js/main.js"/>"></script>
</body>
</html>