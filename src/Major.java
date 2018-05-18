import java.util.ArrayList;

/**
 * A major consisting of a title, the department it's offered under, and an ArrayList of Requirements to be met.
 */
public class Major {

    private String title;
    private String department;
    private ArrayList<Requirement> requirements = new ArrayList<>();

    /**
     * Default Constructor
     */
    public Major(){

    }

    /**
     * Constructor for Major.
     * @param title The title of the major (e.g. Computer Science)
     * @param department The department it's offered under (e.g. Department of Engineering)
     */
    public Major(String title, String department) {
        this.title = title;
        this.department = department;
    }

    /**
     * Sets the title of the major.
     * @param title The title to assign to the major.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns The title of the major.
     * @return The title of the major.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the department this major is offered under.
     * @return The department this major is offered under.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Prints the major followed by the department it's offered under (e.g. "Computer Science, Department of Engineering")
     */
    public void Print(){
        System.out.println(title + ", " + department);
    }

    /**
     * Adds a Requirement to the major.
     * @param r The Requirement to add to the major.
     */
    public void AddRequirement(Requirement r){
        requirements.add(r);
    }

    /**
     * Calls Check() on each Requirement in the requirements list and returns true if each requirement has been met.
     * @param c The list of courses to be passed to each Requirement's Check() method.
     * @return True if each Requirement has been met; false otherwise.
     */
    public boolean CheckRequirements(ArrayList<Course> c){
        boolean success = true;
        for (Requirement r : requirements){
            if (!(r.Check(c))){
                success = false;
            }
        }
        return success;
    }
}
