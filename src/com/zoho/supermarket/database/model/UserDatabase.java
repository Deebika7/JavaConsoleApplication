package com.zoho.supermarket.database.model;

import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.core.model.user.UserRole;



public interface UserDatabase {
    void addUser(String phoneNumber,String userName, String password, UserRole userRole);
    User getUser(String phoneNumber) ;

}
