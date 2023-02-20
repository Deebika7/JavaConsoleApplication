package com.zoho.supermarket.core.model.user;

import com.zoho.supermarket.core.respository.order.CustomerOrderManager;
import com.zoho.supermarket.core.respository.product.CustomerProductManager;
import com.zoho.supermarket.core.respository.user.CustomerDataManager;

public class Customer extends User {
    private CustomerProductManager  customerProductManager;
    private CustomerOrderManager customerOrderManager;
    private CustomerDataManager customerDataManager;

    public Customer(String userName, String email, String password, UserRole customer,
                    CustomerProductManager customerProductManager, CustomerOrderManager customerOrderManager,
                    CustomerDataManager customerDataManager) {
        super(userName, email, password, customer);
        this.customerProductManager = customerProductManager;
        this.customerOrderManager = customerOrderManager;
        this.customerDataManager = customerDataManager;
    }

}
