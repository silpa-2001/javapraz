import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateRecordExample {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "silpa";
        String password = "silpa";
        
        // Rani's new salary
        double newSalary = 15000;

        try {
            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Define the SQL query with parameters
            String updateQuery = "UPDATE Emp SET esal = ? WHERE ename = ?";
            
            // Create prepared statement
            PreparedStatement pstmt = con.prepareStatement(updateQuery);
            
            // Set parameters
            pstmt.setDouble(1, newSalary); // set the new salary
            pstmt.setString(2, "Rani");   // specify the employee name
            
            // Execute the update operation
            int rowsUpdated = pstmt.executeUpdate();
            
            if (rowsUpdated > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No record updated.");
            }

            // Close resources
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
