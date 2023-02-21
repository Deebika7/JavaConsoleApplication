package com.zoho.supermarket.database.repository;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.product.Order;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.respository.order.AdminOrderManager;
import com.zoho.supermarket.core.respository.order.CustomerOrderManager;
import com.zoho.supermarket.database.model.OrderDatabase;
import com.zoho.supermarket.database.model.ProductDatabase;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;


public class OrderDataManager implements AdminOrderManager, CustomerOrderManager {
    private final UserDataManager dataManager;
    private final OrderDatabase orderDatabase;
    private final ProductDatabase productDatabase;
    private Order order=new Order();

    public OrderDataManager(UserDataManager dataManager, OrderDatabase orderDatabase, ProductDatabase productDatabase) {
        this.dataManager = dataManager;
        this.orderDatabase = orderDatabase;
        this.productDatabase = productDatabase;
    }

    @Override
    public String addToCart(String productName, int quantity) {
        List<Product> products=productDatabase.getProducts();
        Order cartProduct=getCartProduct(productName);
        for (Product product:products) {
            if (ValidationUtil.isInstanceValid(cartProduct)) {
                if(product.getQuantity()>=cartProduct.getProduct().getQuantity()+quantity){
                    cartProduct.changeQty(cartProduct.getProduct().getQuantity()+quantity,productName);
                    return Message.ADDED_TO_CART;
                }
                else {
                    return Message.OUT_OF_STOCK;
                }
            } else {
                if(product.getQuantity()>=quantity){
                    order.addTocart(new Order(quantity,product));
                    return Message.ADDED_TO_CART;
                }
                else {
                    return Message.OUT_OF_STOCK;
                }
            }
        }
        return Message.NO_PRODUCT_EXIST;
    }
    public Order getCartProduct(String productName){
        List<Order> orders=getCart();
        for (Order instance:orders){
            if(instance.getProduct().getProductName().equalsIgnoreCase(productName)){
                return instance;
            }
        }
        return null;
    }
    public List<String> getCartProducts(){
        List<String> cartProducts=new ArrayList<>();
        List<Order> cart=getCart();
        if(ValidationUtil.isListValid(cart)){
            cartProducts.add("Product Name\t\tProduct Quantity");
            cart.stream().forEach(cartProduct -> cartProducts.add(cartProduct.getProduct().getProductName()+"\t\t"+cartProduct.getQty()));
            return cartProducts;
        }
        return null;
    }


    public List<Order> getCart(){

        return order.getCart();
    }

}
