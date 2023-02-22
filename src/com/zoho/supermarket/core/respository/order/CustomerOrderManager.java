package com.zoho.supermarket.core.respository.order;


import com.zoho.supermarket.core.model.product.Product;

public interface CustomerOrderManager {

    Product addToCart(String productName);
}
