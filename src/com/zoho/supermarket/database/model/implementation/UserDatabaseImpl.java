package com.zoho.supermarket.database.model.implementation;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.database.model.UserDatabase;

import java.util.HashMap;
import java.util.Map;

public class UserDatabaseImpl implements UserDatabase {
    private Map<String, User> users=new HashMap<>();
    private static UserDatabaseImpl Instance=null;
    private UserDatabaseImpl(){

    }
    public static UserDatabaseImpl getInstance(){
        if(Instance==null){
            new UserDatabaseImpl();
        }
        return Instance;
    }
    public void add(String userName, User user){
        users.put(userName,user);
    }
    public  Map<String,User> getUsers(){
        return new HashMap<>(users);
    }

}
