package com.zoho.supermarket.database.repository;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.core.model.user.UserRole;
import com.zoho.supermarket.core.respository.user.UserDetailsManager;
import com.zoho.supermarket.database.model.UserDatabase;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

public class UserDataManager implements UserDetailsManager {
    private final UserDatabase userDatabase;
    public UserDataManager(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }
    public User getUser(String phoneNumber) {
        return userDatabase.getUser(phoneNumber);
    }
    public String addUser(String phoneNumber,String userName, String password, UserRole userRole){
        if(ValidationUtil.isInstanceValid(getUser(phoneNumber))){
            return Message.USER_EXIST;
        }
        else {
            userDatabase.addUser(phoneNumber,userName,password,userRole);
            return  Message.REGISTER_SUCCESS;
        }
    }

    public String isValidUser(String phoneNumber,String password){
        User user=getUser(phoneNumber);
        if(user!=null){
            if(user.getPassword().equals(password)){
                return Message.LOGIN_SUCCESS;
            }
            return Message.PASSWORD_MISMATCH;
        }
        return Message.NO_USER_EXIST;
    }

}
