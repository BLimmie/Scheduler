//TODO: Have the student's grid autoload values to the grid displayed on the webpage
//TODO: HAVE "Edit Profile" LINK TO THE PROPER WEBPAGE

var courseList = null;
var userGrid = null;
var userMajor = null;
var firstName = null;
var lastName = null;
var email = null;
var password = null;
var depts;

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

    // Get the email and password of the current user
    email = getUrlParameter("email");
    password = getUrlParameter("password");
    console.log(email);
    console.log(password);

    // Get the user details of the current account
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
        }
    });

    // Get the user's grid to autofill into the grid
    $.ajax({
        type: "GET",
        url: '/main',
        headers: {
            "email": email,
            "Method": "grid"
        },
        success: function(data){
            userGrid = data["grid"];
            for (let y = 1; y < 5; y++){
                for (let q = 1; q < 4; q++){
                    let l = userGrid[y-1][q-1]["courses"];
                    for (c = 0; c < l.length; c++){
                        fillFields(("y" + y + "q" + q), l[c]["ID"]);
                    }
                }
            }
        }
    });

    $.ajax({
        type: "GET",
        url: '/main',
        headers: {
            "Method": "dept"
        },
        success: function(data){
            depts = data;
        }
    });

    let list = document.getElementById("CoursesList");
    for (let i = 0; i < depts.length; i++){
        let butt = document.createElement("button");
        butt.className = "accordion";
        butt.innerHTML = depts[i];
        list.appendChild(butt);
        let subCourses;
        $.ajax({
            type: "GET",
            url: '/main',
            headers: {
                "Method": "courses",
                "Dept": depts[i]
            },
            success: function(data){
                subCourses = data;
            }
        });
        let p = document.createElement("div");
        p.className = "panel";
        for (let j = 0; j < subCourses.length; j++){
            let tempID = subCourses[j]["ID"];
            let c = document.createElement("button");
            c.className = "w3-button w3-block w3-left-align";
            c.onclick = function() {ViewCourse(tempID)};
            c.innerHTML = tempID;
            p.appendChild(c);
        }
        list.appendChild(p);
    }

}

function ViewCourse(courseid){
    let id;
    let title;
    let fulltitle;
    let dept;
    let desc;
    let preq;

    $.ajax({
        type: "GET",
        url: '/main',
        headers: {
            "Method": "course",
            "ID": courseid
        },
        success: function(data){
            id = data["ID"];
            title = data["title"];
            fulltitle = data["fullTitle"];
            dept = data["department"];
            desc = data["description"];
            preq = data["prerequisites"];
        }
    });

    let modal = document.getElementById('courseViewer');
    document.getElementById("courseheader").innerHTML = id + " - " + title;
    document.getElementById("courseid").innerHTML = id;
    document.getElementById("coursetitle").innerHTML = title;
    document.getElementById("coursetitlefull").innerHTML = fullTitle;
    document.getElementById("department").innerHTML = dept;
    document.getElementById("description").innerHTML = desc;
    pr = document.getElementById("prerequisites");
    for (let n = 0; n < preq.length; n++){
        let pre = document.createElement("P");
        pre.className = "inf";
        pre.innerHTML = preq[n];
        pr.appendChild(pre);
    }
    modal.style.display = "block";
}

function fillFields(id, value) {
    let quarter = document.getElementById(id);
    let input = document.createElement("input");
    input.type = "text";
    input.className= "w3-input w3-border";
    input.style.width = "90%";
    input.style.cssFloat = "left";
    input.value = value;
    let button = document.createElement("button");
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
    let quarter = document.getElementById(id);
    let input = document.createElement("input");
    input.type = "text";
    input.name = "course";
    input.className= "w3-input w3-border";
    input.style.width = "90%";
    input.style.cssFloat = "left";
    input.placeholder = "e.g. CMPSC56";
    let button = document.createElement("button");
    button.className= "w3-input w3-border";
    button.name = "X";
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
//var grid = (function(grid){while(grid.push([null,null,null]) < 4); return grid})([]);

function Verify(){

    //TODO: SET THE grid VAR TO A NEW EMPTY GRID
    $.ajax({
        type: "POST",
        url: "/main",
        headers: {
            "Method": "ClearGrid",
            "ID": email,
        },
        success: function (data) {}
    });

    let y1q1 = document.getElementById("y1q1");
    AddCourses(y1q1, 1, 1);
    let y1q2 = document.getElementById("y1q2");
    AddCourses(y1q2, 1, 2);
    let y1q3 = document.getElementById("y1q3");
    AddCourses(y1q3, 1, 3);

    let y2q1 = document.getElementById("y2q1");
    AddCourses(y2q1, 2, 1);
    let y2q2 = document.getElementById("y2q2");
    AddCourses(y2q2, 2, 2);
    let y2q3 = document.getElementById("y2q3");
    AddCourses(y2q3, 2, 3);

    let y3q1 = document.getElementById("y3q1");
    AddCourses(y3q1, 3, 1);
    let y3q2 = document.getElementById("y3q2");
    AddCourses(y3q2, 3, 2);
    let y3q3 = document.getElementById("y3q3");
    AddCourses(y3q3, 3, 3);

    let y4q1 = document.getElementById("y4q1");
    AddCourses(y4q1, 4, 1);
    let y4q2 = document.getElementById("y4q2");
    AddCourses(y4q2, 4, 2);
    let y4q3 = document.getElementById("y4q3");
    AddCourses(y4q3, 4, 3);

    $.ajax({
        type: "GET",
        url: "/main",
        headers: {
            "Method": "verify",
            "email": email
        },
        success: function(data){
            alert(data["response"]);
        }
    });
}

// Sadness

function AddCourses(quarterName, year, quarter){
    let courses = quarterName.children;
    for (let i = 0; i < courses.length; i++){
        //alert("tagName: " + courses[i].tagName);
        let cname = courses[i].value;
        //if (courses[i].tagName == "INPUT"){
        if (!(cname == ("X") || courses[i].tagName == "BUTTON")){
            $.ajax({
                type: "POST",
                url: "/main",
                headers: {
                    "Method": "AddToGrid",
                    "ID": email,
                    "Year": year,
                    "Quarter": quarter,
                    "CourseID": cname
                },
                success: function (data) {}
            })
        }
    }
}

function LogOut(){
    //TODO: FILL IN URL FOR LOGIN PAGE
    //window.location.assign("http://www.google.com");
    window.location.assign("http://localhost:63342/Grid-Scheduler/src/main/webapp/Login.html");
}
