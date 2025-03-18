<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, DAOClasses.*, EntityClasses.*, Classes.*, java.time.format.DateTimeFormatter, java.time.LocalDate" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tenant Record Details</title>
    </head>
    <body>
    <form action="index.html">
        <%
            tenantDAO td = new tenantDAO();
            tenant selectedTenant = null;
            // Variables to hold data
            
            int v_tenant_id = Integer.parseInt(request.getParameter("record_ID"));
            try {
                // Fetch the tenant record (Assuming you have a method to get tenant by ID)
                selectedTenant = td.getTenantById(v_tenant_id);  // Use a suitable method to fetch tenant
                if (selectedTenant == null) {
                    out.println("<p>Tenant record not found for ID: " + v_tenant_id + "</p>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
        <% if (selectedTenant != null) { %>

            <table border="1">
                <tr>
                    <th>Tenant ID</th>
                    <td><%= selectedTenant.getTenantId() %></td>
                </tr>
                <tr>
                    <th>Tenant Last Name</th>
                    <td><%= selectedTenant.getTenantLastName() %></td>
                </tr>
                <tr>
                    <th>Tenant First Name</th>
                    <td><%= selectedTenant.getTenantFirstName() %></td>
                </tr>
                <tr>
                    <th>Tenant Email</th>
                    <td><%= selectedTenant.getTenantEmail() %></td>
                </tr>
                <tr>
                    <th>Tenant Contact Number</th>
                    <td><%= selectedTenant.getTenantContactNumber() %></td>
                </tr>
                <tr>
                    <th>House Number</th>
                    <td><%= selectedTenant.getTenantHouseNumber() %></td>
                </tr>
                <tr>
                    <th>Occupancy Date</th>
                    <td><%= selectedTenant.getOccupancyDate() != null ? selectedTenant.getOccupancyDate() : "N/A" %></td>
                </tr>
                <tr>
                    <th>Contract Expiration</th>
                    <td><%= selectedTenant.getContractExpiration() != null ? selectedTenant.getContractExpiration() : "N/A" %></td>
                </tr>

            </table>
        <% } %>
        <input type="submit" value="Return to Menu">
    </form>
    </body>
</html>
