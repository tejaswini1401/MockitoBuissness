package com.mockitoDemo.MockitoDemo;

import java.util.List;

public interface TodoService {
	public List<String> retrieveToDos(String user);
	public void deleteTodo(String todo);
}
