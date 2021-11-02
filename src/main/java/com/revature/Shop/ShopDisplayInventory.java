package com.revature.Shop;



import com.revature.Application.ShopUI;
import com.revature.Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShopDisplayInventory {
    List<Inventory> list = new ArrayList<Inventory>();

    public void displayInventory(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = Database.getConnection();

            String query = "SELECT * FROM product";

            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next())
            {

                int productID = resultSet.getInt("productID");
                String productName = resultSet.getString("productName");
                double productPrice = resultSet.getDouble("productPrice");
                String productDescription = resultSet.getString("productDescription");

                list.add(new Inventory(productID, productName, productPrice, productDescription));

            }

            for (int i = 0; i < list.size(); i++)
            {
                System.out.println("ITEM \n" +
                        "ID: " + list.get(i).getProductID() + "\n" +
                        "NAME " + list.get(i).getProductName() + "\n" +
                        "Price: " + list.get(i).getProductPrice() + "\n" +
                        "Description: " + list.get(i).getProductDescription() + "\n");
            }

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

        ShopUI shopUI = new ShopUI();
        shopUI.shopOption();
    }
}
