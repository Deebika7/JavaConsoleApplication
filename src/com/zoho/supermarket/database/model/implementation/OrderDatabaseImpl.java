package com.zoho.supermarket.database.model.implementation;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.product.Cart;
import com.zoho.supermarket.core.model.product.Order;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.user.Customer;
import com.zoho.supermarket.database.model.OrderDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDatabaseImpl implements OrderDatabase {
    private final Map<String, List<Cart>> carts = new HashMap<>();
    private static OrderDatabaseImpl Instance = null;
    private final List<Order> orders = new ArrayList<>();

    private OrderDatabaseImpl() {}

    public static OrderDatabaseImpl getInstance() {
        if (Instance == null) {
            Instance = new OrderDatabaseImpl();
        }
        return Instance;
    }

    public void createCart(String phoneNumber) {
        carts.put(phoneNumber, new ArrayList<>());
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    @Override
    public void clearCart(String phoneNumber) {
        carts.remove(phoneNumber, carts.get(phoneNumber));
    }

    @Override
    public boolean removeProductFromCart(String phoneNumber,String productName) {
        List<Cart> cart=getCart(phoneNumber);
        if(!cart.isEmpty()) {
            Cart cartProduct = getProductFromCart(productName, cart);
            if(cartProduct!=null) {
                cart.remove(cartProduct);
                return true;
            }
        }
        return false;
    }

    public String addToCart(String phoneNumber, String productName, int quantity, Product product) {
        if (!carts.containsKey(phoneNumber)) {
            createCart(phoneNumber);
        }
        List<Cart> cart = carts.get(phoneNumber);
        Cart productFromCart = getProductFromCart(productName, cart);
        if (product != null) {
            if (productFromCart != null) {
                if (product.getQuantity() >= productFromCart.getQuantity() + quantity) {
                    productFromCart.setQty(quantity + productFromCart.getQuantity());
                    return Message.PRODUCT_ADDED;
                } else {
                    return Message.OUT_OF_STOCK;
                }
            }
            if (product.getQuantity() >= quantity) {
                cart.add(new Cart(quantity, product));
                return Message.PRODUCT_ADDED;
            } else {
                return Message.OUT_OF_STOCK;
            }
        }
        return Message.NO_PRODUCT_EXIST;
    }

    @Override
    public void addToOrders(Customer customer, List<String> bill) {
        orders.add(new Order(customer, bill));
    }

    private Cart getProductFromCart(String productName, List<Cart> cart) {
        for (Cart productFromCart : cart) {
            if (productFromCart.getProduct().getProductName().equalsIgnoreCase(productName)) {
                return productFromCart;
            }
        }
        return null;
    }

    public List<Cart> getCart(String phoneNumber) {
        if (carts.containsKey(phoneNumber)) {
            List<Cart> cart = carts.get(phoneNumber);
            List<Cart> outOfStock = new ArrayList<>();
            for (Cart cartProduct : cart) {
                Product product = ProductDatabaseImpl.getInstance().getProduct(cartProduct.getProduct().getProductName());
                if ((cartProduct.getQuantity() > product.getQuantity())) {
                    outOfStock.add(cartProduct);
                }
            }
            for (Cart product : outOfStock) {
                cart.remove(product);
            }
            return cart;
        }
        return null;
    }
}
