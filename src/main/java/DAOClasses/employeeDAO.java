package DAOClasses;
import EntityClasses.employee;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class employeeDAO {

    // CREATE - Insert a new employee record
    public int create(employee newEmployee) {
        String sqlStmt = "INSERT INTO employee ("
                + "employee_id, "
                + "employee_lastName, "
                + "employee_firstName, "
                + "employee_email, "
                + "employee_phoneNumber) "
                + "VALUES (?, ?, ?, ?, ?);";
        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();


            // Insert new employee record
            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, newEmployee.getEmployeeId());
            pstmt.setString(2, newEmployee.getLastName());
            pstmt.setString(3, newEmployee.getFirstName());
            pstmt.setString(4, newEmployee.getEmail());
            pstmt.setString(5, newEmployee.getContactNumber());
            pstmt.executeUpdate();

            
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // READ - Retrieve an employee record by employee_Id (Stubbed to return null as per your request)
    public employee read(int employeeId)throws SQLException {
        String sqlStmt = "SELECT * FROM employee WHERE employee_id = ?"; // Adjust table and column names
        employee selectedEmployee = null;

        try{
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, employeeId);
            ResultSet resultSet = pstmt.executeQuery();
            
            resultSet.next();
            selectedEmployee = new employee();
            selectedEmployee.setEmployeeId(resultSet.getInt("employee_id"));
            selectedEmployee.setLastName(resultSet.getString("employee_lastName"));
            selectedEmployee.setFirstName(resultSet.getString("employee_firstName"));
            selectedEmployee.setEmail(resultSet.getString("employee_email"));
            selectedEmployee.setContactNumber(resultSet.getString("employee_phoneNumber"));
            
            
           
            return selectedEmployee; 
        }catch(Exception e){
            e.printStackTrace();  
            return null;
        }
    }

    // UPDATE - Update an existing employee record
    public void update(employee updatedEmployee) {
        String sqlStmt = "UPDATE employee " +
                         "SET employee_lastName = ?, " +
                         "employee_firstName = ?, " +
                         "employee_email = ?, " +
                         "employee_phoneNumber = ? " +
                         "WHERE employee_id = ?;";
        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setString(1, updatedEmployee.getLastName());
            pstmt.setString(2, updatedEmployee.getFirstName());
            pstmt.setString(3, updatedEmployee.getEmail());
            pstmt.setString(4, updatedEmployee.getContactNumber());
            pstmt.setInt(5, updatedEmployee.getEmployeeId());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE - Delete an employee record by employee_Id
    public int delete(int employeeId) {
        String sqlStmt = "DELETE FROM employee WHERE employee_id = ?";

        try {
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sqlStmt);
            pstmt.setInt(1, employeeId);
            pstmt.executeUpdate();

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
