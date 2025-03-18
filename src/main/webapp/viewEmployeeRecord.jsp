<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, DAOClasses.*, EntityClasses.*, Classes.*, java.time.format.DateTimeFormatter, java.time.LocalDate" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Record Details</title>
    </head>
    <body>
    <form action="index.html">
        <%
            employeeDAO ed = new employeeDAO();
            employee selectedEmployee = null;
            // Variables to hold data
            
            int v_employee_number = Integer.parseInt(request.getParameter("record_ID"));
            
            try {
                // Fetch the employee record
                selectedEmployee = ed.read(v_employee_number);

                if (selectedEmployee == null) {
                    out.println("<p>Employee record not found for ID: " + v_employee_number + "</p>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
 <% if (selectedEmployee != null) { %>

            <table border="1">
                <tr>
                    <th>Employee ID</th>
                    <td><%= selectedEmployee.getEmployeeId() %></td>
                </tr>
                <tr>
                    <th>Employee Last Name</th>
                    <td><%= selectedEmployee.getLastName() %></td>
                </tr>
                <tr>
                    <th>Employee First Name</th>
                    <td><%= selectedEmployee.getFirstName() %></td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td><%= selectedEmployee.getEmail() %></td>
                </tr>
                <tr>
                    <th>Contact Number</th>
                    <td><%= selectedEmployee.getContactNumber() %></td>
                </tr>

            </table>
        <% } %>
        </table>
        <input type="submit" value="Return to Menu">
    </form>
    </body>
</html>
