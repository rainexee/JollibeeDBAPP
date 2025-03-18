<%-- 
    Document   : delete_employee
    Created on : 18 Nov 2024, 1:32:56 am
    Author     : umali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, DAOClasses.*" %>
<%@page import="java.util.*, EntityClasses.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Employee</title>
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id="A" class="EntityClasses.employee" scope="page"/>
            <% //recevie the value
                int v_employee_Id = Integer.parseInt(request.getParameter("employee_id"));
                
                employeeDAO ed = new employeeDAO();
                int status = ed.delete(v_employee_Id);
                if(status==1){
            %>
            <h1>Delete Employee Success</h1>
            <% } else{
            %>
            <h1>Delete Employee Failed</h1>
            <% }
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
