package com.zoho.supermarket.core.respository.product;
import com.zoho.supermarket.core.model.product.Product;

import java.util.List;

public interface CustomerProductManager {
    String placeOrder( );
    List<String> getDiscounts();
    List<Product> getProducts();

}

