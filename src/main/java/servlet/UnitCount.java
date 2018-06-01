package servlet;
import java.util.ArrayList;

/**
 * A Requirement whose Check() method returns true if the user has taken the minimum
 * number of units from its list.
 */
public class UnitCount implements Requirement{

    /**
     * The list of course String IDs (NOT Course objects)
     */    private ArrayList<String> courses = new ArrayList<String>();

    /**
     * The minimum number of units needed
     */    private int unitCount;

    /**
     * Default Constructor for UnitCount.
     */
    public UnitCount(){ }

    /**
     * Constructor for UnitCount.
     * @param unitCount The minimum number of units from the list that need to be taken.
     */
    public UnitCount(int unitCount){
        this.unitCount = unitCount;
    }

    /**
     * Constructor for UnitCount.
     * @param courses The list of Course IDs
     * @param unitCount The minimum number of units to be taken.
     */
    public UnitCount(ArrayList<String> courses, int unitCount){
        this.courses = courses;
        this.unitCount = unitCount;
    }

    /**
     * Sets the minimum number of units to be taken.
     * @param unitCount The minimum number of units to be taken.
     */
    public void SetMinCount(int unitCount){
        this.unitCount = unitCount;
    }

    /**
     * Returns the minimum number of units to be taken.
     * @return The minimum number of units to be taken.
     */
    public int GetUnitCount(){
        return unitCount;
    }

    /**
     * Adds a Course ID to the list.
     * @param course The Course ID to add to the list.
     */
    public void AddCourse(String course){
        courses.add(course);
    }

    /**
     * Adds a Course to the list.
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
     * @param course The Course to Remove from the list.
     */
    public void RemoveCourse(Course course) { courses.remove(course.getID()); }

    /**
     * Returns the ArrayList of Course IDs in this object's courses list.
     * @return The ArrayList of Course IDs in this object's courses list.
     */
    public ArrayList<String> getCourses(){
        return courses;
    }

    /**
     * Returns true if the minimum number of units from this object's courses list are contained
     * in the input list courseList.
     * @param courseList The list of courses to check against this object's courses list.
     * @return Returns true if the minimum number of units from this object's courses list are
     * contained in the input list courseList; return false otherwise.
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
                count += c.getUnits();
            }
        }
        if (count < unitCount){
            System.out.println("\tYOU'RE SHORT " + (unitCount - count) + " UNITS!");
            System.out.println("\tYOU NEED TO TAKE " + unitCount + " TOTAL UNITS FROM THIS LIST:");
            for (String s : courses){
                System.out.print("\t" + s);
            }
            System.out.println();
            System.out.println();
        }
        else {
            System.out.println("You've taken the correct number of units!");
        }
        return (count >= unitCount);
    }
}
