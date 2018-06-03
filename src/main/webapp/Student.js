//TODO: Have the student's grid autoload values to the grid displayed on the webpage
//TODO: HAVE "Edit Profile" LINK TO THE PROPER WEBPAGE

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
    button.style.height = "100%";
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
var grid;

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

    // TODO: CALL VERIFY ON THE GRID OBJECT
    // TODO: SOMEHOW DISPLAY RESULTS
}

function AddCourses(quarterName, year, quarter){
    var courses = quarter.childNodes;
    var i;
    for (i = 0; i < courses.length; i++){
        //TODO: ADD COURSES TO GRID OBJECT
    }
}

function Save(){
    //TODO: SET THE CURRENT GRID TO THE STUDENT'S GRID
}

function LogOut(){
    //TODO: FILL IN URL FOR LOGIN PAGE
    //window.location.assign("http://www.google.com");
    window.location.assign("http://localhost:63342/Grid-Scheduler/src/main/webapp/Login.html");
}