package com.zoho.supermarket.userinterface.util;

import com.zoho.supermarket.core.respository.user.CustomerDataManager;
import com.zoho.supermarket.database.model.OrderDatabase;
import com.zoho.supermarket.database.model.implementation.OrderDatabaseImpl;
import com.zoho.supermarket.database.model.implementation.ProductDatabaseImpl;
import com.zoho.supermarket.database.model.implementation.UserDatabaseImpl;
import com.zoho.supermarket.database.repository.OrderDataManager;
import com.zoho.supermarket.database.repository.ProductDataManager;
import com.zoho.supermarket.database.repository.UserDataManager;

import static com.zoho.supermarket.database.model.implementation.UserDatabaseImpl.getInstance;

public class ManagerFactory {
    public static UserDataManager getUserDataManager(){
        return new UserDataManager(getInstance());
    }
    public static ProductDataManager getProductDataManager(){
        return new ProductDataManager(OrderDatabaseImpl.getInstance(), ProductDatabaseImpl.getInstance());
    }
    public static OrderDataManager getOrderDataManager(){
        return new OrderDataManager(OrderDatabaseImpl.getInstance(), ProductDatabaseImpl.getInstance());
    }
}
