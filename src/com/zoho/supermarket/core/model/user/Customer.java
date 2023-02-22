package com.zoho.supermarket.core.model.user;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.product.Order;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.respository.order.CustomerOrderManager;
import com.zoho.supermarket.core.respository.product.CustomerProductManager;
import com.zoho.supermarket.core.respository.user.CustomerDataManager;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private final CustomerProductManager customerProductManager;
    private final CustomerOrderManager customerOrderManager;
    private final CustomerDataManager customerDataManager;
    private final List<Order> cart = new ArrayList<>();


    public Customer(String userName, String password, UserRole customer,
                    CustomerProductManager customerProductManager, CustomerOrderManager customerOrderManager,
                    CustomerDataManager customerDataManager) {
        super(userName, password, customer);
        this.customerProductManager = customerProductManager;
        this.customerOrderManager = customerOrderManager;
        this.customerDataManager = customerDataManager;
    }

    public CustomerProductManager getCustomerProductManager() {
        return customerProductManager;
    }

    public CustomerOrderManager getCustomerOrderManager() {
        return customerOrderManager;
    }

    public CustomerDataManager getCustomerDataManager() {
        return customerDataManager;
    }

    public List<String> getCart() {
        List<String> cartProducts=new ArrayList<>();
        cartProducts.add("Product Name\t\tQuantity\t\tPrice");
        cart.forEach(cartProduct->cartProducts.add(cartProduct.getProduct().getProductName()
                +"\t\t\t\t"+cartProduct.getQty()+"\t\t"+cartProduct.getProduct().getUnitPrice()));
        return cartProducts;
    }


    public String addToCart(String productName, int quantity) {
        Product product = customerOrderManager.addToCart(productName);
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

}
