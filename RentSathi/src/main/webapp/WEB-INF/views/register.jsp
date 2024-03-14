<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>Registration Form</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/registerstyle.css"/> " />
<link rel="stylesheet"
	href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<title>Regisration Form</title>
</head>
<body>
	<div class="container">
		<header>Registration (KYC verification)</header>
		<div>
			<h3 style="color: red;">${error}</h3>
		</div>
		<div class="alert alert-danger" role="alert">
			<form:errors path="registerTable.*" />
		</div>
		<form action="registerPost" modelAttribute="registerTable" method=post>
			<div class="form first">
				<div class="details personal">
					<span class="title">Personal Details</span>
					<div class="fields">
						<div class="input-field">
							<label>Full Name</label> <input type="text" name="fullname"
								placeholder="Enter your name" required>
						</div>
						<div class="input-field">
							<label>Date of Birth</label> <input type="date" name="dob"
								placeholder="Enter birth date" required>
						</div>
						<div class="input-field">
							<label>Email</label> <input type="text" name="email"
								placeholder="Enter your email" required>
						</div>
						<div class="input-field">
							<label>Mobile Number</label> <input type="number" name="mobileno"
								placeholder="Enter mobile number" required>
						</div>
						<div class="input-field">
							<label>Gender</label> <select name="gender" required>
								<option disabled selected>Select gender</option>
								<option>Male</option>
								<option>Female</option>
								<option>Others</option>
							</select>
						</div>
						<div class="input-field">
							<label>Occupation</label> <input type="text" name="occupation"
								placeholder="Enter your ccupation">
						</div>
					</div>
				</div>

				<div class="details ID">
					<span class="title">Identity Details</span>
					<div class="fields">
						<div class="input-field">
							<label>ID Type</label> <input type="text" name="idType"
								placeholder="Enter ID type" required>
						</div>
						<div class="input-field">
							<label>ID Number</label> <input type="number" name="idNo"
								placeholder="Enter ID number" required>
						</div>
						<div class="input-field">
							<label>Issued Authority</label> <input type="text"
								name="IssuedAuthority" placeholder="Enter issued authority"
								required>
						</div>
					</div>
					<button class="nextBtn">
						<span class="btnText">Next</span> <i class="uil uil-navigator"></i>
					</button>
				</div>
			</div>
			<div class="form second">
				<div class="details address">
					<span class="title">Address Details</span>
					<div class="fields">
						<div class="input-field">
							<label>Address Type</label> <input type="text" name="addressType"
								placeholder="Permanent or Temporary" required>
						</div>
						<div class="input-field">
							<label>City</label> <input type="text" name="nationality"
								placeholder="Enter your city" required>
						</div>
						<div class="input-field">
							<label>Province</label> <input type="text" name="province"
								placeholder="Enter your state" required>
						</div>
						<div class="input-field">
							<label>District</label> <input type="text" name="district"
								placeholder="Enter your district" required>
						</div>
					</div>
				</div>
				<span class="title">Create a new password</span>
				<div class="fields">
					<div class="input-field">
						<input type="password" name="password"
							placeholder="Enter your password" required> <input
							type="password" name="confirmpassword"
							placeholder="Enter your password again" required>
					</div>
				</div>
				<div class="buttons">
					<div class="backBtn">
						<i class="uil uil-navigator"></i> <span class="btnText">Back</span>
					</div>

					<button class="sumbit">
						<span class="btnText">Submit</span> <i class="uil uil-navigator"></i>
					</button>
				</div>
			</div>
		</form>
	</div>
	<script src="<c:url value="/resources/js/script.js"/>"></script>
</body>
</html>

