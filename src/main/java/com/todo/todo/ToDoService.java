package com.todo.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int toDoCount = 3;
	
	static {
		todos.add(new Todo(1, "todo", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "todo", "Learn Python", new Date(), false));
		todos.add(new Todo(3, "todo", "Learn JavaScript", new Date(), false));
	}
	
	public void addToDo(String name, String description, Date targetDate, boolean isDone) {
		todos.add(new Todo(++toDoCount, name, description, targetDate, isDone));
	}
	
	public void deleteToDo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while(iterator.hasNext()) {
			Todo todo = iterator.next();
			if(todo.getId() == id) {
				iterator.remove();
			}
		}
	}
	
	public List<Todo> retreiveTodos(String user){
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for(Todo todo : todos) {
			if(todo.getUser().contentEquals(user))
				filteredTodos.add(todo);
		}
		
		return filteredTodos;
	}
	
	
	

}
