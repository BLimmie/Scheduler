import java.util.ArrayList;

/**
 * Interface to be implemented by all Requirements; Contains one method Check() which takes an ArrayList of Courses
 * as its argument and returns true or false depending on if that list courseList meets that Requirement's specifications.
 */
public interface Requirement {

    /**
     * Returns true or false depending on the Requirement's specifications.
     * @param courseList The list of Courses to be examined by the Requirement.
     * @return True or false, depending on the Requirement's specifications.
     */
    boolean Check(ArrayList<Course> courseList);
}
