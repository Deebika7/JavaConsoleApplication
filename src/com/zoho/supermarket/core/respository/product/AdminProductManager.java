package com.zoho.supermarket.core.respository.product;

import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.product.ProductCategory;

import java.util.List;

public interface AdminProductManager {
    String add(int productID, String productName, int quantity, double unitPrice, ProductCategory productCategory);
    String remove(String productName);
    String addDiscount(String productName, double discountPercentage);
    String removeDiscount(int discountID);
    List<String> getDiscounts();
    List<Product> getProducts();

}
