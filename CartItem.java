package com.springapp.cart;

import com.springapp.model.Product;

/**
 * Created by LalinPethiyagoda on 28/01/2017.
 */
public class CartItem {
    private Product product;
    private int quantity;
    private double totalPrice;

    public CartItem(){

    }

    public CartItem(Product product) {
        this.quantity = 1;
        this.product = product;
        this.totalPrice = product.getProductPrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

}
