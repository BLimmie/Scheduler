import java.util.ArrayList;

/**
 * A small wrapper class for quarter to be used by the 2D array in Grid.
 */
public class Quarter {

    private ArrayList<Course> courses = new ArrayList<>();

    public Quarter() {}

    public void add(Course c){
        courses.add(c);
    }

    public void remove(Course c){
        courses.remove(c);
    }

    public ArrayList<Course> getCourses(){
        return courses;
    }

    public void Print(){
        System.out.print("\t");
        for (Course c : courses){
            System.out.print("\t" + c.getID());
        }
        System.out.println();
    }
}
