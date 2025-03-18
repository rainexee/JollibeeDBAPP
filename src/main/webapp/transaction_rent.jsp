<%-- 
    Document   : transaction_rent
    Created on : 18 Nov 2024, 12:35:49 pm
    Author     : umali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, DAOClasses.*" %>
<%@page import="java.util.*, DAOClasses.*, EntityClasses.*, Classes.*, java.time.format.DateTimeFormatter, java.time.LocalDate" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rent Payment Transaction</title>
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id="payment" class="EntityClasses.tenantRent" scope="page"/>
            <% //recevie the value
                int v_tenant_id = Integer.parseInt(request.getParameter("tenant_id"));
                float v_tenant_dues = Float.parseFloat(request.getParameter("amount_paid"));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                // Parsing date strings to LocalDate
                LocalDate v_datePaid = LocalDate.parse(request.getParameter("date_paid"), formatter);
                LocalDate v_dueDate = LocalDate.parse(request.getParameter("due_date"), formatter);
                // tenantRentDAO
                tenantRentDAO trd = new tenantRentDAO();
                payment.setTenantId(v_tenant_id);
                payment.setTenantDues(v_tenant_dues);
                payment.setDatePaid(v_datePaid);
                payment.setDueDate(v_dueDate);
                
                
                Integer status=null;
                //check if rent transaction exists
                // create
                if(trd.find(v_tenant_id) == true){
                    status = trd.update(payment);
                } else if (trd.find(v_tenant_id) == false){ // update
                    status = trd.create(payment);
                }
                
                if(status==1 || status == 0){
            %>
            <h1>Registering Payment Success</h1>
            <% } else{
            %>
            <h1>Registering Payment Failed</h1>
            <% }
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
