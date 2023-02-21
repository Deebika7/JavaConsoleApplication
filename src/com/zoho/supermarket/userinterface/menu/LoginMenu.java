package com.zoho.supermarket.userinterface.menu;

import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.core.model.user.UserRole;
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
            case SIGNIN_AS_ADMIN -> { signIn(UserRole.ADMIN);
            }
            case SIGNIN_AS_CUSTOMER -> {
                signIn(UserRole.CUSTOMER);
            }
            case SIGNUP_AS_ADMIN -> { signUp(UserRole.ADMIN);
            }
            case SIGNUP_AS_CUSTOMER -> {
                signUp(UserRole.CUSTOMER);
            }
            case QUIT -> {
            }
        }
    }

    private void signUp(UserRole userRole) {
        System.out.println("Enter User Name:");
        String userName = ValidationUtil.getValidUserName();
        System.out.println("Enter email:");
        String email = ValidationUtil.getValidEmail();
        System.out.println("Enter Password:");
        String password = ValidationUtil.getValidPassword();
        System.out.println("Enter Confirm Password");
        String confirmPassword = ValidationUtil.getValidConfirmPassword(password);
        System.out.println(userDataManager.addUser(new Random().nextInt(1000, 9999),
                userName, email, password, UserRole.CUSTOMER));
    }

    private void signIn(UserRole userRole) {
        if(userRole.equals(UserRole.ADMIN)) {
            System.out.println("Enter email:");
            String email = ValidationUtil.getValidEmail();
            System.out.println("Enter Password:");
            String password = ValidationUtil.getValidPassword();

        }


    }
}