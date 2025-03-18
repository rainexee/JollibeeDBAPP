<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, DAOClasses.*, EntityClasses.*, Classes.*, java.time.format.DateTimeFormatter, java.time.LocalDate" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Land Record Details</title>
    </head>
    <body>
    <form action="index.html">
        <%
            landDAO ld = new landDAO();
            land selectedLand = null;
            // Variables to hold data
            
            int v_land_number = Integer.parseInt(request.getParameter("record_ID"));
            
            try {
                // Fetch the land record
                selectedLand = ld.read(v_land_number);

                if (selectedLand == null) {
                    out.println("<p>Land record not found for ID: " + v_land_number + "</p>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
 <% if (selectedLand != null) { %>

            <table border="1">
                <tr>
                    <th>Land ID</th>
                    <td><%= selectedLand.getLandId() %></td>
                </tr>
                <tr>
                    <th>Land Size</th>
                    <td><%= selectedLand.getSize() %></td>
                </tr>
                <tr>
                    <th>Land Price</th>
                    <td><%= selectedLand.getPrice() %></td>
                </tr>
                <tr>
                    <th>Land Progress</th>
                    <td><%= selectedLand.getLandProgress() %></td>
                </tr>
                <tr>
                    <th>Land Sold</th>
                    <td><%= selectedLand.isLand_sold() ? "Yes" : "No" %></td> <!-- Checks if land is sold -->
                </tr>



            </table>
        <% } %>
        </table>
        <input type="submit" value="Return to Menu">
    </form>
    </body>
</html>
