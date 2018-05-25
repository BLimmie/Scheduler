package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "MainServlet",
        urlPatterns = {"/main"}
)
public class MainServlet extends HttpServlet {


    @Override
    public void init() throws ServletException{

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        String method = req.getHeader("Method");
        if (method.equals("course")){
            String courseID = req.getHeader("ID");
            fbdbw writer = new fbdbw("cs48courseplanner-firebase-adminsdk-m9s7y-f4080e1e58.json", "https://cs48courseplanner.firebaseio.com/");
            writer = writer.child("Course").child(courseID);
            fbdbrCourse reader = new fbdbrCourse(writer);
            Course output = reader.get();
        }
        else if (method.equals("courses")){

        }
        else if (method.equals("user")){

        }
        else if (method.equals("major")){

        }
        else if (method.equals("grid")){

        }
        out.write("".getBytes());
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{

    }

}