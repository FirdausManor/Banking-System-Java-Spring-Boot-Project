package com.dao.bankingsystem.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUser {
	static final String DB_URL = "jdbc:mysql://localhost:3306/banking_system";
    static final String USER = "root";
    static final String PASS = "password";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         // Execute a query
         System.out.println("Inserting records into the table...");          
         String sql = "INSERT INTO m_user (id, username, password, email, account_name, status)"
        		 + "VALUES (UUID(), 'smitho007', '009988765', 'smitho007@gmail.com', 'smith007', 'Blocked')";
         stmt.executeUpdate(sql);
         sql = "INSERT INTO m_user (id, username, password, email, account_name, status)"
        		 + "VALUES (UUID(), 'loey92', '92929292', 'loey@gmail.com', 'loey92', 'Active')";
         stmt.executeUpdate(sql);
         System.out.println("Inserted records into the table...");   	  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}