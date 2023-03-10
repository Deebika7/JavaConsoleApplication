package com.zoho.supermarket.userinterface.menu;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.product.ProductCategory;
import com.zoho.supermarket.core.model.user.Admin;
import com.zoho.supermarket.userinterface.menu.enums.AdminOptions;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

import java.util.List;
import java.util.Random;

public class AdminMenu {
    private final Admin admin;
    public AdminMenu(Admin admin) {
        this.admin = admin;
    }
    public void printAdminMenu(){
        while (true) {
            System.out.println("Enter your choice: ");
            for (AdminOptions option : AdminOptions.values()) {
                System.out.println(option.ordinal() + 1 + ". " + option.name());
            }
            int choice = ValidationUtil.getValidEnumInput(AdminOptions.values().length);
            AdminOptions option = AdminOptions.values()[choice - 1];
            switch (option) {
                case ADD_PRODUCT -> addProducts();
                case REMOVE_PRODUCT -> removeProduct();
                case VIEW_PRODUCT -> viewProducts();
                case ADD_DISCOUNT -> addDiscount();
                case REMOVE_DISCOUNT ->removeDiscount();
                case VIEW_DISCOUNTS ->viewDiscounts();
                case LIST_ORDERS -> displayAllOrders();
                case QUIT -> {return;}
            }
        }
    }

    private void displayAllOrders() {
        List<Object> orders=admin.getAllOrders();
        if(ValidationUtil.isListValid(orders)) {
            orders.forEach(System.out::println);
        }
        else {
            System.out.println("no orders placed yet!");
        }
    }

    private void addProducts() {
            System.out.println("Select Category to add Items");
            printProductCategory();
            ProductCategory productCategory = getProductCategory();
            System.out.println("Enter Product Name: ");
            String productName = ValidationUtil.getValidStringInput();
            System.out.println("Enter Quantity: ");
            int quantity = ValidationUtil.getValidProductQuantityInput();
            System.out.println("Enter Unit Price: ");
            double unitPrice = ValidationUtil.getValidPriceInput();
            System.out.println(admin.add(new Random().nextInt(1000, 9999), productName, quantity, unitPrice, productCategory));
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
    private void viewProducts() {
        printProductCategory();
        System.out.println("Select Category to display items:");
        ProductCategory productCategory = getProductCategory();
        List<Product> products = admin.getProducts();
        if(ValidationUtil.isListValid(products)) {
        System.out.println("==========================\t"+productCategory.name()+"\t=================================================");
        System.out.println("=====================================================================================");
        System.out.println("Product ID\t|\tProduct Name\t|\tunit price\t|\tAvailable quantity");
        System.out.println("=====================================================================================");
            products.stream().filter(product -> product.getCategory().equals(productCategory)).
                    forEach(product -> System.out.println(product.getProductID() + "\t\t\t" + product.getProductName()
                            + "\t\t\t\t\t" + product.getUnitPrice() + "\t\t\t\t" + product.getQuantity()));
        System.out.println("=====================================================================================");
        }
        else {
            System.out.println(Message.NO_PRODUCT_EXIST);
        }
    }
    private void removeProduct(){
        System.out.println("Enter Product Name to remove: ");
        String productName=ValidationUtil.getValidStringInput();
        System.out.println(admin.remove(productName));

    }

    private boolean viewDiscounts() {
        if(!admin.getDiscounts().isEmpty()){
            List<String> discounts=admin.getDiscounts();
            discounts.forEach(System.out::println);
            return true;
        }
        else {
            System.out.println(Message.NO_DISCOUNT_EXIST);
        }
        return false;
    }

    private void removeDiscount() {
        if(viewDiscounts()) {
            System.out.println("Enter Discount ID : ");
            int discountID = ValidationUtil.getValidIntegerInput();
            System.out.println(admin.removeDiscount(discountID));
        }
    }

    private void addDiscount(){
        System.out.println("Enter Product Name: ");
        String productName=ValidationUtil.getValidStringInput();
        System.out.println("Enter Discount Percentage: ");
        double discountPercentage=ValidationUtil.getValidDiscountInput();
        System.out.println(admin.addDiscount(productName,discountPercentage));
    }
}
