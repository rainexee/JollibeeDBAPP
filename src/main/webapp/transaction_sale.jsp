<%-- 
    Document   : transaction_sale
    Created on : 22 Nov 2024, 10:39:29 pm
    Author     : umali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, DAOClasses.*, EntityClasses.*, Classes.*, java.time.format.DateTimeFormatter, java.time.LocalDate" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Property Sale</title>
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id="newSale" class="EntityClasses.sales" scope="page"/>
            <% //recevie the value
                int v_sales_id = Integer.parseInt(request.getParameter("sales_id"));
                int v_employee_id = Integer.parseInt(request.getParameter("employee_id"));
                int v_owner_id = Integer.parseInt(request.getParameter("owner_id"));
                String v_sale_category = request.getParameter("sale_category");
                int v_house_number = Integer.parseInt(request.getParameter("house_number"));
                int v_land_id = Integer.parseInt(request.getParameter("land_id"));
                int v_transfer_id = Integer.parseInt(request.getParameter("transfer_id"));
                float v_amount_paid = Float.parseFloat(request.getParameter("amount_paid"));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                // Parsing date strings to LocalDate
                LocalDate v_sale_date = LocalDate.parse(request.getParameter("sale_date"), formatter);

               
                newSale.setSalesId(v_sales_id);         // Set salesId
                newSale.setEmployeeId(v_employee_id);   // Set employeeId
                newSale.setOwnerId(v_house_owner_Id);         // Set ownerId
                newSale.setSaleCategory(v_sale_category);  // Set saleCategory
                newSale.setHouseNumber(v_house_number);  // Set houseNumber
                newSale.setLandId(v_land_id);           // Set landId
                newSale.setTransferId(v_transfer_id);   // Set transferId
                newSale.setAmountPaid(v_amount_paid);   // Set amountPaid
                newSale.setSaleDate(v_sale_date);
                
                salesDAO sd = new salesDAO();
                int status=sd.create(newSale);
                if(status==1){
            %>
            <h1>Registering Property Sale Success</h1>
            <% } else{
            %>
            <h1>Registering Property Sale Failed</h1>
            <% }
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
