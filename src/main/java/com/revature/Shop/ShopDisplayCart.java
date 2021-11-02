package com.revature.Shop;

import com.revature.Application.MainMenuUI;
import com.revature.Application.ShopUI;
import com.revature.Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShopDisplayCart {
    List<Cart> list = new ArrayList<Cart>();

    public void displayCart()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = Database.getConnection();

            MainMenuUI mainMenuUI = new MainMenuUI();

            String name = mainMenuUI.getUserName();

            String query = "SELECT * FROM cart WHERE userName =" + "'" + name + "'";

            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next() == false)
            {
                System.out.println("CART EMPTY");
            }
            else
            {
                do {
                    int cartID = resultSet.getInt("cartID");
                    String userName = resultSet.getString("userName");
                    String productName = resultSet.getString("productName");
                    double productPrice = resultSet.getDouble("productPrice");
                    double productBidPrice = resultSet.getDouble("productBidPrice");
                } while (resultSet.next());
            }

            for (int i = 0; i < list.size(); i++)
            {
                System.out.println("ITEM ");
                System.out.println("Entry ID: " + list.get(i).getProductID());
                System.out.println("Name " + list.get(i).getProductName());
                System.out.println("Price: " + list.get(i).getProductPrice());
                System.out.println("Your Bid: " + list.get(i).getProductBidPrice());
                System.out.println("");
            }

            ShopUI shop = new ShopUI();
            shop.shopCart();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
