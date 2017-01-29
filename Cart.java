package com.springapp.cart;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LalinPethiyagoda on 28/01/2017.
 */
public class Cart {
    private int cartId;
    private Map<Integer,CartItem> cartItems;
    private double grandTotal;

    public Cart(int cartId) {
        this();
        this.cartId=cartId;
    }

    private Cart(){
        cartItems = new HashMap<Integer,CartItem>();
        grandTotal=0;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void addCartItem(CartItem cartItem){
        int productId = cartItem.getProduct().getProductId();
        if(cartItems.containsKey(productId)){
            CartItem existingCartItem = cartItems.get(productId);
            int updatedQuanitity = existingCartItem.getQuantity() + cartItem.getQuantity();
            existingCartItem.setQuantity(updatedQuanitity);
            cartItems.put(productId, cartItem);
        }
        else{
            cartItems.put(cartItem.getProduct().getProductId(),cartItem);
        }
        updateGrandTotal();
    }

    public void updateGrandTotal(){
        grandTotal =0;
       for(CartItem item:cartItems.values()){
           grandTotal= grandTotal + item.getTotalPrice();
       }
    }

    public void removeCartItem(CartItem item){
        int productId = item.getProduct().getProductId();
        cartItems.remove(productId);
        updateGrandTotal();
    }


}
