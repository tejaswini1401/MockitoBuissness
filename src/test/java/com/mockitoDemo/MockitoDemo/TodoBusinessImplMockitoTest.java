package com.mockitoDemo.MockitoDemo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

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
	
	@Test
	public void usingMockito_UsingBDD() {
		TodoService todoService = mock(TodoService.class);
		TodoBusinessImpl todoBuissnessImple = new TodoBusinessImpl (todoService);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		given(todoService.retrieveToDos("Ranga")).willReturn(allTodos);
		List<String> todos = todoBuissnessImple.retrieveToDoRealatedToString("Ranga");
		assertThat(todos.size(),is(2));
	}
	
	@Test
	public void letsTestDeleteNow() {
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		when(todoService.retrieveToDos("Ranga")).thenReturn(allTodos);
		TodoBusinessImpl todoBuissnessImple = new TodoBusinessImpl (todoService);
		todoBuissnessImple.deleteTodoNotRelatedToSpring("Ranga");
		verify(todoService).deleteTodo("Learn to Dance");
		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");
		verify(todoService, Mockito.never()).deleteTodo("Learn Spring");
		verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");		
	}
	
	@Test
	public void captureArgument() {
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		when(todoService.retrieveToDos("Ranga")).thenReturn(allTodos);
	    TodoBusinessImpl todoBuissnessImple = new TodoBusinessImpl (todoService);
	    todoBuissnessImple.deleteTodoNotRelatedToSpring("Ranga");
	    verify(todoService).deleteTodo(argumentCaptor.capture());
	    assertEquals("Learn to Dance", argumentCaptor.getValue());
	}
}
