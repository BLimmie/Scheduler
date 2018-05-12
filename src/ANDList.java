import java.util.ArrayList;

/**
 * A list whose check() method returns true if all of the courses
 * in its course list have been taken
 */
public class ANDList implements Requirement{

    // A list of the IDs of courses, NOT course objects
    private ArrayList<String> courses = new ArrayList<>();

    public ANDList(){
    }

    public ANDList(ArrayList<String> courses){
        this.courses = courses;
    }

    public void AddCourse(String course){
        courses.add(course);
    }

    public void RemoveCourse(String course){
        courses.remove(course);
    }

    public boolean Check(ArrayList<Course> courseList){
        boolean found = false;
        for (Course c : courseList){
            found = false;
            for (String id : courses){
                if (c.ContainsID(id)){
                    found = true;
                }
            }
            if (!found){
                return found;
            }
        }
        return found;
    }
}
