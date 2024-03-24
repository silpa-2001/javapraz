import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableExample {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "silpa";
        String password = "silpa";
        
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);
            
            // Create tables
            Statement stmt = con.createStatement();
            
            // Create Department table
            String createDeptTableQuery = "CREATE TABLE Department (" +
                                         "dno INT PRIMARY KEY, " +
                                         "dname VARCHAR(255), " +
                                         "dloc VARCHAR(255))";
            stmt.executeUpdate(createDeptTableQuery);
            
            // Create Emp table
            String createEmpTableQuery = "CREATE TABLE Emp (" +
                                        "eno INT PRIMARY KEY, " +
                                        "ename VARCHAR(255), " +
                                        "esal DECIMAL(10, 2), " +
                                        "dno INT, " +
                                        "FOREIGN KEY (dno) REFERENCES Department(dno))";
            stmt.executeUpdate(createEmpTableQuery);
            
            System.out.println("Tables created successfully.");
            
            // Close connection
            stmt.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
