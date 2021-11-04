package com.revature.Application;

import com.revature.Interface.Input;

import java.util.Scanner;

public class PendingBidsUI {
    public void bidsUI(){
        Scanner scan = new Scanner(System.in);

        System.out.println("PENDING BIDS \n" +
                "------------------------------ \n" +
                "\n" +
                "1- Accept Bid \n" +
                "2- Cancel Bid \n" +
                "3- Exit");

        int key = scan.nextInt();

        Input input = new Input();

        input.pendingBids(key);
    }
}
