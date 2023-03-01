package com.zoho.supermarket.core.model.user;

import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.respository.order.CustomerOrderManager;
import com.zoho.supermarket.core.respository.product.CustomerProductManager;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private final CustomerProductManager customerProductManager;
    private final CustomerOrderManager customerOrderManager;

    public Customer(String phoneNumber,String userName, String password, UserRole customer,
                    CustomerProductManager customerProductManager, CustomerOrderManager customerOrderManager) {
        super(phoneNumber,userName, password, customer);
        this.customerProductManager = customerProductManager;
        this.customerOrderManager = customerOrderManager;
    }

    public String addToCart(String productName, int quantity){
       return customerOrderManager.addToCart(this.getPhoneNumber(),productName,quantity);
    }
    public List<String> getCartProducts(){
        return  customerOrderManager.getCartProducts(this.getPhoneNumber());
    }
    public String placeOrder(){
        String message= customerProductManager.placeOrder(this.getPhoneNumber());
        customerOrderManager.addToOrders(this);
        customerOrderManager.clearCart(this.getPhoneNumber());
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
                deepCopyOfProducts.add(product.getCopyOfProduct(product));
            }
        }
        return deepCopyOfProducts;
    }
    public String removeProductFromCart(String productName){
        return customerOrderManager.removeProductFromCart(this.getPhoneNumber(),productName);
    }
}
