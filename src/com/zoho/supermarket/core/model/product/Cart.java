package com.zoho.supermarket.core.model.product;


public class Cart {
    private int quantity;
    private final Product product;

    public Cart(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
