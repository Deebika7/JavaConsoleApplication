package com.zoho.supermarket.userinterface.menu;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.product.ProductCategory;
import com.zoho.supermarket.core.respository.order.AdminOrderManager;
import com.zoho.supermarket.core.respository.product.AdminProductManager;
import com.zoho.supermarket.userinterface.menu.enums.AdminOptions;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

import java.util.List;
import java.util.Random;

public class AdminMenu implements Menu{
    private final AdminOrderManager adminOrderManager;
    private final AdminProductManager adminProductManager;

    public AdminMenu(AdminOrderManager adminOrderManager, AdminProductManager adminProductManager) {
        this.adminOrderManager = adminOrderManager;
        this.adminProductManager = adminProductManager;
    }

    public void start(){
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
                case LIST_ORDERS -> {}
                case QUIT -> {return;}
            }
        }
    }
    private void addProducts(){
        System.out.println("Select Category to add Items");
        printProductCategory();
        ProductCategory itemCategory = getProductCategory();
        System.out.println("Enter Product Name: ");
        String productName=ValidationUtil.getValidStringInput();
        System.out.println("Enter Quantity: ");
        int quantity=ValidationUtil.getValidProductQtyInput();
        System.out.println("Enter Unit Price: ");
        double unitPrice=ValidationUtil.getValidPriceInput();
        System.out.println(adminProductManager.add(new Random().nextInt(1000,9999),  productName, quantity,  unitPrice,  itemCategory));
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
        List<Product> products = adminProductManager.getProducts();
        System.out.println("======================="+itemCategory.name()+"====================================");
        System.out.println("Item ID\t\tProduct Name\t\tunit price\t\tAvailable quantity");
        products.stream().filter(product -> product.getCategory().equals(itemCategory)).
                forEach(product -> System.out.println(product.getProductID() + "\t\t" + product.getProductName()
                        +"\t\t\t\t" + product.getUnitPrice() + "\t\t\t" + product.getQuantity()));
    }
    private void removeProduct(){
        System.out.println("Enter Product Name to remove: ");
        String productName=ValidationUtil.getValidStringInput();
        System.out.println(adminProductManager.remove(productName));
    }
    private void viewDiscounts() {
        if(!adminProductManager.getDiscounts().isEmpty()){
            List<String> discounts=adminProductManager.getDiscounts();
            discounts.stream().forEach(discount -> System.out.println(discount));
        }
        else {
            System.out.println(Message.NO_DISCOUNT_EXIST);
        }
    }

    private void removeDiscount() {
        System.out.println("Enter Discount ID : ");
        int discountID=ValidationUtil.getValidIntegerInput();
        System.out.println(adminProductManager.removeDiscount(discountID));
    }

    private void addDiscount(){
        System.out.println("Enter Product Name: ");
        String productName=ValidationUtil.getValidStringInput();
        System.out.println("Enter Discount Percentage: ");
        double discountPercentage=ValidationUtil.getValidDiscountInput();
        System.out.println(adminProductManager.addDiscount(productName,discountPercentage));
    }


}
