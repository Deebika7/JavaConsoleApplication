package com.zoho.supermarket.core.model.user;

import com.zoho.supermarket.core.respository.order.AdminOrderManager;
import com.zoho.supermarket.core.respository.product.AdminProductManager;
import com.zoho.supermarket.core.respository.user.AdminDataManager;
import com.zoho.supermarket.database.repository.OrderDataManager;
import com.zoho.supermarket.database.repository.ProductDataManager;
import com.zoho.supermarket.database.repository.UserDataManager;

public class Admin extends User{
    private AdminDataManager adminDataManager;
    private AdminOrderManager adminOrderManager;
    private AdminProductManager adminProductManager;


    public Admin(String userName, String email, String password, UserRole admin,
                 AdminDataManager adminDataManager, AdminOrderManager adminOrderManager, AdminProductManager adminProductManager) {
        super(userName, email, password, admin);
        this.adminDataManager = adminDataManager;
        this.adminOrderManager = adminOrderManager;
        this.adminProductManager = adminProductManager;
    }
}
