package com.springapp.mvc;

import org.springframework.stereotype.Service;

/**
 * Created by LalinPethiyagoda on 05/10/2016.
 */

//new Login Service
    @Service
public class LoginServiceNOTUSED {
    public boolean validateLogin(String userName, String password){
        return ("Lalin").equalsIgnoreCase(userName)&& ("Hello").equals(password);
    }
}
