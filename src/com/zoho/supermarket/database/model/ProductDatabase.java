package com.zoho.supermarket.database.model;

import com.zoho.supermarket.core.model.product.Discount;
import com.zoho.supermarket.core.model.product.Product;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProductDatabase {
    List<Product> getProducts();
    Map<Product, Discount> getProductDiscounts();
    void addDiscount();
    void removeDiscount();
    void addProduct();
    void updateProductQuantity();
    void removeProduct();
}
