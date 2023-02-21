package com.zoho.supermarket.core.respository.user;

import com.zoho.supermarket.core.model.user.User;

import java.util.Map;

public interface AdminDataManager {
    Map<String, User> getUsers();
}
