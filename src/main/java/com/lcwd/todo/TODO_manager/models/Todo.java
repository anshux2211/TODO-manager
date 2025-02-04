package com.lcwd.todo.TODO_manager.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Jpa_todos")
public class Todo {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title",length = 100,nullable = false)
    private String title;

    @Column(name = "content",length = 500)
    private String content;

    @Column(name = "status", length = 100)
    private String status;

    @Column(name="addedDate")
    private Date addedDate;

    @Column(name="todoDate")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date todoDate;

    public Todo(int id, String title, String content, String status, Date addedDate, Date todoDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.addedDate = addedDate;
        this.todoDate = todoDate;
    }

    public Todo(){

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getStatus() {
        return status;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(Date todoDate) {
        this.todoDate = todoDate;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", addedDate='" + addedDate + '\'' +
                ", todoDate='" + todoDate + '\'' +
                '}';
    }
}
