package com.revature.Bids;

import com.revature.Application.PendingBidsUI;
import com.revature.Database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CancelPendingBids {
    public void cancelBid(){

        Scanner scan = new Scanner(System.in);

        System.out.println("CANCEL BID \n" +
                "------------------------------ \n" +
                "\n" +
                "ENTER BID ID: \n");

        int key = scan.nextInt();

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = Database.getConnection();

            String deleteQuery = "DELETE from pendingOrders WHERE orderID = ?";

            PreparedStatement preparedStatement = con.prepareStatement(deleteQuery);

            preparedStatement.setInt(1,key);

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
