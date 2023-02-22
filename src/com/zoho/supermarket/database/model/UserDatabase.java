package com.zoho.supermarket.database.model;

import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.core.model.user.UserRole;



public interface UserDatabase {
    void addUser(String userName, String password, UserRole userRole);
    User getUser(UserRole userRole,String userName) ;

}
