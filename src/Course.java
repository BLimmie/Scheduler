import java.util.ArrayList;

public class Course {
    private ArrayList<String> IDs;
    private String realID;
    private String title;
    private String fullTitle;
    private String college;
    private String description;
    private double units;
    //TODO Change prereqs to ArrayList of ArrayLists of Course
    private ArrayList<Course> prereqs;
    private boolean fall;
    private boolean winter;
    private boolean spring;
    private ArrayList<String> labels;

    /**
     * Default constructor for Course
     */
    public Course() {
        this.IDs = new ArrayList<String>();
        this.realID = "";
        this.title = "";
        this.fullTitle = "";
        this.college = "";
        this.units = 0.0;
        //TODO Change prereqs
        this.prereqs = new ArrayList<Course>();
        this.fall = false;
        this.winter = false;
        this.spring = false;
        this.labels = new ArrayList<String>();
    }

    /**
     * Constructor to be used internally for making a full course completely in code
     *
     * @param IDs       List of IDs associated with a course
     * @param title     Short name of course
     * @param fullTitle Full name of course
     * @param college   College that the course is being hosted in
     * @param units     Number of units as a double
     * @param prereqs   List of prerequisistes for a course
     * @param fall      Class is hosted in fall
     * @param winter    Class is hosted in winter
     * @param spring    Class is hosted in spring
     * @param labels    GE Labels for a class
     */
    public Course(ArrayList<String> IDs,
                  String title,
                  String fullTitle,
                  String college,
                  String description,
                  double units,
                  ArrayList<Course> prereqs,
                  boolean fall,
                  boolean winter,
                  boolean spring,
                  ArrayList<String> labels) {
        this.IDs = IDs;
        this.realID = String.join("/", IDs);
        this.title = title;
        this.fullTitle = fullTitle;
        this.college = college;
        this.description = description;
        this.units = units;
        //TODO Change prereqs
        this.prereqs = prereqs;
        this.fall = fall;
        this.winter = winter;
        this.spring = spring;
        this.labels = labels;
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

        return getRealID().equals(course.getRealID());
    }

    /**
     * Creates the hashcode for the course
     * @return Hashcode
     */
    @Override
    public int hashCode() {
        return getRealID().hashCode();
    }

    /**
     * Gets the ArrayList of IDs
     * @return
     */
    public ArrayList<String> getIDs() {
        return IDs;
    }

    /**
     * Adds an ID to the IDs ArrayList
     * @param ID ID to add
     */
    public void addID(String ID) {
        this.IDs.add(ID);
        this.realID = String.join("/", IDs);
    }

    /**
     * Deletes an ID from the IDs ArrayList
     *
     * @param ID ID to remove
     * @return If deleting an ID was successful
     */
    public boolean deleteID(String ID) {
        boolean success = this.IDs.remove(ID);
        this.realID = String.join("/", IDs);
        return success;
    }

    /**
     * Gets the realID of a course
     * @return The course's realID
     */
    public String getRealID() {
        return realID;
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
    public String getCollege() {
        return college;
    }

    /**
     * Sets the college a course is hosted under
     * @param college CoE or L&S
     */
    public void setCollege(String college) {
        this.college = college;
    }

    /**
     * Gets the number of units associated with a course
     * @return Number of units
     */
    public double getUnits() {
        return units;
    }

    /**
     * Sets the number of units associated with a course
     * @param units
     */
    public void setUnits(double units) {
        this.units = units;
    }

    /**
     * Gets the List of prerequisites for a course
     * @return List of prerequisites
     */
    public ArrayList<Course> getPrereqs() {
        return prereqs;
    }

    //TODO Change prereqs
    public void addPrereq(Course prereq) {
        this.prereqs.add(prereq);
    }

    public void deletePrereq(Course prereq) {
        this.prereqs.remove(prereq);
    }
    //end TODO

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
     * Gets an ArrayList of GE labels for a course
     * @return ArrayList of GE labels
     */
    public ArrayList<String> getLabels() {
        return labels;
    }

    /**
     * Adds a label to the list of GE labels
     * @param label Label to be added
     */
    public void addLabel(String label) {
        this.labels.add(label);
    }

    /**
     * Deletes a label from the list of GE labels
     * @param label Label to be deleted
     */
    public void deleteLabel(String label) {
        this.labels.remove(label);
    }
}
