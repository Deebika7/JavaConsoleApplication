package com.zoho.supermarket.core.model.user;

import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.respository.order.CustomerOrderManager;
import com.zoho.supermarket.core.respository.product.CustomerProductManager;
import com.zoho.supermarket.core.respository.user.UserDetailsManager;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private final CustomerProductManager customerProductManager;
    private final CustomerOrderManager customerOrderManager;
    private final UserDetailsManager userDetailsManager;



    public Customer(String userName, String password, UserRole customer,
                    CustomerProductManager customerProductManager, CustomerOrderManager customerOrderManager,
                    UserDetailsManager userDetailsManager) {
        super(userName, password, customer);
        this.customerProductManager = customerProductManager;
        this.customerOrderManager = customerOrderManager;
        this.userDetailsManager=userDetailsManager;
    }

    public void logout(){
        customerOrderManager.clearCart();
    }
    public List<String> getCartProducts(){
        return customerOrderManager.getCartProducts();
    }
    public String addToCart(String productName, int quantity){
       return customerOrderManager.addToCart(productName,quantity);
    }
    public List<String> getBill(){
        return  customerOrderManager.getBill();
    }
    public String updateOrder(Customer customer){
        String message= customerProductManager.updateOrder(customer);
        customerOrderManager.clearCart();
        return message;
    }
    public List<String> getDiscounts(){
        return customerProductManager.getDiscounts();
    }
    public List<Product> getProducts(){
        List<Product> products= customerProductManager.getProducts();
        List<Product> deepCopyOfProducts=new ArrayList<>();
        if(ValidationUtil.isListValid(products)){
            for (Product product:products){
                deepCopyOfProducts.add((Product) product.clone());
            }
        }
        return null;
    }

}
