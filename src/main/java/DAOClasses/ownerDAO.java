package DAOClasses;
import EntityClasses.owner;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ownerDAO {

    // CREATE - Insert a new owner record
    public int create(owner newOwner) {
        String sqlStmt = "INSERT INTO house_owner (owner_id, " +
                         "owner_lastName, " +
                         "owner_firstName, " +
                         "owner_email, " +
                         "owner_phoneNumber, " +
                         "house_houseNumber, " +
                         "owner_startDate, " +
                         "owner_endDate) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();


            // Insert new owner record
            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, newOwner.getIdNumber());
            pstmt.setString(2, newOwner.getLastName());
            pstmt.setString(3, newOwner.getFirstName());
            pstmt.setString(4, newOwner.getEmail());
            pstmt.setString(5, newOwner.getPhoneNumber());
            pstmt.setInt(6, newOwner.getHouseNumber());
            Date sqlStartDate = Date.valueOf(newOwner.getStart_date());
            Date sqlEndDate = Date.valueOf(newOwner.getEnd_date());
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
    public owner read(int ownerId) {
        String sqlStmt = "SELECT * FROM house_owner WHERE owner_id = ?;"; // Adjust table and column names
        owner selectedOwner = null;

        try{
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, ownerId);
            ResultSet resultSet = pstmt.executeQuery();
            
            resultSet.next();
            selectedOwner = new owner();
            selectedOwner.setOwnerId(resultSet.getInt("owner_id")); 
            selectedOwner.setLastName(resultSet.getString("owner_lastName"));
            selectedOwner.setFirstName(resultSet.getString("owner_firstName"));
            selectedOwner.setEmail(resultSet.getString("owner_email"));
            selectedOwner.setPhoneNumber(resultSet.getString("owner_phoneNumber"));
            selectedOwner.setHouseNumber(resultSet.getInt("house_houseNumber"));
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
    public int update(owner updatedOwner) {
        String sqlStmt = "UPDATE house_owner SET " +
                         "owner_lastName = ?, " +
                         "owner_firstName = ?, " +
                         "owner_email = ?, " +
                         "owner_phoneNumber = ?, " +
                         "house_houseNumber = ?, " +
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
            pstmt.setInt(5, updatedOwner.getHouseNumber());
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
        String sqlStmt = "DELETE FROM house_owner WHERE owner_id = ?";

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

