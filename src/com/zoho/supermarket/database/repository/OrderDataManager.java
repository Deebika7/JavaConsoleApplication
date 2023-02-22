package com.zoho.supermarket.database.repository;

import com.zoho.supermarket.core.model.product.Order;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.respository.order.AdminOrderManager;
import com.zoho.supermarket.core.respository.order.CustomerOrderManager;
import com.zoho.supermarket.database.model.OrderDatabase;
import com.zoho.supermarket.database.model.ProductDatabase;

import java.util.ArrayList;
import java.util.List;


public class OrderDataManager implements AdminOrderManager, CustomerOrderManager {
    private final UserDataManager dataManager;
    private final OrderDatabase orderDatabase;
    private final ProductDatabase productDatabase;

    public OrderDataManager(UserDataManager dataManager, OrderDatabase orderDatabase, ProductDatabase productDatabase) {
        this.dataManager = dataManager;
        this.orderDatabase = orderDatabase;
        this.productDatabase = productDatabase;
    }

    @Override
    public String addToCart(String productName, int qty) {
        Product product = productDatabase.getProduct(productName);
        return orderDatabase.addToCart(productName, qty, product);
    }

    public List<Order> getCart() {
        return orderDatabase.getCart();
    }

    public List<String> getBill(){
        double totalAmount=0;
        List<Order> cart=getCart();
        List<String> bill=new ArrayList<>();
        bill.add("Product Name\t\tQuantity\t\tPrice\t\tTotal Amount");
        for(Order product:cart){
            bill.add(product.getProduct().getProductName()+"\t\t\t\t"+product.getQty()+
                    "\t\t\t"+product.getProduct().getUnitPrice()+"\t\t\t"+product.getQty()*product.getProduct().getUnitPrice());
            totalAmount+=product.getQty()*product.getProduct().getUnitPrice();
        }
        bill.add("\t\t\t\t\t\t\t\t\t\tTotal Amount"+totalAmount);
        return bill;
    }

    public List<String> getCartProducts() {
        List<Order> cart=getCart();
        List<String> cartProducts=new ArrayList<>();
        cartProducts.add("Product Name\t\tQuantity\t\tPrice");
        cart.forEach(cartProduct->cartProducts.add(cartProduct.getProduct().getProductName()
                +"\t\t\t\t"+cartProduct.getQty()+"\t\t\t"+cartProduct.getProduct().getUnitPrice()));
        return cartProducts;
    }


}
