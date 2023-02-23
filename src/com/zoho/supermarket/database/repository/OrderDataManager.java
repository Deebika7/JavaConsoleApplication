package com.zoho.supermarket.database.repository;

import com.zoho.supermarket.core.model.product.Cart;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.respository.order.AdminOrderManager;
import com.zoho.supermarket.core.respository.order.CustomerOrderManager;
import com.zoho.supermarket.database.model.OrderDatabase;
import com.zoho.supermarket.database.model.ProductDatabase;

import java.util.ArrayList;
import java.util.List;


public class OrderDataManager implements AdminOrderManager, CustomerOrderManager {

    private final OrderDatabase orderDatabase;
    private final ProductDatabase productDatabase;

    public OrderDataManager( OrderDatabase orderDatabase, ProductDatabase productDatabase) {
        this.orderDatabase = orderDatabase;
        this.productDatabase = productDatabase;
    }

    @Override
    public String addToCart(String productName, int qty) {
        Product product = productDatabase.getProduct(productName);
        return orderDatabase.addToCart(productName, qty, product);
    }

    public List<Cart> getCart() {
        return orderDatabase.getCart();
    }

    public List<String> getBill(){
        double totalAmount=0;
        List<Cart> cart=getCart();
        List<String> bill=new ArrayList<>();
        bill.add("Product Name\t\tQuantity\t\tPrice\t\tTotal Amount");
        for(Cart product:cart){
            bill.add(product.getProduct().getProductName()+"\t\t\t\t"+product.getQty()+
                    "\t\t\t"+product.getProduct().getUnitPrice()+"\t\t\t"+product.getQty()*product.getProduct().getUnitPrice());
            totalAmount+=product.getQty()*product.getProduct().getUnitPrice();
        }
        bill.add("\t\t\t\t\t\t\t\t\t\tTotal Amount"+totalAmount);
        return bill;
    }

    public List<String> getCartProducts() {
        List<Cart> cart=getCart();
        List<String> cartProducts=new ArrayList<>();
        cartProducts.add("Product Name\t\tQuantity\t\tPrice");
        cart.forEach(cartProduct->cartProducts.add(cartProduct.getProduct().getProductName()
                +"\t\t\t\t"+cartProduct.getQty()+"\t\t\t"+cartProduct.getProduct().getUnitPrice()));
        return cartProducts;
    }


//    @Override
//    public List<Order> getAllOrders() {
//        List<String> order=new ArrayList<>();
//        List<Order> orders=orderDatabase.getAllOrders();
//        orders.stream().forEach(order -> order.getCustomer().getUserName());
//        return null;
//    }
}
