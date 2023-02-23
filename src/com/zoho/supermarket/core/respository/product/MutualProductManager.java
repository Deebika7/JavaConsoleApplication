package com.zoho.supermarket.core.respository.product;

import com.zoho.supermarket.core.model.product.Product;

import java.util.List;

public interface MutualProductManager {
    List<String> getDiscounts();
     List<Product> getProducts();
}
