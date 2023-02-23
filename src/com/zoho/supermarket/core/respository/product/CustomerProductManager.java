package com.zoho.supermarket.core.respository.product;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.user.Customer;

import java.util.List;

public interface CustomerProductManager {
    String updateOrder(Customer customer);
    List<String> getDiscounts();
    List<Product> getProducts();
}

