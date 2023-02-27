package com.zoho.supermarket.core.model.product;

public class Discount {
    private final int discountID;
    private final double discountPercentage;

    public Discount(int discountID, double discountPercentage) {
        this.discountID = discountID;
        this.discountPercentage = discountPercentage;
    }

    public int getDiscountID() {
        return discountID;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
