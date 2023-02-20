package com.zoho.supermarket.database.model;

import com.zoho.supermarket.core.model.product.Discount;
import com.zoho.supermarket.core.model.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDatabase {
    List<Product> product=new ArrayList<>();
    Map<Product, Discount> productDiscount=new HashMap<>();
    ProductDatabase productDatabase;
    private ProductDatabase(){

    }
    ProductDatabase getInstance(){
        if(productDatabase==null){
            return new ProductDatabase();
        }
        return productDatabase;
    }



}
