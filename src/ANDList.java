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

    public void AddCourse(Course course){
        courses.add(course.getID());
    }

    public void RemoveCourse(String course){
        courses.remove(course);
    }

    public void RemoveCourse(Course course){
        courses.add(course.getID());
    }

    public ArrayList<String> getCourses(){
        return courses;
    }

    public boolean Check(ArrayList<Course> courseList){
        ArrayList<String> ids = new ArrayList<>();
        ids.addAll(courses);
        boolean found = false;
        for (String id : courses){
            boolean courseFound = false;
            for (Course c : courseList){
                if (c.getID().equals(id)){
                    courseFound = true;
                    ids.remove(id);
                }
            }
            found = courseFound;
        }
        if (!found){
            System.out.println("\tMISSING COURSES:");
            for (String s : ids){
                System.out.println("\t" + s);
            }
            System.out.println();
            System.out.println();
        }
        return found;
    }
}
