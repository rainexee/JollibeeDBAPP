package DAOClasses;

import EntityClasses.house;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

 
public class houseDAO {
    public int create(house newHouse) {
        String sqlStmt = "INSERT INTO house (houseNumber, "
                        + "houseSize, "
                        + "description, "
                        + "dateStarted, "
                        + "dateOfCompletion, "
                        + "house_price, "
                        + "house_address, "
                        + "land_landId, "
                        + "employee_employeeId) "
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try{
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();
            
            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, newHouse.getHouseNumber());
            pstmt.setInt(2, newHouse.getHouseSize());
            pstmt.setString(3, newHouse.getDescription());
            Date sqlDateStarted = Date.valueOf(newHouse.getDateStarted());
            pstmt.setDate(4, sqlDateStarted);
            Date sqlDateCompletion = Date.valueOf(newHouse.getDateOfCompletion());
            pstmt.setDate(5, sqlDateCompletion);
            pstmt.setFloat(6, newHouse.getHousePrice());
            pstmt.setString(7, newHouse.getHouseAddress());
            pstmt.setInt(8, newHouse.getLand_landId());
            pstmt.setInt(9, newHouse.getEmployee_employeeId());
            

            pstmt.executeUpdate();
            
            
            return 1;
        }catch(Exception e){
            e.printStackTrace();      
            return 0;
        }
    }

    //TRANSACTIONS?
    public house read(int id) throws SQLException {
        String sqlStmt = "SELECT * FROM house WHERE houseNumber = ?"; // Adjust table and column names
        house selectedHouse = null;

        try{
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, id);
            ResultSet resultSet = pstmt.executeQuery();
            
            resultSet.next();
            selectedHouse = new house();
            selectedHouse.setHouseNumber(resultSet.getInt("houseNumber")); 
            selectedHouse.setHouseSize(resultSet.getInt("houseSize"));
            selectedHouse.setDescription(resultSet.getString("description"));
            java.sql.Date sqlDateStarted = resultSet.getDate("dateStarted");
            selectedHouse.setDateStarted(sqlDateStarted.toLocalDate());
            java.sql.Date sqlDateOfCompletion = resultSet.getDate("dateOfCompletion");
            selectedHouse.setDateOfCompletion(sqlDateOfCompletion.toLocalDate());
            selectedHouse.setHousePrice(resultSet.getFloat("house_price"));
            selectedHouse.setHouseAddress(resultSet.getString("house_address"));
            selectedHouse.setLand_landId(resultSet.getInt("land_landId"));
            selectedHouse.setEmployee_employeeId(resultSet.getInt("employee_employeeId"));
            
            
           
            return selectedHouse; 
        }catch(Exception e){
            e.printStackTrace();  
            return null;
        }

    }
    
    
    public void update(house newHouse) {
        String sqlStmt = "UPDATE house SET houseSize = ?, "
                + "description = ?, "
                + "dateStarted = ?, "
                + "dateOfCompletion = ?, "
                + "house_price = ?, "
                + "house_address = ?, "
                + "land_landId = ?, "
                + "employee_employeeId = ? "
                + "WHERE houseNumber = ?;";
        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, newHouse.getHouseSize());
            pstmt.setString(2, newHouse.getDescription());
            Date sqlDateStarted = Date.valueOf(newHouse.getDateStarted());
            pstmt.setDate(3, sqlDateStarted);
            Date sqlDateCompletion = Date.valueOf(newHouse.getDateOfCompletion());
            pstmt.setDate(4, sqlDateCompletion);
            pstmt.setFloat(5, newHouse.getHousePrice());
            pstmt.setString(6, newHouse.getHouseAddress());
            pstmt.setInt(7, newHouse.getLand_landId());
            pstmt.setInt(8, newHouse.getEmployee_employeeId());
            pstmt.setInt(9, newHouse.getHouseNumber());
            pstmt.executeUpdate();
        

            
            
        }catch(Exception e){
            e.printStackTrace();        
        }
    }

    public int delete(int id) {
        String sqlStmt = "DELETE FROM house WHERE houseNumber = ?";

        try{
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            
            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            
            return 1;
        }catch(Exception e){
            e.printStackTrace();     
            return 0;
        }
    }
    
    public List<Map<String, Object>> getHouseTenantDetails(int houseNumber, LocalDate occupancyDate) {
        String sql = "SELECT h.houseNumber, h.land_landId, t.tenant_id, t.tenant_lastName, t.tenant_firstName, " +
               "td.tenant_dues, t.occupancyDate, t.contractExpiration " +
               "FROM house h " +
               "JOIN tenant t ON h.houseNumber = t.tenant_houseNumber " +
               "JOIN tenant_dues td ON t.tenant_id = td.tenant_id " +
               "WHERE ? BETWEEN t.occupancyDate AND t.contractExpiration " +
               "AND h.houseNumber = ?";

        List<Map<String, Object>> resultList = new ArrayList<>();

        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setDate(1, java.sql.Date.valueOf(occupancyDate));
            pstmt.setInt(2, houseNumber);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("houseNumber", rs.getInt("houseNumber"));
                row.put("land_landId", rs.getInt("land_landId"));
                row.put("tenant_id", rs.getInt("tenant_id"));
                row.put("tenant_lastName", rs.getString("tenant_lastName"));
                row.put("tenant_firstName", rs.getString("tenant_firstName"));
                row.put("tenant_dues", rs.getDouble("tenant_dues"));
                row.put("occupancyDate", rs.getDate("occupancyDate").toLocalDate());
                row.put("contractExpiration", rs.getDate("contractExpiration").toLocalDate());
                resultList.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

}
