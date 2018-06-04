function studentLogin(){
    $.ajax({
        type: "GET",
        url: '/main',
        headers: {
            "email": document.getElementById("email").value,
            "Method": "user",
            "password": document.getElementById("password").value,
            "admin": "false"
        },
        success: function(data){
            console.log(data);
            if(data["response"] == "Invalid Login"){
                alert("Invalid Login");
            }
            else{
                var url='/Student.html';
                url += "?email=";
                url += data["email"];
                url += "&password=";
                url += data["password"];
                window.location.href = url;
            }
        }
    })
}

function studentLogin(){
    $.ajax({
        type: "GET",
        url: '/main',
        headers: {
            "email": document.getElementById("email").value,
            "Method": "user",
            "password": document.getElementById("password").value,
            "admin": "true"
        },
        success: function(data){
            console.log(data);
            if(data["response"] == "Invalid Login"){
                alert("Invalid Login");
            }
            else if(data["response"] == "Not an admin"){
                alert("Not an Admin");
            }
            else {
                var url='/Admin.html';
                url += "?email=";
                url += data["email"];
                url += "&password=";
                url += data["password"];
                window.location.href = url;
            }
        }
    })
}