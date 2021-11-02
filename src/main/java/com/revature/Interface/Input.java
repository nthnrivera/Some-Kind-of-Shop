package com.revature.Interface;

import com.revature.Account.Login;
import com.revature.Account.Register;
import com.revature.Application.MainMenuUI;
import com.revature.Application.ShopUI;
import com.revature.Shop.ShopBuyItem;
import com.revature.Shop.ShopDisplayCart;
import com.revature.Shop.ShopDisplayInventory;

public class Input {



    public void MainMenuInput(int i)
    {
        MainMenuUI mainMenuUI = new MainMenuUI();
        Login login = new Login();
        ShopUI shop = new ShopUI();

        try {

            String userType = mainMenuUI.getUserType();
            if (i > 7 || i <= 0)
            {
                throw new Exception("INVALID INPUT");
            }

            switch (i){
                case 1: //login

                    login.login();
                    break;
                case 2: //sign up
                    Register register = new Register();
                    register.register();
                    break;
                case 3: //shop

                    shop.shopUI();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("Logging Out");
                    mainMenuUI.setUserName(null);
                    mainMenuUI.setUserType("loggedOut");
                    mainMenuUI.Display();
                    break;
            }
        } catch(Exception e){
            System.out.println(e);
            mainMenuUI.Display();
        }
    }

    public void shopInput(int input) {

        switch (input) {
            case 1:
                ShopDisplayInventory displayInventory = new ShopDisplayInventory();
                displayInventory.displayInventory();
                break;
            case 2:
                ShopDisplayCart displayCart = new ShopDisplayCart();
                displayCart.displayCart();
                break;
        }
    }

    public void shopInventory(int input)
    {
        ShopUI shop = new ShopUI();
        switch (input){
            case 1:
                shop.shopBuyItem();
                break;
            case 2:
                shop.shopUI();
                break;
        }
    }

    public void shopCart(int input)
    {
        ShopUI shop = new ShopUI();
        switch (input){
            case 1:
                shop.shopCartRemoveItem();
                break;
            case 2:
                shop.shopUI();
                break;
        }
    }
}
