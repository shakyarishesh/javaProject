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
		<form action="${pageContext.request.contextPath}/registration/registerPost" modelAttribute="registerTable" method=post onsubmit="return validateForm();">
			<div class="form first">
				<div class="details personal">
					<span class="title">Personal Details</span>
					<div class="fields">
						<div class="input-field">
							<label>Full Name</label> <input type="text" name="fullname" id="fullname"
								placeholder="Enter your name" required>
						</div>
						<div class="input-field">
							<label>Date of Birth</label> <input type="date" name="dob" id="dob"
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
	<script>
    function validateForm() {
        var fullname = document.getElementById("fullname").value;
        var dob = document.getElementById("dob").value;
        var email = document.getElementById("email").value;
        var mobileno = document.getElementById("mobileno").value;
        var gender = document.getElementById("gender").value;
        var occupation = document.getElementById("occupation").value;
        var idType = document.getElementById("idType").value;
        var idNo = document.getElementById("idNo").value;
        var IssuedAuthority = document.getElementById("IssuedAuthority").value;
        var addressType = document.getElementById("addressType").value;
        var nationality = document.getElementById("nationality").value;
        var province = document.getElementById("province").value;
        var district = document.getElementById("district").value;
        var password = document.getElementById("password").value;

        // Regular expressions for validation
        var nameRegex = /^[a-zA-Z\s]{1,60}$/;
        var dobRegex = /^(?:\d{4}-\d{2}-\d{2})|({0})$/;
        var emailRegex = /^[\w\.-]+@[a-zA-Z\d\.-]+\.[a-zA-Z]{2,}$/;
        var mobileRegex = /^\d{10}$/;
        var genderRegex = /^(?i)(Male|Female|Other)$/;
        var occupationRegex = /^(?i)(Student|Teacher|Engineer|Doctor|Other)$/;
        var idTypeRegex = /^(?i)(NationalId|License|Pan|Other)$/;
        var idNoRegex = /^\d*$/;
        var authorityRegex = /^[a-zA-Z\s]*$/;
        var addressTypeRegex = /^(?i)(Permanent|Temporary)$/;
        var nationalityRegex = /^(?i)(Nepali|Nepalese|Indian|Chinese|Other)$/;
        var provinceRegex = /^(?i)(province 1|province 2|Bagmati|Gandaki|Lumbini|Karnali|Sudurpashchim)$/;
        var districtRegex = /^(?i)(Kathmandu|Pokhara|Biratnagar|Birgunj|Nepalgunj|Dharan|Butwal|Dhangadhi|Bharatpur|Hetauda|Janakpur|Itahari|Birendranagar|Tansen|Damak|Ghorahi|Lamjung|Baglung|Myagdi|Kaski|Mustang|Syangja|Parbat|Gulmi|Arghakhanchi|Palpa|Pyuthan|Rukum|Rolpa|Dang|Banke|Bardiya|Surkhet|Dailekh|Jajarkot|Dolpa|Jumla|Kalikot|Mugu|Humla|Bajura|Bajhang|Achham|Doti|Kailali|Kanchanpur)$/;
        var passwordRegex = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,20}$/;

        // Validation check for each field
        if (!fullname.match(nameRegex)) {
        	alert("Full Name should contain alphabets only and be less than 60 characters");
            return false;
        }
        if (!dob.match(dobRegex)) {
            alert("Enter Valid Date (YYYY-mm-dd)");
            return false;
        }
        if (!email.match(emailRegex)) {
            alert("Invalid email format");
            return false;
        }
        if (!mobileno.match(mobileRegex)) {
            alert("Mobile number should be 10 digits");
            return false;
        }
        if (!gender.match(genderRegex)) {
            alert("Invalid gender value");
            return false;
        }
        if (!occupation.match(occupationRegex)) {
            alert("Invalid occupation value");
            return false;
        }
        if (!idType.match(idTypeRegex)) {
            alert("Invalid idType value");
            return false;
        }
        if (!idNo.match(idNoRegex)) {
            alert("Id number is required");
            return false;
        }
        if (!IssuedAuthority.match(authorityRegex)) {
            alert("Issued Authority should contain alphabets only");
            return false;
        }
        if (!addressType.match(addressTypeRegex)) {
            alert("Invalid addressType value");
            return false;
        }
        if (!nationality.match(nationalityRegex)) {
            alert("Invalid nationality value");
            return false;
        }
        if (!province.match(provinceRegex)) {
            alert("Invalid province value");
            return false;
        }
        if (!district.match(districtRegex)) {
            alert("Invalid district value");
            return false;
        }
        if (!password.match(passwordRegex)) {
            alert("Password must contain at least one digit, one lowercase, one uppercase, one special character, and have a length between 6 and 20 characters");
            return false;
        }

        return true; // Form submission allowed
    }
</script>
	
</body>
</html>

