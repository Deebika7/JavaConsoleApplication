package com.zoho.supermarket.core.respository.product;

import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.product.ProductCategory;

import java.util.List;

public interface AdminProductManager {
    String add(int productID, String productName, int quantity, double unitPrice, ProductCategory productCategory);

    String remove(String productName);

    List<Product> getProducts();
//    String addProduct();
//    String removeProduct();
//    String addDiscount();
//    String removeDiscount();
//    void viewProduct();
//    void viewDiscount();

}
