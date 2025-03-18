package DAOClasses;
import EntityClasses.tenant;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class tenantDAO {
    // CREATE - Insert a new tenant record
    public int create(tenant newTenant) {
        String sqlStmt = "INSERT INTO tenant (tenant_id, " +
                 "tenant_lastName, " +
                 "tenant_firstName, " +
                 "tenant_contactNumber, " +
                 "tenant_email, " +
                 "tenant_houseNumber, " +
                 "occupancyDate, " +
                 "contractExpiration) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            // Insert new tenant record
            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, newTenant.getTenantId());
            pstmt.setString(2, newTenant.getTenantLastName());
            pstmt.setString(3, newTenant.getTenantFirstName());
            pstmt.setString(4, newTenant.getTenantContactNumber());
            pstmt.setString(5, newTenant.getTenantEmail());
            pstmt.setInt(6, newTenant.getTenantHouseNumber());
            Date sqlOccupancyDate = Date.valueOf(newTenant.getOccupancyDate());
            pstmt.setDate(7, sqlOccupancyDate);
            Date sqlContractExpiration = Date.valueOf(newTenant.getContractExpiration());
            pstmt.setDate(8, sqlContractExpiration);
            pstmt.executeUpdate();

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // READ - Retrieve a tenant record by tenant_id (Stubbed to return null)
    public Integer getTenantIdUsingHouseNo(int houseId) {
        String sqlStmt = "SELECT tenant_id FROM tenant WHERE tenant_houseNumber = houseId;";
        try{
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            ResultSet resultSet = pstmt.executeQuery();
            resultSet.next();
            int returnVal = resultSet.getInt("tenant_id");
            
            return returnVal;
            
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }
    
    public tenant getTenantById(int tenantId) {
        String sqlStmt = "SELECT * FROM tenant WHERE tenant_id = ?;";
        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, tenantId);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                tenant tenantRecord = new tenant();
                tenantRecord.setTenantId(resultSet.getInt("tenant_id"));
                tenantRecord.setTenantLastName(resultSet.getString("tenant_lastName"));
                tenantRecord.setTenantFirstName(resultSet.getString("tenant_firstName"));
                tenantRecord.setTenantContactNumber(resultSet.getString("tenant_contactNumber"));
                tenantRecord.setTenantEmail(resultSet.getString("tenant_email"));
                tenantRecord.setTenantHouseNumber(resultSet.getInt("tenant_houseNumber"));
                tenantRecord.setOccupancyDate(resultSet.getDate("occupancyDate").toLocalDate());
                tenantRecord.setContractExpiration(resultSet.getDate("contractExpiration").toLocalDate());
                return tenantRecord;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if no record is found
    }


    // UPDATE - Update an existing tenant record
    public void update(tenant updatedTenant) {
        String sqlStmt = "UPDATE tenant SET " +
                 "tenant_lastName = ?, " +
                 "tenant_firstName = ?, " +
                 "tenant_contactNumber = ?, " +
                 "tenant_email = ?, " +
                 "tenant_houseNumber = ?, " +
                 "occupancyDate = ?, " +
                 "contractExpiration = ? " +
                 "WHERE tenant_id = ?;";

        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setString(1, updatedTenant.getTenantLastName());
            pstmt.setString(2, updatedTenant.getTenantFirstName());
            pstmt.setString(3, updatedTenant.getTenantContactNumber());
            pstmt.setString(4, updatedTenant.getTenantEmail());
            pstmt.setInt(5, updatedTenant.getTenantHouseNumber());
            Date sqlOccupancyDate = Date.valueOf(updatedTenant.getOccupancyDate());
            pstmt.setDate(6, sqlOccupancyDate);
            Date sqlContractExpiration = Date.valueOf(updatedTenant.getContractExpiration());
            pstmt.setDate(7, sqlContractExpiration);
            pstmt.setInt(8, updatedTenant.getTenantId());
            pstmt.executeUpdate();

         
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE - Delete a tenant record by tenant_id
    public void delete(int tenantId) {
        String sqlStmt = "DELETE FROM tenant WHERE tenant_id = ?";

        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, tenantId);
            pstmt.executeUpdate();

          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
