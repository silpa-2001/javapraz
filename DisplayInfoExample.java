import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayInfoExample {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "silpa";
        String password = "silpa";

        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Prepare SQL query
            String query = "SELECT e.eno, e.ename, e.esal, d.dname, d.dloc " +
                           "FROM Emp e " +
                           "JOIN Department d ON e.dno = d.dno " +
                           "WHERE e.eno IN (101, 102)";

            // Create prepared statement
            PreparedStatement pstmt = con.prepareStatement(query);

            // Execute query
            ResultSet rs = pstmt.executeQuery();

            // Display results
            System.out.println("eno\t ename\t  esal\t  dname\t dloc");
            while (rs.next()) {
                int eno = rs.getInt("eno");
                String ename = rs.getString("ename");
                double esal = rs.getDouble("esal");
                String dname = rs.getString("dname");
                String dloc = rs.getString("dloc");
                System.out.println(eno + "\t" + ename + "\t" + esal + "\t " + dname + "\t" + dloc);
            }

            // Close resources
            rs.close();
            pstmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
