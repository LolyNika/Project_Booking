package com.monroe.booking.dao.Impl;

import java.sql.*;

public class ConnectionPool {
    private static String dbhost = "jdbc:mysql://localhost:3306/booking";
    private static String username = "root";
    private static String password = "password";
    private static Connection conn;

    @SuppressWarnings("finally")
    public static Connection createNewDBconnection() {
        try {
            conn = DriverManager.getConnection(
                    dbhost, username, password);
            System.out.println("Successfully create connect to DB");
        } catch (SQLException e) {
            System.out.println("Cannot create database connection");
            e.printStackTrace();
        } finally {
            return conn;
        }
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}