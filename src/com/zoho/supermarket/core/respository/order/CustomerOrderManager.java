package com.zoho.supermarket.core.respository.order;

import com.zoho.supermarket.core.model.product.Order;

import java.util.List;

public interface CustomerOrderManager {
    String addToCart(String productName, int quantity);
    List<Order> getCart();
//        String addToCart();
//    String placeOrder();
//    void getBill();
}
