package com.lcwd.todo.TODO_manager.DAO;

import com.lcwd.todo.TODO_manager.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface TodoJPARepository extends JpaRepository<Todo,Integer> {
}
