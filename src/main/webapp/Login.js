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
                let url='/Student.html';
                url += "?email=";
                url += data["email"];
                url += "&password=";
                url += data["password"];
                window.location.href = url;
            }
        }
    });
}

function createProfile(){
    $.ajax({
        type: "GET",
        url: '/main',
        headers: {
            "email": document.getElementById("studentEmail").value,
            "Method": "user",
            "password": document.getElementById("studentPassword").value,
            "admin": "false"
        },
        success: function(data){
            console.log(data);
            if(data["response"] == "Invalid Login"){
                alert("Invalid Login");
            }
            else{
                let url='/Student.html';
                url += "?email=";
                url += data["email"];
                url += "&password=";
                url += data["password"];
                window.location.href = url;
            }
        },
        error: function(){
            alert("ERROR");
        },
        failure: function(){
            alert("FAILURE");
        }
    });
}

function adminLogin(){
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