package com.lcwd.todo.TODO_manager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExpHandler {


        @ExceptionHandler(NullPointerException.class)
    public ResponseEntity nullPointerExp(NullPointerException ex){
        return new ResponseEntity("Null Pointer Exception: "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
