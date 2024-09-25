package com.mockitoDemo.MockitoDemo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TodoBusinessImplMockitoTest {
	@Test
	public void usingMockito() {
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		when(todoService.retrieveToDos("Ranga")).thenReturn(allTodos);
		TodoBusinessImpl todoBuissnessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBuissnessImpl.retrieveToDoRealatedToString("Ranga");
		assertEquals(2, todos.size());
	}
}
