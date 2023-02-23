package com.zoho.supermarket.core.model.user;

import com.zoho.supermarket.core.respository.order.CustomerOrderManager;
import com.zoho.supermarket.core.respository.product.CustomerProductManager;
import com.zoho.supermarket.core.respository.product.MutualProductManager;
import com.zoho.supermarket.core.respository.user.CustomerDataManager;

public class Customer extends User {
    private final CustomerProductManager customerProductManager;
    private final CustomerOrderManager customerOrderManager;
    private final CustomerDataManager customerDataManager;
    private final MutualProductManager mutualProductManager;


    public Customer(String userName, String password, UserRole customer,
                    CustomerProductManager customerProductManager, CustomerOrderManager customerOrderManager,
                    CustomerDataManager customerDataManager,MutualProductManager mutualProductManager) {
        super(userName, password, customer);
        this.customerProductManager = customerProductManager;
        this.customerOrderManager = customerOrderManager;
        this.customerDataManager = customerDataManager;
        this.mutualProductManager=mutualProductManager;
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

    public MutualProductManager getMutualProductManager() {
        return mutualProductManager;
    }
}
