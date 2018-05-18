import java.util.ArrayList;

/**
 * A Requirement whose check() method returns true if all of the courses
 * in its course list have been taken.
 */
public class ANDList implements Requirement{

    /**
     * The list of course String IDs (NOT Course objects).
     */
    private ArrayList<String> courses = new ArrayList<>();

    /**
     * Default Constructor.
     */
    public ANDList(){
    }

    /**
     * Constructor for ANDList.
     * @param courses The list of String IDs of Courses
     */
    public ANDList(ArrayList<String> courses){
        this.courses = courses;
    }

    /**
     * Adds a Course ID to the list.
     * @param course Course ID to be added to the list.
     */
    public void AddCourse(String course){
        courses.add(course);
    }

    /**
     * Adds a Course ID to the list
     * @param course The Course whose ID is to be added to the list.
     */
    public void AddCourse(Course course){
        courses.add(course.getID());
    }

    /**
     * Removes a Course ID from the list.
     * @param course The Course ID to remove from the list.
     */
    public void RemoveCourse(String course){
        courses.remove(course);
    }

    /**
     * Removes a Course ID from the list.
     * @param course The Course whose ID is to be removed from the list.
     */
    public void RemoveCourse(Course course){
        courses.add(course.getID());
    }

    /**
     * Returns the ArrayList of Course IDs.
     * @return The ArrayList of Course IDs.
     */
    public ArrayList<String> getCourses(){
        return courses;
    }

    /**
     * Returns true if each course in this object's courses list is contained in the input list courseList.
     * @param courseList The list of courses to check against this Requirement's list.
     * @return True if each course in this object's list is contained in the input list; false otherwise.
     */
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
