package com.zoho.supermarket.database.model;

import com.zoho.supermarket.core.model.product.Discount;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.product.ProductCategory;

import java.util.List;
import java.util.Map;

public interface ProductDatabase {
     List<Product> getProducts();
     void add(Product product);
    void remove(Product productToRemove);
//    List<Product> getProducts();
//    Map<Product, Discount> getProductDiscounts();
//    void addDiscount();
//    void removeDiscount();
//    void addProduct();
//    void updateProductQuantity();
//    void removeProduct();
}
