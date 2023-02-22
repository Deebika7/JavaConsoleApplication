package com.zoho.supermarket.database.model;


import com.zoho.supermarket.core.model.product.Order;
import com.zoho.supermarket.core.model.product.Product;

import java.util.List;

public interface OrderDatabase {
//    Map<Customer,List<Order>> getOrders();
//    void setOrders();
    List<Order> getCart();
    String addToCart(String productName, int quantity, Product product) ;

}
