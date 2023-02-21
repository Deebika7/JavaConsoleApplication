package com.zoho.supermarket.database.repository;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.core.model.user.UserRole;
import com.zoho.supermarket.database.model.UserDatabase;
import com.zoho.supermarket.database.model.implementation.UserDatabaseImpl;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

import java.util.Map;

public class UserDataManager {
    UserDatabase userDatabase=new UserDatabaseImpl();
    private Map<String,User> getUsers(){
        if(ValidationUtil.isInstanceValid(userDatabase.getUsers())){
            return userDatabase.getUsers();
        }
        return null;
    }
    private boolean isUserExist(String email){
        Map<String,User> users=getUsers();
        boolean isPresent=false;
        if (users!=null){
            return users.containsKey(email);
        }
        return false;
    }

    public String addUser(int userID, String userName, String email, String password, UserRole userRole){
        if(!isUserExist(email)){
            userDatabase.addUser(userID,userName,email,password,userRole);
            return Message.REGISTER_SUCCESS;
        }
        return Message.REGISTER_FAILED+"\n"+Message.USER_EXIST;
    }


}
