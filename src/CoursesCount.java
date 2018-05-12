import java.util.ArrayList;

/**
 * A Requirement whose Check() method returns true if the user has taken the minimum
 * number of courses from a specified list
 */
public class CoursesCount implements Requirement{
    // A list of the IDs of courses, NOT course objects
    private ArrayList<String> courses = new ArrayList<>();

    // The minimum number of courses from the list a student must take for Check to return true
    private int minCount;

    public CoursesCount(){
    }

    public CoursesCount(int minCount){
        this.minCount = minCount;
    }

    public CoursesCount(ArrayList<String> courses, int minCount){
        this.courses = courses;
        this.minCount = minCount;
    }

    public void SetMinCount(int minCount){
        this.minCount = minCount;
    }

    public int GetMinCount(){
        return minCount;
    }

    public void AddCourse(String course){
        courses.add(course);
    }

    public void AddCourse(Course course){
        courses.add(course.getID());
    }

    public void RemoveCourse(String course){
        courses.remove(course);
    }

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
