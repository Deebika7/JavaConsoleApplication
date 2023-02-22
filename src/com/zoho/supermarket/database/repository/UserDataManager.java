package com.zoho.supermarket.database.repository;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.core.model.user.UserRole;
import com.zoho.supermarket.core.respository.user.AdminDataManager;
import com.zoho.supermarket.core.respository.user.CustomerDataManager;
import com.zoho.supermarket.database.model.UserDatabase;
import com.zoho.supermarket.userinterface.util.ValidationUtil;



public class UserDataManager implements AdminDataManager, CustomerDataManager {
    private final UserDatabase userDatabase;

    public UserDataManager(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }


    @Override
    public User getUser(UserRole userRole, String userName) {
        return userDatabase.getUser(userRole,userName);
    }
    public String addUser(String userName, String password, UserRole userRole){
        if(ValidationUtil.isInstanceValid(getUser(userRole,userName))){
            return Message.USER_EXIST;
        }
        else {
            userDatabase.addUser(userName,password,userRole);
            return  Message.REGISTER_SUCCESS;
        }
    }

    public String isValidUser(String userName,String password,UserRole userRole){
        User user=getUser(userRole,userName);
        if(user!=null){
            if(user.getPassword().equals(password)){
                return Message.LOGIN_SUCCESS;
            }
            return Message.PASSWORD_MISMATCH;
        }
        return Message.NO_USER_EXIST;
    }

}
