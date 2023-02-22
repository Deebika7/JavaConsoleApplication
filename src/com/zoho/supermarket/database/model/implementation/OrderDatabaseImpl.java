package com.zoho.supermarket.database.model.implementation;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.product.Order;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.user.Customer;
import com.zoho.supermarket.database.model.OrderDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDatabaseImpl implements OrderDatabase {
    private final Map<Customer,List<Order>> orders=new HashMap<>();
    private final List<Order> cart = new ArrayList<>();
    private static OrderDatabaseImpl Instance=null;
    private OrderDatabaseImpl(){}
    public static OrderDatabaseImpl getInstance(){
        if(Instance ==null){
            return new OrderDatabaseImpl();
        }
        return Instance;
    }

    public String addToCart(String productName, int quantity,Product product) {
        Order productFromCart = getProductFromCart(productName);
        if (product != null) {
            if (productFromCart != null) {
                if (product.getQuantity() >= productFromCart.getQty() + quantity) {
                    productFromCart.setQty(quantity + productFromCart.getQty());
                    return Message.PRODUCT_ADDED;
                }
                else {
                    return Message.OUT_OF_STOCK;
                }
            }
            if (product.getQuantity() >= quantity) {
                cart.add(new Order(quantity, product));
                return Message.PRODUCT_ADDED;
            }
            else {
                return Message.OUT_OF_STOCK;
            }
        }
        return Message.NO_PRODUCT_EXIST;
    }




    private Order getProductFromCart(String productName) {
        for (Order productFromCart : cart) {
            if (productFromCart.getProduct().getProductName().equalsIgnoreCase(productName)) {
                return productFromCart;
            }
        }
        return null;
    }
    public List<Order> getCart(){
        return cart;
    }
}
