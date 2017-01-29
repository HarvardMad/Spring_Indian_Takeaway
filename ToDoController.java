package com.springapp.product;

import com.springapp.common.ExceptionController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

/**
 * Created by LalinPethiyagoda on 01/10/2016.
 * add methods to handle web requests inside the controler class
 */
@Controller
@SessionAttributes("name")
public class ToDoController {
    private Log logger = LogFactory.getLog(ExceptionController.class);
    //auto wiring the bean
    @Autowired
    ToDoService todoService;


    @RequestMapping(value="/todo" , method= RequestMethod.GET)
    public String invokeToDos(ModelMap modelMap){
        modelMap.addAttribute("toDoList",todoService.retrieveToDos(retrieveLoggedinUserName()));
       // modelMap.addAttribute("toDoBean",new ToDo(0,"abc","add a job",new Date(), "false"));
        return "todo";
    }

    private String retrieveLoggedinUserName(){
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        if(principal instanceof UserDetails){
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }
    @RequestMapping(value="/addToDo", method=RequestMethod.GET)

    public String showNewToDo(ModelMap modelMap){
    throw new RuntimeException("dummy exception");
        //modelMap.addAttribute("toDoBean",new ToDo(0,"abc","add a job",new Date(), "false"));
        //return "addToDo";
    }

    @RequestMapping(value="/addToDo", method=RequestMethod.POST)


    public String addNewToDo( @Valid ToDo toDoBean,
                             BindingResult result, // result of the validation is stored in the result object
                             ModelMap modelMap){

        if(result.hasErrors()){
            // and if this result reference has Errors, then go back to
            //todo page as we need to fix the problems
            return "addToDo";
        }
        else{
        todoService.addToDo(toDoBean.getUser(),toDoBean.getDesc(),new Date(),"false");
        modelMap.clear();
        return "redirect:todo";}
    }

    @RequestMapping(value="/deleteToDo", method=RequestMethod.GET)
    public String deleteToDo(@RequestParam int id,
                             ModelMap model
    ){
        todoService.deleteToDo(id);
        model.clear();
        return "redirect:todo";
    }

    @RequestMapping(value="/updateToDo", method=RequestMethod.GET)
    public String updateToDo(@RequestParam int id,
                             ModelMap model){
        //todoService.updateToDo(todoService.retrieveTodo(id));
        model.addAttribute("toDoBean", todoService.retrieveTodo(id));
        return "addToDo";
    }


    @RequestMapping(value="/updateToDo", method=RequestMethod.POST)
    public String updateToDo(@Valid ToDo toDoBean,
                             BindingResult result, // result of the validation is stored in the result object
                             ModelMap modelMap){

        if(result.hasErrors()){
            // and if this result reference has Errors, then go back to
            //todo page as we need to fix the problems
            return "addToDo";
        }
        toDoBean.setUser("abc");
        todoService.updateToDo(toDoBean);

        return "redirect:todo";
    }



    @ExceptionHandler(value = Exception.class)
    public String handleError(HttpServletRequest req, Exception exception){
        logger.error("Request: " + req.getRequestURL() + "raised ", exception);
        return "error-specific";
    }
}
