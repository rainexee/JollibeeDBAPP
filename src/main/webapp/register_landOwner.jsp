<%-- 
    Document   : register_landOwner
    Created on : 14 Nov 2024, 3:28:31 pm
    Author     : umali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, DAOClasses.*, EntityClasses.*, Classes.*, java.time.format.DateTimeFormatter, java.time.LocalDate" %>
   
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Land Owner</title>
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id="A" class="EntityClasses.landOwner" scope="page"/>
            
            <% //recevie the value
                int v_owner_Id = Classes.DatabaseUtils.getLastId("land_owner", "owner_id") + 1;
                String v_owner_lastName = request.getParameter("owner_lastName");
                String v_owner_firstName = request.getParameter("owner_firstName");
                String v_owner_email = request.getParameter("owner_email");
                String v_owner_phoneNumber = request.getParameter("owner_phoneNumber");
                int v_land_number = Integer.parseInt(request.getParameter("land_number"));
                String v_owner_startDate = request.getParameter("owner_startDate");
                String v_owner_endDate = request.getParameter("owner_endDate");
                
                // Create a new owner object and set its properties
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                A.setIdNumber(v_owner_Id);
                A.setLastName(v_owner_lastName);
                A.setFirstName(v_owner_firstName);
                A.setEmail(v_owner_email);
                A.setPhoneNumber(v_owner_phoneNumber);
                A.setlandNumber(v_land_number);
                A.setStart_date(LocalDate.parse(v_owner_startDate, formatter));
                A.setEnd_date(LocalDate.parse(v_owner_endDate, formatter));
                
                landOwnerDAO lod = new landOwnerDAO();
                int status = lod.create(A);
                if(status==1){
            %>
            <h1>Registering Land Owner Success</h1>
            <% } else{
            %>
            <h1>Registering Land Owner Failed</h1>
            <% }
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
