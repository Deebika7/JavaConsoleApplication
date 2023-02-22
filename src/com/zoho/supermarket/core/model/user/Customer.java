package com.zoho.supermarket.core.model.user;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.product.Order;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.respository.order.CustomerOrderManager;
import com.zoho.supermarket.core.respository.product.CustomerProductManager;
import com.zoho.supermarket.core.respository.user.CustomerDataManager;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private final CustomerProductManager customerProductManager;
    private final CustomerOrderManager customerOrderManager;
    private final CustomerDataManager customerDataManager;



    public Customer(String userName, String password, UserRole customer,
                    CustomerProductManager customerProductManager, CustomerOrderManager customerOrderManager,
                    CustomerDataManager customerDataManager) {
        super(userName, password, customer);
        this.customerProductManager = customerProductManager;
        this.customerOrderManager = customerOrderManager;
        this.customerDataManager = customerDataManager;
    }

    public CustomerProductManager getCustomerProductManager() {
        return customerProductManager;
    }

    public CustomerOrderManager getCustomerOrderManager() {
        return customerOrderManager;
    }

    public CustomerDataManager getCustomerDataManager() {
        return customerDataManager;
    }







}
