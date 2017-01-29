package com.springapp.mvc;

/**
 * Created by LalinPethiyagoda on 07/11/2016.
 */


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by LalinPethiyagoda on 01/10/2016.
 * add methods to handle web requests inside the controler class
 */
@Controller
public class LogoutController {

    @RequestMapping(value="/logout" , method = RequestMethod.GET)
    public String logout(HttpServletRequest request,
                         HttpServletResponse response){
        Authentication auth = SecurityContextHolder
                            .getContext()
                            .getAuthentication();

        if(auth!=null){
            new SecurityContextLogoutHandler().logout(request,response,auth);
            request.getSession().invalidate();
        }

        return "redirect:/";
    }
}
