import java.util.ArrayList;

public class Course {
    private ArrayList<String> IDs;
    private String realID;
    private String title;
    private String fullTitle;
    private String college;
    private String dept;
    private double units;
    private ArrayList<Course> prereqs;
    private boolean fall;
    private boolean winter;
    private boolean spring;
    private ArrayList<String> labels;

    public Course() {
        this.IDs = new ArrayList<String>();
        this.realID = "";
        this.title = "";
        this.fullTitle = "";
        this.college = "";
        this.dept = "";
        this.units = 0.0;
        this.prereqs = new ArrayList<Course>();
        this.fall = false;
        this.winter = false;
        this.spring = false;
        this.labels = new ArrayList<String>();
    }

    public Course(ArrayList<String> IDs,
                  String title,
                  String fullTitle,
                  String college,
                  String dept,
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
        this.dept = dept;
        this.units = units;
        this.prereqs = prereqs;
        this.fall = fall;
        this.winter = winter;
        this.spring = spring;
        this.labels = labels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return getRealID().equals(course.getRealID());
    }

    @Override
    public int hashCode() {
        return getRealID().hashCode();
    }

    public ArrayList<String> getIDs() {
        return IDs;
    }

    public void addID(String ID) {
        this.IDs.add(ID);
    }

    public void deleteID(String ID) {
        this.IDs.remove(ID);
    }

    public String getRealID() {
        return realID;
    }

    public void setRealID(String realID) {
        this.realID = realID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public double getUnits() {
        return units;
    }

    public void setUnits(double units) {
        this.units = units;
    }

    public ArrayList<Course> getPrereqs() {
        return prereqs;
    }

    public void addPrereq(Course prereq) {
        this.prereqs.add(prereq);
    }

    public void deletePrereq(Course prereq) {
        this.prereqs.remove(prereq);
    }

    public boolean isFall() {
        return fall;
    }

    public void setFall(boolean fall) {
        this.fall = fall;
    }

    public boolean isWinter() {
        return winter;
    }

    public void setWinter(boolean winter) {
        this.winter = winter;
    }

    public boolean isSpring() {
        return spring;
    }

    public void setSpring(boolean spring) {
        this.spring = spring;
    }

    public ArrayList<String> getLabels() {
        return labels;
    }

    public void addLabel(String label) {
        this.labels.add(label);
    }

    public void deleteLabel(String label) {
        this.labels.remove(label);
    }
}
