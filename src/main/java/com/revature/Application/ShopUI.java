package com.revature.Application;

import com.revature.Interface.Input;
import com.revature.Shop.ShopAddInventory;
import com.revature.Shop.ShopBuyItem;
import com.revature.Shop.ShopCartRemoveItem;

import java.util.Scanner;

public class ShopUI {
    Scanner scan = new Scanner(System.in);

    MainMenuUI ui = new MainMenuUI();

    String userType = ui.getUserType();

    public void shopUI() {

        System.out.println("SHOP \n" +
                "------------------------------ \n" +
                "1- Inventory \n" +
                "2- Cart");

        if (userType.equals("manager")) {
            System.out.println("3- Add Items \n" +
                    "4- Remove Items");
        }

        System.out.println("5- Exit");

        int key = scan.nextInt();

        Input input = new Input();

        input.shopInput(key);
    }

    public  void shopAddItem()
    {
        System.out.println("ADD ITEM \n" +
                "------------------------------ \n" +
                "\n" +
                "ENTER PRODUCT NAME:");

        String productName = scan.next();

        System.out.println("ENTER PRODUCT PRICE:");
        double productPrice = scan.nextDouble();

        System.out.println("ENTER PRODUCT DESCRIPTION: ");
        String productDescription = scan.next();
    }

    public void shopRemoveItem()
    {
        System.out.println("REMOVE ITEM \n" +
                "------------------------------ \n" +
                "\n" +
                "ENTER ITEM ID");
    }

    public void shopOption()
    {
        System.out.println("1- MAKE OFFER \n" +
                "2- EXIT");
        int key = scan.nextInt();

        Input input = new Input();
        input.shopInventory(key);
    }

    public void shopBuyItem()
    {
        System.out.println("MAKE OFFER \n" +
                "------------------------------ \n" +
                "\n" +
                "ENTER ITEM ID");

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
        System.out.println("REMOVE ITEM \n" +
                "------------------------------ \n" +
                "ENTER ITEM ID:");
        int key = scan.nextInt();

        ShopCartRemoveItem removeItem = new ShopCartRemoveItem();

        removeItem.removeItem(key);
    }

    public void shopCartAddInventory()
    {
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        System.out.println("ADD INVENTORY \n" +
                "------------------------------ \n" +
                "\n" +
                "ENTER ITEM NAME: ");

                String name = scan.next();

                System.out.println("ENTER ITEM PRICE: ");

                double price = scan.nextDouble();

                System.out.println("ENTER ITEM DESCRIPTION: ");

                String description = scan.toString();

        ShopAddInventory addInventory = new ShopAddInventory();
        addInventory.addInventory(name, price, description);
    }
}
