package servlet;
import java.util.ArrayList;

/**
 * A Class containing a 2D Array (grid) of Quarters that contain a list of Courses.
 */
public class Grid{

    // [year] [quarter]
    private Quarter[][] grid = new Quarter[4][3];
    private ArrayList<Course> library = new ArrayList<Course>();
    private Major major;

    /**
     * Default Constructor for Grid.
     */
    public Grid() {
        InitializeArray();
    }

    /**
     * Constructor for Grid.
     * @param library Library of Courses to be used by the Grid
     */
    public Grid(ArrayList<Course> library){
        this.library = library;
        InitializeArray();
    }

    /**
     * Constructor for Grid.
     * @param library Library of Courses to be used by the Grid
     * @param major The Major against which to check Requirements
     */
    public Grid(ArrayList<Course> library, Major major){
        this.library = library;
        this.major = major;
        InitializeArray();
    }

    /**
     * Helper function for the Constructor which initializes each Quarter object in the 2D array.
     */
    private void InitializeArray(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 3; j++){
                grid[i][j] = new Quarter();
            }
        }
    }

    /**
     * Updates the current Course library.
     * @param library The new Library to be used by the Grid.
     */
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
        if (year < 1 || year > 4 || quarter < 1 || quarter > 3){
            System.out.println("ERROR: Year or quarter exceeded bounds.  There's only 4 years and 3 quarters!");
            return;
        }
        grid[year - 1][quarter - 1].add(c);
    }

     /**
      * Deletes a course from the grid.  Calls verify at the end to determine if the delete produces an error.
      * @param c Course object you wish to add
      * @param year Year you want to add the class to
      * @param quarter Quarter you want to add the class to
      */
    public void DeleteCourse(Course c, int year, int quarter){
        if (year < 1 || year > 4 || quarter < 1 || quarter > 3){
            System.out.println("ERROR: Year or quarter exceeded bounds.  There's only 4 years and 3 quarters!");
            return;
        }
        grid[year - 1][quarter - 1].remove(c);
    }

    /**
     * Gets the quarter
     * @param year Number of year
     * @param quarter Number of quarter (Fall=0,Winter=1,Spring=2)
     * @return
     */
    public Quarter getQuarter(int year, int quarter){
        return this.grid[year][quarter];
    }
    /**
     * Prints the current Grid.
     */
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
    public Response Verify(){

        ArrayList<Course> tempLibrary = new ArrayList<Course>();
        String messages = "";
        boolean prereqsGood = true;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                for (Course c : grid[i][j].getCourses()) {
                    if (!(c.CheckPrereqs(tempLibrary))) {
                        messages += ("MISSING PREREQUISITE(S) FOR " + c.getID() + "!\n");
                        prereqsGood = false;
                    }
                }
                tempLibrary.addAll(grid[i][j].getCourses());
            }
        }

        if (prereqsGood) {
            messages += ("All Course Prerequisites met.\n");
        }

        System.out.println();

        if (major.CheckRequirements(tempLibrary)){
            messages += ("SUCCESS - You've met the requirements of your major!\n");

        }
        else{
            messages +=("FAILURE - You have not met the requirements of your major.\n");
        }
        return new Response(messages);
    }

 }