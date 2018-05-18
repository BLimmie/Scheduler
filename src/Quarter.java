import java.util.ArrayList;

/**
 * A small wrapper class for ArrayLists of Courses; used by the 2D array in Grid.
 */
public class Quarter {

    /**
     * The list of courses taken during this quarter.
     */
    private ArrayList<Course> courses = new ArrayList<>();

    /**
     * Default Constructor.
     */
    public Quarter() {}

    /**
     * Adds a Course to the Quarter.
     * @param c The Course to add to the Quarter.
     */
    public void add(Course c){
        courses.add(c);
    }

    /**
     * Removes a Course from the Quarter.
     * @param c The course to remove from the Quarter.
     */
    public void remove(Course c){
        courses.remove(c);
    }

    /**
     * Returns the list of Courses taken during this Quarter.
     * @return The ArrayList of courses taken during this Quarter.
     */
    public ArrayList<Course> getCourses(){
        return courses;
    }

    /**
     * Prints the ID of each Course taken during this quarter on a new line.
     */
    public void Print(){
        System.out.print("\t");
        for (Course c : courses){
            System.out.print("\t" + c.getID());
        }
        System.out.println();
    }
}
