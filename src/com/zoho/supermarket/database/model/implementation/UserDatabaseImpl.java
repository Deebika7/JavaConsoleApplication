package com.zoho.supermarket.database.model.implementation;


import com.zoho.supermarket.core.model.user.Admin;
import com.zoho.supermarket.core.model.user.Customer;
import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.core.model.user.UserRole;
import com.zoho.supermarket.database.model.UserDatabase;
import com.zoho.supermarket.userinterface.util.ManagerFactory;

import java.util.ArrayList;
import java.util.List;


public class UserDatabaseImpl implements UserDatabase {
    private final List<User> users=new ArrayList<>();
    private static  UserDatabaseImpl Instance=null;
    private UserDatabaseImpl(){
    }
    public static UserDatabaseImpl getInstance(){
        if(Instance==null){
            return new UserDatabaseImpl();
        }
        return Instance;
    }

    {
        users.add(new Admin("test","Test@123",UserRole.ADMIN,ManagerFactory.getUserDataManager(),
                ManagerFactory.getOrderDataManager(),ManagerFactory.getProductDataManager()));
        users.add(new Customer("test","Test@123",UserRole.CUSTOMER,ManagerFactory.getProductDataManager(),
                ManagerFactory.getOrderDataManager(),ManagerFactory.getUserDataManager()));
    }

    public void addUser(String userName, String password, UserRole userRole){
        if(userRole.equals(UserRole.ADMIN)){
            users.add(new Admin(userName,password,userRole, ManagerFactory.getUserDataManager(),
                    ManagerFactory.getOrderDataManager(),ManagerFactory.getProductDataManager()));
        }
        else {
            users.add(new Customer(userName,password,userRole,ManagerFactory.getProductDataManager(),
                    ManagerFactory.getOrderDataManager(),ManagerFactory.getUserDataManager()));
        }
    }
    public User getUser(UserRole userRole,String userName){
            for (User user : users) {
                if (user.getUserRole().equals(userRole) && user.getUserName().equalsIgnoreCase(userName)) {
                    return user;
                }
            }
        return null;
    }

}

