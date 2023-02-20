package com.zoho.supermarket.userinterface.menu;

import com.zoho.supermarket.userinterface.menu.enums.UserOptions;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

public class CustomerMenu {
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
}
