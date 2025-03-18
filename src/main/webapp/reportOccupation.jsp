<%@page import="java.util.*, DAOClasses.*, java.time.LocalDate"%>
<%@page import="java.util.*, DAOClasses.*, EntityClasses.*, Classes.*, java.time.format.DateTimeFormatter, java.time.LocalDate" %>

<!DOCTYPE html>
<html>
    <head>
        <title>House Occupation Report</title>
    </head>
    <body>
        <%
            // Retrieve input parameters (date and house number)
            String dateParam = request.getParameter("report_date");
            String houseNumberParam = request.getParameter("house_ID");

            List<Map<String, Object>> details = new ArrayList<>();

            try {
                if (dateParam != null && houseNumberParam != null) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                    // Parsing date strings to LocalDate
                    LocalDate occupancyDate = LocalDate.parse(dateParam, formatter);
                    int houseNumber = Integer.parseInt(houseNumberParam);

                    houseDAO hd = new houseDAO();
                    details = hd.getHouseTenantDetails(houseNumber, occupancyDate);
                }
            } catch (Exception e) {
                e.printStackTrace();
                out.println("<p>Error occurred while fetching data.</p>");
            }
        %>

        <h1>House Tenant Details</h1>

        <% if (details.isEmpty()) { %>
        <form action="index.html">
                <p>No tenant was found for the given house number and date of occupancy.</p>
            <input type="submit" value="Return to Menu">
        </form>
        <% } else { %>
            <form action="index.html">
                <table border="1">
                    <thead>
                        <tr>
                            <th>House Number</th>
                            <th>Land ID</th>
                            <th>Tenant ID</th>
                            <th>Last Name</th>
                            <th>First Name</th>
                            <th>Tenant Dues</th>
                            <th>Occupancy Date</th>
                            <th>Contract Expiration</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Map<String, Object> row : details) { %>
                            <tr>
                                <td><%= row.get("houseNumber") %></td>
                                <td><%= row.get("land_landId") %></td>
                                <td><%= row.get("tenant_id") %></td>
                                <td><%= row.get("tenant_lastName") %></td>
                                <td><%= row.get("tenant_firstName") %></td>
                                <td>$<%= String.format("%.2f", row.get("tenant_dues")) %></td>
                                <td><%= row.get("occupancyDate") %></td>
                                <td><%= row.get("contractExpiration") %></td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            <% } %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
