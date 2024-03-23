<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listings</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<div class="container mt-5">
		<h2>Property specifications</h2>
		<p>Here's a list of properties with their specifications</p>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Booking ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Mobile Number</th>
					<th>Comment</th>
					<th>Created At</th>

					<th>Rent ID</th>
					<th>Rent Type</th>
					<th>Title</th>
					<th>Location</th>
					<th>Price</th>
					<th>Status</th>
				</tr>
			</thead>
			<%
			int i = 1;
			%>
			<c:forEach items="${listings }" var="l">
				<tbody>
					<tr>
						<td><%= i++ %></td>
						<td>${l.bookingId }</td>
						<td>${l.name }</td>
						<td>${l.email }</td>
						<td>${l.mobileno }</td>
						<td>${l.comment }</td>
						<td>${l.createdAt }</td>
						<td>${l.rentId }</td>
						<td>${l.rentType }</td>
						<td>${l.title }</td>
						<td>${l.location }</td>
						<td>${l.price }</td>
						<td>${l.status }</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
</body>
</html>