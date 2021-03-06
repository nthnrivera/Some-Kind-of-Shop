package com.revature.Shop;

import com.revature.Application.ShopUI;
import com.revature.Database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShopAddCart {

    public void addCart(String userName, String productName, double productPrice, double productBidPrice)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = Database.getConnection();

            String query = "INSERT INTO pendingOrders(userName, productName, productPrice, productBidPrice)" +
                    "VALUES(?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1,userName);
            statement.setString(2,productName);
            statement.setDouble(3,productPrice);
            statement.setDouble(4, productBidPrice);

            statement.execute();
            System.out.println("Product Added to Cart");

            ShopDisplayInventory displayInventory = new ShopDisplayInventory();
            displayInventory.displayInventory();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
