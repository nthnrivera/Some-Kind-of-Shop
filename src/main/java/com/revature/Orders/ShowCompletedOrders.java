package com.revature.Orders;

import com.revature.Application.MainMenuUI;
import com.revature.Application.PendingBidsUI;
import com.revature.Database.Database;
import com.revature.Shop.Cart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShowCompletedOrders {
    public void completedOrders(){
        List<Cart> list = new ArrayList<Cart>();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = Database.getConnection();

            MainMenuUI mainMenuUI = new MainMenuUI();

            String userName = mainMenuUI.getUserName();
            String userType = mainMenuUI.getUserType();
            String query;

            int orderID = 0;
            String user = null;
            String productName = null;
            double productPrice = 0;
            double productBidPrice = 0;

            if (userType == "user")
            {
                query = "SELECT * FROM completedOrders WHERE userName = " + "'" + userName + "'";
            }
            else
            {
                query = "SELECT * FROM completedOrders";
            }

            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next())
            {
              orderID = resultSet.getInt("orderID");
              user = resultSet.getString("userName");
              productName = resultSet.getString("productName");
              productPrice = resultSet.getDouble("productPrice");
              productBidPrice = resultSet.getDouble("productBidPrice");

                list.add(new Cart(orderID,user,productName,productPrice,productBidPrice));
            }

            for (int i = 0 ; i < list.size(); i++)
            {
                System.out.println("ITEM \n" +
                        "ORDER ID: " + list.get(i).getProductID() + "\n" +
                        "Name: " + list.get(i).getUserName() + "\n" +
                        "Price: " + list.get(i).getProductPrice() + "\n" +
                        "Bid: " + list.get(i).getProductBidPrice() + "\n");
            }

            int paymentsRemaining = (int)productBidPrice/10;

            System.out.println("Payments Remaining: " + paymentsRemaining);
        }
        catch (SQLException e)
        {
            System.out.println("NO EXISTING BID");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch (Exception e)
        {
            System.out.println(e);
            PendingBidsUI pendingBids = new PendingBidsUI();
            pendingBids.bidsUI();
        }
    }
}
