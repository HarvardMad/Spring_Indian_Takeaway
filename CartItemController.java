package com.springapp.cart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LalinPethiyagoda on 28/01/2017.
 */
@Controller
@RequestMapping("/cart")
public class CartItemController {

    @RequestMapping
    public String get(HttpServletRequest request){
        return "redirect:/cart/" + request.getSession(true).getId();
    }

    @RequestMapping(value="/" , method= RequestMethod.GET)
    public String getCart(@RequestParam("cartId") int cartId, ModelMap model){
        model.addAttribute("cartId", cartId);
        return "cart";
    }
}
