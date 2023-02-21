package com.zoho.supermarket.userinterface.menu;


import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.product.ProductCategory;
import com.zoho.supermarket.core.respository.order.CustomerOrderManager;
import com.zoho.supermarket.core.respository.product.CustomerProductManager;
import com.zoho.supermarket.userinterface.menu.enums.CustomerOptions;

import com.zoho.supermarket.userinterface.util.ValidationUtil;

import java.util.List;

public class CustomerMenu {
    private final CustomerOrderManager customerOrderManager;
    private final CustomerProductManager customerProductManager;

    public CustomerMenu(CustomerOrderManager customerOrderManager, CustomerProductManager customerProductManager) {
        this.customerOrderManager = customerOrderManager;
        this.customerProductManager = customerProductManager;
    }
    public void start() {
        while (true) {
            System.out.println("Enter your choice: ");
            for (CustomerOptions option : CustomerOptions.values()) {
                System.out.println(option.ordinal() + 1 + ". " + option.name());
            }
            int choice = ValidationUtil.getValidEnumInput(CustomerOptions.values().length);
            CustomerOptions option = CustomerOptions.values()[choice - 1];
            switch (option) {
                case VIEW_PRODUCTS -> viewProducts();
                case ADD_PRODUCT_TO_CART -> addToCart();
                case VIEW_CART -> viewCart();
                case CHECK_DISCOUNT -> {
                }
                case GENERATE_BILL -> {
                }
                case PLACE_ORDER -> {
                }
                case QUIT -> {return;}
            }
        }
    }

    private void viewCart() {
        List<String> cart=customerOrderManager.getCartProducts();
        if(ValidationUtil.isListValid(cart)){
            cart.stream().forEach(product->System.out.println(product));
        }
        else {
            System.out.println(Message.EMPTY_CART);
        }
    }

    private void printProductCategory() {
        for (ProductCategory productCategory:ProductCategory.values()){
            System.out.println(productCategory.ordinal() + 1 + ". " + productCategory.name());
        }
    }
    ProductCategory getProductCategory() {
        int category = ValidationUtil.getValidEnumInput(ProductCategory.values().length);
        return ProductCategory.values()[category-1];
    }
    public void viewProducts() {
        printProductCategory();
        System.out.println("Select Category to display items:");
        ProductCategory itemCategory = getProductCategory();
        List<Product> products = customerProductManager.getProducts();
        System.out.println("======================="+itemCategory.name()+"====================================");
        System.out.println("Item ID\t\tProduct Name\t\tunit price\t\tAvailable quantity");
        products.stream().filter(product -> product.getCategory().equals(itemCategory)).
                forEach(product -> System.out.println(product.getProductID() + "\t\t" + product.getProductName()
                        +"\t\t\t\t" + product.getUnitPrice() + "\t\t\t" + product.getQuantity()));
    }
    private void addToCart() {
        System.out.println("Enter Product Name: ");
        String productName=ValidationUtil.getValidStringInput();
        System.out.println("Enter Quantity: ");
        int quantity=ValidationUtil.getValidProductQtyInput();
        System.out.println(customerOrderManager.addToCart(productName,quantity));
    }





}
