// src/main/resources/static/js/login.js
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    fetch('http://34.143.221.150/api/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password })
    }).then(response => response.json())
        .then(data => {
            if (data.token) {
                document.cookie = `bearer=${data.token};path=/`;
                window.location.href = '/profile';
            } else {
                document.getElementById('loginError').textContent = data.message;
            }
        }).catch(error => {
        console.error('Error:', error);
    });
});