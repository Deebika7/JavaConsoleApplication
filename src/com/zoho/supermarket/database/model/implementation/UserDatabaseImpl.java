package com.zoho.supermarket.database.model.implementation;

import com.zoho.supermarket.core.model.user.User;

import java.util.HashMap;
import java.util.Map;

public class UserDatabaseImpl {
    private Map<Integer, User> users=new HashMap<>();
    private static UserDatabaseImpl Instance;
    public static UserDatabaseImpl getInstance(){
        if(Instance==null){
            new UserDatabaseImpl();
        }
        return Instance;
    }




}
