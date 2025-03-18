<%-- 
    Document   : transferOwnership
    Created on : 22 Nov 2024, 3:06:31 am
    Author     : umali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, DAOClasses.*, EntityClasses.*, Classes.*, java.time.format.DateTimeFormatter, java.time.LocalDate" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transfer Ownership</title>
    </head>
    <body>
        <form action="index.html">
            <jsp:useBean id="newTransfer" class="EntityClasses.transfers" scope="page"/>
            <jsp:useBean id="newHouse" class="EntityClasses.house" scope="page"/>
            <jsp:useBean id="newOwner" class="EntityClasses.owner" scope="page"/>
            <jsp:useBean id="newSale" class="EntityClasses.sales" scope="page"/>
            <% //recevie the value
                // getting prerequisite values
                int v_transfer_id = Classes.DatabaseUtils.getLastId("transfers", "transfer_id") + 1;
                int v_house_owner_Id = Integer.parseInt(request.getParameter("house_owner_Id"));
                
                // find house newOwner in owner table
                ownerDAO od = new ownerDAO();
                newOwner = od.read(v_house_owner_Id);
                String v_oldOwnerLastName = newOwner.getLastName();
                String v_oldOwnerFirstName = newOwner.getFirstName();
                int v_house_number = newOwner.getHouseNumber();
                
                // get houserecord by using houseNumber in house table
                houseDAO hd = new houseDAO();
                newHouse  = hd.read(v_house_number);
                int v_land_id = newHouse.getLand_landId();
                
                
                
                
                // add data to transfer table
                String v_newOwner_lastName = request.getParameter("new_houseOwnerLastName");
                String v_newOwner_firstName = request.getParameter("new_houseOwnerFirstName");
                
                String v_newOwner_email = request.getParameter("new_houseOwnerEmail");
                String v_newOwner_phoneNo = request.getParameter("new_houseOwnerPhoneNo");
                int v_sales_id = Classes.DatabaseUtils.getLastId("sales", "sales_id") + 1;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                // Parsing date strings to LocalDate
                LocalDate v_sale_date = LocalDate.parse(request.getParameter("sale_date"), formatter);
                int v_employee_id = Integer.parseInt(request.getParameter("employee_id"));
                float v_amount_paid = Float.parseFloat(request.getParameter("amount_paid"));
                
                
                newTransfer.setTransferId(v_transfer_id);
                newTransfer.setOldOwnerID(v_house_owner_Id);
                newTransfer.setOldHouseOwnerLastName(v_oldOwnerLastName);
                newTransfer.setOldHouseOwnerFirstName(v_oldOwnerFirstName);
                newTransfer.setNewHouseOwnerLastName(v_newOwner_lastName);
                newTransfer.setNewHouseOwnerFirstName(v_newOwner_firstName);
                newTransfer.setEmployeeId(v_employee_id);
                newTransfer.setSalesId(v_sales_id);
                newTransfer.setHouseNumber(v_house_number);
                
                transfersDAO transd = new transfersDAO();
                int statusTransfer=transd.create(newTransfer);
                
                if(statusTransfer==0){
            %>
            <h1>Transferring Ownership FAILEEDD</h1>
            
            <% } 
                else{}
                
                // update houeOwner table
                newOwner.setLastName(v_newOwner_lastName);
                newOwner.setFirstName(v_newOwner_firstName);
                newOwner.setEmail(v_newOwner_email);
                newOwner.setPhoneNumber(v_newOwner_phoneNo);
                int statusUpdateOwner = od.update(newOwner);
                if(statusUpdateOwner==0){
            %>
            <h1>Owner Name Change FAILEEDD</h1>
            
            <% } 
                else{}
                // add new record in sales
                salesDAO salesd = new salesDAO();
                newSale.setSalesId(v_sales_id);         // Set salesId
                newSale.setEmployeeId(v_employee_id);   // Set employeeId
                newSale.setOwnerId(v_house_owner_Id);         // Set ownerId
                String cat = "HouseSale";
                newSale.setSaleCategory(cat);  // Set saleCategory
                newSale.setHouseNumber(v_house_number);  // Set houseNumber
                newSale.setLandId(v_land_id);           // Set landId
                newSale.setTransferId(v_transfer_id);   // Set transferId
                newSale.setAmountPaid(v_amount_paid);   // Set amountPaid
                newSale.setSaleDate(v_sale_date);
                int statusSales = salesd.create(newSale);
                if(statusSales==0){
            %>
            <h1>Add Sale Record FAILEEDD</h1>
            
            <% } 
                else{}
                        
                if(statusTransfer==1 && statusUpdateOwner == 1 && statusSales == 1){
            %>
            <h1>Transferring Ownership Success</h1>
            
            <% } else{
            %>
            <h1>Transferring Ownership Failed</h1>
            <% }
            %>
            <input type="submit" value="Return to Menu">
        </form>
    </body>
</html>
