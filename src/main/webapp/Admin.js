function LogOut(){
    //TODO: FILL IN URL FOR LOGIN PAGE
    //window.location.assign("http://www.google.com");
    window.location.assign("http://localhost:63342/Grid-Scheduler/src/main/webapp/Login.html");
}

function CreateMajor(){
    //TODO: USE ID'S FROM MAJOR CREATOR MODAL TO CREATE A MAJOR OBJECT AND ADD IT TO THE DATABASE
}

function CreateCourse(){
    //TODO: USE ID'S FROM COURSE CREATOR MODAL TO CREATE A COURSE OBJECT AND ADD IT TO THE DATABASE
}

function addPrereqField() {
    var container = document.getElementById("prereqsList");
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
        document.getElementById("prereqsList").removeChild(input);
        document.getElementById("prereqsList").removeChild(button);
    }
    ;
    container.appendChild(input);
    container.appendChild(button);
}

function addReqField() {
    var e = document.getElementById("reqSelect");
    var choice = e.options[e.selectedIndex].value;
    if (choice == "1"){
        var c = document.getElementById("Requirements");
        var courses = document.createElement("div");
        var butt = document.createElement("button");
        var label = document.createElement("p");
        label.style.color = "black";
        courses.className = "ANDList";
        butt.textContent = "Add Course";
        var text = document.createTextNode("You must take all of the courses in this list:");
        label.appendChild(text);
        var b = document.createElement("button");
        b.textContent = "Remove Requirement";
        b.style.color = "red";
        b.onclick = function()
        {
            c.removeChild(label);
            c.removeChild(courses);
            c.removeChild(butt);
            c.removeChild(b);
        }
        ;
        c.appendChild(label);
        c.appendChild(courses);
        c.appendChild(butt);
        c.appendChild(b);
        c.appendChild(document.createElement("p"));
        butt.onclick = function()
        {
            var input = document.createElement("input");
            input.type = "text";
            //input.className= "w3-input w3-border";
            input.style.width = "90%";
            input.style.cssFloat = "left";
            input.placeholder = "e.g. CMPSC56";
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
                courses.removeChild(input);
                courses.removeChild(button)
            }
            ;
            courses.appendChild(input);
            courses.appendChild(button);
        }
        ;
    }
    if (choice == "2"){
        var c2 = document.getElementById("Requirements");
        var courses2 = document.createElement("div");
        var label2 = document.createElement("p");
        label2.style.color = "black";
        courses2.className = "ORList";
        var butt2 = document.createElement("button");
        butt2.textContent = "Add Course";
        var text2 = document.createTextNode("You must take at least one course from this list:");
        label2.appendChild(text2);
        var b2 = document.createElement("button");
        b2.textContent = "Remove Requirement";
        b2.style.color = "red";
        b2.onclick = function()
        {
            c2.removeChild(label2);
            c2.removeChild(courses2);
            c2.removeChild(butt2);
            c2.removeChild(b2);
        }
        ;
        c2.appendChild(label2);
        c2.appendChild(courses2);
        c2.appendChild(butt2);
        c2.appendChild(b2);
        c2.appendChild(document.createElement("p"));
        butt2.onclick = function()
        {
            var input = document.createElement("input");
            input.type = "text";
            input.placeholder = "e.g. CMPSC56";
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
                courses2.removeChild(input);
                courses2.removeChild(button)
            }
            ;
            courses2.appendChild(input);
            courses2.appendChild(button);
        }
        ;
    }
    if (choice == "3"){
        var c3 = document.getElementById("Requirements");
        var courses3 = document.createElement("div");
        var label3 = document.createElement("p");
        label3.style.color = "black";
        var count3 = document.createElement("input");
        count3.type = "number";
        count3.value = "0";
        courses3.className = "MinCourses";
        var butt3 = document.createElement("button");
        butt3.textContent = "Add Course";
        var text3 = document.createTextNode("You must take this many courses from this list:");
        label3.appendChild(text3);
        var b3 = document.createElement("button");
        b3.textContent = "Remove Requirement";
        b3.style.color = "red";
        b3.onclick = function()
        {
            c3.removeChild(label3);
            c3.removeChild(courses3);
            c3.removeChild(butt3);
            c3.removeChild(b3);
            c3.removeChild(count3);
        }
        ;
        c3.appendChild(label3);
        c3.appendChild(count3);
        c3.appendChild(courses3);
        c3.appendChild(butt3);
        c3.appendChild(b3);
        c3.appendChild(document.createElement("p"));
        butt3.onclick = function()
        {
            var input = document.createElement("input");
            input.type = "text";
            input.placeholder = "e.g. CMPSC56";
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
                courses3.removeChild(input);
                courses3.removeChild(button)
            }
            ;
            courses3.appendChild(input);
            courses3.appendChild(button);
        }
        ;
    }
    if (choice == "4"){
        var c4 = document.getElementById("Requirements");
        var courses4 = document.createElement("div");
        var label4 = document.createElement("p");
        label4.style.color = "black";
        var count4 = document.createElement("input");
        count4.type = "number";
        count4.value = "0";
        courses4.className = "MinUnits";
        var butt4 = document.createElement("button");
        butt4.textContent = "Add Course";
        var text4 = document.createTextNode("You must take this many units from this list of courses:");
        label4.appendChild(text4);
        var b4 = document.createElement("button");
        b4.textContent = "Remove Requirement";
        b4.style.color = "red";
        b4.onclick = function()
        {
            c4.removeChild(label4);
            c4.removeChild(courses4);
            c4.removeChild(butt4);
            c4.removeChild(b4);
            c4.removeChild(count4);
        }
        ;
        c4.appendChild(label4);
        c4.appendChild(count4);
        c4.appendChild(courses4);
        c4.appendChild(butt4);
        c4.appendChild(b4);
        c4.appendChild(document.createElement("p"));
        butt4.onclick = function()
        {
            var input = document.createElement("input");
            input.type = "text";
            input.placeholder = "e.g. CMPSC56";
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
                courses4.removeChild(input);
                courses4.removeChild(button)
            }
            ;
            courses4.appendChild(input);
            courses4.appendChild(button);
        }
        ;
    }
}