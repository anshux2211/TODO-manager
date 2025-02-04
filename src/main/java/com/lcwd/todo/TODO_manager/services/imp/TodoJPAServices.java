package com.lcwd.todo.TODO_manager.services.imp;

import com.lcwd.todo.TODO_manager.DAO.TodoJPARepository;
import com.lcwd.todo.TODO_manager.models.Todo;
import com.lcwd.todo.TODO_manager.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class TodoJPAServices implements TodoService {

    @Autowired
    private TodoJPARepository jpa_repo;

    @Override
    public Todo createTodo(Todo todo) {
        return jpa_repo.save(todo);

    }

    @Override
    public List<Todo> getTodos() {
        List<Todo> lst=jpa_repo.findAll();
        return lst;
    }

    @Override
    public Todo getSingleTodo(Integer id) {
        return jpa_repo.findById(id).orElseThrow(()->new RuntimeException("Todo with given is not Present"));
    }

    @Override
    public Todo updateTodo(int todoID, Todo updatedTodo) {
        Todo old_todo=jpa_repo.findById(todoID).orElseThrow(()->new RuntimeException("Todo with given Id is not present"));
        old_todo.setTodoDate(updatedTodo.getTodoDate());
        old_todo.setStatus(updatedTodo.getStatus());
        old_todo.setAddedDate(updatedTodo.getAddedDate());
        old_todo.setContent(updatedTodo.getContent());
        old_todo.setTitle(updatedTodo.getTitle());
        return jpa_repo.save(old_todo);
    }

    @Override
    public void deleteTODO(int todoID) {
        jpa_repo.deleteById(todoID);
    }
}
