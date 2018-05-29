package servlet;
import java.util.ArrayList;

/**
 * A Requirement whose check() method returns true if at least one of the courses
 * in its course list have been taken.
 */
public class ORList implements Requirement{

    /**
     * The list of course String IDs (NOT Course objects)
     */
    private ArrayList<String> courses = new ArrayList<String>();

    /**
     * Default Constructor
     */
    public ORList(){ }

    /**
     * Constructor for ORList.
     * @param courses The list of String IDs of Courses
     */
    public ORList(ArrayList<String> courses){
        this.courses = courses;
    }

    /**
     * Adds a Course ID to the list.
     * @param course Course ID to be added to the list.
     */
    public void AddCourse(Course course){
        courses.add(course.getID());
    }

    /**
     * Adds a Course ID to the list
     * @param course The Course whose ID is to be added to the list.
     */
    public void AddCourse(String course){
        courses.add(course);
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
    public void RemoveCourse(Course course) { courses.remove(course.getID()); }


    /**
     * Returns the ArrayList of Course IDs.
     * @return The ArrayList of Course IDs.
     */
    public ArrayList<String> getCourses(){
        return courses;
    }

    /**
     * Returns true if at least one of the courses in this object's list is contained in the input list courseList.
     * @param courseList The list to check against this object's courses list.
     * @return True if at least one of the courses in this object's list is contained in the input list courseList; false otherwise.
     */
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
