package com.zoho.supermarket.database.model.implementation;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.product.Cart;
import com.zoho.supermarket.core.model.product.Order;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.user.Customer;
import com.zoho.supermarket.database.model.OrderDatabase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderDatabaseImpl implements OrderDatabase {
    private final List<Order> orders =new ArrayList<>();
    private final List<Cart> cart = new ArrayList<>();
    private static OrderDatabaseImpl Instance=null;
    private OrderDatabaseImpl(){}

    public static OrderDatabaseImpl getInstance(){
        if(Instance ==null){
            return new OrderDatabaseImpl();
        }
        return Instance;
    }
    public List<Order> getAllOrders(){
        return orders;
    }

    public String addToCart(String productName, int quantity,Product product) {
        Cart productFromCart = getProductFromCart(productName);
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
                cart.add(new Cart(quantity, product));
                return Message.PRODUCT_ADDED;
            }
            else {
                return Message.OUT_OF_STOCK;
            }
        }
        return Message.NO_PRODUCT_EXIST;
    }
    public void addToOrder(Customer customer){
        orders.add(new Order(customer,cart));
        cart.clear();
    }

    private Cart getProductFromCart(String productName) {
        for (Cart productFromCart : cart) {
            if (productFromCart.getProduct().getProductName().equalsIgnoreCase(productName)) {
                return productFromCart;
            }
        }
        return null;
    }
    public List<Cart> getCart(){
        return cart;
    }
}
