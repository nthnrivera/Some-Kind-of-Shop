package com.revature.Shop;

import com.revature.Application.ShopUI;
import com.revature.Database.Database;

import java.sql.*;

public class ShopCartRemoveItem {

    public void removeItem(int id)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = Database.getConnection();

            String query = "DELETE FROM cart WHERE cartID = ?";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setInt(1,id);

            statement.execute();
        }
        catch (SQLException e)
        {
            System.out.println("SQLException");
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

        ShopDisplayCart displayCart = new ShopDisplayCart();
        displayCart.displayCart();
    }
}
