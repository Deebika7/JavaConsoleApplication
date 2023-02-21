package com.zoho.supermarket.userinterface.menu;


import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.user.Customer;
import com.zoho.supermarket.core.model.user.UserRole;
import com.zoho.supermarket.database.repository.UserDataManager;
import com.zoho.supermarket.userinterface.menu.enums.LoginOptions;
import com.zoho.supermarket.userinterface.util.ManagerFactory;
import com.zoho.supermarket.userinterface.util.ValidationUtil;



public class LoginMenu implements Menu{
    private final UserDataManager userDataManager;

    public LoginMenu(UserDataManager userDataManager) {
        this.userDataManager = userDataManager;
    }

    public void start() {
            while (true) {
                System.out.println("How would you like to login as?");
                for (LoginOptions option : LoginOptions.values()) {
                    System.out.println(option.ordinal() + 1 + ". " + option.name());
                }
                int choice = ValidationUtil.getValidEnumInput(LoginOptions.values().length);
                LoginOptions option = LoginOptions.values()[choice - 1];
                switch (option) {
                    case SIGNIN_AS_ADMIN -> signIn(UserRole.ADMIN);

                    case SIGNIN_AS_CUSTOMER -> signIn(UserRole.CUSTOMER);

                    case SIGNUP_AS_ADMIN -> signUp(UserRole.ADMIN);

                    case SIGNUP_AS_CUSTOMER -> signUp(UserRole.CUSTOMER);

                    case QUIT -> {
                    }
                }
            }

    }
    private void signUp(UserRole userRole) {
        System.out.println("Enter User Name:");
        String userName = ValidationUtil.getValidUserName();
        System.out.println("Enter Password:");
        String password = ValidationUtil.getValidPassword();
        System.out.println("Enter Confirm Password");
        String confirmPassword = ValidationUtil.getValidConfirmPassword(password);
        if (userRole.equals(UserRole.CUSTOMER)) {
            System.out.println(userDataManager.addUser(userName, password, UserRole.CUSTOMER));
        } else {
            System.out.println(userDataManager.addUser(userName, password, UserRole.ADMIN));
        }

    }
    private void signIn(UserRole userRole) {
        System.out.println("Enter User Name:");
        String userName = ValidationUtil.getValidUserName();
        System.out.println("Enter Password:");
        String password = ValidationUtil.getValidPassword();
        if (userRole.equals(UserRole.ADMIN) && userDataManager.validateUser(userName, password, UserRole.ADMIN)) {
            System.out.println(Message.LOGIN_SUCCESS);
            Menu menu=new AdminMenu(ManagerFactory.getOrderDataManager(),ManagerFactory.getProductDataManager());
            menu.start();

        } else if (userRole.equals(UserRole.CUSTOMER) && userDataManager.validateUser(userName, password, UserRole.CUSTOMER)) {
            System.out.println(Message.LOGIN_SUCCESS);
            Menu menu=new CustomerMenu(ManagerFactory.getOrderDataManager(),ManagerFactory.getProductDataManager());
            menu.start();
        } else {
            System.out.println(Message.NO_USER_EXIST);
        }
    }
}