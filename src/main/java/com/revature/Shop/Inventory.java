package com.revature.Shop;

import java.util.Arrays;
import java.util.List;

public class Inventory {
    private final int productID;
    private final String productName;
    private final double productPrice;
    private final String productDescription;

    public Inventory (int productID, String productName, double productPrice, String productDescription)
    {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
