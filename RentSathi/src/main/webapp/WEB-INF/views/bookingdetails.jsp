<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/profilestyle.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body
	style="background-image: url(${pageContext.request.contextPath}/resources/Images/Background1.png);">
	<div class="profile-info">
		<h2>Booking Information</h2>

		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">S.N.</th>
					<th scope="col">Title</th>
					<th scope="col">Rent Type</th>
					<th scope="col">Price</th>
					<th scope="col">Date</th>
					<th scope="col">Status</th>
					<th scope="col">Description</th>
				</tr>
			</thead>
			<tbody id="booking-table-body">
				<c:forEach items="${bookingdetails }" var="b">
					<%
					int i = 1;
					%>
					<tr>
						<td scope="col"><%=i++%></td>
						<td scope="col">${b.title }</td>
						<td scope="col">${b.rentType }</td>
						<td scope="col">${b.price }</td>
						<td scope="col">${b.created_at }</td>
						<td scope="col">${b.status }</td>
						<td scope="col">${b.description }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script
		src="${pageContext.request.contextPath}/resources/js/profscript.js"></script>
</body>
</html>