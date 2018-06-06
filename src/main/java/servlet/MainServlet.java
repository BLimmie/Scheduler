package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebServlet(
        name = "MainServlet",
        urlPatterns = {"/main"}
)

public class MainServlet extends HttpServlet {

    private ArrayList<Course> courses;
    private ArrayList<User> users;
    private ArrayList<Major> majors;
    @Override
    public void init() throws ServletException{
        //TODO Make servlet fields to store data for quick retrieval from database
        courses = new ArrayList<Course>();
        users = new ArrayList<User>();
        majors = new ArrayList<Major>();
        majors.add(new Major("Computer Science", "College of Engineering"));
        //users.add(new User("john.doe@gmail.com", "John", "Doe", 1010101, "password", majors.get(0),true));
        courses.add(new Course("CMPSC8", "INTRO TO COMP", "Computer Science 8", "CMPSC", "bad class", 4, new ANDList(),true,true, true));
        courses.add(new Course("CMPSC16", "PROBLEM SOLVING I", "Problem Solving with Computers I", "CMPSC", "bad class", 4, new ANDList(),true,true, true));
        courses.add(new Course("CMPSC24", "PROBLEM SOLVING II", "Problem Solving with Computers II", "CMPSC", "bad class", 4, new ANDList(),true,true, true));
        courses.add(new Course("CMPSC32", "INTRO TO OOB", "Intro to Object Oriented Programming", "CMPSC", "bad class", 4, new ANDList(),true,true, true));
        courses.add(new Course("CMPSC48", "COMP SCI PROJECT", "Computer Science Project", "CMPSC", "bad class", 4, new ANDList(),true,true, true));
        courses.add(new Course("CMPSC40", "INTRO TO LOGIC", "Introduction to Computer Science Logic", "CMPSC", "bad class", 4, new ANDList(),true,true, true));
        courses.add(new Course("CMPSC56", "COMP SCI APP", "Computer Science Applications", "CMPSC", "bad class", 4, new ANDList(),true,true, true));
        courses.add(new Course("CMPSC64", "COMP SCI ARCH", "Computer Science Architecture", "CMPSC", "bad class", 4, new ANDList(),true,true, true));
        User john = new User("john.doe@gmail.com", "John", "Doe", 1010101, "password", majors.get(0),true);
        john.AddCourseToGrid(courses.get(1), 1,1);
        john.AddCourseToGrid(courses.get(2), 1,2);
        john.AddCourseToGrid(courses.get(3), 1,3);
        john.AddCourseToGrid(courses.get(5), 2,1);
        john.AddCourseToGrid(courses.get(6), 2,1);
        john.AddCourseToGrid(courses.get(7), 2,2);
        john.AddCourseToGrid(courses.get(4), 2,3);
        john.UpdateGridLibrary(courses);
        users.add(john);

        super.init();
    }

    /**
     * GET http://grid-scheduler.herokuapp.com/main
     *
     * Headers:
     * {
     *     Method:
     *     {
     *         course: gets course by CourseID
     *         courses: gets JSON ArrayList of courses that match query
     *         user: gets user by perm#
     *         major: gets major by majorTitle
     *         grid: gets GRID by user perm#
     *     }
     *     email: User email. User with Method = {user, grid}
     *     ID: CourseID. Use with Method = course
     *     Title: majorTitle. Use with Method = major
     *     Quarter:
     *     {
     *         fall: Query by Course.fall == true
     *         winter: Query by Course.winter == true
     *         spring: Query by Course.spring == true
     *     } Use with Method = courses
     *     Dept: DeptID. Query by DeptID. Use with Method = courses, can be uses with header:Quarter
     * }
     * @param req HTTP GET request
     * @param resp HTTP Response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            resp.setContentType("application/json");
            String method = req.getHeader("Method");
            if (method.equals("test")){
                resp.getWriter().write(new Gson().toJson(new Response("Testing message")));
            }
            else if (method.equals("course")) {
                String courseID = req.getHeader("ID");
//                fbdbw writer = new fbdbw("cs48courseplanner-firebase-adminsdk-m9s7y-f4080e1e58.json", "https://cs48courseplanner.firebaseio.com/");
//                writer = writer.child("Course").child(courseID);
//                fbdbrCourse reader = new fbdbrCourse(writer);
//                Course output = reader.get();
                Course output = null;
                for (Course c : this.courses) {
                    if (c.getID().equals(courseID)) {
                        output = c;
                        break;
                    }
                }
                String json = new Gson().toJson(output);
                resp.getWriter().write(json);
            } else if (method.equals("courses")) {
                String quarter = req.getHeader("Quarter");
                ArrayList<Course> query= new ArrayList<Course>(courses);
                if(quarter.equals("fall")){
                    for(Course c:query){
                        if(!c.isFall()){
                            query.remove(c);
                        }
                    }
                }
                else if(quarter.equals("winter")){
                    for(Course c:query){
                        if(!c.isWinter()){
                            query.remove(c);
                        }
                    }
                }
                else if(quarter.equals("spring")){
                    for(Course c:query){
                        if(!c.isSpring()){
                            query.remove(c);
                        }
                    }
                }
                String deptID = req.getHeader("Dept");
                if(deptID != null){
                    for(Course c: query){
                        if(!c.getDepartment().equals(deptID)){
                            query.remove(c);
                        }
                    }
                }
                String json = new Gson().toJson(query);
                resp.getWriter().write(json);
            } else if (method.equals("user")) {
                String userID = req.getHeader("email");
                String password = req.getHeader("password");
                boolean admin = Boolean.parseBoolean(req.getHeader("admin"));
                User output = null;
                for (User u : this.users) {
                    if (u.getEmail().equals(userID)) {
                        output = u;
                        break;
                    }
                }
                if (output == null){
                    output = new User(userID,password,false);
                    users.add(output);
                }
                String json = "";
                if(output.getPassword().equals(password)){
                    if(admin && output.admin) {
                        json = new Gson().toJson(output);
                    }
                    else if(admin){
                        json = new Gson().toJson(new Response("Not an admin"));
                    }
                    else{
                        json = new Gson().toJson(output);
                    }
                } else {
                    json = new Gson().toJson(new Response("Invalid Login"));
                }
                resp.getWriter().write(json);
            } else if (method.equals("major")) {
                String majorTitle = req.getHeader("Title");
                Major output = null;
                for(Major m : this.majors){
                    if(m.getTitle().equals(majorTitle)){
                        output = m;
                        break;
                    }
                }
                String json = new Gson().toJson(output);
                resp.getWriter().write(json);
            } else if (method.equals("grid")) {
                String userID = req.getHeader("email");
                User output = null;
                for (User u : this.users) {
                    if (u.getEmail() == (userID)) {
                        output = u;
                        break;
                    }
                }
                String json = new Gson().toJson(output.getGrid());
                resp.getWriter().write(json);
            } else if (method.equals("verify")){
                String userID = req.getHeader("email");
                User checking = null;
                for (User u : this.users) {
                    if (u.getEmail() == (userID)) {
                        checking = u;
                        break;
                    }
                }
                String json = new Gson().toJson(checking.getGrid().Verify());
                resp.getWriter().write(json);
            }
            else{
                resp.getWriter().write(new Gson().toJson(new Response("Invalid Method")));
            }
            resp.getWriter().flush();
        } catch(Exception e){
            //TODO print error in request
        }
    }

    /**
     * POST http:/grid-scheduler.herokuapp.com/main
     *
     * Headers:
     * {
     *     Method:
     *     {
     *         Course: Adds, deletes, or edits a course
     *         Major: Adds, deletes, or edits a major
     *         GRID: Adds or deletes a course from a user GRID
     *     }
     *     Action:
     *     {
     *         add: Add item
     *         delete: Delete item
     *         edit: Edit item. Use with Method = {Course, Major}
     *     }
     *     ID: User ID. Use with Method = GRID
     *     CourseID: CourseID
     *     courseData: {
     *         CourseID: CourseID
     *         Title: Title of Course or Major. Use with Method = {Course, Major}
     *         Full Title: Full title of Course. Use with Method = Course
     *         Department: DepartmentID of Course. Use with Method = {Course, Major}
     *         Description: Description of Course. Use with Method = Course
     *         Units: Number of units. Use with Method = Course
     *         Fall:
     *         {
     *             true: Course held in Fall
     *             false: Course not held in Fall
     *         }
     *         Winter:
     *         {
     *             true: Course held in Winter
     *             false: Course not held in Winter
     *         }
     *         Spring:
     *         {
     *             true: Course held in Spring
     *             false: Course not held in Spring
     *         }
     *     }
     *     Prerequisites: List of prerequisites. Use with Method = Major. **Unstable**
     *     Year: {
     *         0: Freshman year
     *         1: Sophomore year
     *         2: Junior year
     *         3: Senior year
     *     } Use with Method = GRID
     *     Quarter {
     *         0: Fall
     *         1: Winter
     *         2: Spring
     *     } Use with Method = GRID
     * }
     *
     * @param req HTTP POST Request
     * @param resp HTTP response object
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        try{
            resp.setContentType("application/json");
            String method = req.getHeader("Method");
            //TODO Check if user is admin
            if(method.equals("Course")){
                if(req.getHeader("Action").equals("delete")){
                    String id = req.getHeader("CourseID");
                    for (Course c : courses) {
                        if (c.getID().equals(id)) {
                            //TODO Remove from database
                            courses.remove(c);
                            break;
                        }
                    }
                } else if(req.getHeader("Action").equals("add")){
                    courses.add((Course)new Gson().fromJson(req.getHeader("courseData"), new TypeToken<Course>(){}.getType()));
                    //TODO Add to database
                } else if(req.getHeader("Action").equals("edit")){
                    String id = req.getHeader("CourseID");
                    Course edit = null;
                    for (Course c : courses) {
                        if (c.getID().equals(id)) {
                            //TODO Remove from database
                            courses.remove(c);
                            break;
                        }
                    }
                    courses.add((Course)new Gson().fromJson(req.getHeader("courseData"), new TypeToken<Course>(){}.getType()));
                    //TODO Add back to database
                }
            } else if(method.equals("Major")){
                if(req.getHeader("Action").equals("delete")){
                    String id = req.getHeader("Title");
                    for (Major m : majors) {
                        if (m.getTitle().equals(id)) {
                            //TODO Remove from database
                            majors.remove(m);
                            break;
                        }
                    }
                } else if(req.getHeader("Action").equals("add")){
                    majors.add(new Major(
                            req.getHeader("Title"),
                            req.getHeader("Department")
                    ));
                    //TODO Add to database
                    Major temp = majors.get(majors.size()-1);
                    ArrayList<Requirement> reqs = new Gson().fromJson(req.getHeader("Requirements"),new TypeToken<ArrayList<Requirement>>(){}.getType());
                    for(Requirement r: reqs){
                        temp.AddRequirement(r);
                    }

                } else if(req.getHeader("Action").equals("edit")){
                    String id = req.getHeader("Title");
                    for (Major m : majors) {
                        if (m.getTitle().equals(id)) {
                            //TODO Remove from database
                            majors.remove(m);
                            break;
                        }
                    }
                    majors.add(new Major(
                            req.getHeader("Title"),
                            req.getHeader("Department")
                    ));
                    //TODO Add back to database
                    Major temp = majors.get(majors.size()-1);
                    ArrayList<Requirement> reqs = new Gson().fromJson(req.getHeader("Requirements"),new TypeToken<ArrayList<Requirement>>(){}.getType());
                    for(Requirement r: reqs){
                        temp.AddRequirement(r);
                    }
                    //TODO fix the total requirements
                }
            } else if(method.equals("GRID")){
                String userID = req.getHeader("ID");
                User found = null;
                for (User u : users) {
                    if (u.getEmail().equals(userID)) {
                        found = u;
                        break;
                    }
                }
                found.setGrid((Grid) new Gson().fromJson(req.getHeader("GRID"), new TypeToken<Grid>(){}.getType()));
                found.getGrid().UpdateLibrary(courses);
                //TODO Update user's grid in database
            } else if(method.equals("User")){
                if(req.getHeader("Action").equals("add")){
                    User input = new Gson().fromJson(req.getHeader("userInfo"), new TypeToken<User>(){}.getType());
                    users.add(input);
                    //TODO Add user to database
                }
                else if(req.getHeader("Action").equals("edit")){
                    User input = new Gson().fromJson(req.getHeader("userInfo"), new TypeToken<User>(){}.getType());
                    for(User u: users){
                        if(u.getPerm() == input.getPerm()){
                            //TODO Remove user from database
                            users.remove(u);
                            break;
                        }
                    }
                    //TODO Add back to database
                    users.add(input);
                }
            }
            resp.getWriter().write(new Gson().toJson(new Response("Success")));
            resp.getWriter().flush();
        }catch(Exception e){
            //TODO print error in request
        }
    }

}