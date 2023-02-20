package com.zoho.supermarket.database.model;

import com.zoho.supermarket.core.model.product.Order;
import com.zoho.supermarket.core.model.user.Customer;

import java.util.List;
import java.util.Map;

public interface OrderDatabase {
    Map<Customer,List<Order>> getOrders();
    void setOrders();


}
