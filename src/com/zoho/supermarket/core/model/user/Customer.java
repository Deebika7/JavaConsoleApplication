package com.zoho.supermarket.core.model.user;

import com.zoho.supermarket.core.respository.order.CustomerOrderManager;
import com.zoho.supermarket.core.respository.product.CustomerProductManager;
import com.zoho.supermarket.core.respository.user.UserDetailsManager;

public class Customer extends User {
    private final CustomerProductManager customerProductManager;
    private final CustomerOrderManager customerOrderManager;
    private final UserDetailsManager userDetailsManager;



    public Customer(String userName, String password, UserRole customer,
                    CustomerProductManager customerProductManager, CustomerOrderManager customerOrderManager,
                    UserDetailsManager userDetailsManager) {
        super(userName, password, customer);
        this.customerProductManager = customerProductManager;
        this.customerOrderManager = customerOrderManager;
        this.userDetailsManager=userDetailsManager;
    }

    public CustomerProductManager getCustomerProductManager() {
        return customerProductManager;
    }

    public CustomerOrderManager getCustomerOrderManager() {
        return customerOrderManager;
    }



}
