package com.zoho.supermarket.database.model.implementation;

import com.zoho.supermarket.core.model.product.Discount;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.product.ProductCategory;
import com.zoho.supermarket.database.model.ProductDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDatabaseImpl implements ProductDatabase {
    private final List<Product> products=new ArrayList<>();
    private final Map<Product, Discount> productDiscounts=new HashMap<>();
    private static ProductDatabaseImpl Instance;
    public ProductDatabaseImpl(){

    }
    public static ProductDatabaseImpl getInstance(){
        if(Instance ==null){
            return new ProductDatabaseImpl();
        }
        return Instance;
    }

    public List<Product> getProducts(){
        return new ArrayList<>(products);
    }

    public void add(Product product){
        products.add(product);
    }

    @Override
    public void remove(Product productToRemove) {
        products.stream().filter(product -> product.getProductName().equalsIgnoreCase(productToRemove.getProductName())).
                forEach(product -> products.remove(product));
    }


}
