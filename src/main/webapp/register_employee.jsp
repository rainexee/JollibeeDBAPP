<%-- 
    Document   : register_land
    Created on : 14 Nov 2024, 3:28:31 pm
    Author     : umali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, DAOClasses.*, EntityClasses.*, Classes.*, java.time.format.DateTimeFormatter, java.time.LocalDate" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Land</title>
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id="A" class="EntityClasses.employee" scope="page"/>
            <% //recevie the value
                int v_employee_id = Classes.DatabaseUtils.getLastId("employee", "employee_id") + 1;
                String v_employee_lastName = request.getParameter("employee_lastName");
                String v_employee_firstName = request.getParameter("employee_firstName");
                String v_employee_email = request.getParameter("employee_email");
                String v_employee_phoneNumber = request.getParameter("employee_phoneNumber");
                
                A.setEmployeeId(v_employee_id);
                A.setLastName(v_employee_lastName);
                A.setFirstName(v_employee_firstName);
                A.setEmail(v_employee_email);
                A.setContactNumber(v_employee_phoneNumber);
                
                employeeDAO ed = new employeeDAO();
                int status=ed.create(A);
                if(status==1){
            %>
            <h1>Registering Employee Success</h1>
            <% } else{
            %>
            <h1>Registering Employee Failed</h1>
            <% }
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
