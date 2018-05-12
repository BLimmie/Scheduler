import java.util.ArrayList;

/**
 * A requirement whose Check() method returns true if one of the
 * classes in the courses list has been fulfilled.
 */
public class ORList implements Requirement{

    // A list of the IDs of courses, NOT course objects
    private ArrayList<String> courses = new ArrayList<>();

    public ORList(){
    }

    public ORList(ArrayList<String> courses){
        this.courses = courses;
    }

    public void AddCourse(Course course){
        courses.add(course.getID());
    }

    public void AddCourse(String course){
        courses.add(course);
    }

    public void RemoveCourse(String course){
        courses.remove(course);
    }

    public boolean Check(ArrayList<Course> courseList){
        for (String id : courses){
            for (Course c : courseList){
                if (c.getID().equals(id)){
                    return true;
                }
            }
        }
        System.out.println("\tYOU NEED TO TAKE ONE OF THESE COURSES:");
        for (String s : courses){
            System.out.print("\t" + s);
        }
        System.out.println();
        System.out.println();
        return false;
    }
}
