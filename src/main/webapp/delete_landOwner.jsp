<%-- 
    Document   : delete_owner
    Created on : 18 Nov 2024, 1:33:56 am
    Author     : umali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, DAOClasses.*" %>
<%@page import="java.util.*, EntityClasses.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Land Owner</title>
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id="A" class="EntityClasses.landOwner" scope="page"/>
            <% //recevie the value
                int v_landOwner_Id = Integer.parseInt(request.getParameter("land_owner_id"));
                
                
                landOwnerDAO od = new landOwnerDAO();
                int status=od.delete(v_landOwner_Id);
                if(status==1){
            %>
            <h1>Delete Land Owner Success</h1>
            <% } else{
            %>
            <h1>Delete Land Owner Failed</h1>
            <% }
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
