/*CREATE OR REPLACE PROCEDURE insert_department(
    dno_param IN INT,
    dname_param IN VARCHAR2,
    dloc_param IN VARCHAR2
)
AS
BEGIN
    INSERT INTO Department(dno, dname, dloc) VALUES(dno_param, dname_param, dloc_param);
    COMMIT;
END;
/*/

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertDepartmentExample {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "silpa";
        String password = "silpa";

        try {
            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Define the SQL call to stored procedure
            String sql = "{ call insert_department(?, ?, ?) }";

            // Create CallableStatement
            CallableStatement cstmt = con.prepareCall(sql);

            // Set parameter values
            cstmt.setInt(1, 1);          // dno
            cstmt.setString(2, "IT");    // dname
            cstmt.setString(3, "New York"); // dloc

            // Execute stored procedure
            cstmt.execute();

            System.out.println("Record inserted successfully.");

            // Close resources
            cstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
