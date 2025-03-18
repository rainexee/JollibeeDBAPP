package DAOClasses;
import EntityClasses.tenantRent;
import java.sql.*;
import java.util.List;

public class tenantRentDAO{

    // CREATE - Insert a new tenant rent record
    public int create(tenantRent newTenantRent) {
        String sqlStmt = "INSERT INTO tenant_dues (tenant_id, " +
                         "tenant_dues, " +
                         "tenant_datePaid, " +
                         "tenant_dueDate) " +
                         "VALUES (?, ?, ?, ?);";

        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            // Insert new tenant rent record
            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, newTenantRent.getTenantId());
            pstmt.setFloat(2, newTenantRent.getTenantDues());
            Date sqlDatePaid = Date.valueOf(newTenantRent.getDatePaid());
            pstmt.setDate(3, sqlDatePaid);
            Date sqlDueDate = Date.valueOf(newTenantRent.getDueDate());
            pstmt.setDate(4, sqlDueDate);
            pstmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // READ - Retrieve a tenant rent record by tenant_id (Stubbed to return null)
    public Boolean find(int tenantId) throws SQLException {
        String sqlStmt = "SELECT * FROM tenant_dues WHERE tenant_id = ?;"; // Adjust table and column names
        tenantRent selectedLand = null;

        try{
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, tenantId);
            ResultSet resultSet = pstmt.executeQuery();
            
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            } 
        }catch(Exception e){  
            e.printStackTrace();
            return null;
        }
    }

    // UPDATE - Update an existing tenant rent record
    public int update(tenantRent updatedTenantRent) {
        String sqlStmt = "UPDATE tenant_dues SET " +
                         "tenant_dues = ?, " +
                         "tenant_datePaid = ?, " +
                         "tenant_dueDate = ? " +
                         "WHERE tenant_id = ?;";

        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setFloat(1, updatedTenantRent.getTenantDues());
            Date sqlDatePaid = Date.valueOf(updatedTenantRent.getDatePaid());
            pstmt.setDate(2, sqlDatePaid);
            Date sqlDueDate = Date.valueOf(updatedTenantRent.getDueDate());
            pstmt.setDate(3, sqlDueDate);
            pstmt.setInt(4, updatedTenantRent.getTenantId());
            pstmt.executeUpdate();

           return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // DELETE - Delete a tenant rent record by tenant_id and house_number
    public void delete(int tenantId, int houseNumber) {
        String sqlStmt = "DELETE FROM tenant_rent WHERE tenant_id = ? AND house_number = ?";

        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, tenantId);
            pstmt.setInt(2, houseNumber);
            pstmt.executeUpdate();

          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
