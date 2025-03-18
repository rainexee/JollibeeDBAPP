<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, DAOClasses.*" %>
<%@page import="java.util.*, EntityClasses.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Land</title>
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id="A" class="EntityClasses.land" scope="page"/>
            <% //recevie the value
                int v_land_Id = Classes.DatabaseUtils.getLastId("land", "land_id") + 1;
                String v_land_size = request.getParameter("land_size");
                String v_land_price = request.getParameter("land_price");
                String v_land_progress = request.getParameter("land_progress");
                String v_land_sold = request.getParameter("land_sold");

                // Set the properties on the newly created land object
                A.setLandId(v_land_Id);
                A.setSize(Integer.parseInt(v_land_size));  // Assuming size is an integer
                A.setPrice(Float.parseFloat(v_land_price)); // Assuming price is a float
                A.setLandProgress(v_land_progress);
                A.setLand_sold(Boolean.parseBoolean(v_land_sold));

                // Create the land DAO and insert the new land object
                landDAO ld = new landDAO();
                int status = ld.create(A); // Insert the new land object into the database
                // Check the result of the database insert operation
                if (status == 1) {
            %>
            <h1>Registering Land Success</h1>
            <% 
                } else {
            %>
            <h1>Registering Land Failed</h1>
            <% 
                }
            %>
            <form action="index.html" method="get">
                <input type="submit" value="Return to Home">
            </form>
        </form>
    </body>
</html>
