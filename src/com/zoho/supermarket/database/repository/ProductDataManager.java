package com.zoho.supermarket.database.repository;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.product.Discount;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.product.ProductCategory;
import com.zoho.supermarket.core.respository.product.AdminProductManager;
import com.zoho.supermarket.core.respository.product.CustomerProductManager;
import com.zoho.supermarket.database.model.OrderDatabase;
import com.zoho.supermarket.database.model.ProductDatabase;
import com.zoho.supermarket.userinterface.util.ValidationUtil;
import java.util.List;
import java.util.Random;

public class ProductDataManager implements AdminProductManager, CustomerProductManager {
    private final OrderDatabase orderDatabase;
    private final ProductDatabase productDatabase;

    public ProductDataManager(OrderDatabase orderDatabase, ProductDatabase productDatabase) {
        this.orderDatabase = orderDatabase;
        this.productDatabase = productDatabase;
    }
    @Override
    public String add(int productID, String productName, int quantity, double unitPrice, ProductCategory productCategory) {
        if(!ValidationUtil.isInstanceValid(productDatabase.getProduct(productName))){
            productDatabase.add(new Product(productID,productName,quantity,unitPrice,productCategory));
            return Message.PRODUCT_ADDED;
        }
        return Message.PRODUCT_EXIST;
    }
    @Override
    public String remove(String productName){
        Product instance=  productDatabase.getProduct(productName);
        if(ValidationUtil.isInstanceValid(instance)){
            productDatabase.remove(instance);
            return Message.PRODUCT_REMOVED;
        }
        return Message.NO_PRODUCT_EXIST;
    }

    @Override
    public List<Product> getProducts() {
        return productDatabase.getProducts();
    }
    @Override
    public String addDiscount(String productName, double discountPercentage) {
        Product product=  productDatabase.getProduct(productName);
        if (ValidationUtil.isInstanceValid(product)){
            productDatabase.addDiscount(product,new Discount(new Random().nextInt(1000,9999),discountPercentage));
            return Message.DISCOUNT_ADDED;
        }
        return Message.NO_PRODUCT_EXIST;
    }
    public String removeDiscount(int discountID){
        if(productDatabase.removeDiscount(discountID)){
            return Message.DISCOUNT_REMOVED;
        }
        return Message.NO_PRODUCT_EXIST;
    }
    public String updateOrder( ){
        if(ValidationUtil.isListValid(orderDatabase.getCart())){
            productDatabase.updateProduct(orderDatabase.getCart());
            return Message.ORDER_PLACED;
        }
        return Message.EMPTY_CART;
    }
    public List<String> getDiscounts() {
        return productDatabase.getDiscounts();
    }


}
