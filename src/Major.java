import java.util.ArrayList;

public class Major {

    private String title;
    private String department;
    private ArrayList<Requirement> requirements = new ArrayList<>();

    public Major(){

    }

    public Major(String title, String department) {
        this.title = title;
        this.department = department;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }

    public void AddRequirement(Requirement r){
        requirements.add(r);
    }

    public boolean CheckRequirements(ArrayList<Course> c){
        for (Requirement r : requirements){
            if (!(r.Check(c))){
                return false;
            }
        }
        return true;
    }
}
