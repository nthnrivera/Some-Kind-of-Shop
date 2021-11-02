package com.revature.Shop;

import com.revature.Database.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ShopCartRemoveItem {

    public void removeItem(int id)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = Database.getConnection();

            String query = "DELETE FROM cart WHERE cartID = " + "'" + id + "'";

            Statement statement = con.createStatement();

            statement.executeQuery(query);
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

    }
}
