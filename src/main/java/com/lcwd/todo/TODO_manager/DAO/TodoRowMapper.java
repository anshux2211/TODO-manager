package com.lcwd.todo.TODO_manager.DAO;

import com.lcwd.todo.TODO_manager.helper.Helper;
import com.lcwd.todo.TODO_manager.models.Todo;
import org.apache.el.parser.ParseException;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TodoRowMapper implements RowMapper<Todo> {

    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Todo todo =new Todo();
        todo.setId(rs.getInt("id"));
        todo.setTitle(rs.getString("title"));
        todo.setContent(rs.getString("content"));
        todo.setStatus(rs.getString("status"));
        try {
            todo.setTodoDate( Helper.parseDate((LocalDateTime) rs.getObject("addedDate")));
            todo.setTodoDate(Helper.parseDate((LocalDateTime) rs.getObject("todoDate")));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
         return todo;
    }
}
