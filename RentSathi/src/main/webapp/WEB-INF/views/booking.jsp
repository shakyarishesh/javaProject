<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking</title>
</head>
<body>
	<h2>Room Booking Information</h2>
	<form action="bookAdd" method=post>
		<label for="name">Name:</label><br> <input type="text" id="name"
			name="name" required><br> <label for="email">Email:</label><br>
		<input type="email" id="email" name="email" required><br>

		<label for="mobileno">Mobile Number:</label><br> <input
			type="tel" id="mobileno" name="mobileno" required><br>
			
			<label for="duration">duration</label><br> <input
			type="number" id="duration" name="duration" placeholder="Duration in months" required><br>
			
			 <label
			for="comment">Comment:</label><br>
		<textarea id="comment" name="comment" rows="4" cols="50"></textarea>
		<br> <input type="submit" value="Submit">
	</form>
</body>
</html>