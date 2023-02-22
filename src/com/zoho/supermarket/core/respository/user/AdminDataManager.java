package com.zoho.supermarket.core.respository.user;

import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.core.model.user.UserRole;



public interface AdminDataManager {
    User getUser(UserRole userRole, String userName);
}
