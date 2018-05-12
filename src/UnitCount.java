import java.util.ArrayList;

/**
 * A Requirement whose Check() returns true if a minimum number of units are taken from a specified list of courses
 */
public class UnitCount implements Requirement{
    // A list of the IDs of courses, NOT course objects
    private ArrayList<String> courses = new ArrayList<>();

    // The minimum number of courses from the list a student must take for Check to return true
    private int unitCount;

    public UnitCount(){
    }

    public UnitCount(int unitCount){
        this.unitCount = unitCount;
    }

    public UnitCount(ArrayList<String> courses, int unitCount){
        this.courses = courses;
        this.unitCount = unitCount;
    }

    public void SetMinCount(int unitCount){
        this.unitCount = unitCount;
    }

    public int GetUnitCount(){
        return unitCount;
    }

    public void AddCourse(String course){
        courses.add(course);
    }

    public void RemoveCourse(String course){
        courses.remove(course);
    }

    public boolean Check(ArrayList<Course> courseList){
        int count = 0;
        for (Course c : courseList){
            boolean found = false;
            for (String id : courses){
                if (c.ContainsID(id)){
                    found = true;
                }
            }
            if (found){
                count += c.getUnits();
            }
        }
        return (count >= unitCount);
    }
}
