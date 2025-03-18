<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, DAOClasses.*, EntityClasses.*, Classes.*, java.time.format.DateTimeFormatter, java.time.LocalDate" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>House Record Details</title>
    </head>
    <body>
    <form action="index.html">
        <%
            houseDAO hd = new houseDAO();
            house selectedHouse = null;
            // Variables to hold data
            
            int v_house_number = Integer.parseInt(request.getParameter("record_ID"));
            
            try {
                // Fetch the house record
                selectedHouse = hd.read(v_house_number);

                if (selectedHouse == null) {
                    out.println("<p>House record not found for ID: " + v_house_number + "</p>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
 <% if (selectedHouse != null) { %>

            <table border="1">
                <tr>
                    <th>House Number</th>
                    <td><%= selectedHouse.getHouseNumber() %></td>
                </tr>
                <tr>
                    <th>House Size</th>
                    <td><%= selectedHouse.getHouseSize() %> sq. meters</td>
                </tr>
                <tr>
                    <th>Description</th>
                    <td><%= selectedHouse.getDescription() %></td>
                </tr>
                <tr>
                    <th>Date Started</th>
                    <td><%= selectedHouse.getDateStarted() %></td>
                </tr>
                <tr>
                    <th>Date of Completion</th>
                    <td><%= selectedHouse.getDateOfCompletion() %></td>
                </tr>
                <tr>
                    <th>House Price</th>
                    <td>Php<%= String.format("%.2f", selectedHouse.getHousePrice()) %></td>
                </tr>
                <tr>
                    <th>House Address</th>
                    <td><%= selectedHouse.getHouseAddress() %></td>
                </tr>
                <tr>
                    <th>Land ID</th>
                    <td><%= selectedHouse.getLand_landId() %></td>
                </tr>
                <tr>
                    <th>Employee ID</th>
                    <td><%= selectedHouse.getEmployee_employeeId() %></td>
                </tr>
            </table>
        <% } %>
        </table>
        <input type="submit" value="Return to Menu">
    </form>
    </body>
</html>
