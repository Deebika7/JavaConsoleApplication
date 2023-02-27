package com.zoho.supermarket.core.respository.order;


import com.zoho.supermarket.core.model.user.Customer;

import java.util.List;

public interface CustomerOrderManager {

    String addToCart(String phoneNumber,String productName, int quantity);

    List<String> getCartProducts(String phoneNumber);
    void clearCart(String phoneNumber);
    void addToOrders(Customer customer);
}
