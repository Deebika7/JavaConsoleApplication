package com.zoho.supermarket.core.model.user;

import com.zoho.supermarket.core.respository.order.AdminOrderManager;
import com.zoho.supermarket.core.respository.product.AdminProductManager;
import com.zoho.supermarket.core.respository.product.MutualProductManager;
import com.zoho.supermarket.core.respository.user.AdminDataManager;


public class Admin extends User{
    private final AdminDataManager adminDataManager;
    private final AdminOrderManager adminOrderManager;
    private final AdminProductManager adminProductManager;
    private final MutualProductManager mutualProductManager;

    public Admin(String userName,  String password, UserRole admin,
                 AdminDataManager adminDataManager, AdminOrderManager adminOrderManager,
                 AdminProductManager adminProductManager,MutualProductManager mutualProductManager) {
        super(userName, password, admin);
        this.adminDataManager = adminDataManager;
        this.adminOrderManager = adminOrderManager;
        this.adminProductManager = adminProductManager;
        this.mutualProductManager=mutualProductManager;
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

    public MutualProductManager getMutualProductManager() {
        return mutualProductManager;
    }
}
