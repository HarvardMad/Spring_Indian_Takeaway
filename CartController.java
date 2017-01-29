package com.springapp.cart;

import com.springapp.dao.CartDao;
import com.springapp.dao.ProductDao;
import com.springapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LalinPethiyagoda on 28/01/2017.
 * If you annotate a method with @ResponseBody, spring will try to convert
 * its return value and write it to the http response automatically.
 * If you annotate a methods parameter with @RequestBody,
 * spring will try to convert the content of the incoming
 * request body to your parameter object on the fly.
 */
@Controller
@RequestMapping("/rest/cart")
public class CartController {
    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value="/" , method= RequestMethod.GET)
    public @ResponseBody Cart read(@RequestParam int cartId){
        return cartDao.read(cartId);
    }

    @RequestMapping(value="/" , method= RequestMethod.PUT) //update == put
    @ResponseStatus(value = HttpStatus.NO_CONTENT) // NO CONTENT SENT WITH THE RESPONSE
    public void update(@RequestParam int cartId, @RequestBody Cart cart){
        cartDao.update(cartId,cart);
    }

    @RequestMapping(value="/" , method= RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@RequestParam int cartId){
        cartDao.delete(cartId);
    }

    @RequestMapping(value="/add" , method= RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@RequestParam int productId, HttpServletRequest request){
        String sessionId = request.getSession(true).getId();
        Cart cart = cartDao.read(Integer.valueOf(sessionId));

        if(cart==null){
          cart = cartDao.create(new Cart(Integer.valueOf(sessionId))) ;
        }

        Product product = productDao.getProductById(productId);
        if(product == null){
            throw new IllegalArgumentException("product does not exist");
        }
        cart.addCartItem(new CartItem(product));
        cartDao.update(Integer.valueOf(sessionId), cart);
    }


    @RequestMapping(value="/remove" , method= RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@RequestParam int productId, HttpServletRequest request){
        String sessionId = request.getSession(true).getId();
        Cart cart = cartDao.read(Integer.valueOf(sessionId));

        if(cart==null){
            cart = cartDao.create(new Cart(Integer.valueOf(sessionId))) ;
        }

        Product product = productDao.getProductById(productId);
        if(product == null){
            throw new IllegalArgumentException("product does not exist");
        }
        cart.removeCartItem(new CartItem(product));
        cartDao.update(Integer.valueOf(sessionId), cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Illiga; request verify payload")
    public void handleClientError(Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Internal server error")
    public void handleServerError(Exception e){}


}
