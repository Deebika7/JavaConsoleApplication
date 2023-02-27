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
    public String addToCart(String productName, int qty) {
        Product product =  productDatabase.getProduct(productName);
        return orderDatabase.addToCart(productName, qty, product);
    }

    public List<Cart> getCart() {
        return orderDatabase.getCart();
    }

    public List<String> getCartProducts(){
        double totalAmount=0;
        List<Cart> cart=getCart();
        List<String> cartProducts=new ArrayList<>();
        if(ValidationUtil.isListValid(cart)) {
            cartProducts.add("\n");
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
    public double calculatePrice(double productPrice, double discountPercentage) {
        return productPrice - (productPrice * (discountPercentage / 100));
    }

    @Override
    public void clearCart() {
        orderDatabase.clearCart();
    }

    @Override
    public void addToOrders(Customer customer) {
        orderDatabase.addToOrders(customer, getCartProducts());
    }
    public List<Order> getAllOrders(){
        return orderDatabase.getOrders();
    }



}
