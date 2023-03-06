package com.zoho.supermarket.core.respository.user;

import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.core.model.user.UserRole;

public interface UserDetailsManager {
    User getUser(String phoneNumber);
    String addUser(String phoneNumber,String userName, String password, UserRole userRole);
    String isValidUser(String phoneNumber,String password);
}
