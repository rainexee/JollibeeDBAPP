package DAOClasses;
import EntityClasses.sales;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
public class salesDAO {
   
    // CREATE - Insert a new sales record
    public int create(sales newSale) {
        String sqlStmt = "INSERT INTO sales (sales_id, " +
                 "employee_id, " +
                 "owner_id, " +
                 "sale_category, " +
                 "houseNumber, " +
                 "land_id, " +
                 "transfer_id, " +
                 "amount_paid, " +
                 "sale_date) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();


            // Insert new sales record
            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, newSale.getSalesId());
            pstmt.setInt(2, newSale.getEmployeeId());
            pstmt.setInt(3, newSale.getOwnerId()); 
            pstmt.setString(4, newSale.getSaleCategory());
            pstmt.setInt(5, newSale.getHouseNumber());
            pstmt.setInt(6, newSale.getLandId());
            pstmt.setInt(7, newSale.getTransferId());
            pstmt.setFloat(8, newSale.getAmountPaid());
            Date sqlSaleDate = Date.valueOf(newSale.getSaleDate());
            pstmt.setDate(9, sqlSaleDate);
            pstmt.executeUpdate();
            
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // READ - Retrieve a sales record by sales_id (Stubbed to return null)
    public sales read(int salesId) {
        return null;
    }

    // UPDATE - Update an existing sales record
    public void update(sales updatedSale) {
        String sqlStmt = "UPDATE sales SET " +
                         "employee_id = ?, " +
                         "owner_id = ?, " +
                         "sale_category = ?, " +
                         "house_number = ?, " +
                         "land_id = ?, " +
                         "transfer_id = ?, " +
                         "amount_paid = ?, " +
                         "sale_date = ? " +
                         "WHERE sales_id = ?;";
        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, updatedSale.getEmployeeId());
            pstmt.setInt(2, updatedSale.getOwnerId());
            pstmt.setString(3, updatedSale.getSaleCategory());
            pstmt.setInt(4, updatedSale.getHouseNumber());
            pstmt.setInt(5, updatedSale.getLandId());
            pstmt.setInt(6, updatedSale.getTransferId());
            pstmt.setFloat(7, updatedSale.getAmountPaid());
            Date sqlSaleDate = Date.valueOf(updatedSale.getSaleDate());
            pstmt.setDate(8, sqlSaleDate);
            pstmt.setInt(9, updatedSale.getSalesId());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
}

    // DELETE - Delete a sales record by sales_id
    public void delete(int salesId) {
        String sqlStmt = "DELETE FROM sales WHERE sales_id = ?";

        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, salesId);
            pstmt.executeUpdate();

          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Map<String, Object>> getSalesReport(LocalDate startDate, LocalDate endDate) {
        // SQL query to fetch sales data between two dates
        String sql = "SELECT s.sale_date AS Date_Sold, h.houseNumber, l.land_id "
                + "FROM house h "
                + "JOIN land l ON l.land_id = h.land_landId "
                + "JOIN sales s ON s.houseNumber = h.houseNumber "
                + "WHERE s.sale_date BETWEEN ? AND ? "
                + "ORDER BY s.sale_date;";

        // List to hold the result
        List<Map<String, Object>> resultList = new ArrayList<>();

        try {
            // Get database connection
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            // Prepare the statement with the date range parameters
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, java.sql.Date.valueOf(startDate));
            pstmt.setDate(2, java.sql.Date.valueOf(endDate));

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Loop through the result set and store data in the result list
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("Date_Sold", rs.getDate("Date_Sold").toLocalDate());  // Convert to LocalDate
                row.put("houseNumber", rs.getInt("houseNumber"));
                row.put("land_id", rs.getInt("land_id"));
                resultList.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

}
