<%-- 
    Document   : viewTenantRecords
    Created on : 23 Nov 2024, 3:14:52 pm
    Author     : umali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, DAOClasses.*, EntityClasses.*, Classes.*, java.time.format.DateTimeFormatter, java.time.LocalDate" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <form action="index.html">
            <jsp:useBean id="newTenant" class="EntityClasses.tenant" scope="page"/>
            <% //recevie the value
                
            <h1>Registering Tenant Success</h1>
            <% } else{
            %>
            <h1>Registering Tenant Failed</h1>
            <% }
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
