<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/profilestyle.css">
</head>
<body>
   
    <main>
        <section class="profile-container">
            <div class="profile-info">
                <img src="${pageContext.request.contextPath}/resources/Images/logo.png" alt="Profile picture">
                <h2><span id="name"></span></h2>
                <p>Username: <span id="username"></span></p>
                <p>Email: ${login } <span id="email"></span></p>
                <p>Phone: <span id="phone"></span></p>
            </div>
            <div class="profile-info">
                <p>Occupation: <span id="occupation"></span></p>
                <p>Gender: <span id="gender"></span></p>
                <p>ID Type: <span id="id-type"></span></p>
                <p>ID Number: <span id="id-number"></span></p>
                <p>Issued Authority: <span id="issued-authority"></span></p>
                <p>Address Type: <span id="address-type"></span></p>
                <p>Nationality: <span id="nationality"></span></p>
                <p>Province: <span id="province"></span></p>
                <p>District: <span id="district"></span></p>
            </div> 
        
             <div class="profile-settings">
                <h3>Account Settings</h3>
                <ul>
                    <li><a href="#">Edit Profile</a></li>
                    <li><a href="#">Change Password</a></li>
                    <li><a href="#">Delete Account</a></li>
                </ul>
                <h3>Teams</h3>
                <h3>Invoices</h3>
                <h3>Integration</h3>
                <h3>Privacy</h3>
                <h3>Notifications</h3>
            </div>

        </section>
    </main>
    <script src="${pageContext.request.contextPath}/resources/js/profscript.js"></script>
</body>
</html>
