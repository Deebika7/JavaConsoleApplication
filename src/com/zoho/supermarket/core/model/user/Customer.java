package com.zoho.supermarket.core.model.user;

import com.zoho.supermarket.core.model.product.Order;
import com.zoho.supermarket.core.respository.order.CustomerOrderManager;
import com.zoho.supermarket.core.respository.product.CustomerProductManager;
import com.zoho.supermarket.core.respository.user.CustomerDataManager;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private CustomerProductManager  customerProductManager;
    private CustomerOrderManager customerOrderManager;
    private CustomerDataManager customerDataManager;
    List<Order> cart=new ArrayList<>();


    public Customer(String userName, String password, UserRole customer,
                    CustomerProductManager customerProductManager, CustomerOrderManager customerOrderManager,
                    CustomerDataManager customerDataManager) {
        super(userName,  password, customer);
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

    public String addToCart(String productName, int quantity) {
        return customerOrderManager.addToCart(productName,quantity);
    }

}
