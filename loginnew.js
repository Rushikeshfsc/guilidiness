
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var formData = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    };
    
    fetch('http://localhost:8081/admin/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
    .then(response => response.json())
    .then(data => {
        if(data.success) {

            

            window.location.href='nextpage.html';
            document.getElementById('message').textContent = 'Login successful';
            
            
            //this.onclick=window.location.href='nextpage.html';

            // Redirect to another page or perform other actions upon successful login
              // window.location.href = 'nextpage.html';
               

        } else {
            document.getElementById('message').textContent = 'Login failed';
        }

    })
    .catch(error => {
        console.error('Error:', error);
        
    });
});
