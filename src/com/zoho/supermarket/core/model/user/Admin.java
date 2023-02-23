package com.zoho.supermarket.core.model.user;

import com.zoho.supermarket.core.respository.product.AdminProductManager;
import com.zoho.supermarket.core.respository.user.UserDetailsManager;


public class Admin extends User{
    private final UserDetailsManager userDetailsManager;
    private final AdminProductManager adminProductManager;


    public Admin(String userName,  String password, UserRole admin,
                 UserDetailsManager userDetailsManager,
                 AdminProductManager adminProductManager) {
        super(userName, password, admin);
        this.userDetailsManager = userDetailsManager;
        this.adminProductManager = adminProductManager;
    }

    public UserDetailsManager getUserDataManager() {
        return userDetailsManager;
    }

    public AdminProductManager getAdminProductManager() {
        return adminProductManager;
    }


}
