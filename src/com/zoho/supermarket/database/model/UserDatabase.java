package com.zoho.supermarket.database.model;

import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.core.model.user.UserRole;

import java.util.Map;

public interface UserDatabase {
    void addUser(String email,User data);
    Map<String, User> getUsers();

}
