<%-- 
    Document   : register_house
    Created on : 14 Nov 2024, 10:04:47 pm
    Author     : umali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, DAOClasses.*, EntityClasses.*, Classes.*, java.time.format.DateTimeFormatter, java.time.LocalDate" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register House</title>
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id="A" class="EntityClasses.house" scope="page"/>
            <% //recevie the value
                
                int houseNumber = Classes.DatabaseUtils.getLastId("house", "houseNumber") + 1;
                int landId = Integer.parseInt(request.getParameter("land_id"));
                int houseSize = Integer.parseInt(request.getParameter("house_size"));
                String description = request.getParameter("house_description");
                float housePrice = Float.parseFloat(request.getParameter("house_price"));
                String houseAddress = request.getParameter("house_address");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                // Parsing date strings to LocalDate
                LocalDate dateStarted = LocalDate.parse(request.getParameter("dateStarted"), formatter);
                LocalDate dateOfCompletion = LocalDate.parse(request.getParameter("dateOfCompletion"), formatter);
                int employeeId = Integer.parseInt(request.getParameter("employee_ID"));
                
                

                // Create House object and set properties
                A.setHouseNumber(houseNumber);
                A.setLand_landId(landId);
                A.setHouseSize(houseSize);
                A.setDescription(description);
                A.setHousePrice(housePrice);
                A.setHouseAddress(houseAddress);
                A.setDateStarted(dateStarted);
                A.setDateOfCompletion(dateOfCompletion);
                A.setEmployee_employeeId(employeeId);
                
                
                houseDAO hd = new houseDAO();
                int status=hd.create(A);
                if(status==1){
            %>
            <h1>Registering House Success</h1>
            <% } else{
            %>
            <h1>Registering House Failed</h1>
            <% }
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
