package com.zoho.supermarket.database.repository;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.respository.order.AdminOrderManager;
import com.zoho.supermarket.core.respository.order.CustomerOrderManager;
import com.zoho.supermarket.database.model.OrderDatabase;
import com.zoho.supermarket.database.model.ProductDatabase;


public class OrderDataManager implements AdminOrderManager, CustomerOrderManager {
    private final UserDataManager dataManager;
    private final OrderDatabase orderDatabase;
    private final ProductDatabase productDatabase;

    public OrderDataManager(UserDataManager dataManager, OrderDatabase orderDatabase, ProductDatabase productDatabase) {
        this.dataManager = dataManager;
        this.orderDatabase = orderDatabase;
        this.productDatabase = productDatabase;
    }
    @Override
    public Product addToCart(String productName) {
        Product product=productDatabase.getProduct(productName);
        if(product!=null){
            return product;
        }
        return null;
    }

}
