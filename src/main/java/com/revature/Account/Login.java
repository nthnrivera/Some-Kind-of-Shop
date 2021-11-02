package com.revature.Account;

import com.revature.Application.MainMenuUI;
import com.revature.Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
    Database database = new Database();
    MainMenuUI mainMenuUI = new MainMenuUI();
    Scanner scan = new Scanner(System.in);
    public void login()
    {
        String userName;
        String userPassword;
        String userType;

        try
        {
            System.out.println("LOGIN");
            System.out.println("----------------");
            System.out.println();
            System.out.println("INPUT USERNAME:");

            String name = scan.next();

            if (name.isBlank())
                throw new Exception("INPUT CANNOT BE BLANK");

            System.out.println();
            System.out.println("INPUT PASSWORD:");

            String password = scan.next();

            if (password.isBlank())
                throw new Exception("INPUT CANNOT BE BLANK");

            Connection con = Database.getConnection();

            String query = "SELECT * from users WHERE userName= " + "'" +name + "'" + "AND userPassword= " + "'" + password + "'";

            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(query);

            if (rs.next())
            {
                System.out.println("Logging in");
                int id = rs.getInt("userID");
                userName = rs.getString("userName");
                userPassword = rs.getString("userPassword");
                userType = rs.getString("userType");

                mainMenuUI.setUserName(userName);
                mainMenuUI.setUserType(userType);
            }
            else
            {
                throw new Exception("USERNAME OR PASSWORD DOES NOT MATCH");
            }
        }catch (SQLException e)
        {
            System.out.println("SQLException");
            e.printStackTrace();
            login();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("ClassNotFoundException");
            System.out.println(e);
            login();
        }
        catch (Exception e)
        {
            System.out.println(e);
            login();
        }
        finally {

            mainMenuUI.Display();
        }
    }
}
