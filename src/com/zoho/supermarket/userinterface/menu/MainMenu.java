package com.zoho.supermarket.userinterface.menu;

import com.zoho.supermarket.userinterface.menu.enums.LoginOptions;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

public class MainMenu {
    public void start(){
        System.out.println("How would you like to login as?");
        for (LoginOptions option : LoginOptions.values()) {
            System.out.println(option.ordinal() + 1 + ". " + option.name());
        }
        int choice = ValidationUtil.getValidEnumInput(LoginOptions.values().length);
        LoginOptions option = LoginOptions.values()[choice - 1];
        switch (option){
            case LOGIN_AS_ADMIN -> {}
            case LOGIN_AS_CUSTOMER -> {}
            case QUIT -> {}
        }
    }
}
