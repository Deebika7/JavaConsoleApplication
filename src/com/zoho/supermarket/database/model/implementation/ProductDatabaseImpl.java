package com.zoho.supermarket.database.model.implementation;

import com.zoho.supermarket.core.model.product.*;
import com.zoho.supermarket.database.model.ProductDatabase;
import java.util.*;

public class ProductDatabaseImpl implements ProductDatabase {
    private final Map<String,Product> products=new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private final Map<Product, Discount> productDiscounts=new HashMap<>();
    private static  ProductDatabaseImpl Instance=null;
    private ProductDatabaseImpl(){}
    public static ProductDatabaseImpl getInstance(){
        if(Instance ==null){
            Instance= new ProductDatabaseImpl();
        }
        return Instance;
    }

    {
        products.put("milk",(new Product(1111,"milk",12,12, ProductCategory.DAIRY)));
        products.put("cheese",(new Product(1234,"cheese",12,12, ProductCategory.DAIRY)));
        products.put("butter",(new Product(1113,"butter",12,12, ProductCategory.DAIRY)));
        products.put("heinz",(new Product(1231,"heinz",12,12, ProductCategory.SAUCE)));
    }

    public List<Product> getProducts(){
        return new ArrayList<>(products.values());
    }

    @Override
    public void add(Product product){
        products.put(product.getProductName(),product);
    }

    @Override
    public void remove(Product productToRemove) {
        if(! products.isEmpty()){
            products.remove(productToRemove.getProductName());
        }
        int discountID=getDiscountID(productToRemove.getProductName());
        if(discountID!=0){
            removeDiscount(discountID);
        }
    }
    Product getInstance(Product product){
        if(!products.isEmpty()){
            if(products.containsKey(product.getProductName())){
                return products.get(product.getProductName());
            }
        }
        return null;
    }
    @Override
    public void addDiscount(Product product, Discount discount) {
        productDiscounts.put(getInstance(product),discount);
    }
    public boolean removeDiscount(int discountID) {
        for (Map.Entry<Product, Discount> productDiscountEntry : productDiscounts.entrySet()) {
            if (productDiscountEntry.getValue().getDiscountID() == discountID) {
                productDiscounts.remove(productDiscountEntry.getKey(), productDiscountEntry.getValue());
                return true;
            }
        }
        return false;
    }
    public double getDiscountPercentage(String productName){
        for (Map.Entry<Product,Discount> productDiscountEntry:productDiscounts.entrySet()){
            if(productDiscountEntry.getKey().getProductName().equalsIgnoreCase(productName)){
                return productDiscountEntry.getValue().getDiscountPercentage();
            }
        }
        return 0;
    }
    @Override
    public List<String> getDiscounts() {
        List<String> discounts = new ArrayList<>();
        if(!productDiscounts.isEmpty()) {
            discounts.add("=========================================================");
            discounts.add("Discount ID\t|\tProduct Name\t|\tDiscount Percentage");
            discounts.add("=========================================================");
            for (Map.Entry<Product, Discount> discountEntryKey : productDiscounts.entrySet()) {
                discounts.add(discountEntryKey.getValue().getDiscountID() + "\t\t\t" +
                        discountEntryKey.getKey().getProductName() + "\t\t\t\t\t" + discountEntryKey.getValue().getDiscountPercentage());
            }
            discounts.add("=========================================================");
        }
        return discounts;
    }
    private int getDiscountID(String productName){
        for(Map.Entry<Product, Discount> productDiscount:productDiscounts.entrySet()){
            if(productDiscount.getKey().getProductName().equalsIgnoreCase(productName)){
               return productDiscount.getValue().getDiscountID();
            }
        }
        return 0;
    }
    public Product getProduct(String productName){
        if(!products.isEmpty()){
            if(products.containsKey(productName)){
                 return products.get(productName);
            }
        }
        return null;
    }

    @Override
    public void updateProductQuantity(List<Cart> cart) {
        for (Cart cartProduct: cart){
            Product product=getInstance(cartProduct.getProduct());
            product.setQuantity(product.getQuantity()-cartProduct.getQuantity());
        }
    }

}
