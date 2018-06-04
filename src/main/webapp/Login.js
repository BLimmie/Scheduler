function studentLogin(){
    $.ajax({
        type: "GET",
        url: 'grid-scheduler.herokuapp.com/main',
        headers: {
            "email": document.getElementById("email").value,
            "Method": "user",
            "password": document.getElementById("password").value
        },
        success: function(data){
            if(data["response"] == "Invalid Login"){
                alert("Invalid Login");
            }
            else{
                var url='grid-scheduler.herokuapp.com/Student.html';
                url += "?email=";
                url += data["email"];
                url += "&password=";
                url += data["password"];
                window.location.href = url;
            }
        }
    })
}