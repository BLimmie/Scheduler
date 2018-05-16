import java.sql.Connection;
import java.sql.DriverManager;

public class Controller {
    public static void main(String args[]) {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection(
                            "postgres://wzaiqauiwsqjec:7d427376d5a2e2ce6c5469f41111d80a856516d8b25037c92ac67b8bebaabf08@ec2-54-197-250-121.compute-1.amazonaws.com:5432/df46dgbjaokp5t"
                    );
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }


}
