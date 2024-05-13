// src/main/resources/static/js/login.js
document.getElementById('signupForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const form = document.getElementById('signupForm');
    const formData = {
        username: form.username.value,
        email: form.email.value,
        password: form.password.value,
        firstName: form.firstName.value,
        lastName: form.lastName.value,
        dob: form.dob.value.substring(0, form.dob.value.indexOf('T')).concat(" 00:00:00"),
        role: Array.from(form.querySelectorAll('input[name="role"]:checked')).map(el => el.value)
    };

    console.log(formData)

    fetch('http://35.198.196.1/api/auth/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData)
    }).then(response => response.json())
        .then(data => {
            if (data.message === "User registered successfully!") {
                alert("Registration successful.")
                window.location.href = '/login';
            } else {
                document.getElementById('signupError').textContent = 'Error: ' + data.message;
            }
        }).catch(error => {
        console.error('Error:', error);
    });
});