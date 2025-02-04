package com.lcwd.todo.TODO_manager.services.imp;

import com.lcwd.todo.TODO_manager.DAO.Todo_dao;
import com.lcwd.todo.TODO_manager.models.Todo;
import com.lcwd.todo.TODO_manager.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Primary
public class DaoTodoServicesImp implements TodoService {
    @Autowired
    Todo_dao todoDao;

    @Override
    public Todo createTodo(Todo todo) {
        Todo todo1=todoDao.saveTodo(todo);
        return todo1;
    }

    @Override
    public List<Todo> getTodos() {
        List<Todo> todos=todoDao.getAllTodo();
        return todos;
    }

    @Override
    public Todo getSingleTodo(Integer id) {
        Todo todo=todoDao.getSingleTodo(id);
        return todo;
    }

    @Override
    public Todo updateTodo(int todoID, Todo updatedTodo) {
        Todo todo=todoDao.updateTodo(todoID,updatedTodo);
        return todo;
    }

    @Override
    public void deleteTODO(int todoID) {
        todoDao.deleteTodo(todoID);
        return;
    }
}
