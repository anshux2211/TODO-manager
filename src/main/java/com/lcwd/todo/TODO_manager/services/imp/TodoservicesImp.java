package com.lcwd.todo.TODO_manager.services.imp;


import com.lcwd.todo.TODO_manager.models.Todo;
import com.lcwd.todo.TODO_manager.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoservicesImp implements TodoService {

    Logger logger= LoggerFactory.getLogger(TodoservicesImp.class);
    List<Todo> todos=new ArrayList<>();

    // Create Service
    public Todo createTodo(Todo todo){
        todos.add(todo);
        logger.info("Todo Added: {}",todo);

        return todo;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public Todo getSingleTodo(Integer id) {
        int sz=todos.size();
        for(int i=0;i<sz;i++){
            if(todos.get(i).getId()==id)
                return todos.get(i);
        }
        return null;
    }

    public Todo updateTodo(int todoID, Todo updatedTodo) {
        int sz=todos.size();
        for(int i=0;i<sz;i++){
            if(todos.get(i).getId()==todoID){
                todos.set(i,updatedTodo);
                todos.get(i).setId(todoID);
                return todos.get(i);
            }
        }
        return null;
    }

    public void deleteTODO(int todoID) {
        List<Todo> newList=new ArrayList<>();
        for(int i=0;i<todos.size();i++){
            if(todos.get(i).getId()!=todoID)
                newList.add(todos.get(i));
        }
        todos=newList;
    }
}
