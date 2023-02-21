package com.zoho.supermarket.database.repository;

import com.zoho.supermarket.constants.Message;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.product.ProductCategory;
import com.zoho.supermarket.core.respository.product.AdminProductManager;
import com.zoho.supermarket.core.respository.product.CustomerProductManager;
import com.zoho.supermarket.database.model.OrderDatabase;
import com.zoho.supermarket.database.model.ProductDatabase;
import com.zoho.supermarket.database.model.implementation.OrderDatabaseImpl;
import com.zoho.supermarket.database.model.implementation.ProductDatabaseImpl;
import com.zoho.supermarket.userinterface.util.ValidationUtil;

import java.util.List;

public class ProductDataManager implements AdminProductManager, CustomerProductManager {
    private OrderDatabase orderDatabase=new OrderDatabaseImpl();
    private ProductDatabase productDatabase=new ProductDatabaseImpl();
    public ProductDataManager() {
    }

    @Override
    public String add(int productID, String productName, int quantity, double unitPrice, ProductCategory productCategory) {
        if(!ValidationUtil.isInstanceValid(getProduct(productName))){
            productDatabase.add(new Product(productID,productName,quantity,unitPrice,productCategory));
            return Message.PRODUCT_ADDED;
        }
        return Message.PRODUCT_EXIST;
    }
    @Override
    public String remove(String productName){
        Product instance= getProduct(productName);
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
    private Product getProduct(String productName){
        List<Product> products=getProducts();
        if(ValidationUtil.isListValid(products)){
            for (Product product:products){
                if(product.getProductName().equalsIgnoreCase(productName)){
                    return product;
                }
            }
        }
        return null;
    }



}
