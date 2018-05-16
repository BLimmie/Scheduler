public class User {

    private String firstName;
    private String lastName;
    private String password;
    private String classStanding;
    private Major major;
    private Grid grid;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClassStanding() {
        return classStanding;
    }

    public void setClassStanding(String classStanding) {
        this.classStanding = classStanding;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public User(String firstName, String lastName, String password, Major major){
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.grid = new Grid();
    }

    public User(String firstName, String lastName, String password, Major major, Grid grid){
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.grid = grid;
    }


	/*
	//Instance Var
	String username;
	String password;
	int user_id;
	Grid user_grid;
	//profiles
	String name;
	String legal_name;
	ArrayList <Major> user_majors;
	ArrayList <Minor> user_minors;
	ArrayList <int> AP;
	ArrayList <courses> courses_before_university;
	Grid class_taken;
	

	//create profile
	public create_profile ()
	
	//view profile 
	public view_profile ()
	
	//modify profile 
	public modify_profile ()
	
	//sign up a new account
	public sign_up ()

	//sign in an existing account
	public sign_in()

	//sign out current account 
	public sign_out ()

	//create a new schedule
	public new_schedule ()

	//get the infomation of a course
	public find_course_info ()

	//print out current schedule 
	public print_current () 

	//save current schedule 
	public save_current ()

	//get the list of classes to choose
	public get_class_list ()
	
	//add a course to grid
	public add_course ()

	//delete a course from grid
	public del_course ()
	
	//check current grid viability
	public check_status ()
	
	//auto-complete grid 
	public auto_complete ()
	
	//dismiss warning
	public dismiss ()
*/
}
