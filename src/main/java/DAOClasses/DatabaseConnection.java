package DAOClasses; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    /* ================ CHANGE AS NEEDED ================ */
    private final String url = "jdbc:mysql://localhost:3306/Residence_SQL_test";
    private final String username = "root";
    private final String password = "Demisemiquaver_32";

    // Private constructor prevents instantiation from outside the class
    private DatabaseConnection() throws SQLException {
        try {
            // Load the JDBC driver (optional for newer JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            throw new SQLException("Database connection creation failed: " + ex.getMessage());
        }
    }

    // Public static method to get the single instance
    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {  // Double-checked locking
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    // Public method to get the Connection object
    public Connection getConnection() {
        return connection;
    }
    
    public void closeConnection() {
    if (connection != null) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

}