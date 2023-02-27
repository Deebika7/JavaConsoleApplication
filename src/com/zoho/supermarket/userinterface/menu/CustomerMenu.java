package com.zoho.supermarket.userinterface.menu;


import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.product.ProductCategory;
import com.zoho.supermarket.core.model.user.Customer;
import com.zoho.supermarket.userinterface.menu.enums.CustomerOptions;

import com.zoho.supermarket.userinterface.util.ValidationUtil;


import java.util.List;

public class CustomerMenu {
    private final Customer customer;

    public CustomerMenu(Customer customer) {
        this.customer = customer;
    }

    public void printCustomerMenu() {
        while (true) {
            System.out.println("Enter your choice: ");
            for (CustomerOptions option : CustomerOptions.values()) {
                System.out.println(option.ordinal() + 1 + ". " + option.name());
            }
            int choice = ValidationUtil.getValidEnumInput(CustomerOptions.values().length);
            CustomerOptions option = CustomerOptions.values()[choice - 1];
            switch (option) {
                case VIEW_PRODUCTS -> viewProducts();
                case ADD_PRODUCT_TO_CART ->addToCart();
                case VIEW_CART -> viewCart();
                case CHECK_DISCOUNT ->  viewDiscounts();
                case GENERATE_BILL -> generateBill();
                case PLACE_ORDER -> placeOrder();
                case QUIT -> { logout();
                    return;}
            }
        }
    }

    private void logout() {
        System.out.println("Thank You!");
        customer.logout();
    }

    private void placeOrder( ) {
        System.out.println(customer.placeOrder(customer));
    }

    private void generateBill() {
        List<String> bill=customer.getBill();
        System.out.println("=====================================================================================");
        bill.forEach(System.out::println);
        System.out.println("=====================================================================================");
    }

    private void viewDiscounts() {
        if(!customer.getDiscounts().isEmpty()){
            List<String> discounts=customer.getDiscounts();
            System.out.println("=====================================================================================");
            discounts.forEach(System.out::println);
            System.out.println("=====================================================================================");
        }
        else {
            System.out.println(Message.NO_DISCOUNT_EXIST);
        }
    }

    private void viewCart() {
        List<String> cart=customer.getCartProducts();
        if(ValidationUtil.isListValid(cart)){
            cart.forEach(System.out::println);
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
        ProductCategory productCategory = getProductCategory();
        List<Product> products = customer.getProducts();
        System.out.println("=====================================================================================");
        System.out.println("======================="+productCategory.name()+"====================================");
        System.out.println("Product ID\t\tProduct Name\t\tUnit price\t\tAvailable quantity");
        products.stream().filter(product -> product.getCategory().equals(productCategory)).
                forEach(product -> System.out.println(product.getProductID() + "\t\t" + product.getProductName()
                        +"\t\t\t\t" + product.getUnitPrice() + "\t\t\t" + product.getQuantity()));
        System.out.println("=====================================================================================");
    }
    private void addToCart() {
        System.out.println("Enter Product Name: ");
        String productName=ValidationUtil.getValidStringInput();
        System.out.println("Enter Quantity: ");
        int quantity=ValidationUtil.getValidProductQuantityInput();
        System.out.println(customer.addToCart(productName,quantity));
    }
}
