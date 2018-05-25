package servlet;
import java.util.ArrayList;

/**
 * A Requirement whose Check() method returns true if the user has taken the minimum
 * number of courses from its list.
 */
public class CoursesCount implements Requirement{

    /**
     * The list of course String IDs (NOT Course objects)
     */
    private ArrayList<String> courses = new ArrayList<String>();

    /**
     * The minimum number of courses needed
     */
    private int minCount;

    /**
     * Default constructor.
     */
    public CoursesCount(){
    }

    /**
     * Constructor for CoursesCount.
     * @param minCount The minimum number of Courses from the list that need to be taken.
     */
    public CoursesCount(int minCount){
        this.minCount = minCount;
    }

    /**
     * Constructor for CoursesCount.
     * @param courses The list of Course IDs
     * @param minCount The minimum number of courses to be taken.
     */
    public CoursesCount(ArrayList<String> courses, int minCount){
        this.courses = courses;
        this.minCount = minCount;
    }

    /**
     * Sets the minimum number of Courses needed.
     * @param minCount The minimum number of Courses needed.
     */
    public void SetMinCount(int minCount){
        this.minCount = minCount;
    }

    /**
     * Gets the minimum number of Courses needed.
     * @return The minimum number of Courses needed.
     */
    public int GetMinCount(){
        return minCount;
    }

    /**
     * Adds a Course ID to the list.
     * @param course The Course ID to add to the list.
     */
    public void AddCourse(String course){
        courses.add(course);
    }

    /**
     * Adds a Course to the list
     * @param course The Course to add to the list.
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
     * Removes a Course from the list.
     * @param course The Course to remove from the list.
     */
    public void RemoveCourse(Course course) { courses.remove(course.getID()); }

    /**
     * Returns an ArrayList of the Course IDs in this object's list.
     * @return The ArrayList of Course IDs in this object's list.
     */
    public ArrayList<String> getCourses(){
        return courses;
    }

    /**
     * Returns true if at least the minimum number of Courses minCount from this object's courses list
     * are contained in the input list courseList.
     * @param courseList The list to check against this object's courses list.
     * @return Returns true if at least the minimum number of Courses minCount from this object's
     * courses list are contained in the input list courseList; false otherwise.
     */
    public boolean Check(ArrayList<Course> courseList){
        int count = 0;
        for (Course c : courseList){
            boolean found = false;
            for (String id : courses){
                if (c.getID().equals(id)){
                    found = true;
                }
            }
            if (found){
                count ++;
            }
        }
        if (count < minCount){
            System.out.println("\tYOU'RE SHORT " + (minCount - count) + " COURSES!");
            System.out.println("\tYOU NEED TO TAKE " + minCount + " TOTAL COURSES FROM THIS LIST:");
            for (String s : courses){
                System.out.print("\t" + s);
            }
            System.out.println();
            System.out.println();
        }
        return (count >= minCount);
    }
}
