document.addEventListener("DOMContentLoaded", function() {
    const form = document.querySelector("form"),
        nextBtn = form.querySelector(".nextBtn"),
        backBtn = form.querySelector(".backBtn"),
        allInput = form.querySelectorAll(".first input");

    nextBtn.addEventListener("click", (e) => {
        e.preventDefault(); // Prevent the default form submission behavior

        allInput.forEach(input => {
            if (input.value !== "") {
                form.classList.add('secActive');
            } else {
                form.classList.remove('secActive');
            }
        });
    });

    backBtn.addEventListener("click", () => form.classList.remove('secActive'));

    // Function to validate passwords (enhanced for security)
    function validatePasswords() {
        const password1 = document.getElementById('pd1').value;
        const password2 = document.getElementById('pd2').value;

        // Validate password format (minimum 8 characters, mix of uppercase, lowercase, numbers, and symbols)
        const passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^\w\s]).{8,}$/;
        if (!passwordRegex.test(password1)) {
            return false; // Invalid password format
        }

        // Check if passwords match
        return password1 === password2;
    }

    // Function to validate email
    function validateEmail(email) {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }

    // Function to validate phone number (consider country-specific formatting)
    function validatePhoneNumber(phonenum) {
        // Example for Nepal phone numbers (replace with your desired validation):
        const phoneRegex = /^98[0-9]{8}$/; // Adjust for Nepal format
        return phoneRegex.test(phonenum);
    }

    // Function to validate full name (allow spaces)
    function validateName(fullname) {
        const nameRegex = /^[a-zA-Z\s]+$/; // Allow spaces
        return nameRegex.test(fullname);
    }

    // Event listener for form submission
    
    form.addEventListener("submit", function(event) {
        event.preventDefault(); // Prevent default form submission

        // Validate passwords before submission
        if (!validatePasswords()) {
            alert('Passwords do not match or invalid format. Minimum 8 characters with mix of uppercase, lowercase, numbers, and symbols.');
            document.getElementById('pd1').focus(); // Focus on first password field
            return false; // Prevent form submission
        }

        // Validate email
        const email = document.getElementById('email').value;
        if (!validateEmail(email)) {
            alert('Please enter a valid email address.');
            document.getElementById('email').focus();
            return false; // Prevent form submission
        }

        // Validate phone number (adjust validation function for your needs)
        const phonenum = document.getElementById('phonenum').value;
        if (!validatePhoneNumber(phonenum)) {
            alert('Please enter a valid phone number (e.g. 9812345678).');
            document.getElementById('phonenum').focus();
            return false;
        }

        // Validate full name
        const fullname = document.getElementById('fullname').value;
        if (!validateName(fullname)) {
            alert('Please enter a valid name (letters and spaces only).');
            document.getElementById('fullname').focus();
            return false;
        }

        // Successful validation
        alert("Registered Successfully! Click OK to continue");
        return ture;

    });
});
