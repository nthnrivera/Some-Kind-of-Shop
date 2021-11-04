package com.revature.Application;

import com.revature.Account.Login;
import com.revature.Interface.Input;

import java.util.Scanner;

public class MainMenuUI {

    private static String userName = "NO USER";
    private enum type {user,employee,manager,loggedOut}
    private static type userType = type.loggedOut;

    public static void main(String[] args)
    {
        Display();
    }

    public static void Display()
    {
        System.out.println("******************* \n" +
                "*Some Kind of Shop* \n" +
                "*   Version 0.1   * \n" +
                "******************* \n" +
                "\n" +
                "PLEASE INPUT COMMAND \n" +
                "------------------------------ \n" +
                "\n" +
                userName + "\n");

        if (userType == type.loggedOut)
        {
            System.out.println("1- Login \n" +
                    "2- Register");
        } else
        {
            if (userType == type.employee || userType == type.manager) {
                System.out.println("3- Shop \n" +
                        "4- Completed Orders \n" +
                        "5- Pending Bids \n" +
                        "6- Log Out");
            }
            else
            {
                System.out.println("3- Shop \n" +
                        "4- Payments \n" +
                        "6- Log Out");
            }
        }

        Scanner scan = new Scanner(System.in);
        int key = scan.nextInt();

        Input input = new Input();
        input.MainMenuInput(key);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserType(String userType) {
        switch (userType){
            case "user":
                this.userType = type.user;
                break;
            case "employee":
                this.userType = type.employee;
                break;
            case "manager":
                this.userType = type.manager;
                break;
            case "loggedOut":
                this.userType = type.loggedOut;
        }
    }

    public String getUserType()
    {
        String userType = String.valueOf(this.userType);
        return userType;
    }

    public  String getUserName() {
        return userName;
    }
}
