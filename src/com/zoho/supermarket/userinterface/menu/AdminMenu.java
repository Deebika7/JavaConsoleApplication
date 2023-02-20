package com.zoho.supermarket.userinterface.menu;

import com.zoho.supermarket.userinterface.menu.enums.AdminOptions;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

public class AdminMenu {
    public void start(){
        while (true) {
            System.out.println("Enter your choice: ");
            for (AdminOptions option : AdminOptions.values()) {
                System.out.println(option.ordinal() + 1 + ". " + option.name());
            }
            int choice = ValidationUtil.getValidEnumInput(AdminOptions.values().length);
            AdminOptions option = AdminOptions.values()[choice - 1];
            switch (option) {
                case ADD_PRODUCT -> {}
                case REMOVE_PRODUCT -> {}
                case VIEW_PRODUCT -> {}
                case ADD_DISCOUNT -> {}
                case REMOVE_DISCOUNT ->{}
                case VIEW_DISCOUNTS ->{}
                case LIST_ORDERS -> {}
                case QUIT -> {}
            }
        }
    }
}
