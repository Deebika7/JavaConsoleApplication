package com.zoho.supermarket.userinterface.util;

import com.zoho.supermarket.database.repository.UserDataManager;

public class ManagerFactory {
    public static UserDataManager getUserDataManager(){
        return new UserDataManager();
    }
}
