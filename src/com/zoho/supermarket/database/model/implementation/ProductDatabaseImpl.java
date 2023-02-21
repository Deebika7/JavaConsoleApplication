package com.zoho.supermarket.database.model.implementation;

import com.zoho.supermarket.core.model.product.Discount;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.model.product.ProductCategory;
import com.zoho.supermarket.database.model.ProductDatabase;

import java.util.*;

public class ProductDatabaseImpl implements ProductDatabase {
    private final List<Product> products=new ArrayList<>();
    private final Map<Product, Discount> productDiscounts=new HashMap<>();
    private static ProductDatabaseImpl Instance=null;
    private ProductDatabaseImpl(){

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
    @Override
    public void add(Product product){
        products.add(product);
    }

    @Override
    public void remove(Product productToRemove) {
        ListIterator<Product> listIterator=products.listIterator();
        while (listIterator.hasNext()){
            if (listIterator.next().getProductName().equalsIgnoreCase(productToRemove.getProductName())){
                listIterator.remove();
            }
        }
    }
    Product getInstance(Product product){
        for(Product instance:products){
            if (instance.getProductName().equalsIgnoreCase(product.getProductName())){
                return instance;
            }
        }
        return null;
    }
    @Override
    public void addDiscount(Product product, Discount discount) {
        productDiscounts.put(getInstance(product),discount);
    }
    public boolean removeDiscount(int discountID) {
        for (Map.Entry<Product, Discount> itemDiscountEntry : productDiscounts.entrySet()) {
            if (itemDiscountEntry.getValue().getDiscountID() == discountID) {
                productDiscounts.remove(itemDiscountEntry.getKey(), itemDiscountEntry.getValue());
                return true;
            }
        }
        return false;
    }

    @Override
    public Map<Product, Discount> getDiscounts() {
        return new HashMap<>(productDiscounts);
    }


}
