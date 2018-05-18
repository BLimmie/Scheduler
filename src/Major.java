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

    public String getTitle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }

    public void Print(){
        System.out.println(title + ", " + department);
    }

    public void AddRequirement(Requirement r){
        requirements.add(r);
    }

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
