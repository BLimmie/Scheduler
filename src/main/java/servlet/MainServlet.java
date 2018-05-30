package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.org.apache.xpath.internal.operations.Bool;

@WebServlet(
        name = "MainServlet",
        urlPatterns = {"/main"}
)
public class MainServlet extends HttpServlet {

    ArrayList<Course> courses;
    ArrayList<User> users;
    ArrayList<Major> majors;
    @Override
    public void init() throws ServletException{
        //TODO Make servlet fields to store data for quick retrieval
        courses = new ArrayList<Course>();
        users = new ArrayList<User>();
        majors = new ArrayList<Major>();
        majors.add(new Major("Computer Science", "College of Engineering"));
        users.add(new User("john.doe@gmail.com", "John", "Doe", 1010101, "password", majors.get(0)));
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            resp.setContentType("application/json");
            String method = req.getHeader("Method");
            if (method.equals("default")){
                resp.getWriter().write("Testing");
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
                int userID = Integer.parseInt(req.getHeader("ID"));
                User output = null;
                for (User u : this.users) {
                    if (u.getPerm() == (userID)) {
                        output = u;
                        break;
                    }
                }
                String json = new Gson().toJson(output);
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
                int userID = Integer.parseInt(req.getHeader("ID"));
                User output = null;
                for (User u : this.users) {
                    if (u.getPerm() == (userID)) {
                        output = u;
                        break;
                    }
                }
                String json = new Gson().toJson(output.getGrid());
                resp.getWriter().write(json);
            }
            else{
                resp.getWriter().write("Idk what's happening");
            }
            resp.getWriter().flush();
        } catch(Exception e){
            //TODO print error in request
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        try{
            resp.setContentType("application/json");
            String method = req.getHeader("Method");
            if(method.equals("Course")){
                if(req.getHeader("Action").equals("delete")){
                    String id = req.getHeader("ID");
                    for (Course c : courses) {
                        if (c.getID().equals(id)) {
                            //TODO Remove from database
                            courses.remove(c);
                            break;
                        }
                    }
                } else if(req.getHeader("Action").equals("add")){
                    courses.add(new Course(
                            req.getHeader("ID"),
                            req.getHeader("Title"),
                            req.getHeader("Full Title"),
                            req.getHeader("Department"),
                            req.getHeader("Description"),
                            Integer.parseInt(req.getHeader("Units")),
                            new ANDList(), //TODO
                            Boolean.parseBoolean(req.getHeader("Fall")),
                            Boolean.parseBoolean(req.getHeader("Winter")),
                            Boolean.parseBoolean(req.getHeader("Spring"))
                    ));
                    //TODO Add to database
                } else if(req.getHeader("Action").equals("edit")){
                    //TODO this is much more complex
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
                    ArrayList<String> reqs = new Gson().fromJson(req.getHeader("Prerequisites"),new TypeToken<ArrayList<String>>(){}.getType());
                    for(String s: reqs){
                        temp.AddRequirement(new ANDList(reqs));
                        //TODO fix the total requirements
                    }
                } else if(req.getHeader("Action").equals("edit")){
                    //TODO this is much more complex
                }
            } else if(method.equals("GRID")){
                if(req.getHeader("Action").equals("add")) {
                    int perm = Integer.parseInt(req.getHeader("ID"));
                    User found = null;
                    for (User u : users) {
                        if (u.getPerm() == perm) {
                            found = u;
                            break;
                        }
                    }
                    String courseID = req.getHeader("CourseID");
                    Course adding = null;
                    for (Course c : courses) {
                        if (c.getID().equals(courseID)) {
                            adding = c;
                            break;
                        }
                    }
                    found.getGrid().AddCourse(
                            adding,
                            Integer.parseInt(req.getHeader("Year")),
                            Integer.parseInt(req.getHeader("Quarter"))
                    );
                }
                else if(req.getHeader("Action").equals("delete")){
                    int perm = Integer.parseInt(req.getHeader("ID"));
                    User found = null;
                    for (User u : users) {
                        if (u.getPerm() == perm) {
                            found = u;
                            break;
                        }
                    }
                    String courseID = req.getHeader("CourseID");
                    Course deleting = null;
                    for (Course c : found.getGrid().getQuarter(
                            Integer.parseInt(req.getHeader("Year")),
                            Integer.parseInt(req.getHeader("Quarter"))
                    ).getCourses()) {
                        if (c.getID().equals(courseID)) {
                            deleting = c;
                            break;
                        }
                    }
                    found.getGrid().DeleteCourse(
                            deleting,
                            Integer.parseInt(req.getHeader("Year")),
                            Integer.parseInt(req.getHeader("Quarter"))
                    );
                }
            }
        }catch(Exception e){
            //TODO print error in request
        }
    }

}