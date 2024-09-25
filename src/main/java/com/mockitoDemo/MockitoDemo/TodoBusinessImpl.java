package com.mockitoDemo.MockitoDemo;

import java.util.ArrayList;
import java.util.List;

public class TodoBusinessImpl {
	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	public List<String> retrieveToDoRealatedToString(String user){
		List<String> filteredToDos = new ArrayList<>();
		List<String> allToDos = todoService.retrieveToDos(user);
		for(String todo : allToDos) {
			if(todo.contains("Spring")) {
				filteredToDos.add(todo);
			}
		}
		return filteredToDos;
	}
}
