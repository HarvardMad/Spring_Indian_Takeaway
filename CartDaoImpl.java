package com.springapp.cart;

import com.springapp.dao.CartDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LalinPethiyagoda on 28/01/2017.
 * The three annotations are used to separate "Layers" in your application,

 Controllers just do stuff like dispatching, forwarding, calling service methods etc.
 Service Hold business Logic, Calculations etc.
 Repository are the DAOs(Data Access Objects), they access the database directly.

 */
@Repository
public class CartDaoImpl implements CartDao {
    private Map<Integer,Cart> listOfCarts;

    public CartDaoImpl(){
        listOfCarts = new HashMap<>();
    }
    @Override
    public Cart create(Cart cart) {
        if(listOfCarts.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException(String.format("cart already exists "
            + cart.getCartId()));
        }

        listOfCarts.put(cart.getCartId(),cart);

        return null;
    }

    @Override
    public Cart read(int cartId) {
        return listOfCarts.get(cartId);
    }

    @Override
    public void update(int cartId, Cart cart) {
        if(listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException("Cannot update the cart- cart with id " + cartId + "does not exsit");
        }
        listOfCarts.put(cartId, cart);
    }

    @Override
    public void delete(int cartId) {
        if(listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException("Cannot delete the cart- cart with id " + cartId + "does not exsit");
        }
        listOfCarts.remove(cartId);
    }
}
