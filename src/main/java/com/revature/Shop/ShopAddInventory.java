package com.revature.Shop;

import com.revature.Database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShopAddInventory {
    public void addInventory(String productName, double productPrice, String productDescription)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = Database.getConnection();

            String query = "INSERT INTO product(productName, productPrice, productDescription)" +
                    "VALUES (?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, productName);
            statement.setDouble(2, productPrice);
            statement.setString(3, productDescription);

            statement.execute();

            System.out.println("Product Created");
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
