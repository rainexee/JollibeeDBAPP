<%@page import="java.util.*, DAOClasses.*, java.time.LocalDate"%>
<%@page import="java.util.*, DAOClasses.*, EntityClasses.*, Classes.*, java.time.format.DateTimeFormatter, java.time.LocalDate" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sales Report</title>
    </head>
    <body>
        <% 
            // Retrieving start and end dates from form input
            String startDateStr = request.getParameter("week_range1");
            String endDateStr = request.getParameter("week_range2");

            if (startDateStr != null && endDateStr != null) {
                // Parse the dates
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate startDate = LocalDate.parse(startDateStr, formatter);
                LocalDate endDate = LocalDate.parse(endDateStr, formatter);

                try {
                    // Create SalesDAO instance to fetch the sales report data
                    salesDAO salesDAO = new salesDAO();
                    // Fetch the sales report data using the fetchSalesReport method
                    List<Map<String, Object>> reportData = salesDAO.getSalesReport(startDate, endDate);

                    // Check if there are any records
                    if (reportData.isEmpty()) {
                        out.println("<p>No sales records found for the given date range.</p>");
                    } else {
                %>
                        <!-- Display the results in a table -->
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>Date Sold</th>
                                    <th>House Number</th>
                                    <th>Land ID</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (Map<String, Object> record : reportData) {
                                %>
                                    <tr>
                                        <td><%= record.get("Date_Sold") %></td>
                                        <td><%= record.get("houseNumber") %></td>
                                        <td><%= record.get("land_id") %></td>
                                    </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                <% 
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<p>Error fetching data.</p>");
                }
            }
        %>

        <br>
        <form action="index.html">
            <input type="submit" value="Return to Menu">
        </form>

    </body>
</html>
