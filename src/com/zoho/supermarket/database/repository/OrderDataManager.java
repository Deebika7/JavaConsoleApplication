package com.zoho.supermarket.database.repository;

import com.zoho.supermarket.core.model.product.Cart;
import com.zoho.supermarket.core.model.product.Discount;
import com.zoho.supermarket.core.model.product.Product;
import com.zoho.supermarket.core.respository.order.CustomerOrderManager;
import com.zoho.supermarket.database.model.OrderDatabase;
import com.zoho.supermarket.database.model.ProductDatabase;

import java.util.ArrayList;
import java.util.List;

public class OrderDataManager implements CustomerOrderManager {

    private final OrderDatabase orderDatabase;
    private final ProductDatabase productDatabase;

    public OrderDataManager( OrderDatabase orderDatabase, ProductDatabase productDatabase) {
        this.orderDatabase = orderDatabase;
        this.productDatabase = productDatabase;
    }

    @Override
    public String addToCart(String productName, int qty) {
        Product product =  productDatabase.getProduct(productName);
        return orderDatabase.addToCart(productName, qty, product);
    }

    public List<Cart> getCart() {
        return orderDatabase.getCart();
    }

    public List<String> getBill(){
        double totalAmount=0;
        List<Cart> cart=getCart();
        List<String> bill=new ArrayList<>();

        bill.add("Product Name\t\tQuantity\t\tPrice\t\tTotal Amount\t\t\tDiscount Percentage\t\t\tTotal Amount After Discount");
        for(Cart product:cart){
            double discountPercentage=productDatabase.getDiscountPercentage(product.getProduct().getProductName());
            double price=0;
            if(discountPercentage!=0){
                price=calculatePrice(product.getProduct().getUnitPrice(),discountPercentage);
            }
            else {
                price=product.getQty()*product.getProduct().getUnitPrice();
            }
            bill.add(product.getProduct().getProductName()+"\t\t\t\t"+product.getQty()+
                    "\t\t\t"+product.getProduct().getUnitPrice()+"\t\t\t"+product.getQty()*product.getProduct().getUnitPrice()+"\t\t\t"+discountPercentage+"\t\t\t"+product.getQty()*price);
            totalAmount+=product.getQty()*price;
        }
        bill.add("\t\t\t\t\t\t\t\t\t\tTotal Amount"+totalAmount);
        return bill;
    }
    public double calculatePrice(double productPrice, double discountPercentage) {
        return productPrice - (productPrice * (discountPercentage / 100));
    }

    public List<String> getCartProducts() {
        List<Cart> cart=getCart();
        List<String> cartProducts=new ArrayList<>();
        cartProducts.add("Product Name\t\tQuantity\t\tPrice");
        cart.forEach(cartProduct->cartProducts.add(cartProduct.getProduct().getProductName()
                +"\t\t\t\t"+cartProduct.getQty()+"\t\t\t"+cartProduct.getProduct().getUnitPrice()));
        return cartProducts;
    }
    @Override
    public void clearCart() {
        orderDatabase.clearCart();
    }

}
