//TODO: Have the student's grid autoload values to the grid displayed on the webpage
//TODO: HAVE "Edit Profile" LINK TO THE PROPER WEBPAGE

var courseList = null;
var userGrid = null;
var userMajor = null;
var firstName = null;
var email;

var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};

function initialize(){
    email = getUrlParameter("email");
    var password = getUrlParameter("password");
    console.log(email);
    console.log(password);
    $.ajax({
        type: "GET",
        url: '/main',
        headers: {
            "email": email,
            "Method": "user",
            "password": password,
            "admin": "false"
        },
        success: function(data){
            console.log(data);
            userMajor = data["major"];
            firstName = data["firstName"];
            console.log(firstName);
            document.getElementById("header").innerHTML = "Welcome " + firstName + "!";
            document.getElementById("header").innerHTML = "AHHHHH IT WORKS";
	    // document.getElementById("header").innerHTML = userGrid[1][1]["courses"][0]["ID"];
		/*
            var q11 = userGrid[0][0]["courses"];
            var q12 = userGrid[0][1]["courses"];
            var q13 = userGrid[0][2]["courses"];
            var q21 = userGrid[1][0]["courses"];
            var q22 = userGrid[1][1]["courses"];
            var q23 = userGrid[1][2]["courses"];
            var q31 = userGrid[2][0]["courses"];
            var q32 = userGrid[2][1]["courses"];
            var q33 = userGrid[2][2]["courses"];
            var q41 = userGrid[3][0]["courses"];
            var q42 = userGrid[3][1]["courses"];
            var q43 = userGrid[3][2]["courses"];
		
            for (y = 1; y < 5; y++){
                for (q = 1; q < 4; q++){
                    // var l = userGrid[y-1][q-1]["courses"]
		    document.getElementById("header").innerHTML = userGrid[y-1][q-1]["courses"][0]
                    for (c = 0; c < l.length; c++){
                        fillFields(("y" + y + "q" + q), l[c]["ID"]);
                    }
                }
            }
		*/
        }
    });
    $.ajax({
        type: "GET",
        url: '/main',
        headers: {
            "email": email,
            "Method": "grid",
        },
        success: function(data){
            userGrid = data["grid"];
            for (y = 1; y < 5; y++){
                for (q = 1; q < 4; q++){
                    let l = userGrid[y-1][q-1]["courses"];
                    for (c = 0; c < l.length; c++){
                        fillFields(("y" + y + "q" + q), l[c]["ID"]);
                        // fillFields(("y" + y + "q" + q), "TESTCOURSE");
                    }
                }
            }
            /*
            q13 = data["grid"][0][2]["courses"]
            for (i = 0; i < q13.length; i++){
                display(q13[i]["ID"]);
            }
            display(course["ID"])
            */
        }
    });

}

function fillFields(id, value) {
    var quarter = document.getElementById(id);
    var input = document.createElement("input");
    input.type = "text";
    input.className= "w3-input w3-border";
    input.style.width = "90%";
    input.style.cssFloat = "left";
    input.value = value;
    var button = document.createElement("button");
    button.className= "w3-input w3-border";
    button.textContent = "X";
    button.style.backgroundColor = "#162e54";
    button.style.color = "white";
    button.style.width = "10%";
    button.style.height = "49px";
    button.onclick = function()
    {
        document.getElementById(id).removeChild(input);
        document.getElementById(id).removeChild(button)
    }
    ;
    quarter.appendChild(input);
    quarter.appendChild(button);
}

function addField(id) {
    var quarter = document.getElementById(id);
    var input = document.createElement("input");
    input.type = "text";
    input.className= "w3-input w3-border";
    input.style.width = "90%";
    input.style.cssFloat = "left";
    input.placeholder = "e.g. CMPSC56";
    var button = document.createElement("button");
    button.className= "w3-input w3-border";
    button.textContent = "X";
    button.style.backgroundColor = "#162e54";
    button.style.color = "white";
    button.style.width = "10%";
    button.style.height = "49px";
    button.onclick = function()
    {
        document.getElementById(id).removeChild(input);
        document.getElementById(id).removeChild(button)
    }
    ;
    quarter.appendChild(input);
    quarter.appendChild(button);
}

// THE GRID OBJECT
var grid = (function(grid){while(grid.push([null,null,null]) < 4); return grid})([]);

function Verify(){
    //TODO: SET THE grid VAR TO A NEW EMPTY GRID

    var y1q1 = document.getElementById("y1q1");
    AddCourses(y1q1, 1, 1);
    var y1q2 = document.getElementById("y1q1");
    AddCourses(y1q2, 1, 2);
    var y1q3 = document.getElementById("y1q1");
    AddCourses(y1q3, 1, 3);

    var y2q1 = document.getElementById("y2q1");
    AddCourses(y2q1, 2, 1);
    var y2q2 = document.getElementById("y2q1");
    AddCourses(y2q2, 2, 2);
    var y2q3 = document.getElementById("y2q1");
    AddCourses(y2q3, 2, 3);

    var y3q1 = document.getElementById("y3q1");
    AddCourses(y3q1, 3, 1);
    var y3q2 = document.getElementById("y3q1");
    AddCourses(y3q2, 3, 2);
    var y3q3 = document.getElementById("y3q1");
    AddCourses(y3q3, 3, 3);

    var y4q1 = document.getElementById("y4q1");
    AddCourses(y4q1, 4, 1);
    var y4q2 = document.getElementById("y4q1");
    AddCourses(y4q2, 4, 2);
    var y4q3 = document.getElementById("y4q1");
    AddCourses(y4q3, 4, 3);

    $.ajax({
        type: "POST",
        url: "/main",
        headers: {
            "Method": "GRID",
            "ID": email, //TODO
            "GRID": JSON.stringify({
                "grid": grid,
                "library": [],
                "major": userMajor //TODO
            })
        },
        success: function (data) {
            $.ajax({
                type: "GET",
                url: "/main",
                headers: {
                    "Method": "verify",
                    "email": email //TODO
                },
                success: function(data){
                    alert(data["response"]);
                }
            });
        }
    })
    // TODO: CALL VERIFY
}

function AddCourses(quarterName, year, quarter){
    var courses = quarter.childNodes;
    var i;
    for (i = 0; i < courses.length; i++){
        var course = courses[i].value;
        $.ajax({
            type: "GET",
            url: '/main',
            headers: {
                "Method": "course",
                "ID": course
            },
            success: function(data){
                grid[year][quarter].push(data);
            }
        });
        //TODO: ADD COURSES TO GRID OBJECT
    }
}

function LogOut(){
    //TODO: FILL IN URL FOR LOGIN PAGE
    //window.location.assign("http://www.google.com");
    window.location.assign("http://localhost:63342/Grid-Scheduler/src/main/webapp/Login.html");
}
