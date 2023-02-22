package com.zoho.supermarket.core.respository.user;

import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.core.model.user.UserRole;

import java.util.Map;

public interface AdminDataManager {
    User getUser(UserRole userRole, String userName);
}
