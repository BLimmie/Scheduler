import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    public static void main(String args[]) {
        System.out.println("Welcome to the FOUR YEAR PLANNER.");
        System.out.println("Creating courses...");
        Course cs16 = new Course("CS16", 4);
        Course cs24 = new Course("CS24", 4);
        Course cs32 = new Course("CS32", 4);
        Course cs40 = new Course("CS40", 5);
        Course cs56 = new Course("CS56", 4);
        Course cs64 = new Course("CS64", 4);
        Course cs48 = new Course("CS48", 4);
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
        System.out.println("Courses created.");
        System.out.println("Adding prerequisites");
        cs24.addPrereq(cs16);
        cs32.addPrereq(cs24);
        cs56.addPrereq(cs32);
        cs64.addPrereq(cs56);
        System.out.println("Added Prerequisites");
        System.out.println("Adding them to the library...");
        ArrayList<Course> library = new ArrayList<>();
        library.add(cs16);
        library.add(cs24);
        library.add(cs32);
        library.add(cs56);
        library.add(cs40);
        library.add(cs64);
        library.add(cs48);
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

        System.out.println("Added to library successfully.");

        Major major = new Major("Computer Science", "College of Engineering");

        System.out.println("Created major - creating requirements now:");

        // LOWER DIVS
        ANDList r1 = new ANDList();
        r1.AddCourse(cs16);
        r1.AddCourse(cs24);
        r1.AddCourse(cs32);
        r1.AddCourse(cs40);
        r1.AddCourse(cs56);
        r1.AddCourse(cs64);
        r1.AddCourse(cs48);

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

        System.out.println("Requirements created and added.  Building grid now.");

        Grid grid = new Grid(library, major);

        System.out.println("Grid created.  Testing display 1");
        //System.out.println("SHOULD BE EMPTY");
        //grid.PrintGrid();
        grid.AddCourse(cs16, 1, 1);
        grid.AddCourse(cs24, 1, 2);
        grid.AddCourse(cs32, 1, 3);
        grid.AddCourse(cs56, 2, 1);
        grid.AddCourse(cs40, 2, 1);
        grid.AddCourse(cs64, 2, 2);
        grid.AddCourse(cs48, 2, 3);
        grid.PrintGrid();
        System.out.println("VERIFYING GRID");
        grid.Verify();
        grid.AddCourse(random1, 3, 1);
        grid.AddCourse(random2, 3, 1);
        grid.AddCourse(random3, 3, 2);
        grid.AddCourse(cs130a, 3, 2);
        grid.AddCourse(cs130b, 3, 3);
        grid.AddCourse(cs138, 4, 1);
        grid.PrintGrid();
        grid.Verify();
    }
}

    /*
    public Driver(){

    }

    public ArrayList<Course> loadCourses(){
        Course cs16 = new Course("CS16", 4);
        Course cs24 = new Course("CS24", 4);
        Course cs32 = new Course("CS32", 4);
        Course cs40 = new Course("CS40", 5);
        Course cs56 = new Course("CS56", 4);
        Course cs64 = new Course("CS64", 4);
        Course cs48 = new Course("CS48", 4);
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

        ArrayList<Course> library = new ArrayList<>();
        library.add(cs16);
        library.add(cs24);
        library.add(cs32);
        library.add(cs56);
        library.add(cs40);
        library.add(cs64);
        library.add(cs48);
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
        return library;
    }

    public ArrayList<Major> loadMajors(){
        Major major = new Major("Computer Science", "College of Engineering");

        // LOWER DIVS
        ANDList r1 = new ANDList();
        r1.AddCourse("CS16");
        r1.AddCourse("CS24");
        r1.AddCourse("CS32");
        r1.AddCourse("CS40");
        r1.AddCourse("CS56");
        r1.AddCourse("CS64");
        r1.AddCourse("CS48");

        // UPPER DIVS (TAKE 4 OF A LIST OF 6)
        CoursesCount r2 = new CoursesCount(4);
        r2.AddCourse("CS178");
        r2.AddCourse("CS177");
        r2.AddCourse("CS170");
        r2.AddCourse("CS154");
        r2.AddCourse("CS166");
        r2.AddCourse("CS199");

        // ELECTIVES (TAKE 16 UNITS OF 7 COURSES)
        UnitCount r3 = new UnitCount(16);
        r3.AddCourse("EARTH7");
        r3.AddCourse("ARTHI6A");
        r3.AddCourse("ARTHI6C");
        r3.AddCourse("CLASS40");
        r3.AddCourse("CLASS20B");
        r3.AddCourse("GREEK199");
        r3.AddCourse("HIST2C");

        major.AddRequirement(r1);
        major.AddRequirement(r2);
        major.AddRequirement(r3);

        ArrayList<Major> majors = new ArrayList<>();
        majors.add(major);
        return majors;
    }

    public void MainMenu(){
        Scanner in = new Scanner(System.in);
        System.out.println("WELCOME TO OUR FOUR YEAR PLANNER");
        System.out.println("--");
        System.out.println("MAIN MENU:");
        System.out.println("1: Create Student Profile");
        System.out.println("2: Create Admin Profile");
        System.out.println("3: Log into existing Student Profile");
        System.out.println("4: Log into existing Admin Profile");
        System.out.println();
        int i = in.nextInt();
        boolean moveOn = false;
        while (!moveOn) {
            if (i == 1) {
                User student = CreateStudent();
                //StudentManager(student);
                moveOn = true;
            } else if (i == 2) {
                //Admin admin = CreateAdmin();
                //AdminManager(admin);
                moveOn = true;
            } else {
                System.out.println("ERROR - please enter 1 or 2");
            }
        }
    }

    private User CreateStudent(){
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("------------------------------");
        System.out.println();
        System.out.println("Enter your first name:");
        String firstName = in.nextLine();
        System.out.println("Enter your last name:");
        String lastName = in.nextLine();
        System.out.println("Enter a password:");
        String password = in.nextLine();
        ArrayList<Course> library = loadCourses();
        ArrayList<Major> majors = loadMajors();
        Major major;
        String majorTitle;
        boolean proceed = false;
        while (!proceed) {
            System.out.println("What is your major? (type HELP for a list of majors/departments)");
            String i = in.nextLine();
            if (i.equals("HELP")) {
                for (Major m : majors) {
                    m.Print();
                }
            } else {
                for (Major m : majors) {
                    if (m.getTitle().equals(i)) {
                        proceed = true;
                        majorTitle = i;
                    }
                }
                if (!proceed){
                    System.out.println("I'm sorry, we don't seem to offer that major!");
                }
            }
        }
        proceed = false;
        while (!proceed){
            System.out.println("In which department is your major offered? (type HELP for a list of majors/departments)");
            String i = in.nextLine();
            if (i.equals("HELP")) {
                for (Major m : majors) {
                    m.Print();
                }
            } else {
                for (Major m : majors) {
                    if ((m.getTitle().equals(majorTitle)) && (m.getDepartment().equals(i))) {
                        proceed = true;
                        major = m;
                    }
                }
                if (!proceed){
                    System.out.println("I'm sorry, your major doesn't match the department you specified!");
                }
            }
        }

        Grid grid = new Grid(library, major);
        User student = new User(firstName, lastName, password, major, grid);
        return student;
    }

    void CreateAdmin(){
        Scanner in = new Scanner(System.in);
    }

    public void StudentInterface(){

    }
}
*/