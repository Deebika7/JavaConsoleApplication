package com.zoho.supermarket.core.model.product;



public class Cart {
    private int qty;
    private final Product product;
    public Cart(int qty, Product product) {
        this.qty = qty;
        this.product = product;
    }


    public Product getProduct() {
        return product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
