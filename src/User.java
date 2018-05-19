import java.util.ArrayList;

/**
 * A profile for a student user of the grid containing an email, name, perm, password, major, and grid.
 */
public class User {

    private String email;
    private String firstName;
    private String lastName;
    private String perm;
    private String password;
    private Major major;
    private Grid grid;

    private static ArrayList<User> users = new ArrayList<>();

    /**
     * Adds a User to the static list of Users
     * @param u User to add to the list
     */
    public static void AddUser(User u){
        users.add(u);
    }

    /**
     * Removes a User from the static list of Users
     * @param u User to remove from the list
     */
    public static void RemoveUser(User u) {
        users.remove(u);
    }

    /**
     * Prints a list of current Users
     */
    public static void ListUsers(){
        System.out.println();
        for (User u : users){
            System.out.println("\t" + u.getLastName() + ", " + u.getFirstName());
            System.out.println("\t" + u.getMajor().getTitle());
            System.out.println();
        }
    }

    /**
     * Gets a User from the static list of Users
     * @param email The email of the User to retrieve
     * @return The User with the given email
     */
    public static User GetUser(String email){
        for (User u : users){
            if (u.getEmail().equals(email)){
                return u;
            }
        }
        System.out.println("We couldn't find an account registered to this email!");
        return new User();
    }

    /**
     * Gets the email address of this User
     * @return The email address of this User
     */
    public String getEmail(){
        return email;
    }

    /**
     * Sets the email address of this User
     * @param e The email address of this User
     */
    public void setEmail(String e){
        this.email = e;
    }

    /**
     * Gets the User's first name
     * @return The User's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set's the User's first name
     * @param firstName The User's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the User's last name
     * @return The User's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the User's last name
     * @param lastName The User's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the User's perm number
     * @return The User's perm number
     */
    public String getPerm(){
        return this.perm;
    }

    /**
     * Sets the User's perm number
     * @param perm The User's perm number
     */
    public void setPerm(String perm){
        this.perm = perm;
    }

    /**
     * Gets the User's password
     * @return The user's password
     */
    private String getPassword() {
        return password;
    }

    /**
     * Sets the User's password
     * @param password The user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the User's major
     * @return The User's major
     */
    public Major getMajor() {
        return major;
    }

    /**
     * Sets the User's major
     * @param major The User's major
     */
    public void setMajor(Major major) {
        this.major = major;
        UpdateMajor();
    }

    /**
     * Gets the User's grid
     * @return The User's grid
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * Sets the User's grid
     * @param grid The User's grid
     */
    public void setGrid(Grid grid) {
        this.grid = grid;
        UpdateMajor();
    }

    /**
     * Adds a Course to this User's grid
     * @param c Course to add to the grid
     * @param year Year to add the Course in
     * @param quarter Quarter to add the Course in
     */
    public void AddCourseToGrid(Course c, int year, int quarter){
        this.grid.AddCourse(c, year, quarter);
    }

    /**
     * Removes a Course from this User's grid
     * @param c Course to remove from the grid
     * @param year Year to remove the Course from
     * @param quarter Quarter to remove the Course from
     */
    public void RemoveCourseFromGrid(Course c, int year, int quarter){
        this.grid.DeleteCourse(c, year, quarter);
    }

    /**
     * Verifies this User's grid.
     */
    public void VerifyGrid(){
        this.grid.Verify();
    }

    /**
     * Prints this User's grid.
     */
    public void PrintGrid(){
        this.grid.PrintGrid();
    }

    /**
     * Updates this User's grid with the current major.
     */
    public void UpdateMajor(){
        this.grid.UpdateMajor(major);
    }

    /**
     * Updates the Course library of this User's grid.
     * @param courseList The Course library with which to update this User's grid.
     */
    public void UpdateGridLibrary(ArrayList<Course> courseList){
        this.grid.UpdateLibrary(courseList);
    }

    /**
     * Updates the Course library of this User's grid.
     * @param m The major to update the grid with.
     */
    public void UpdateGridMajor(Major m){
        this.grid.UpdateMajor(m);
    }

    /**
     * Checks to see if the input String is this User's password.
     * @param p The String to test.
     * @return True if input p is equal to the password; false otherwise.
     */
    public boolean CheckPassword(String p){
        return password.equals(p);
    }

    public void Print(){
        System.out.println(email);
        System.out.println(lastName + ", " + firstName);
        major.Print();
        System.out.println("PERM #: " + perm);
    }

    /**
     * Default Constructor
     */
    public User(){
        this.email = "";
        this.firstName = "";
        this.lastName = "";
        this.perm = "";
        this.password = "";
        this.major = new Major();
        this.grid = new Grid();
    }

    /**
     * Constructor for User
     * @param email User's email
     * @param firstName User's first name
     * @param lastName User's last name
     * @param perm User's perm
     * @param password User's password
     * @param major User's major
     */
    public User(String email, String firstName, String lastName, String perm, String password, Major major) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.perm = perm;
        this.password = password;
        this.major = major;
        this.grid = new Grid();
        UpdateMajor();
    }

    /**
     * Constructor for User
     * @param email User's email
     * @param firstName User's first name
     * @param lastName User's second name
     * @param perm User's perm
     * @param password User's password
     * @param major User's major
     * @param grid User's grid
     */
    public User(String email, String firstName, String lastName, String perm, String password, Major major, Grid grid) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.perm = perm;
        this.password = password;
        this.major = major;
        this.grid = grid;
        UpdateMajor();
    }

    /**
     * Checks if two Users are equal
     * @param o An object to check equivalence
     * @return If an object is equal to this one
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        User user = (User) o;

        return (getPerm() == user.getPerm());
    }
}
