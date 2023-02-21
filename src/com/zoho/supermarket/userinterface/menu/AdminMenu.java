package com.zoho.supermarket.userinterface.menu;

import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.product.ProductCategory;
import com.zoho.supermarket.core.respository.order.AdminOrderManager;
import com.zoho.supermarket.core.respository.product.AdminProductManager;
import com.zoho.supermarket.userinterface.menu.enums.AdminOptions;
import com.zoho.supermarket.userinterface.util.ManagerFactory;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

import java.util.List;
import java.util.Random;

public class AdminMenu {
    private final AdminOrderManager adminOrderManager;
    private final AdminProductManager adminProductManager;

    public AdminMenu(AdminOrderManager adminOrderManager, AdminProductManager adminProductManager) {
        this.adminOrderManager = adminOrderManager;
        this.adminProductManager = adminProductManager;
    }

    private final AdminMenu adminMenu=new AdminMenu(ManagerFactory.getOrderDataManager(),ManagerFactory.getProductDataManager());
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
                case ADD_DISCOUNT -> {}
                case REMOVE_DISCOUNT ->{}
                case VIEW_DISCOUNTS ->{}
                case LIST_ORDERS -> {}
                case QUIT -> {}
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
        System.out.println(adminMenu.adminProductManager.add(new Random().nextInt(1000,9999),  productName, quantity,  unitPrice,  itemCategory));
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
        List<Product> products = adminMenu.adminProductManager.getProducts();
        System.out.println("======================="+itemCategory.name()+"====================================");
        System.out.println("Item ID\t\tProduct Name\t\tunit price\t\tAvailable quantity");
        products.stream().filter(product -> product.getCategory().equals(itemCategory)).
                forEach(product -> System.out.println(product.getProductID() + "\t\t" + product.getProductName()
                        +"\t\t\t\t" + product.getUnitPrice() + "\t\t\t" + product.getQuantity()));
    }
    private void removeProduct(){
        System.out.println("Enter Item Name to remove: ");
        String productName=ValidationUtil.getValidStringInput();
        System.out.println(adminMenu.adminProductManager.remove(productName));
    }
//    private void viewDiscounts() {
//        if(!adminMiddleware.getDiscounts().isEmpty()){
//            List<String> discounts=adminMiddleware.getDiscounts();
//            discounts.stream().forEach(discount -> System.out.println(discount));
//        }
//        else {
//            System.out.println(Message.NO_DISCOUNT_EXIST);
//        }
//    }
//
//    private void removeDiscount() {
//        System.out.println("Enter Discount ID : ");
//        int discountID=ValidationUtil.getValidIntegerInput();
//        System.out.println(adminMiddleware.removeDiscount(discountID));
//    }
//
//    private void addDiscount(){
//        System.out.println("Enter Product Name: ");
//        String productName=ValidationUtil.getValidStringInput();
//        System.out.println("Enter Discount Percentage: ");
//        double discountPercentage=ValidationUtil.getValidDiscountInput();
//        System.out.println(adminMiddleware.addDiscount(productName,discountPercentage));
//    }

}
