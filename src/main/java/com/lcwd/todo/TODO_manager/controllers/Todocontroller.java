package com.lcwd.todo.TODO_manager.controllers;

import com.lcwd.todo.TODO_manager.models.Todo;
import com.lcwd.todo.TODO_manager.services.TodoService;
import com.lcwd.todo.TODO_manager.services.imp.TodoservicesImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class Todocontroller {

    Logger logger= LoggerFactory.getLogger(Todocontroller.class);
    @Autowired
    private TodoService todo_service;
    Random rand=new Random();

    // Create TODO
    @PostMapping
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo){

        logger.info("Create TODO");

        int id=rand.nextInt(999999);
        todo.setId(id);

        // Getting Date
        Date currDate=new Date();
        todo.setAddedDate(currDate);
        logger.info("Date: {}",todo.getTodoDate());

        //call TODO service
        Todo ret_todo=todo_service.createTodo(todo);
        ResponseEntity<Todo> resp=new ResponseEntity<>(todo, HttpStatus.CREATED);
        return resp;

    }

    // GET All TODO
    @GetMapping
    public ResponseEntity<List<Todo>> getallTodo(){
        logger.info("GET All Todo Called");
        List<Todo> todolist=todo_service.getTodos();

        ResponseEntity<List<Todo>> resp=new ResponseEntity<>(todolist,HttpStatus.OK);
        return resp;
    }

    // GET Single TODO
    @GetMapping("/{todoID}")
    public ResponseEntity<Todo> get_single_todo(@PathVariable("todoID") Integer id){
        logger.info("GET SINGLE TODO Called");

        Todo todo1=todo_service.getSingleTodo(id);
        if(todo1==null){
            ResponseEntity<Todo> resp=new ResponseEntity<>(todo1,HttpStatus.NOT_FOUND);
            return resp;
        }

        ResponseEntity<Todo> resp=new ResponseEntity<>(todo1,HttpStatus.OK);
        return resp;
    }

    // UPDATE TODO
    @PutMapping("/{todoID}")
    public ResponseEntity<Todo> update_todo(@RequestBody Todo updatedTodo,@PathVariable int todoID){
        logger.info("Update TODO called");
        Todo todo1=todo_service.updateTodo(todoID, updatedTodo);

        if(todo1==null) {
            ResponseEntity<Todo> resp=new ResponseEntity<>(todo1,HttpStatus.NOT_FOUND);
            return resp;
        }
        else
            return ResponseEntity.ok(todo1);
    }

    // DELETE TODO
    @DeleteMapping("/{todoID}")
    public ResponseEntity<String> delete_todo(@PathVariable int todoID){
        logger.info("Delete TODO called");
        todo_service.deleteTODO(todoID);
        return ResponseEntity.ok("Deleted");
    }

//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity nullPointerExp(NullPointerException ex){
//        return new ResponseEntity("Null Pointer Exception: "+ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//    @ExceptionHandler(value={NullPointerException.class, ArithmeticException.class})
//    public ResponseEntity ExpHandler(Exception ex){
//        return new ResponseEntity(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
