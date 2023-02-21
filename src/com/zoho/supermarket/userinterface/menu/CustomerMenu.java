package com.zoho.supermarket.userinterface.menu;


import com.zoho.supermarket.core.model.user.Customer;
import com.zoho.supermarket.core.respository.order.CustomerOrderManager;
import com.zoho.supermarket.core.respository.product.CustomerProductManager;
import com.zoho.supermarket.userinterface.menu.enums.UserOptions;

import com.zoho.supermarket.userinterface.util.ManagerFactory;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

public class CustomerMenu {
    private final CustomerOrderManager customerOrderManager;
    private final CustomerProductManager customerProductManager;

    public CustomerMenu(CustomerOrderManager customerOrderManager, CustomerProductManager customerProductManager) {
        this.customerOrderManager = customerOrderManager;
        this.customerProductManager = customerProductManager;
    }
    private final CustomerMenu customerMenu=new CustomerMenu(ManagerFactory.getOrderDataManager(),ManagerFactory.getProductDataManager());
    public void start() {
        System.out.println("Enter your choice: ");
        for (UserOptions option : UserOptions.values()) {
            System.out.println(option.ordinal() + 1 + ". " + option.name());
        }
        int choice = ValidationUtil.getValidEnumInput(UserOptions.values().length);
        UserOptions option = UserOptions.values()[choice - 1];
        switch (option) {
            case VIEW_PRODUCTS -> {}
            case ADD_PRODUCT_TO_CART -> {}
            case CHECK_DISCOUNT -> {}
            case GENERATE_BILL -> {}
            case PLACE_ORDER -> {}
            case QUIT -> {}
        }
    }
    public void viewProduct(){

    }




}
