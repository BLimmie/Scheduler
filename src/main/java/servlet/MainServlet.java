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

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            resp.setContentType("application/json");
            ServletOutputStream out = resp.getOutputStream();
            String method = req.getHeader("Method");
            if (method.equals("course")) {
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
                //TODO Implement search
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
        } catch(Exception e){
            //TODO print error in request
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{

    }

}