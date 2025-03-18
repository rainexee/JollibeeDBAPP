package DAOClasses;
import EntityClasses.land;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
public class landDAO {

    // CREATE - Insert a new land record
    public int create(land newLand) {
    String sqlStmt = "INSERT INTO land (land_id, " +
                     "land_size, " +
                     "land_price, " +
                     "landprogress, " +
                     "land_sold) " +
                     "VALUES (?, ?, ?, ?, ?);";
    try {
        Connection conn = DatabaseConnection.getInstance().getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
        
        pstmt.setInt(1, newLand.getLandId());
        pstmt.setInt(2, newLand.getSize());
        pstmt.setDouble(3, newLand.getPrice());
        pstmt.setString(4, newLand.getLandProgress());
        pstmt.setBoolean(5, newLand.isLand_sold()); // need to fix
        pstmt.executeUpdate();

        return 1;
    } catch (Exception e) {
        e.printStackTrace();
        return 0;
    }
}


    // READ - Retrieve a land record by land_id
    public land read(int landId) throws SQLException {
        String sqlStmt = "SELECT * FROM land WHERE land_id = ?"; // Adjust table and column names
        land selectedLand = null;

        try{
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, landId);
            ResultSet resultSet = pstmt.executeQuery();
            
            resultSet.next();
            selectedLand = new land();
            selectedLand.setLandId(resultSet.getInt("land_id"));
            selectedLand.setSize(resultSet.getInt("land_size"));
            selectedLand.setPrice(resultSet.getFloat("land_price"));
            selectedLand.setLandProgress(resultSet.getString("landprogress"));
            selectedLand.setLand_sold(resultSet.getBoolean("land_sold"));

            return selectedLand; 
        }catch(Exception e){
            e.printStackTrace();  
            return null;
        }
    }

    // UPDATE - Update an existing land record
    // UPDATE - Update an existing land record
    public int update(land updatedLand) {
        String sqlStmt = "UPDATE land SET " +
                         "land_size = ?, " +
                         "land_price = ?, " +
                         "landprogress = ?, " +
                         "land_sold = ? " +
                         "WHERE land_id = ?;";
        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setDouble(1, updatedLand.getSize());
            pstmt.setDouble(2, updatedLand.getPrice());
            pstmt.setString(3, updatedLand.getLandProgress());
            pstmt.setBoolean(4, updatedLand.isLand_sold());
            pstmt.setInt(5, updatedLand.getLandId());
            pstmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;   
        }
    }


    // DELETE - Delete a land record by land_id
    public int delete(int landId) {
        String sqlStmt = "DELETE FROM land WHERE land_id = ?;";

        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, landId);
            pstmt.executeUpdate();

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public List<Map<String, Object>> fetchLandSalesReport(LocalDate startDate, LocalDate endDate) {
        String sql = "SELECT l.landprogress, COUNT(l.land_sold) AS total_land_bought " +
                     "FROM land l " +
                     "LEFT JOIN sales s ON l.land_id = s.land_id " +
                     "WHERE l.land_sold IS TRUE AND s.sale_date BETWEEN ? AND ? " +
                     "GROUP BY l.landprogress WITH ROLLUP";

        List<Map<String, Object>> resultList = new ArrayList<>();

        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, java.sql.Date.valueOf(startDate));
            pstmt.setDate(2, java.sql.Date.valueOf(endDate));

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                String landProgress = rs.getString("landprogress");

                // Replace NULL with "TOTAL" for rollup rows
                if (landProgress == null) {
                    landProgress = "TOTAL";
                }

                row.put("landprogress", landProgress);
                row.put("total_land_bought", rs.getInt("total_land_bought"));
                resultList.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }
    
}
