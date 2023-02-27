package com.zoho.supermarket.core.respository.order;

import com.zoho.supermarket.core.model.product.Order;

import java.util.List;

public interface AdminOrderManager {
    List<Order> getAllOrders();
}

