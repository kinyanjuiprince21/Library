package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not loaded");
        }
        if(connection != null)
            return connection;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/library", "david", "david123");
            System.out.println("Connection established");
        } catch (SQLException e) {
            System.out.println("Connection could not be established");
        }
        return connection;
    }
}
