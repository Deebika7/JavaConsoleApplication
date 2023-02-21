package com.zoho.supermarket.userinterface.menu;

import com.zoho.supermarket.database.repository.UserDataManager;
import com.zoho.supermarket.userinterface.menu.enums.LoginOptions;
import com.zoho.supermarket.userinterface.util.ManagerFactory;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

import java.util.Random;

public class LoginMenu {
    private UserDataManager userDataManager = ManagerFactory.getUserDataManager();

    public void start() {
        System.out.println("How would you like to login as?");
        for (LoginOptions option : LoginOptions.values()) {
            System.out.println(option.ordinal() + 1 + ". " + option.name());
        }
        int choice = ValidationUtil.getValidEnumInput(LoginOptions.values().length);
        LoginOptions option = LoginOptions.values()[choice - 1];
        switch (option) {
            case LOGIN_AS_ADMIN -> { 
            }
            case LOGIN_AS_CUSTOMER -> {
            }
            case QUIT -> {
            }
        }

        public void userLogin () {
            System.out.println("Enter email:");
            String email = ValidationUtil.getValidEmail();
            System.out.println("Enter Password:");
            String password = ValidationUtil.getValidPassword();

        }
        public void register () {
            System.out.println("Enter User Name:");
            String userName = ValidationUtil.getValidUserName();
            System.out.println("Enter email:");
            String email = ValidationUtil.getValidEmail();
            System.out.println("Enter Password:");
            String password = ValidationUtil.getValidPassword();
            System.out.println("Enter Confirm Password");
            String confirmPassword = ValidationUtil.getValidPassword();
            userDataManager.addUser(new Random().nextInt(1000, 9999), userName, email, password, );
        }

    }
}