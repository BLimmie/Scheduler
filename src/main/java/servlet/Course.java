package servlet;
import java.util.ArrayList;

public class Course {

    /**
     * The Course ID (e.g. CMPSC48)
     */
    private String ID;

    /**
     * The Course title (e.g. Comp Sci Project)
     */
    private String title;

    /**
     * The full Course title (e.g. Computer Science Project)
     */
    private String fullTitle;

    /**
     * The department the Course is offered under (e.g. Engineering)
     */
    private String department;

    /**
     * The description of the Course
     */
    private String description;

    /**
     * The number of units this Course offers
     */
    private int units;

    /**
     * An ANDList of Courses to have been taken as prerequisites for this Course
     */
    private ANDList prereqs;

    /**
     * Whether this Course is offered in the Fall
     */
    private boolean fall;

    /**
     * Whether this Course is offered in the Winter.
     */
    private boolean winter;

    /**
     * Whether this Course is offered in the Spring.
     */
    private boolean spring;

    /**
     * GE labels this Course contains.
     */

    /**
     * Default constructor for Course
     */
    public Course() {
        this.ID = "";
        this.title = "";
        this.fullTitle = "";
        this.department = "";
        this.units = 0;
        this.prereqs = new ANDList();
        this.fall = false;
        this.winter = false;
        this.spring = false;
    }

    /**
     * Partial Constructor used by Admin
     * @param ID        The ID for the class (e.g. CMPSC48)
     * @param units     The number of units the class is
     */
    public Course(String ID, int units) {
        this.ID = ID;
        this.title = "";
        this.fullTitle = "";
        this.department = "";
        this.units = units;
        this.prereqs = new ANDList();
        this.fall = false;
        this.winter = false;
        this.spring = false;
    }

    /**
     * Constructor to be used internally for making a full course completely in code
     *
     * @param ID       ID associated with the course
     * @param title     Short name of course
     * @param fullTitle Full name of course
     * @param department   College that the course is being hosted in
     * @param units     Number of units as a double
     * @param prereqs   List of prerequisistes for a course
     * @param fall      Class is hosted in fall
     * @param winter    Class is hosted in winter
     * @param spring    Class is hosted in spring
     */
    public Course(String ID,
                  String title,
                  String fullTitle,
                  String department,
                  String description,
                  int units,
                  ANDList prereqs,
                  boolean fall,
                  boolean winter,
                  boolean spring) {
        this.ID = ID;
        this.title = title;
        this.fullTitle = fullTitle;
        this.department = department;
        this.description = description;
        this.units = units;
        this.prereqs = prereqs;
        this.fall = fall;
        this.winter = winter;
        this.spring = spring;
    }

    public Course(String ID,
                  String title,
                  String fullTitle,
                  String department,
                  String description,
                  int units,
                  boolean fall,
                  boolean winter,
                  boolean spring) {
        this.ID = ID;
        this.title = title;
        this.fullTitle = fullTitle;
        this.department = department;
        this.description = description;
        this.units = units;
        this.prereqs = new ANDList();
        this.fall = fall;
        this.winter = winter;
        this.spring = spring;
    }


    /**
     * Checks if two courses are equal
     * @param o An object to check equivalence
     * @return If an object is equal to this one
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return getID().equals(course.getID());
    }

    /**
     * Creates the hashcode for the course
     * @return Hashcode
     */
    @Override
    public int hashCode() {
        return getID().hashCode();
    }

    /**
     * Gets the ID of the course
     * @return The ID of the course
     */
    public String getID() {
        return ID;
    }

    /**
     * Gets the short title of a course
     * @return Short title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the short title of a course
     * @param title Short title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the full title of a course
     * @return Full title
     */
    public String getFullTitle() {
        return fullTitle;
    }

    /**
     * Sets the full title of a course
     * @param fullTitle Full title
     */
    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    /**
     * Gets the college a course is hosted under
     * @return CoE or L&S
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the college a course is hosted under
     * @param department CoE or L&S
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Gets the number of units associated with a course
     * @return Number of units
     */
    public int getUnits() {
        return units;
    }

    /**
     * Sets the number of units associated with a course
     * @param units
     */
    public void setUnits(int units) {
        this.units = units;
    }

    /**
     * Gets the List of prerequisites for a course
     * @return List of prerequisites
     */
    public ArrayList<String> getPrereqs() {
        return prereqs.getCourses();
    }

    /**
     * Adds a Course to this Course's prerequisites.
     * @param prereq The Course to add to this Course's prerequisites.
     */
    public void addPrereq(Course prereq) {
        this.prereqs.AddCourse(prereq);
    }

    /**
     * Adds a Course ID to this Course's prerequisites.
     * @param prereq The Course ID to add to this Course's prerequisites.
     */
    public void addPrereq(String prereq) {
        this.prereqs.AddCourse(prereq);
    }

    public void addPrereq(ANDList prereq) { this.prereqs = prereq; }

    /**
     * Removes a Course from this Course's prerequisites.
     * @param prereq The Course to remove from this Course's prerequisites.
     */
    public void deletePrereq(Course prereq) {
        this.prereqs.RemoveCourse(prereq);
    }

    /**
     * Removes a Course ID from this Course's prerequisites.
     * @param prereq The Course ID to remove from this Course's prerequisites.
     */
    public void deletePrereq(String prereq) {
        this.prereqs.RemoveCourse(prereq);
    }

    /**
     * Checks if a course is held in the fall
     * @return If course is held in fall
     */
    public boolean isFall() {
        return fall;
    }

    /**
     * Sets held in fall boolean
     * @param fall Held in fall
     */
    public void setFall(boolean fall) {
        this.fall = fall;
    }

    /**
     * Checks if a course is held in the winter
     * @return If course is held in winter
     */
    public boolean isWinter() {
        return winter;
    }

    /**
     * Sets held in winter boolean
     * @param winter Held in winter
     */
    public void setWinter(boolean winter) {
        this.winter = winter;
    }

    /**
     * Checks if a course is held in the fall
     * @return If course is held in fall
     */
    public boolean isSpring() {
        return spring;
    }

    /**
     * Sets held in spring boolean
     * @param spring Held in spring
     */
    public void setSpring(boolean spring) {
        this.spring = spring;
    }

    /**
     * Calls Check() on the prereqs Requirement and returns the result.
     * @param courseList The list of classes to checked against the prereqs Requirement.
     * @return The result of the Check() method.
     */
    public boolean CheckPrereqs(ArrayList<Course> courseList){
        return prereqs.Check(courseList);
    }

}
