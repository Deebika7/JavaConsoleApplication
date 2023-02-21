package com.zoho.supermarket.userinterface.util;

import com.zoho.supermarket.core.respository.user.CustomerDataManager;
import com.zoho.supermarket.database.repository.OrderDataManager;
import com.zoho.supermarket.database.repository.ProductDataManager;
import com.zoho.supermarket.database.repository.UserDataManager;

public class ManagerFactory {
    public static UserDataManager getUserDataManager(){
        return new UserDataManager();
    }
    public static ProductDataManager getProductDataManager(){
        return new ProductDataManager();
    }
    public static OrderDataManager getOrderDataManager(){
        return new OrderDataManager();
    }
}
