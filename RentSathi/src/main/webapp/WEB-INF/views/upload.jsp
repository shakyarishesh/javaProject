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
<title>upload</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/upload.css">
</head>
<body>
	<div align="center" class="container">
		<h3>Image Upload</h3>
		<form action="${pageContext.request.contextPath}/upload/add"
			enctype="multipart/form-data" method=post>
			<label for="Image" class="section">Image: </label> <input type="file"
				name="img" class="form-control" /> <label for="rentType"
				class="section">Rent Type:</label> <select id="rentType"
				name="rentType">
				<option value="house">house</option>
				<option value="flat">flat</option>
				<option value="room">room</option>
				<!-- <option value="Room with Kitchen">Room with Kitche</option>
          <option value="1BHK">1BHK</option>
          <option value="2BHK">2BHK</option> -->
			</select> <label for="Location" class="section">Location:</label> <input
				type="text" id="location" name="location"> <label for="bhk"
				class="section">BHK: </label> <input type="text" id="bhk" name="bhk">

			<label for="title" class="section">Title:</label> <input type="text"
				id="title" name="title"> <label for="price" class="section">Price:
			</label> <input type="number" id="price" name="price"> <label
				for="description" class="section">Description: </label>
			<textarea id="description" name="description" rows="4" cols="50"></textarea>

			<input type="submit" class="uploadbox" value="Upload" />
		</form>
	</div>

</body>
</html>