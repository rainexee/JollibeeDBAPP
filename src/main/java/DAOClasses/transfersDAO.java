package DAOClasses;
import EntityClasses.transfers;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class transfersDAO {
    
    // CREATE - Insert a new transfer record
    public int create(transfers newTransfer) {
        String sqlStmt = "INSERT INTO transfers (transfer_id, " +
                 "old_ownerID, " +
                 "old_houseOwnerLastName, " +
                 "old_houseOwnerFirstName, " +
                 "new_houseOwnerLastName, " +
                 "new_houseOwnerFirstName, " +
                 "employee_id, " +
                 "sales_id, " +
                 "houseNumber) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            // Insert new transfer record
            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, newTransfer.getTransferId());
            pstmt.setInt(2, newTransfer.getOldOwnerID());
            pstmt.setString(3, newTransfer.getOldHouseOwnerLastName());
            pstmt.setString(4, newTransfer.getOldHouseOwnerFirstName());
            pstmt.setString(5, newTransfer.getNewHouseOwnerLastName());
            pstmt.setString(6, newTransfer.getNewHouseOwnerFirstName());
            pstmt.setInt(7, newTransfer.getEmployeeId());
            pstmt.setInt(8, newTransfer.getSalesId());
            pstmt.setInt(9, newTransfer.getHouseNumber());
            pstmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // READ - Retrieve a transfer record by transfer_id (Stubbed to return null)
    public transfers read(int transferId) {
        return null;
    }

    // UPDATE - Update an existing transfer record
    public void update(transfers updatedTransfer) {
        String sqlStmt = "UPDATE transfers SET " +
                 "oldHouseOwner_lastName = ?, " +
                 "oldHouseOwner_firstName = ?, " +
                 "newHouseOwner_lastName = ?, " +
                 "newHouseOwner_firstName = ?, " +
                 "sales_id = ?, " +
                 "house_number = ? " +
                 "WHERE transfer_id = ?;";

        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setString(1, updatedTransfer.getOldHouseOwnerLastName());
            pstmt.setString(2, updatedTransfer.getOldHouseOwnerFirstName());
            pstmt.setString(3, updatedTransfer.getNewHouseOwnerLastName());
            pstmt.setString(4, updatedTransfer.getNewHouseOwnerFirstName());
            pstmt.setInt(5, updatedTransfer.getSalesId());
            pstmt.setInt(6, updatedTransfer.getHouseNumber());
            pstmt.setInt(7, updatedTransfer.getTransferId());
            pstmt.executeUpdate();

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE - Delete a transfer record by transfer_id
    public void delete(int transferId) {
        String sqlStmt = "DELETE FROM transfers WHERE transfer_id = ?";

        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, transferId);
            pstmt.executeUpdate();

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
