package com.dao.bankingsystem.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchUserById {
	static final String DB_URL = "jdbc:mysql://localhost:3306/banking_system";
    static final String USER = "root";
    static final String PASS = "password";
    static final String QUERY = "SELECT * FROM m_user WHERE id = '001'";

    public static void main(String[] args) {
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);) {
            while (rs.next()) {
                // Display values
                System.out.print("id: " + rs.getString("id"));
                System.out.print(", username: " + rs.getString("username"));
                System.out.print(", password: " + rs.getString("password"));
                System.out.print(", email: " + rs.getString("email"));
                System.out.print(", account name: " + rs.getString("account_name"));
                System.out.print(", status: " + rs.getString("status"));
                System.out.print(", created by: " + rs.getString("created_by"));
                System.out.print(", created at: " + rs.getString("created_at"));
                System.out.print(", last modified by: " + rs.getString("last_modified_by"));
                System.out.print(", last modified at: " + rs.getString("last_modified_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
