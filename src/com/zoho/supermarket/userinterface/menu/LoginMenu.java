package com.zoho.supermarket.userinterface.menu;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.user.Admin;
import com.zoho.supermarket.core.model.user.Customer;
import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.core.model.user.UserRole;
import com.zoho.supermarket.core.respository.user.UserDetailsManager;
import com.zoho.supermarket.userinterface.menu.enums.LoginOptions;
import com.zoho.supermarket.userinterface.util.ValidationUtil;
import java.util.Scanner;

public class LoginMenu {

    private final UserDetailsManager UserDetailsManager;

    public LoginMenu(UserDetailsManager userDetailsManager) {
        this.UserDetailsManager = userDetailsManager;
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
                case SIGN_IN_AS_ADMIN, SIGN_IN_AS_CUSTOMER -> signIn();
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
        String phoneNumber = ValidationUtil.getValidPhoneNumber();
        System.out.println("Enter User Name:");
        String userName = ValidationUtil.getValidUserName();
        System.out.println("Enter Password:");
        String password = ValidationUtil.getValidPassword();
        System.out.println("Enter Confirm Password");
        ValidationUtil.getValidConfirmPassword(password);
        System.out.println(UserDetailsManager.addUser(phoneNumber, userName, password, userRole));
    }

    private void signIn() {
        System.out.println("Enter Phone Number:");
        String phoneNumber = ValidationUtil.getValidPhoneNumber();
        System.out.println("Enter Password:");
        String password = new Scanner(System.in).nextLine();
        String signInStatus = UserDetailsManager.ValidateUser(phoneNumber, password);
        System.out.println(signInStatus);
        if (signInStatus.equals(Message.LOGIN_SUCCESS)) {
            User user = UserDetailsManager.getUser(phoneNumber);
            if (user instanceof Customer customer) {
                CustomerMenu customerMenu = new CustomerMenu(customer);
                customerMenu.printCustomerMenu();
            } else if (user instanceof Admin admin) {
                AdminMenu adminMenu = new AdminMenu(admin);
                adminMenu.printAdminMenu();
            }
        }
    }
}