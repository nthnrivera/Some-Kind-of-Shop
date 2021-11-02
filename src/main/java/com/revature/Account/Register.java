package com.revature.Account;

import com.revature.Application.MainMenuUI;
import com.revature.Database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Register {
    Scanner scan = new Scanner(System.in);



    public void register()
    {


        String userName;
        String userPassword;
        String userType;

        try
        {
            System.out.println("REGISTER \n" +
                    "---------------- \n" +
                    "INPUT USERNAME: \n");

            String name = scan.next();

            System.out.println("INPUT PASSWORD: \n");

            String password = scan.next();

            System.out.println("INPUT USER TYPE user,employee,manager:");

            String type = scan.next();

            if (type.equals("user" ) || type.equals("employee" ) || type.equals("manager" ))
            {
                Class.forName("com.mysql.cj.jdbc.Driver");

                Connection con = Database.getConnection();

                String query = "INSERT INTO users (userName, userPassword, userType) " +
                        "VALUES (?,?,?)";

                PreparedStatement statement = con.prepareStatement(query);

                statement.setString(1,name);
                statement.setString(2,password);
                statement.setString(3,type);

                statement.execute();

                System.out.println("User Registered");
            }
        }catch (SQLException e)
        {
            System.out.println("SQLException");
            e.printStackTrace();
            register();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("ClassNotFoundException");
            System.out.println(e);
            register();
        }
        catch (Exception e)
        {
            System.out.println(e);
            register();
        }
        finally {
            MainMenuUI mainMenuUI = new MainMenuUI();
            mainMenuUI.Display();
        }
    }
}
