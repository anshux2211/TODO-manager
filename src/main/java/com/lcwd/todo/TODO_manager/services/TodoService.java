package com.lcwd.todo.TODO_manager.services;

import com.lcwd.todo.TODO_manager.models.Todo;

import java.util.List;

public interface TodoService {
    public Todo createTodo(Todo todo);
    public List<Todo> getTodos();
    public Todo getSingleTodo(Integer id);
    public Todo updateTodo(int todoID, Todo updatedTodo);
    public void deleteTODO(int todoID);
}
