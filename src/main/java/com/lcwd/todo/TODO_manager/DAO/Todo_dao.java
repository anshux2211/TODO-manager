package com.lcwd.todo.TODO_manager.DAO;

import com.lcwd.todo.TODO_manager.helper.Helper;
import com.lcwd.todo.TODO_manager.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class Todo_dao {

    Logger logger= LoggerFactory.getLogger(Todo_dao.class);

    JdbcTemplate template;

    public Todo_dao(@Autowired JdbcTemplate template) {
        this.template = template;
        String query="Create table IF NOT EXISTS Todos(id int primary key,title varchar(100) not null, content varchar(500), status varchar(100), addedDate date, todoDate date)";
        template.update(query);
        logger.info("Table created ");
        return;
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public Todo saveTodo(Todo todos){
        String query="insert into Todos(id,title,content,status,addedDate,todoDate) values(?,?,?,?,?,?)";
        int rows= template.update(query,todos.getId(),todos.getTitle(),todos.getContent(),todos.getStatus(),todos.getAddedDate(),todos.getTodoDate());
        logger.info("Find me "+rows);
        return todos;
    }

    public Todo getSingleTodo(int id){
        String qry=" Select * from Todos where id=?";
        Todo todo=template.queryForObject(qry,new TodoRowMapper(),id);
        return todo;
    }

    public List<Todo> getAllTodo(){
        String qry="Select * from Todos";
        List<Todo> lst=template.query(qry,new TodoRowMapper());

//        List<Map<String,Object>> lst=template.queryForList(qry);
//        List<Todo> ans=lst.stream().map((map)->{
//            Todo todo=new Todo();
//            todo.setId((int)map.get("id"));
//            todo.setTitle((String) map.get("title"));
//            todo.setContent((String) map.get("content"));
//            todo.setAddedDate(Helper.parseDate((LocalDateTime)map.get("addedDate")));
//            todo.setTodoDate(Helper.parseDate((LocalDateTime)map.get("todoDate")));
//            return todo;
//        }).collect(Collectors.toList());

        return lst;
    }

    public Todo updateTodo(int id,Todo new_todo){
        Todo prev_todo=getSingleTodo(id);

        if(new_todo.getAddedDate()==null)
            new_todo.setAddedDate(prev_todo.getAddedDate());
        if(new_todo.getTodoDate()==null)
            new_todo.setTodoDate(prev_todo.getTodoDate());

        String qry="update Todos set title=?,content=?, status=?,addedDate=?,todoDate=? where id=?";
        int row=template.update(qry,new_todo.getTitle(), new_todo.getContent(), new_todo.getStatus(), new_todo.getAddedDate(),new_todo.getTodoDate(),id);
        return new_todo;
    }

    public void deleteTodo(int ids){
        String qry="delete from Todos where id=?";
        int row=template.update(qry,ids);
        return;
    }

    public void deleteMultipleTodo(int[] ids){
        String qry="delete from Todos where id=?";
        template.batchUpdate(qry, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                int id=ids[i];
                ps.setInt(1,id);
            }

            @Override
            public int getBatchSize() {
                return ids.length;
            }
        });
        return;
    }
}
