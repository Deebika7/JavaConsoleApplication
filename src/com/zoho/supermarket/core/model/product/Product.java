package com.zoho.supermarket.core.model.product;

public class Product {
    private final int productID;
    private final String productName;
    private int quantity;
    private final double unitPrice;
    private final ProductCategory category;
    public Product(int productID, String productName, int quantity, double unitPrice, ProductCategory category) {
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.category = category;
    }
    public int getProductID() {
        return productID;
    }
    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductCategory getCategory() {
        return category;
    }
}
