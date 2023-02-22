package com.zoho.supermarket.database.repository;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.product.Order;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.respository.order.AdminOrderManager;
import com.zoho.supermarket.core.respository.order.CustomerOrderManager;
import com.zoho.supermarket.database.model.OrderDatabase;
import com.zoho.supermarket.database.model.ProductDatabase;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;


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
    public String addToCart(String productName, int quantity) {
        Product product=productDatabase.getProduct(productName);
        if(product!=null){

        }
        return Message.NO_PRODUCT_EXIST;
    }

}
