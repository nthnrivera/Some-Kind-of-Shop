package com.revature.Bids;

import com.revature.Application.PendingBidsUI;
import com.revature.Database.Database;
import com.revature.Shop.Cart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AcceptPendingBids {
    List<Cart> list = new ArrayList<Cart>();

    public void acceptBid()
    {
        int cartID;
        String userName = null;
        String productName = null;
        double productPrice = 0;
        double productBidPrice = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println("ACCEPT BID \n" +
                "------------------------------ \n" +
                "\n" +
                "ENTER BID ID: \n");

        int key = scan.nextInt();

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = Database.getConnection();

            String query = "SELECT * FROM pendingOrders WHERE orderID =" + "'" + key + "'";

            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next())
            {
                cartID = resultSet.getInt("orderID");
                userName = resultSet.getString("userName");
                productName = resultSet.getString("productName");
                productPrice = resultSet.getDouble("productPrice");
                productBidPrice = resultSet.getDouble("productBidPrice");

                list.add(new Cart(cartID,userName,productName,productPrice,productBidPrice));
            }



            String deleteQuery = "DELETE from pendingOrders WHERE orderID = ?";

            PreparedStatement preparedStatement = con.prepareStatement(deleteQuery);

            preparedStatement.setInt(1,key);

            preparedStatement.execute();



            String insertQuery = "INSERT INTO completedOrders(userName, productName, productPrice, productBidPrice)" +
                    "VALUES(?,?,?,?)";

            PreparedStatement insertStatement = con.prepareStatement(insertQuery);

            insertStatement.setString(1,userName);
            insertStatement.setString(2,productName);
            insertStatement.setDouble(3, productPrice);
            insertStatement.setDouble(4, productBidPrice);

            preparedStatement.execute();


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
        finally {
            PendingBidsUI pendingBids = new PendingBidsUI();
            pendingBids.bidsUI();
        }
    }
}
