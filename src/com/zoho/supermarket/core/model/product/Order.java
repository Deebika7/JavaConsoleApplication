package com.zoho.supermarket.core.model.product;

import com.zoho.supermarket.core.model.user.Customer;

import java.util.List;

public class Order {
    private final Customer customer;
    private final List<Cart> cart;

    public Customer getCustomer() {
        return customer;
    }

    public List getCart() {
        return cart;
    }

    public Order(Customer customer, List cart) {
        this.customer = customer;
        this.cart = cart;
    }
}
