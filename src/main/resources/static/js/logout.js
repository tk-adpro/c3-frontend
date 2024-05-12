// src/main/resources/static/js/logout.js
// function clearClientStorage() {
//     localStorage.clear();
//     sessionStorage.clear();
// }

document.getElementById('logoutButton').addEventListener('click', function() {
    document.cookie = 'bearer=; Max-Age=0'
    fetch('/auth/logout', {
        method: 'POST'
    });
});