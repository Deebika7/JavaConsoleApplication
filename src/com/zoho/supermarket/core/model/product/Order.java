package com.zoho.supermarket.core.model.product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int qty;
    private double totalAmount;
    private Product item;
    List<Order> cart=new ArrayList<>();

}
