package com.springapp.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by LalinPethiyagoda on 08/10/2016.
 */
@Service
public class ToDoService {
    private static List<ToDo> todos = new ArrayList<ToDo>();
    private static int toDoCount = 3;

    static{
        todos.add(new ToDo(1,"abc","learn Spring", new Date(),"false"));
        todos.add(new ToDo(2,"abc","learn Spring Boot", new Date(),"false"));
        todos.add(new ToDo(3,"abc","learn Spring MVC", new Date(),"false"));
    }




    public void addToDo(
                         String user,
                         String desc,
                         Date targetDate,
                         String isDone){
        todos.add((new ToDo(++toDoCount,user,desc, targetDate,isDone)));
    }

    public void deleteToDo(int id){
        Iterator listIterator = todos.iterator();
        while(listIterator.hasNext()){
            ToDo nextToDo = (ToDo)listIterator.next();
            if(nextToDo.getId()==id){
                listIterator.remove();
            }
        }

    }

    public List<ToDo> retrieveToDos(String userName){
        List<ToDo> retrievedList= new ArrayList<ToDo>();
        for(ToDo todoListItem : todos){
            if(todoListItem.getUser().equals(userName)){
                retrievedList.add(todoListItem);
            }
        }
        return retrievedList;
    }

    public ToDo retrieveTodo(int id){
        ToDo todo=null;
        for(ToDo todoItem : todos){
            if(todoItem.getId()==id){
                todo= todoItem;
            }
        }
        return todo;
    }
    public void updateToDo(ToDo todo){
        System.out.println("inside update ToDo " + todo.getDesc());
        //todos.remove(todo);
        deleteToDo(todo.getId());
        todos.add(todo);
    }

}
