package com.zoho.supermarket.core.model.product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int qty;
    private final Product product;
    public Order(int qty, Product product) {
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
