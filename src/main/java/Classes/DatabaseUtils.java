package Classes;
import DAOClasses.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtils {
    public static int getLastId(String tableName, String idColumn) throws SQLException {
        DatabaseConnection database = DatabaseConnection.getInstance();
        Connection conn = database.getConnection();
        
        String sql = "SELECT MAX(" + idColumn + ") AS last_id FROM " + tableName + ";";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet resultSet = pstmt.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getInt("last_id"); // Retrieve the last ID
            } else {
                return -1; // No records found in the table
            }
        }
    }
}
