package com.zoho.supermarket.core.model.user;

import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.product.ProductCategory;
import com.zoho.supermarket.core.respository.product.AdminProductManager;
import com.zoho.supermarket.core.respository.user.UserDetailsManager;

import java.util.List;


public class Admin extends User{
    private final UserDetailsManager userDetailsManager;
    private final AdminProductManager adminProductManager;


    public Admin(String userName,  String password, UserRole admin,
                 UserDetailsManager userDetailsManager,
                 AdminProductManager adminProductManager) {
        super(userName, password, admin);
        this.userDetailsManager = userDetailsManager;
        this.adminProductManager = adminProductManager;
    }

    public UserDetailsManager getUserDataManager() {
        return userDetailsManager;
    }


    public String add(int productID, String productName, int quantity, double unitPrice, ProductCategory productCategory){
        return adminProductManager.add(productID,productName,quantity,unitPrice,productCategory);
    }
    public String remove(String productName){
        return adminProductManager.remove(productName);
    }
    public String addDiscount(String productName, double discountPercentage){
        return adminProductManager.addDiscount(productName,discountPercentage);
    }
    public String removeDiscount(int discountID){
        return adminProductManager.removeDiscount(discountID);
    }
    public List<String> getDiscounts(){
        return adminProductManager.getDiscounts();
    }
    public List<Product> getProducts(){
        return adminProductManager.getProducts();
    }

}
