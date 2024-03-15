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
				name="rentType" onchange="changeRentType()">
				<option value="house">house</option>
				<option value="flat">flat</option>
				<option value="room">room</option>
			</select>
			<!-- <option value="Room with Kitchen">Room with Kitche</option>
          <option value="1BHK">1BHK</option>
          <option value="2BHK">2BHK</option> -->
			<label for="Location" class="section">Location:</label> <input
				type="text" id="location" name="location">
			<div id="bhkField">
				<!-- BHK field will be added dynamically here based on selection -->
			</div>


			<label for="title" class="section">Title:</label> <input type="text"
				id="title" name="title"> <label for="price" class="section">Price:
			</label> <input type="number" id="price" name="price"> <label
				for="description" class="section">Description: </label>
			<textarea id="description" name="description" rows="4" cols="50"></textarea>

			<input type="submit" class="uploadbox" value="Upload" />
		</form>
	</div>


	<script>
		function changeRentType() {
			var rentType = document.getElementById("rentType").value;
			var bhkField = document.getElementById("bhkField");

			// Clear previous options
			bhkField.innerHTML = "";

			if (rentType === "flat") {
				// If flat is chosen, add BHK options
			    var bhkLabel = document.createElement("label");
			    bhkLabel.setAttribute("for", "bhk");
			    bhkLabel.textContent = "BHK:";
			    bhkField.appendChild(bhkLabel);

			    bhkField.appendChild(document.createElement("br"));

			    var bhkInput = document.createElement("input");
			    bhkInput.setAttribute("id", "bhk");
			    bhkInput.setAttribute("name", "PropertySpecification");
			    bhkInput.setAttribute("type", "text");
			    bhkField.appendChild(bhkInput);
			} else if (rentType === "house") {
				// If house is chosen, add storey label
				var storeyLabel = document.createElement("label");
				storeyLabel.setAttribute("for", "storey");
				storeyLabel.textContent = "Storey:";
				bhkField.appendChild(storeyLabel);

				var storeyInput = document.createElement("input");
				storeyInput.setAttribute("type", "text");
				storeyInput.setAttribute("id", "storey");
				storeyInput.setAttribute("name", "PropertySpecification");
				bhkField.appendChild(storeyInput);
			} else if (rentType === "room") {
				// If room is chosen, add options for number of rooms
				var roomLabel = document.createElement("label");
				roomLabel.setAttribute("for", "numberOfRooms");
				roomLabel.textContent = "Number of Rooms:";
				bhkField.appendChild(roomLabel);

				var roomInput = document.createElement("input");
				roomInput.setAttribute("type", "text");
				roomInput.setAttribute("id", "numberOfRooms");
				roomInput.setAttribute("name", "PropertySpecification");
				bhkField.appendChild(roomInput);
			}
		}
	</script>

</body>
</html>