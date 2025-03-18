//package DAOClasses;
//import EntityClasses.houseDue;
//import java.sql.*;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//public class houseDueDAO {
//
//    // CREATE - Insert a new house dues record
//    public void create(houseDue newHouseDues) {
//        String sqlStmt = "INSERT INTO houseDues (idNumber, houseNumber, occupancyDate, contractExpiration) VALUES (?, ?, ?, ?);";
//        try {
//            DatabaseConnection database = DatabaseConnection.getInstance();
//            Connection conn = database.getConnection();
//
//            // Get the next ID for idNumber
//            PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(idNumber) + 1 AS newID FROM houseDues;");
//            ResultSet rst = pstmt.executeQuery();
//            while (rst.next()) {
//                newHouseDues.setIdNumber(rst.getInt("newID"));
//            }
//
//            // Insert new house dues record
//            pstmt = conn.prepareStatement(sqlStmt);
//            pstmt.setInt(1, newHouseDues.getIdNumber());
//            pstmt.setInt(2, newHouseDues.getHouseNumber());
//            pstmt.setDate(3, Date.valueOf(newHouseDues.getOccupancyDate()));
//            pstmt.setDate(4, Date.valueOf(newHouseDues.getContractExpiration()));
//            pstmt.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // READ - Retrieve a house dues record by idNumber
//    public houseDue read(int idNumber) {
//        return null;
//    }
//
//    // UPDATE - Update an existing house dues record
//    public void update(houseDue updatedHouseDues) {
//        String sqlStmt = "UPDATE houseDues SET houseNumber = ?, occupancyDate = ?, contractExpiration = ? WHERE idNumber = ?;";
//        try {
//            DatabaseConnection database = DatabaseConnection.getInstance();
//            Connection conn = database.getConnection();
//
//            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
//            pstmt.setInt(1, updatedHouseDues.getHouseNumber());
//            pstmt.setDate(2, Date.valueOf(updatedHouseDues.getOccupancyDate()));
//            pstmt.setDate(3, Date.valueOf(updatedHouseDues.getContractExpiration()));
//            pstmt.setInt(4, updatedHouseDues.getIdNumber());
//            pstmt.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // DELETE - Delete a house dues record by idNumber
//    public void delete(int idNumber) {
//        String sqlStmt = "DELETE FROM houseDues WHERE idNumber = ?";
//
//        try {
//            DatabaseConnection database = DatabaseConnection.getInstance();
//            Connection conn = database.getConnection();
//
//            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
//            pstmt.setInt(1, idNumber);
//            pstmt.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
