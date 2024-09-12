document.addEventListener("DOMContentLoaded", function() {
    // Get user data from localStorage
    const userData = JSON.parse(localStorage.getItem('userData'));

    // Populate profile fields with user data
    document.getElementById("name").textContent = userData.name;
    document.getElementById("username").textContent = userData.username;
    document.getElementById("email").textContent = userData.email;
    document.getElementById("phone").textContent = userData.phone;
    document.getElementById("occupation").textContent = userData.occupation;
    document.getElementById("gender").textContent = userData.gender;
    document.getElementById("id-type").textContent = userData.idType;
    document.getElementById("id-number").textContent = userData.idNumber;
    document.getElementById("issued-authority").textContent = userData.issuedAuthority;
    document.getElementById("address-type").textContent = userData.addressType;
    document.getElementById("nationality").textContent = userData.nationality;
    document.getElementById("province").textContent = userData.province;
    document.getElementById("district").textContent = userData.district;
});
