package com.springapp.order;

import com.springapp.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by LalinPethiyagoda on 23/01/2017.
 */
@Controller
public class OrderController {
    @Autowired
    ProductDao productDao;

}
