package com.zoho.supermarket.database.repository;

import com.zoho.supermarket.core.model.product.Cart;

import com.zoho.supermarket.core.model.product.Order;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.user.Customer;
import com.zoho.supermarket.core.respository.order.AdminOrderManager;
import com.zoho.supermarket.core.respository.order.CustomerOrderManager;
import com.zoho.supermarket.database.model.OrderDatabase;
import com.zoho.supermarket.database.model.ProductDatabase;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;

public class OrderDataManager implements CustomerOrderManager, AdminOrderManager {

    private final OrderDatabase orderDatabase;
    private final ProductDatabase productDatabase;

    public OrderDataManager( OrderDatabase orderDatabase, ProductDatabase productDatabase) {
        this.orderDatabase = orderDatabase;
        this.productDatabase = productDatabase;
    }

    @Override
    public String addToCart(String phoneNumber,String productName, int qty) {
        Product product =  productDatabase.getProduct(productName);
        return orderDatabase.addToCart(phoneNumber,productName, qty, product);
    }

    public List<Cart> getCart(String phoneNumber) {
        return orderDatabase.getCart(phoneNumber);
    }

    public List<String> getCartProducts(String phoneNumber){
        double totalAmount=0;
        List<Cart> cart=getCart(phoneNumber);
        List<String> cartProducts=new ArrayList<>();
        if(ValidationUtil.isListValid(cart)) {
            cartProducts.add("========================================================================================================================================");
            cartProducts.add("Product Name\t|\tQuantity\t|\tPrice\t|\tTotal Amount\t\t|\t\tDiscount Percentage\t\t|\t\tTotal Amount After Discount");
            cartProducts.add("========================================================================================================================================");
            for (Cart product : cart) {
                double discountPercentage = productDatabase.getDiscountPercentage(product.getProduct().getProductName());
                double price;
                if (discountPercentage != 0) {
                    price = calculatePrice(product.getProduct().getUnitPrice(), discountPercentage);
                } else {
                    price = product.getQty() * product.getProduct().getUnitPrice();
                }
                cartProducts.add(product.getProduct().getProductName() + "\t\t\t\t" + product.getQty() +
                        "\t\t\t\t" + product.getProduct().getUnitPrice() + "\t\t\t\t" + product.getQty() * product.getProduct().getUnitPrice() + "\t\t\t\t\t" + discountPercentage + "\t\t\t\t\t\t\t" + product.getQty() * price);
                totalAmount += product.getQty() * price;
            }
            cartProducts.add("\n");
            cartProducts.add("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tTotal Amount: " + totalAmount);
            cartProducts.add("========================================================================================================================================");
        }
        return cartProducts;
    }

    @Override
    public void clearCart(String phoneNumber) {
        orderDatabase.clearCart(phoneNumber);
    }

    public double calculatePrice(double productPrice, double discountPercentage) {
        return productPrice - (productPrice * (discountPercentage / 100));
    }

    @Override
    public void addToOrders(Customer customer) {
        orderDatabase.addToOrders(customer, getCartProducts(customer.getPhoneNumber()));
    }
    public List<Order> getAllOrders(){
        return orderDatabase.getOrders();
    }



}
