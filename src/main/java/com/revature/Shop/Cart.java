package com.revature.Shop;

public class Cart {
    private final int productID;
    private final String productName;
    private final double productPrice;
    private final double productBidPrice;
    private final String userName;

    public Cart (int cartID,String userName, String productName, double productPrice,double productBidPrice)
    {
        this.productID = cartID;
        this.userName = userName;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productBidPrice = productBidPrice;
    }

    public String getUserName() {
        return userName;
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

    public double getProductBidPrice() {
        return productBidPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productBidPrice=" + productBidPrice +
                ", userName='" + userName + '\'' +
                '}';
    }
}
