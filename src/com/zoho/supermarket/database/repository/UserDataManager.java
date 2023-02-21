package com.zoho.supermarket.database.repository;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.user.Admin;
import com.zoho.supermarket.core.model.user.Customer;
import com.zoho.supermarket.core.model.user.User;
import com.zoho.supermarket.core.model.user.UserRole;
import com.zoho.supermarket.core.respository.user.AdminDataManager;
import com.zoho.supermarket.core.respository.user.CustomerDataManager;
import com.zoho.supermarket.database.model.UserDatabase;
import com.zoho.supermarket.database.model.implementation.UserDatabaseImpl;
import com.zoho.supermarket.userinterface.util.ManagerFactory;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

import java.util.Map;

public class UserDataManager implements AdminDataManager, CustomerDataManager {
    UserDatabase userDatabase=new UserDatabaseImpl();

    public UserDataManager() {
    }

    public Map<String,User> getUsers(){
        if(ValidationUtil.isInstanceValid(userDatabase.getUsers())){
            return userDatabase.getUsers();
        }
        return null;
    }
    private boolean isUserExist(String email,UserRole userRole){
        Map<String,User> users=getUsers();
        if (users!=null){
            if(users.containsKey(email)&&users.get(email).getUserRole().equals(userRole)){
                return true;
            }
        }
        return false;
    }

    public String addUser(String userName, String email, String password, UserRole userRole){
        if(!isUserExist(email,userRole)){
            if(userRole.equals(UserRole.ADMIN)){
                userDatabase.addUser(email,new Admin(userName,email,password,userRole, ManagerFactory.getUserDataManager(),ManagerFactory.getOrderDataManager(),ManagerFactory.getProductDataManager()));
            }
            else {
                userDatabase.addUser(email,new Customer(userName,email,password,userRole,ManagerFactory.getProductDataManager(),ManagerFactory.getOrderDataManager(),ManagerFactory.getUserDataManager()));
            }
            return Message.REGISTER_SUCCESS;
        }
        return Message.REGISTER_FAILED+"\n"+Message.USER_EXIST;
    }
    public boolean validateUser(String email,String password,UserRole userRole){
        Map<String,User> users=getUsers();
        if(userRole.equals(UserRole.CUSTOMER)&&users.containsKey(email)&&users.get(email).getPassword().equals(password)
                &&users.get(email) instanceof Customer){
            return true;
        }
        else if(userRole.equals(UserRole.ADMIN)&&users.containsKey(email)&&users.get(email).getPassword().equals(password)
                &&users.get(email) instanceof Admin){
            return true;
        }
        return false;
    }




}
