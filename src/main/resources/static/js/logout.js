// src/main/resources/static/js/logout.js
// function clearClientStorage() {
//     localStorage.clear();
//     sessionStorage.clear();
// }

document.getElementById('logoutButton').addEventListener('click', function() {
    document.cookie = 'bearer=;path=/'
    window.location.href = '/profile';
});