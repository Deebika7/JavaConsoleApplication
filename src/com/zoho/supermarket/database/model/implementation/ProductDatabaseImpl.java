package com.zoho.supermarket.database.model.implementation;

import com.zoho.supermarket.core.model.product.Discount;
import com.zoho.supermarket.core.model.product.Cart;
import com.zoho.supermarket.core.model.product.Product;

import com.zoho.supermarket.core.model.product.ProductCategory;
import com.zoho.supermarket.database.model.ProductDatabase;
import com.zoho.supermarket.userinterface.util.ValidationUtil;
import java.util.*;

public class ProductDatabaseImpl implements ProductDatabase {
    private final List<Product> products=new ArrayList<>();
    private final Map<Product, Discount> productDiscounts=new HashMap<>();
    private static  ProductDatabaseImpl Instance=null;
    private ProductDatabaseImpl(){

    }
    public static ProductDatabaseImpl getInstance(){
        if(Instance ==null){
            Instance= new ProductDatabaseImpl();
        }
        return Instance;
    }

    {
        products.add(new Product(1111,"milk",12,12, ProductCategory.DAIRY));
        products.add(new Product(1234,"cheese",12,12, ProductCategory.DAIRY));
        products.add(new Product(1113,"butter",12,12, ProductCategory.DAIRY));
        products.add(new Product(1231,"tomato",12,12, ProductCategory.SAUCE));
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
        products.removeIf(product -> product.getProductName().equalsIgnoreCase(productToRemove.getProductName()));
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
    public Product getProduct(String productName){
        if(ValidationUtil.isListValid(products)){
            for (Product product:products){
                if(product.getProductName().equalsIgnoreCase(productName)){
                    return product;
                }
            }
        }
        return null;
    }

    @Override
    public void updateProduct(List<Cart> cart) {
        for (Cart cartProduct: cart){
            Product product=getProduct(cartProduct.getProduct().getProductName());
            product.setQuantity(product.getQuantity()-cartProduct.getQty());
        }
    }


}
