package com.zoho.supermarket.database.model.implementation;


import com.zoho.supermarket.ManagerFactory;
import com.zoho.supermarket.core.model.user.Admin;
import com.zoho.supermarket.core.model.user.Customer;
import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.core.model.user.UserRole;
import com.zoho.supermarket.database.model.UserDatabase;

import java.util.HashMap;
import java.util.Map;


public class UserDatabaseImpl implements UserDatabase {
    //private final List<User> users=new ArrayList<>();
    private final Map<String, User> users = new HashMap<>();
    private static UserDatabaseImpl Instance = null;

    private UserDatabaseImpl() {
    }

    public static UserDatabaseImpl getInstance() {
        if (Instance == null) {
            Instance = new UserDatabaseImpl();
        }
        return Instance;
    }

    public void addUser(String phoneNumber, String userName, String password, UserRole userRole) {
        if (userRole.equals(UserRole.ADMIN)) {
            users.put(phoneNumber, (new Admin(userName, password, userRole, ManagerFactory.getProductDataManager(),
                    ManagerFactory.getOrderDataManager())));
        } else {
            users.put(phoneNumber, (new Customer(userName, password, userRole, ManagerFactory.getProductDataManager(),
                    ManagerFactory.getOrderDataManager())));
        }
    }

    public User getUser(String phoneNumber) {

        if (users.containsKey(phoneNumber)) {
            return users.get(phoneNumber);
        }

        return null;
    }

}

