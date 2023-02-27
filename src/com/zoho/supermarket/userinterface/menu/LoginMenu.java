package com.zoho.supermarket.userinterface.menu;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.user.Admin;
import com.zoho.supermarket.core.model.user.Customer;
import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.core.model.user.UserRole;
import com.zoho.supermarket.database.repository.UserDataManager;
import com.zoho.supermarket.userinterface.menu.enums.LoginOptions;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

import java.util.Scanner;

public class LoginMenu {
    private final UserDataManager userDataManager;

    public LoginMenu(UserDataManager userDataManager) {
        this.userDataManager = userDataManager;
    }

    public void printLoginMenu() {
        while (true) {
            System.out.println("How would you like to login ?");
            for (LoginOptions option : LoginOptions.values()) {
                System.out.println(option.ordinal() + 1 + ". " + option.name());
            }
            int choice = ValidationUtil.getValidEnumInput(LoginOptions.values().length);
            LoginOptions option = LoginOptions.values()[choice - 1];
            switch (option) {
                case SIGN_IN_AS_ADMIN -> signIn(UserRole.ADMIN);
                case SIGN_IN_AS_CUSTOMER -> signIn(UserRole.CUSTOMER);
                case SIGN_UP_AS_ADMIN -> signUp(UserRole.ADMIN);
                case SIGN_UP_AS_CUSTOMER -> signUp(UserRole.CUSTOMER);
                case QUIT -> {
                    return;
                }
            }
        }
    }

    private void signUp(UserRole userRole) {
        System.out.println("Enter Phone Number:");
        String phoneNumber=ValidationUtil.getValidPhoneNumber();
        System.out.println("Enter User Name:");
        String userName = ValidationUtil.getValidUserName();
        System.out.println("Enter Password:");
        String password = ValidationUtil.getValidPassword();
        System.out.println("Enter Confirm Password");
        String confirmPassword = ValidationUtil.getValidConfirmPassword(password);
        System.out.println(userDataManager.addUser(phoneNumber,userName, password, userRole));
    }

    private void signIn(UserRole userRole) {
        System.out.println("Enter Phone Number:");
        String phoneNumber = ValidationUtil.getValidPhoneNumber();
        System.out.println("Enter Password:");
        String password = new Scanner(System.in).nextLine();
        String signInStatus = userDataManager.isValidUser(phoneNumber, password);
        System.out.println(signInStatus);
        if (signInStatus.equals(Message.LOGIN_SUCCESS)) {
            User user = userDataManager.getUser(phoneNumber);
            if (user instanceof Customer) {
                CustomerMenu customerMenu = new CustomerMenu((Customer) user);
                customerMenu.printCustomerMenu();
            } else if (user instanceof Admin) {
                AdminMenu adminMenu = new AdminMenu((Admin) user);
                adminMenu.printAdminMenu();
            }
        }
    }

}