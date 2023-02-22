package com.zoho.supermarket.core.model.product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int qty;
    private Product product;
    public Order(int qty, Product product) {
        this.qty = qty;
        this.product = product;
    }

    public int getQty() {
        return qty;
    }




}
