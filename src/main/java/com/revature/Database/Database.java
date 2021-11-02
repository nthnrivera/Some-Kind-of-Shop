package com.revature.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static String dbConnection = "jdbc:mysql://localhost:3306/some-kind-of-shop";
    private static String dbUsername = "admin";
    private static String dbPassword = "password";

    public static Connection getConnection() {
        Connection con = null;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(dbConnection,
                    dbUsername, dbPassword);

            System.out.println("Connecting to Database");
        }
        catch(SQLException e)
        {

        }
        catch(ClassNotFoundException e)
        {

        }
        catch(Exception e)
        {

        }
        return con;
    }
}
