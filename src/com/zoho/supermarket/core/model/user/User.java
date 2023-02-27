package com.zoho.supermarket.core.model.user;

public class User {
    private final String userName, password,phoneNumber;
    private final UserRole userRole;

    public User(String phoneNumber,String userName, String password, UserRole userRole) {
        this.phoneNumber=phoneNumber;
        this.userName = userName;
        this.password = password;
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
