import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLWarning;

public class SQLExceptionExample {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "silpa";
        String password = "silpa";

        try {
            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create a Statement object
            Statement stmt = con.createStatement();

            // Execute a query that may cause SQLException
            ResultSet rs = stmt.executeQuery("SELECT * FROM NonExistentTable");

            // Handle SQLWarning
            SQLWarning warning = stmt.getWarnings();
            if (warning != null) {
                System.out.println("SQLWarning occurred:");
                while (warning != null) {
                    System.out.println("Message: " + warning.getMessage());
                    System.out.println("SQLState: " + warning.getSQLState());
                    System.out.println("Error code: " + warning.getErrorCode());
                    warning = warning.getNextWarning();
                }
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            // Handle SQLException
            System.out.println("SQLException occurred:");
            System.out.println("Message: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Error code: " + e.getErrorCode());
            e.printStackTrace();
        }
    }
}
