import java.util.ArrayList;

public class Grid{

    // [year] [quarter]
    private Quarter[][] grid = new Quarter[4][3];
    private ArrayList<Course> library = new ArrayList<>();
    private Major major;

    public Grid() {}

    public Grid(ArrayList<Course> library){
        this.library = library;
        InitializeArray();
    }

    public Grid(ArrayList<Course> library, Major major){
        this.library = library;
        this.major = major;
        InitializeArray();
    }

    private void InitializeArray(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                grid[i][j] = new Quarter();
            }
        }
    }

    public void UpdateLibrary(ArrayList<Course> library){
        this.library = library;
    }

    /**
     * Updates the major this Grid is going to use to verify classes.
     * User will call this function on its grid object, passing its major to it.
     * @param major The Major object user will send to this function
     */
    public void UpdateMajor(Major major){
        this.major = major;
    }

     /**
      * Adds a course to the grid.  Calls verify at the end to determine if the add produces an error.
      * @param c Course object you wish to add
      * @param year The year in which you wish to add the class
      * @param quarter The quarter in which you wish to add the class
      */
    public void AddCourse(Course c, int year, int quarter){
        grid[year - 1][quarter - 1].add(c);

    }

     /**
      * Deletes a course from the grid.  Calls verify at the end to determine if the delete produces an error.
      * @param c Course object you wish to add
      * @param year Year you want to add the class to
      * @param quarter Quarter you want to add the class to
      */
    public void DeleteCourse(Course c, int year, int quarter){
        grid[year - 1][quarter - 1].remove(c);
    }

    public void PrintGrid(){
        for (int i = 0; i < grid.length; i++){
            System.out.println("--------------------------------------");
            System.out.println("YEAR " + (i + 1) + ":");
            for (int j = 0; j < grid[i].length; j++){
                System.out.println("- - - - - - - - -");
                System.out.println("\tQUARTER " + (j + 1) + ": ");
                grid[i][j].Print();
                System.out.println("- - - - - - - - -");
            }
            System.out.println("--------------------------------------");
            System.out.println();
        }
    }

    /**
    Checks to see if the grid is currently valid and produces an error otherwise.
     */
    public void Verify(){

        ArrayList<Course> tempLibrary = new ArrayList<>();

        boolean prereqsGood = true;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                for (Course c : grid[i][j].getCourses()) {
                    if (!(c.CheckPrereqs(tempLibrary))) {
                        System.out.println("MISSING PREREQUISITE(S) FOR " + c.getID() + "!");
                        prereqsGood = false;
                    }
                }
                tempLibrary.addAll(grid[i][j].getCourses());
            }
        }

        if (prereqsGood) {
            System.out.println("All Course Prerequisites met.");
        }

        System.out.println();

        if (major.CheckRequirements(tempLibrary)){
            System.out.println("SUCCESS - You've met the requirements of your major!");
        }
        else{
            System.out.println("FAILURE - You have not met the requirements of your major.");
        }

    }

 }