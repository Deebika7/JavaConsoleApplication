package com.zoho.supermarket.core.respository.order;


import com.zoho.supermarket.core.model.product.Order;

import java.util.List;

public interface CustomerOrderManager {
    List<String> getCartProducts();
    String addToCart(String productName, int quantity);
    List<String> getBill();


}
