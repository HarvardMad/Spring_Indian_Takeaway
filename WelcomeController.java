package com.springapp.mvc;


import com.springapp.dao.ProductDaoIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by LalinPethiyagoda on 01/10/2016.
 * add methods to handle web requests inside the controler class
 */
@Controller

public class WelcomeController {
    @Autowired
    ProductDaoIgnore productDao;
    @RequestMapping(value="/" , method= RequestMethod.GET)
    public String invokeLogin(){
       // ModelMap model model.put("userName", "lalin");
        return "welcome";
    }

    /*@RequestMapping(value="/productList", method= RequestMethod.GET)
    public String getProducts(ModelMap model){
        model.clear();
        model.addAttribute("productList",productDao.getProductList());

        return "productList";
    }*/

    /*@RequestMapping(value="/productList/viewProduct", method= RequestMethod.GET)
    public String viewProduct(){

        return "viewProduct";
    }
*/


}
