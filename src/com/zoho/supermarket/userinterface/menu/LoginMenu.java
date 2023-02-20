package com.zoho.supermarket.userinterface.menu;

import com.zoho.supermarket.userinterface.util.ValidationUtil;

public class LoginMenu {
    public void start(){
        System.out.println("Enter the Choice:\n1. Register\n2.Login\n3.Quit");
        int choice=ValidationUtil.getValidEnumInput(2);
        switch (choice){
            case 1->login();
            case 2->register();
            case 3->{}
        }
    }
    public void login(){
        System.out.println("Enter email:");
        String email;
        System.out.println("Enter Password:");
        String password=ValidationUtil.getValidPassword();
    }
    public void register(){
        System.out.println("Enter User Name:");
        String userName=ValidationUtil.getValidUserName();
        System.out.println("Enter email:");
        String email;
        System.out.println("Enter Password:");
        String password=ValidationUtil.getValidPassword();
        System.out.println("Enter Confirm Password");
        String confirmPassword=ValidationUtil.getValidPassword();
    }

}
