package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by LalinPethiyagoda on 01/10/2016.
 * add methods to handle web requests inside the controler class
 */
@Controller
@SessionAttributes("name")
public class LoginController {
    //auto wiring the bean
   /* @Autowired
    LoginService loginService;*/

    @RequestMapping(value="/login" , method= RequestMethod.GET)
    public String invokeLogin(ModelMap model){
        model.put("userName","lalin");
        return "welcome";
    }

   /* @RequestMapping(value="/login" , method= RequestMethod.POST)
    public String processLogin(@RequestParam String userName,
                               @RequestParam String password,
                               ModelMap modelMap){
        if(!loginService.validateLogin(userName,password)){
            modelMap.put("errorMessage", "not good, is it?");
            return "loginNOTUSED";
        }


        modelMap.put("name",userName);
        modelMap.put("password",userName);
        //accessing session scope so the name is everywhere
        return "welcome";
    }*/
}
