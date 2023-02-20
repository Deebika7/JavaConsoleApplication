package com.zoho.supermarket.database.model.implementation;

import com.zoho.supermarket.core.model.product.Order;
import com.zoho.supermarket.core.model.user.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDatabaseImpl {
    private Map<Customer,List<Order>> orders=new HashMap<>();
    private static OrderDatabaseImpl Instance;
    private OrderDatabaseImpl(){}
    public static OrderDatabaseImpl getInstance(){
        if(Instance ==null){
            new OrderDatabaseImpl();
        }
        return Instance;
    }


}
