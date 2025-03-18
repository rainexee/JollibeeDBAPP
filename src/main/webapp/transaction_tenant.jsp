<%-- 
    Document   : transaction_tenant
    Created on : 22 Nov 2024, 8:45:34 pm
    Author     : umali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, DAOClasses.*, EntityClasses.*, Classes.*, java.time.format.DateTimeFormatter, java.time.LocalDate" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Tenant</title>
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id="newTenant" class="EntityClasses.tenant" scope="page"/>
            <% //recevie the value
                int v_tenant_id = Integer.parseInt(request.getParameter("tenant_id"));
                String v_tenant_last_name = request.getParameter("tenant_lastName");
                String v_tenant_first_name = request.getParameter("tenant_firstName");
                String v_tenant_contact_no = request.getParameter("tenant_contactNumber");
                String v_tenant_email = request.getParameter("tenant_email");
                int v_house_no = Integer.parseInt(request.getParameter("tenant_houseNumber"));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                // Parsing date strings to LocalDate
                LocalDate v_occupancy_date = LocalDate.parse(request.getParameter("occupancyDate"), formatter);
                LocalDate v_contract_expiration = LocalDate.parse(request.getParameter("contract_expiration"), formatter);
                
                newTenant.setTenantId(v_tenant_id);
                newTenant.setTenantLastName(v_tenant_last_name);
                newTenant.setTenantFirstName(v_tenant_first_name);
                newTenant.setTenantContactNumber(v_tenant_contact_no);
                newTenant.setTenantEmail(v_tenant_email);
                newTenant.setTenantHouseNumber(v_house_no);
                newTenant.setOccupancyDate(v_occupancy_date);
                newTenant.setContractExpiration(v_contract_expiration);

                
                tenantDAO tend = new tenantDAO();
                int status=tend.create(newTenant);
                if(status==1){
            %>
            <h1>Registering Tenant Success</h1>
            <% } else{
            %>
            <h1>Registering Tenant Failed</h1>
            <% }
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
