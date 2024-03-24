/*CREATE OR REPLACE PROCEDURE display_employees_info (c_out OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN c_out FOR
    SELECT ename, esal FROM Emp;
END;
/*/

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleTypes;

public class DisplayEmployeesInfo {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "silpa";
        String password = "silpa";

        try {
            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Define the SQL call to stored procedure
            String sql = "{ call display_employees_info(?) }";

            // Create CallableStatement
            CallableStatement cstmt = con.prepareCall(sql);

            // Register the output parameter
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);

            // Execute stored procedure
            cstmt.execute();

            // Retrieve the result set
            ResultSet rs = (ResultSet) cstmt.getObject(1);

            // Iterate over the result set and display the data
            while (rs.next()) {
                String ename = rs.getString("ename");
                double esal = rs.getDouble("esal");
                System.out.println("Employee Name: " + ename + ", Salary: " + esal);
            }

            // Close resources
            rs.close();
            cstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
