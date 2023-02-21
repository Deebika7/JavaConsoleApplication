package com.zoho.supermarket.database.model;

import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.core.model.user.UserRole;

import java.util.Map;

public interface UserDatabase {
    void addUser(int userID, String userName, String email, String password, UserRole userRole);
    Map<String, User> getUsers();

}
