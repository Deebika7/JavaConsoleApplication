package com.zoho.supermarket.core.model.user;

public  class User {

    private final String userName,password;
    private final UserRole userRole;

    public User(String userName, String password, UserRole userRole) {
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

    public UserRole getUserRole() {
        return userRole;
    }
}
