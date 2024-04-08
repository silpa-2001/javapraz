import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListRecordsExample {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "silpa";
        String password = "silpa";

        try {
            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Define the SQL query with parameter
            String selectQuery = "SELECT * FROM Emp WHERE ename LIKE ?";

            // Create prepared statement
            PreparedStatement pstmt = con.prepareStatement(selectQuery);

            // Set parameter value
            pstmt.setString(1, "R%"); // The "%" acts as a wildcard for any characters after "R"

            // Execute query
            ResultSet rs = pstmt.executeQuery();

            // Display results
            System.out.println("eno\t ename\t  esal\t   dno");
            while (rs.next()) {
                int eno = rs.getInt("eno");
                String ename = rs.getString("ename");
                double esal = rs.getDouble("esal");
                int dno = rs.getInt("dno");
                System.out.println(eno + "\t " + ename + "\t " + esal + "\t " + dno);
            }

            // Close resources
            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
