import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionExample {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "silpa";
        String password = "silpa";

        Connection con = null;
        Statement stmt = null;

        try {
            // Establish connection
            con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false); // Disable auto-commit mode

            // Create a Statement object
            stmt = con.createStatement();

            // Perform multiple database operations within the transaction
            stmt.executeUpdate("INSERT INTO Department VALUES (101, 'IT', 'New York')");
            stmt.executeUpdate("INSERT INTO Department VALUES (102, 'HR', 'London')");

            // Commit the transaction
            con.commit();
            System.out.println("Transaction committed successfully.");
        } catch (SQLException e) {
            try {
                // Rollback the transaction if any exception occurs
                if (con != null) {
                    con.rollback();
                    System.out.println("Transaction rolled back successfully.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                // Close resources
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
