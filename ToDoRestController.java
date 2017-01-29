package com.springapp.rest;

import com.springapp.product.ToDo;
import com.springapp.product.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by LalinPethiyagoda on 19/11/2016.
 */
@RestController
public class ToDoRestController {
    @Autowired
    ToDoService service;

     @RequestMapping(path="/todos")
    public List<ToDo> retrieveAllToDos(){
        return service.retrieveToDos("abc");
    }
    @RequestMapping(value="/todos/{id}")
    public ToDo retrieveToDo(@PathVariable int id){
        return service.retrieveTodo(id);
    }
}
