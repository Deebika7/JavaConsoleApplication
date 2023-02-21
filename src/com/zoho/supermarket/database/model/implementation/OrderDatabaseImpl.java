package com.zoho.supermarket.database.model.implementation;

import com.zoho.supermarket.core.model.product.Order;
import com.zoho.supermarket.core.model.user.Customer;
import com.zoho.supermarket.database.model.OrderDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDatabaseImpl implements OrderDatabase {
    private Map<Customer,List<Order>> orders=new HashMap<>();
    private static OrderDatabaseImpl Instance=null;
    private OrderDatabaseImpl(){}
    public static OrderDatabaseImpl getInstance(){
        if(Instance ==null){
            return new OrderDatabaseImpl();
        }
        return Instance;
    }


}
