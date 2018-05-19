import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Driver class used to implement a Command-Line Interface for Four Year Grid.
 */
public class Driver {

    private User user;
    private ArrayList<Course> library = new ArrayList<>();
    private ArrayList<Major> majors = new ArrayList<>();

    /**
     * The static main function that calls Driver's static Run() function.
     * @param args
     */
    public static void main(String args[]) {
        Driver.Run();
    }

    /**
     * Driver's static Run() function which calls various GUI functions.
     */
    public static void Run(){
        Driver d = new Driver();
        System.out.println();
        System.out.println("WELCOME TO THE FOUR YEAR GRID.");
        System.out.println();
        d.Load();
        d.Login();
        d.MainMenu();
    }

    /**
     * Private constructor for Driver.
     */
    private Driver(){}

    /**
     * Pre-loads courses and majors into the Driver.
     */
    private void Load(){
        Course cs16 = new Course("CS16", 4);
        Course cs24 = new Course("CS24", 4);
        Course cs32 = new Course("CS32", 4);
        Course cs40 = new Course("CS40", 5);
        Course cs56 = new Course("CS56", 4);
        Course cs64 = new Course("CS64", 4);
        Course cs48 = new Course("CS48", 4);
        Course ece1 = new Course("ECE152A", 4);
        Course ece2 = new Course("ECE152B", 4);
        Course ece3 = new Course("ECE152C", 4);
        Course ece4 = new Course("ECE160", 5);
        Course ece5 = new Course("ECE177", 4);
        Course ece6 = new Course("ECE162", 4);
        Course ece7 = new Course("ECE163", 4);
        Course cs130a = new Course("CS130A", 4);
        Course cs130b = new Course("CS130B", 4);
        Course cs138 = new Course("CS138", 4);
        Course upper1 = new Course("CS178", 4);
        Course upper2 = new Course("CS177", 4);
        Course upper3 = new Course("CS170", 4);
        Course upper4 = new Course("CS166", 4);
        Course upper5 = new Course("CS154", 4);
        Course upper6 = new Course("CS199", 4);
        Course random1 = new Course("EARTH7", 4);
        Course random2 = new Course("ARTHI6A", 4);
        Course random3 = new Course("ARTHI6C", 4);
        Course random4 = new Course("CLASS40", 4);
        Course random5 = new Course("CLASS20B", 4);
        Course random6 = new Course("GREEK199", 4);
        Course random7 = new Course("HIST2C", 4);
        cs24.addPrereq(cs16);
        cs32.addPrereq(cs24);
        cs56.addPrereq(cs32);
        cs64.addPrereq(cs56);
        library.add(cs16);
        library.add(cs24);
        library.add(cs32);
        library.add(cs56);
        library.add(cs40);
        library.add(cs64);
        library.add(cs48);
        library.add(ece1);
        library.add(ece2);
        library.add(ece3);
        library.add(ece4);
        library.add(ece5);
        library.add(ece6);
        library.add(ece7);
        library.add(cs130a);
        library.add(cs130b);
        library.add(cs138);
        library.add(upper1);
        library.add(upper2);
        library.add(upper3);
        library.add(upper4);
        library.add(upper5);
        library.add(upper6);
        library.add(random1);
        library.add(random2);
        library.add(random3);
        library.add(random4);
        library.add(random5);
        library.add(random6);
        library.add(random7);
        Major major = new Major("Computer Science", "College of Engineering");
        Major major2 = new Major("Electrical Engineering", "College of Engineering");
        Major major3 = new Major("Computer Engineering", "College of Engineering");

        // LOWER DIVS
        ANDList r1 = new ANDList();
        r1.AddCourse(cs16);
        r1.AddCourse(cs24);
        r1.AddCourse(cs32);
        r1.AddCourse(cs40);
        r1.AddCourse(cs56);
        r1.AddCourse(cs64);
        r1.AddCourse(cs48);

        ANDList r1a = new ANDList();
        r1.AddCourse(ece1);
        r1.AddCourse(ece2);
        r1.AddCourse(ece3);
        r1.AddCourse(ece4);
        r1.AddCourse(ece5);
        r1.AddCourse(ece6);
        r1.AddCourse(ece7);

        ANDList r1b = new ANDList();
        r1.AddCourse(cs16);
        r1.AddCourse(cs24);
        r1.AddCourse(cs32);
        r1.AddCourse(ece1);
        r1.AddCourse(ece2);
        r1.AddCourse(ece3);
        r1.AddCourse(ece4);

        // UPPER DIVS (TAKE 4 OF A LIST OF 6)
        CoursesCount r2 = new CoursesCount(4);
        r2.AddCourse(upper1);
        r2.AddCourse(upper2);
        r2.AddCourse(upper3);
        r2.AddCourse(upper4);
        r2.AddCourse(upper5);
        r2.AddCourse(upper6);

        // ELECTIVES (TAKE 16 UNITS OF 7 COURSES)
        UnitCount r3 = new UnitCount(16);
        r3.AddCourse(random1);
        r3.AddCourse(random2);
        r3.AddCourse(random3);
        r3.AddCourse(random4);
        r3.AddCourse(random5);
        r3.AddCourse(random6);
        r3.AddCourse(random7);

        major.AddRequirement(r1);
        major.AddRequirement(r2);
        major.AddRequirement(r3);

        major2.AddRequirement(r1a);
        major2.AddRequirement(r2);
        major2.AddRequirement(r3);

        major3.AddRequirement(r1b);
        major3.AddRequirement(r2);
        major3.AddRequirement(r3);
        majors.add(major);
        majors.add(major2);
        majors.add(major3);
    }

    /**
     * The Login screen which prompts a user to create a User or sign in.
     */
    private void Login(){
        while (true) {
            System.out.println("Signed in:");
            if (user == null){
                System.out.println("\tNOT SIGNED IN");
            }
            else{
                System.out.println("\t" + user.getEmail());
            }
            System.out.println("1. CREATE USER");
            System.out.println("2. SIGN IN TO USER");

            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            in.nextLine();
            if (a == 1) {
                CreateUser();
                if (!(user == null)) {
                    return;
                }
            } else if (a == 2) {
                SignIn();
                if (!(user == null)) {
                    return;
                }
            } else {
                System.out.println("Please enter a 1 or 2.");
            }
        }
    }

    /**
     * Screen to Create a User profile by taking in User inputs.
     */
    private void CreateUser(){
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("----------------");
        System.out.println();
        System.out.println("CREATE USER:");
        System.out.println();
        System.out.println("Enter your email address (type BACK to go back):");
        String email = in.nextLine();
        if (email.equals("BACK")){
            return;
        }
        System.out.println("Enter your first name:");
        String firstName = in.nextLine();
        System.out.println("Enter your last name:");
        String lastName = in.nextLine();
        System.out.println("Enter a unique perm number:");
        int perm = in.nextInt();
        in.nextLine();
        System.out.println("Enter a password:");
        String password = in.nextLine();
        System.out.println("What is your major? (For a list of majors, type HELP)");
        Major major = new Major();
        boolean contains = false;
        while (!contains) {
            String majorTitle = in.nextLine();
            if (majorTitle.equals("HELP")) {
                for (Major m : majors) {
                    m.Print();
                }
            } else {
                for (Major m : majors){
                    if (m.getTitle().equals(majorTitle)){
                        contains = true;
                        major = m;
                    }
                }
                if (!contains){
                    System.out.println("Sorry, we couldn't find that major!");
                }
            }
        }
        user = new User(email, firstName, lastName, perm, password, major);
        return;
    }

    /**
     * Signs into a User profile by taking User inputs.
     */
    private void SignIn(){
        System.out.println();
        System.out.println("----------------");
        System.out.println();
        System.out.println("SIGN IN:");
        System.out.println();
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter your email address (Type BACK to go back):");
            String email = in.nextLine();
            if (email.equals("BACK")){
                return;
            }
            System.out.println("Enter your password:");
            String password = in.nextLine();
            if (User.GetUser(email).CheckPassword(password) && !(email.equals(""))) {
                user = User.GetUser(email);
                return;
            } else {
                System.out.println("Incorrect email or password; try again:");
            }
        }
    }

    /**
     * Brings up the Main Menu, where the User can choose
     * 1) Course Manager
     * 2) Major Manager
     * 3) Grid Manager
     * 4) Profile Manager
     * 5) Exit
     */
    private void MainMenu(){
        while(true) {
            System.out.println();
            System.out.println("-------------------------------------------");
            System.out.println();
            System.out.println("MAIN MENU:");
            System.out.println("1. COURSE MANAGER");
            System.out.println("2. MAJOR MANAGER");
            System.out.println("3. GRID MANAGER");
            System.out.println("4. PROFILE MANAGER");
            System.out.println("5. EXIT");
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();
            in.nextLine();
            if (input == 1) {
                CourseManager();
            }
            else if (input == 2) {
                MajorManager();
            }
            else if (input == 3) {
                GridManager();
            }
            else if (input == 4){
                ProfileManager();
            }
            else if (input == 5){
                return;
            }
            else {
                System.out.println("Please enter 1, 2, or 3!");
            }
        }
    }

    /**
     * Profile Manager; User can choose
     * 1) Change first name
     * 2) Change last name
     * 3) Change major
     * 4) View profile
     * 5) Exit
     */
    private void ProfileManager(){
        while(true) {
            Scanner in = new Scanner(System.in);
            System.out.println();
            System.out.println("-------------------------------------------");
            System.out.println();
            System.out.println("PROFILE MANAGER:");
            System.out.println("1. CHANGE FIRST NAME");
            System.out.println("2. CHANGE LAST NAME");
            System.out.println("3. CHANGE MAJOR");
            System.out.println("4. VIEW PROFILE");
            System.out.println("5. EXIT");

            int in1 = in.nextInt();
            in.nextLine();
            if (in1 == 1){
                System.out.println("Enter your first name:");
                String first = in.nextLine();
                user.setFirstName(first);
            }
            else if (in1 == 2){
                System.out.println("Enter your last name:");
                String last = in.nextLine();
                user.setLastName(last);
            }
            else if (in1 == 3){
                System.out.println("Enter your major");
                String major = in.nextLine();
                boolean found = false;
                for (Major m : majors){
                    if (m.getTitle().equals(major)){
                        found = true;
                        user.setMajor(m);
                    }
                }
                if (!found){
                    System.out.println("Couldn't find that major!");
                }
            }
            else if (in1 == 4){
                user.Print();
            }
            else if (in1 == 5){
                return;
            }
            else {
                System.out.println("Please enter a valid input!");
            }
        }
    }

    /**
     * Grid Manager; User can choose
     * 1) Display Grid
     * 2) Add Course to Grid
     * 3) Remove Course from Grid
     * 4) Verify Grid
     * 5) Exit
     */
    private void GridManager(){
        Scanner in = new Scanner(System.in);
        user.UpdateGridLibrary(library);
        user.UpdateGridMajor(user.getMajor());
        while (true) {
            System.out.println();
            System.out.println("-------------------------------------------");
            System.out.println();
            System.out.println("GRID MANAGER:");
            System.out.println("1. DISPLAY GRID");
            System.out.println("2. ADD COURSE TO GRID");
            System.out.println("3. REMOVE COURSE FROM GRID");
            System.out.println("4. VERIFY GRID");
            System.out.println("5. EXIT");
            int in1 = in.nextInt();
            in.nextLine();
            if (in1 == 1){
                user.PrintGrid();
            }
            else if (in1 == 2){
                System.out.println("Which year do you want to add the course to?");
                int year = in.nextInt();
                in.nextLine();
                System.out.println("Which quarter do you want to add the course to?");
                int quarter = in.nextInt();
                in.nextLine();
                System.out.println("Which class do you want to add?");
                String in2 = in.nextLine();
                for (Course c : library){
                    if (c.getID().equals(in2)){
                        user.AddCourseToGrid(c, year, quarter);
                    }
                }
            }
            else if (in1 == 3){
                System.out.println("Which year do you want to remove the course from?");
                int year = in.nextInt();
                in.nextLine();
                System.out.println("Which quarter do you want to remove the course from?");
                int quarter = in.nextInt();
                in.nextLine();
                System.out.println("Which class do you want to remove?");
                String in2 = in.nextLine();
                for (Course c : library){
                    if (c.getID().equals(in2)){
                        user.RemoveCourseFromGrid(c, year, quarter);
                    }
                }
            }
            else if (in1 == 4){
                user.VerifyGrid();
            }
            else if (in1 == 5){
                return;
            }
            else {
                System.out.println("Please enter a valid input!");
            }
        }
    }

    /**
     * Major Manager; User can choose
     * 1) Get list of Majors
     * 2) Create Major
     * 3) Go back
     */
    private void MajorManager(){
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println();
            System.out.println("-------------------------------------------");
            System.out.println();
            System.out.println("MAJOR MANAGER:");
            System.out.println("1. GET LIST OF MAJORS");
            System.out.println("2. CREATE MAJOR");
            System.out.println("3. GO BACK");
            int input = in.nextInt();
            in.nextLine();
            if (input == 1) {
                System.out.println("Current Majors:");
                for (Major m : majors) {
                    m.Print();
                }
            }
            else if (input == 2) {
                MajorCreator();
            }
            else if (input == 3) {
                return;
            }
            else {
                System.out.println("Please enter 1, 2, or 3!");
            }
        }
    }

    /**
     * Major Creator: User can create a major and add requirements.
     */
    private void MajorCreator(){
        Scanner in = new Scanner(System.in);
        System.out.println("MAJOR CREATOR");
        System.out.println("Please enter the following fields:");
        System.out.println("Major Title (e.g. Computer Science):");
        String title = in.nextLine();
        System.out.println("Major Department (e.g. Engineering)");
        String dept = in.nextLine();
        Major major = new Major(title, dept);
        while (true) {
            System.out.println();
            System.out.println("-------------------------------------------");
            System.out.println();
            System.out.println("REQUIREMENTS EDITOR:");
            System.out.println("There are four types of Requirements:");
            System.out.println("\t1) AND Lists: all of the courses in this list must be taken.");
            System.out.println("\t2) OR Lists: at LEAST one of the courses in this list must be taken.");
            System.out.println("\t3) Course Count: a specified number of courses from this list must be taken.");
            System.out.println("\t4) Unit Count: a specified number of units from this list must be taken.");
            System.out.println();
            System.out.println("Which Requirement do you wish to add?  Enter a number (enter 5 to exit)");
            int in1 = in.nextInt();
            in.nextLine();
            if (in1 == 5) {
                majors.add(major);
                return;
            } else if (in1 == 1) {
                ANDList r = ANDListCreator();
                major.AddRequirement(r);
            } else if (in1 == 2) {
                ORList r = ORListCreator();
                major.AddRequirement(r);
            } else if (in1 == 3) {
                CoursesCount r = CCountCreator();
                major.AddRequirement(r);
            } else if (in1 == 4) {
                UnitCount r = UnitCountCreator();
                major.AddRequirement(r);
            } else {
                System.out.println("Please enter a valid input:");
            }
        }
    }

    /**
     * Helper function for MajorCreator() - creates an AND List.
     * @return An ANDList
     */
    ANDList ANDListCreator(){
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println("AND LIST CREATOR:");
        System.out.println("All of the classes from this list must be taken.");
        System.out.println("Please enter courses to add to the list.  When you are done, type EXIT.");
        ANDList r = new ANDList();
        while (true){
            String in1 = in.nextLine();
            if (in1.equals("EXIT")){
                return r;
            }
            else {
                for (Course c : library){
                    if (c.getID().equals(in1)){
                        r.AddCourse(c);
                    }
                }
            }
            System.out.println("CURRENT COURSES IN LIST:");
            ArrayList<String> t = r.getCourses();
            for (String s : t){
                System.out.println("\t" + s);
            }
        }
    }

    /**
     * Helper function for MajorCreator().  Returns an OR List.
     * @return An ORList.
     */
    ORList ORListCreator(){
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println("OR LIST CREATOR:");
        System.out.println("At least one of the classes from this list must be taken.");
        System.out.println("Please enter courses to add to the list.  When you are done, type EXIT.");
        ORList r = new ORList();
        while (true){
            String in1 = in.nextLine();
            if (in1.equals("EXIT")){
                return r;
            }
            else {
                for (Course c : library){
                    if (c.getID().equals(in1)){
                        r.AddCourse(c);
                    }
                }
            }
            System.out.println("CURRENT COURSES IN LIST:");
            ArrayList<String> t = r.getCourses();
            for (String s : t){
                System.out.println("\t" + s);
            }
        }
    }

    /**
     * Helper function for MajorCreator().  Returns a CoursesCount.
     * @return A CoursesCount.
     */
    CoursesCount CCountCreator(){
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println("COURSE COUNT CREATOR:");
        System.out.println("At least a specified number of the classes from this list must be taken.");
        System.out.println("How many courses from this list must be taken?");
        int min = in.nextInt();
        in.nextLine();
        CoursesCount r = new CoursesCount(min);
        System.out.println("Please enter courses to add to the list.  When you are done, type EXIT.");
        while (true){
            String in1 = in.nextLine();
            if (in1.equals("EXIT")){
                return r;
            }
            else {
                for (Course c : library){
                    if (c.getID().equals(in1)){
                        r.AddCourse(c);
                    }
                }
            }
            System.out.println("CURRENT COURSES IN LIST:");
            ArrayList<String> t = r.getCourses();
            for (String s : t){
                System.out.println("\t" + s);
            }
        }
    }

    /**
     * Helper function for MajorCreator().  Returns a UnitCount.
     * @return A UnitCount.
     */
    UnitCount UnitCountCreator(){
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println("UNIT COUNT CREATOR:");
        System.out.println("At least a specified number of units from the classes in this list must be taken.");
        System.out.println("How many units from this list must be taken?");
        int min = in.nextInt();
        in.nextLine();
        UnitCount r = new UnitCount(min);
        System.out.println("Please enter courses to add to the list.  When you are done, type EXIT.");
        while (true){
            String in1 = in.nextLine();
            if (in1.equals("EXIT")){
                return r;
            }
            else {
                for (Course c : library){
                    if (c.getID().equals(in1)){
                        r.AddCourse(c);
                    }
                }
            }
            System.out.println("CURRENT COURSES IN LIST:");
            ArrayList<String> t = r.getCourses();
            for (String s : t){
                System.out.println("\t" + s);
            }
        }
    }

    /**
     * Creates a Course with user inputs.
     */
    private void CourseCreator() {
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println("COURSE CREATOR:");
        System.out.println("Please enter the following fields:");
        System.out.println("Course ID (e.g. CMPSC48):");
        String id = in.nextLine();
        System.out.println("Course Title (e.g. Comp Sci Project):");
        String title = in.nextLine();
        System.out.println("Full Course Title (e.g. Computer Science Project):");
        String fulltitle = in.nextLine();
        System.out.println("College (e.g. Engineering)");
        String college = in.nextLine();
        System.out.println("Description:");
        String description = in.nextLine();
        System.out.println("Units:");
        int units = in.nextInt();
        in.nextLine();
        System.out.println("Prerequisites (For a list of courses, type HELP.  When you're done adding prerequisites, type EXIT)");
        Course c = new Course(id, units);
        c.setTitle(title);
        c.setFullTitle(fulltitle);
        c.setCollege(college);
        while (true) {
            System.out.println("Current Prerequisites:");
            ArrayList<String> preq = c.getPrereqs();
            for (String s : preq){
                System.out.println("\t" + c.getID());
            }
            System.out.println("Enter next prerequisite:");
            String in1 = in.nextLine();
            if (in1.equals("HELP")) {
                System.out.println("Current Courses:");
                for (Course course : library) {
                    System.out.println(course.getID() + "\t-\t" + course.getTitle());
                }
            }
            else if (in1.equals("EXIT")) {
                library.add(c);
                return;
            }
            else {
                boolean found = false;
                for (Course course : library) {
                    if (course.getID().equals(in1)) {
                        found = true;
                        c.addPrereq(in1);
                    }
                }
                if (!found) {
                    System.out.println("Couldn't find that course!  Try again.");
                }
            }
        }
    }

    /**
     * Course manager; user can choose
     * 1) Get list of courses
     * 2) Create course
     * 3) Edit Course
     * 4) Go back
     */
    private void CourseManager() {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println();
            System.out.println("-------------------------------------------");
            System.out.println();
            System.out.println("COURSE MANAGER:");
            System.out.println("1. GET LIST OF COURSES");
            System.out.println("2. CREATE COURSE");
            System.out.println("3. GO BACK");
            int input = in.nextInt();
            in.nextLine();
            if (input == 1) {
                System.out.println("Current Courses:");
                for (Course c : library) {
                    System.out.println(c.getID() + "\t-\t" + c.getTitle());
                }
            }
            else if (input == 2) {
                CourseCreator();
            }
            else if (input == 3) {
                return;
            }
            else {
                System.out.println("Please enter 1, 2, or 3!");
            }
        }
    }
}