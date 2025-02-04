package com.lcwd.todo.TODO_manager;

import com.lcwd.todo.TODO_manager.DAO.Todo_dao;
import com.lcwd.todo.TODO_manager.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TodoManagerApplication  implements CommandLineRunner {

//	@Autowired
//	private Todo_dao todo_dao;
	
	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application Started");

//		Todo todo=new Todo(8439,"Meeting","Progress meet on Sunday","Pending",new Date(),new Date());
//		Todo todo=new Todo(6541,"Placement","Hitachi is coming","Pending",new Date(),new Date());
//		Todo tmp=todo_dao.saveTodo(todo);

//		Todo todo=todo_dao.getSingleTodo(6542);
//		System.out.println(todo);

//		List<Todo> todos=todo_dao.getAllTodo();
//		todos.forEach(t-> System.out.println((t)));

//		Todo todo=new Todo(8439,"Travel","Visit Manali","Pending",new Date(),new Date());
//		Todo tmp=todo_dao.updateTodo(8439,todo);
//		System.out.println(tmp);

//		todo_dao.deleteTodo(8439);
//		todo_dao.deleteMultipleTodo(new int[]{6541,7412});
	}
}
