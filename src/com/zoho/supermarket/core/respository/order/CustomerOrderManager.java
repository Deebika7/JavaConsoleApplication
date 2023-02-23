package com.zoho.supermarket.core.respository.order;


import java.util.List;

public interface CustomerOrderManager {
    List<String> getCartProducts();
    String addToCart(String productName, int quantity);
    List<String> getBill();
    void clearCart();
}
