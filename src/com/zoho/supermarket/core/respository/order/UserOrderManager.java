package com.zoho.supermarket.core.respository.order;

public interface UserOrderManager {
    String placeOrder();
    void generateBill();
}
