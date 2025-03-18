package DAOClasses;
import EntityClasses.landOwner;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class landOwnerDAO {

    // CREATE - Insert a new owner record
    public int create(landOwner newLandOwner) {
        String sqlStmt = "INSERT INTO land_owner (owner_id, " +
                         "owner_lastName, " +
                         "owner_firstName, " +
                         "owner_email, " +
                         "owner_phoneNumber, " +
                         "land_landNumber, " +
                         "owner_startDate, " +
                         "owner_endDate) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();


            // Insert new owner record
            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, newLandOwner.getIdNumber());
            pstmt.setString(2, newLandOwner.getLastName());
            pstmt.setString(3, newLandOwner.getFirstName());
            pstmt.setString(4, newLandOwner.getEmail());
            pstmt.setString(5, newLandOwner.getPhoneNumber());
            pstmt.setInt(6, newLandOwner.getlandNumber());
            Date sqlStartDate = Date.valueOf(newLandOwner.getStart_date());
            Date sqlEndDate = Date.valueOf(newLandOwner.getEnd_date());
            pstmt.setDate(7, sqlStartDate);
            pstmt.setDate(8, sqlEndDate);
            pstmt.executeUpdate();

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
}


    // READ - Retrieve an owner record by owner_id (Stubbed to return null as per request)
    public landOwner read(int landOwnerId) {
        String sqlStmt = "SELECT * FROM land_owner WHERE owner_id = ?;"; // Adjust table and column names
        landOwner selectedOwner = null;

        try{
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, landOwnerId);
            ResultSet resultSet = pstmt.executeQuery();
            
            resultSet.next();
            selectedOwner = new landOwner();
            selectedOwner.setOwnerId(resultSet.getInt("owner_id")); 
            selectedOwner.setLastName(resultSet.getString("owner_lastName"));
            selectedOwner.setFirstName(resultSet.getString("owner_firstName"));
            selectedOwner.setEmail(resultSet.getString("owner_email"));
            selectedOwner.setPhoneNumber(resultSet.getString("owner_phoneNumber"));
            selectedOwner.setlandNumber(resultSet.getInt("land_landNumber"));
            java.sql.Date ownerStartDate = resultSet.getDate("owner_startDate");
            selectedOwner.setStart_date(ownerStartDate.toLocalDate());
            java.sql.Date ownerEndDate = resultSet.getDate("owner_endDate");
            selectedOwner.setEnd_date(ownerEndDate.toLocalDate());
            
            
           
            return selectedOwner; 
        }catch(Exception e){
            e.printStackTrace();  
            return null;
        }
    }

    // UPDATE - Update an existing owner record
    public int update(landOwner updatedOwner) {
        String sqlStmt = "UPDATE land_owner SET " +
                         "owner_lastName = ?, " +
                         "owner_firstName = ?, " +
                         "owner_email = ?, " +
                         "owner_phoneNumber = ?, " +
                         "land_landNumber = ?, " +
                         "owner_startDate = ?, " +
                         "owner_endDate = ? " +
                         "WHERE owner_id = ?;";
        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setString(1, updatedOwner.getLastName());
            pstmt.setString(2, updatedOwner.getFirstName());
            pstmt.setString(3, updatedOwner.getEmail());
            pstmt.setString(4, updatedOwner.getPhoneNumber());
            pstmt.setInt(5, updatedOwner.getlandNumber());
            pstmt.setDate(6, Date.valueOf(updatedOwner.getStart_date()));
            pstmt.setDate(7, Date.valueOf(updatedOwner.getEnd_date()));
            pstmt.setInt(8, updatedOwner.getOwnerId());
            pstmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    // DELETE - Delete an owner record by owner_id
    public int delete(int ownerId) {
        String sqlStmt = "DELETE FROM land_owner WHERE owner_id = ?";

        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, ownerId);
            pstmt.executeUpdate();

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

