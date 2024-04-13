document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var formData = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    };
    
    fetch('http://localhost:8081/admin/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
    .then(response => response.json())
    .then(data => {
        if(data.success) {

            

            window.location.href='nexrpagenew.html';
            document.getElementById('message').textContent = 'Register Successfully';
            
        } else {
            document.getElementById('message').textContent = 'register failed';
        }

    })
    .catch(error => {
        console.error('Error:', error);
        
    });
});
