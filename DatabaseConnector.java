import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnector {
    private Connection connection;
    private String url;
    private String username;
    private String password;

    // Constructor to initialize database connection parameters
    public DatabaseConnector(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Method to establish database connection
    public void connect() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to database.");
    }

    // Method to close database connection
    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Disconnected from database.");
        }
    }

    // Method to execute a SQL query and return the ResultSet
    public ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "silpa";
        String password = "silpa";

        DatabaseConnector connector = new DatabaseConnector(url, username, password);

        try {
            connector.connect();
            ResultSet resultSet = connector.executeQuery("SELECT * FROM Emp");
            while (resultSet.next()) {
                // Process rows from the result set
                int eno = resultSet.getInt("eno");
                String ename = resultSet.getString("ename");
                double esal = resultSet.getDouble("esal");
                System.out.println("Employee: " + eno + ", " + ename + ", " + esal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connector.disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
