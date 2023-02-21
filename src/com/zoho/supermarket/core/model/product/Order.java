package com.zoho.supermarket.core.model.product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int qty;
    private double totalAmount;
    private Product product;
    List<Order> cart=new ArrayList<>();
    public Order(){

    }
    public Order(int qty, Product product) {
        this.qty = qty;
        this.product = product;
    }
    public void addTocart(Order order){
        cart.add(order);
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty){
        this.qty=qty;
    }
    public void changeQty(int qty,String productName) {
        cart.stream().filter(product->product.getProduct().getProductName().equalsIgnoreCase(productName))
                .forEach(product->product.setQty(qty));
    }

    public Product getProduct() {
        return product;
    }

    public List<Order> getCart() {
        return new ArrayList<>(cart);
    }
}
