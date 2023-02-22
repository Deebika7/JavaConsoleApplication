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
     void addDiscount(Product product,Discount discount);
     boolean removeDiscount(int discountID);
     List<String> getDiscounts();
     Product getProduct(String productName);


//    void updateProductQuantity();

}
