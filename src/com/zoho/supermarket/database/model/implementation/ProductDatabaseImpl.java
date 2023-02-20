package com.zoho.supermarket.database.model.implementation;

import com.zoho.supermarket.core.model.product.Discount;
import com.zoho.supermarket.core.model.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDatabaseImpl {
    private List<Product> products=new ArrayList<>();
    private Map<Product, Discount> productDiscounts=new HashMap<>();
    private static ProductDatabaseImpl Instance;
    private ProductDatabaseImpl(){

    }
    public static ProductDatabaseImpl getInstance(){
        if(Instance ==null){
            return new ProductDatabaseImpl();
        }
        return Instance;
    }



}
