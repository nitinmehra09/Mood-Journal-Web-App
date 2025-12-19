package com.moodjournal.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/MoodJournalDb";
            String user = "rot";
            String password = "RedTiger!?";

            con = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database");
        }

        return con;
    }
}