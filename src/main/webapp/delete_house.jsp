<%-- 
    Document   : delete_house
    Created on : 18 Nov 2024, 1:32:46 am
    Author     : umali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, DAOClasses.*" %>
<%@page import="java.util.*, EntityClasses.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete House</title>
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id="A" class="EntityClasses.house" scope="page"/>
            <% //recevie the value
                int v_house_Id = Integer.parseInt(request.getParameter("house_id"));
                
                
                houseDAO hd = new houseDAO();
                int status=hd.delete(v_house_Id);
                if(status==1){
            %>
            <h1>Delete House Success</h1>
            <% } else{
            %>
            <h1>Delete House Failed</h1>
            <% }
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
