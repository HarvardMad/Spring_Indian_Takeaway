package com.springapp.dao;

import com.springapp.cart.Cart;

/**
 * Created by LalinPethiyagoda on 28/01/2017.
 */
public interface CartDao {

    Cart create(Cart cart);

    Cart read(int cartId);

    void update(int cartId, Cart cart);

    void delete(int cartId);
}
