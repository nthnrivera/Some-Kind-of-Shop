package com.revature.Shop;

import com.revature.Application.MainMenuUI;
import com.revature.Application.ShopUI;
import com.revature.Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShopBuyItem {

    private String productName;
    private double productPrice;

    public void buyItem(int id, double bidPrice){
        try {
            MainMenuUI mainMenuUI = new MainMenuUI();
            ShopAddCart shopAddCart = new ShopAddCart();

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = Database.getConnection();

            String query = "SELECT * FROM product WHERE productID = " + id;

            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            ShopUI shopUI = new ShopUI();

            while (resultSet.next())
            {
                 productName = resultSet.getString("productName");
                 productPrice = resultSet.getDouble("productPrice");
            }


            String username = mainMenuUI.getUserName();

            shopAddCart.addCart(username, productName, productPrice, bidPrice);
        }
        catch (SQLException e)
        {

        }
        catch (ClassNotFoundException e)
        {

        }
        catch (Exception e)
        {

        }
    }
}
