import java.util.ArrayList;

public class Driver {

    public static void main (String args[]){
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
        Course upper1 = new Course("UPPER1", 4);
        Course upper2 = new Course("UPPER2", 4);
        Course upper3 = new Course("UPPER3", 4);
        Course upper4 = new Course("UPPER4", 4);
        Course upper5 = new Course("UPPER5", 4);
        Course upper6 = new Course("UPPER6", 4);
        Course random1 = new Course("RANDOM1", 4);
        Course random2 = new Course("RANDOM2", 4);
        Course random3 = new Course("RANDOM3", 4);
        Course random4 = new Course("RANDOM4", 4);
        Course random5 = new Course("RANDOM5", 4);
        Course random6 = new Course("RANDOM6", 4);
        Course random7 = new Course("RANDOM7", 4);
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
