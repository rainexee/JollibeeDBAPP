<%@page import="java.util.*, DAOClasses.*, java.time.LocalDate"%>
<%@page import="java.util.*, DAOClasses.*, EntityClasses.*, Classes.*, java.time.format.DateTimeFormatter, java.time.LocalDate" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Land Sales Report</title>
    </head>
    <body>
        <br>
        <%
            String startDateStr = request.getParameter("week_range1");
            String endDateStr = request.getParameter("week_range2");

            if (startDateStr != null && endDateStr != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate startDate = LocalDate.parse(startDateStr);
                LocalDate endDate = LocalDate.parse(endDateStr);

                try {
                    landDAO landDAO = new landDAO();
                    List<Map<String, Object>> reportData = landDAO.fetchLandSalesReport(startDate, endDate);

                    if (reportData.isEmpty()) {
                        out.println("<p>No land sales records found for the given date range.</p>");
                    } else {
        %>
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>Land Progress</th>
                                    <th>Total Land Bought</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (Map<String, Object> record : reportData) {
                                        String landProgress = (String) record.get("landprogress");
                                        int totalLandBought = (int) record.get("total_land_bought");
                                %>
                                    <tr>
                                        <td><%= landProgress %></td>
                                        <td><%= totalLandBought %></td>
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
