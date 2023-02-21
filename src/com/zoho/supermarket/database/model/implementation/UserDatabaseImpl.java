package com.zoho.supermarket.database.model.implementation;

import com.zoho.supermarket.core.model.user.Admin;
import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.core.model.user.UserRole;
import com.zoho.supermarket.database.model.UserDatabase;

import java.util.HashMap;
import java.util.Map;

public class UserDatabaseImpl implements UserDatabase {
    private Map<String, User> users=new HashMap<>();
    private static UserDatabaseImpl Instance;
    public static UserDatabaseImpl getInstance(){
        if(Instance==null){
            new UserDatabaseImpl();
        }
        return Instance;
    }
    public void addUser(String string,User user){
        users.put(string,user);

    }
    public  Map<String,User> getUsers(){
        return new HashMap<>(users);
    }



}
