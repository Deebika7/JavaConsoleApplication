package com.zoho.supermarket.core.model.user;

import com.zoho.supermarket.core.respository.order.AdminOrderManager;
import com.zoho.supermarket.core.respository.product.AdminProductManager;
import com.zoho.supermarket.core.respository.user.AdminDataManager;


public class Admin extends User{
    private final AdminDataManager adminDataManager;
    private final AdminOrderManager adminOrderManager;
    private final AdminProductManager adminProductManager;


    public Admin(String userName,  String password, UserRole admin,
                 AdminDataManager adminDataManager, AdminOrderManager adminOrderManager, AdminProductManager adminProductManager) {
        super(userName, password, admin);
        this.adminDataManager = adminDataManager;
        this.adminOrderManager = adminOrderManager;
        this.adminProductManager = adminProductManager;
    }

    public AdminDataManager getAdminDataManager() {
        return adminDataManager;
    }

    public AdminOrderManager getAdminOrderManager() {
        return adminOrderManager;
    }

    public AdminProductManager getAdminProductManager() {
        return adminProductManager;
    }
}
