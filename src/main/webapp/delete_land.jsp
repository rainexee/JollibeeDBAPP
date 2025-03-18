<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, DAOClasses.*" %>
<%@page import="java.util.*, EntityClasses.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Land</title>
    </head>
    <body>
        <form action="index.html">
            <% //recevie the value
                int v_land_Id = Integer.parseInt(request.getParameter("land_id"));
                
                
                landDAO ld = new landDAO();
                int status=ld.delete(v_land_Id);
                if(status==1){
            %>
            <h1>Delete Land Success</h1>
            <% } else{
            %>
            <h1>Delete Land Failed</h1>
            <% }
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
