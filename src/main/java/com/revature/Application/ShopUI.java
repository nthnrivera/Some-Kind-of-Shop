package com.revature.Application;

import com.revature.Interface.Input;
import com.revature.Shop.ShopBuyItem;

import java.util.Scanner;

public class ShopUI {
    Scanner scan = new Scanner(System.in);

    MainMenuUI ui = new MainMenuUI();

    String userType = ui.getUserType();

    public void shopUI() {
        //list<Products> products = new ArrayList();

        System.out.println("SHOP");
        System.out.println("------------------------------");

        System.out.println("1- Inventory");
        System.out.println("2- Cart");

        if (userType.equals("manager")) {
            System.out.println("3- Add Items");
            System.out.println("4- Remove Items");
        }

        System.out.println("4- Exit");

        int key = scan.nextInt();

        Input input = new Input();

        input.shopInput(key);
    }

    public  void shopAddItem()
    {
        System.out.println("ADD ITEM");
        System.out.println("------------------------------");

        System.out.println("ENTER PRODUCT NAME:");
        String productName = scan.next();

        System.out.println("ENTER PRODUCT PRICE:");
        double productPrice = scan.nextDouble();
    }

    public void shopRemoveItem()
    {
        System.out.println("REMOVE ITEM");
        System.out.println("------------------------------");
        System.out.println("");
        System.out.println("ENTER ITEM ID");
    }

    public void shopOption()
    {
        System.out.println("1- PURCHASE ITEM");
        System.out.println("2- EXIT");
        int key = scan.nextInt();

        Input input = new Input();
        input.shopInventory(key);
    }

    public void shopBuyItem()
    {
        System.out.println("PURCHASE ITEM");
        System.out.println("------------------------------");
        System.out.println("");
        System.out.println("ENTER ITEM ID");

        int key = scan.nextInt();

        System.out.println("ENTER BID PRICE");

        double bid = scan.nextDouble();

        ShopBuyItem shopBuyItem = new ShopBuyItem();
        shopBuyItem.buyItem(key,bid);
    }

    public void shopCart()
    {
        System.out.println("CART \n" +
                "------------------------------ \n" +
                "1- REMOVE ITEM \n" +
                "2- EXIT");
        int key = scan.nextInt();

        Input input = new Input();
        input.shopCart(key);
    }

    public void shopCartRemoveItem()
    {
        System.out.println("ENTER ITEM ID \n" +
                "------------------------------");
        int key = scan.nextInt();


    }
}
