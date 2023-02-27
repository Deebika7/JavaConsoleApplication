package com.zoho.supermarket.database.model;


import com.zoho.supermarket.core.model.product.Cart;
import com.zoho.supermarket.core.model.product.Order;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.user.Customer;

import java.util.List;

public interface OrderDatabase {
    List<Cart> getCart(String phoneNumber);
    String addToCart(String phoneNumber,String productName, int quantity, Product product) ;
    void addToOrders(Customer customer, List<String> bill);
    List<Order> getOrders() ;
    void clearCart(String phoneNumber);
}
