package com.zoho.supermarket.database.model;

import com.zoho.supermarket.core.model.user.User;

import java.util.Map;

public interface UserDatabase {
    void add(String userName, User data);
    Map<String, User> getUsers();

}
