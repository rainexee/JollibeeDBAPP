/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntityClasses;
import DAOClasses.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * This file is used to test if the java project can connect to sql file
 */
public class ConnectionTester {
    
    public ConnectionTester(){}
    
    public void registerCity(){
        
        try{
            DatabaseConnection database = DatabaseConnection.getInstance();
            Connection conn = database.getConnection();
            System.out.print("success!");
            
            conn.close();
            database.closeConnection();
        }catch(Exception e){
            e.printStackTrace();        }
    }
    
    public static void main(String args[]){
        ConnectionTester db = new ConnectionTester();
        db.registerCity();
    }
}
