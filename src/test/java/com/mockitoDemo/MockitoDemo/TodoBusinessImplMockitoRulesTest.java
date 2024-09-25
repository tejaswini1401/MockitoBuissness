package com.mockitoDemo.MockitoDemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TodoBusinessImplMockitoRulesTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	TodoService todoService;
	
	@InjectMocks
	TodoBusinessImpl todoBuissnessImpl;
	
	@Captor
	ArgumentCaptor<String> argumentCaptor;
	
	@Test
	public void usingMockito() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		when(todoService.retrieveToDos("Ranga")).thenReturn(allTodos);

		List<String> todos = todoBuissnessImpl.retrieveToDoRealatedToString("Ranga");
		
		assertEquals(2, todos.size());
	}
	
	@Test
	public void usingMockito_UsingBDD() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		//given
		given(todoService.retrieveToDos("Ranga")).willReturn(allTodos);

		//when
		List<String> todos = todoBuissnessImpl.retrieveToDoRealatedToString("Ranga");

		//then
		assertThat(todos.size(), is(2));
	}

	@Test
	public void letsTestDeleteNow() {

		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		when(todoService.retrieveToDos("Ranga")).thenReturn(allTodos);

		todoBuissnessImpl.deleteTodoNotRelatedToSpring("Ranga");

		verify(todoService).deleteTodo("Learn to Dance");

		verify(todoService, never()).deleteTodo("Learn Spring MVC");

		verify(todoService, never()).deleteTodo("Learn Spring");

		verify(todoService, times(1)).deleteTodo("Learn to Dance");

	}
	
	@Test
	public void captureArgument() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		when(todoService.retrieveToDos("Ranga")).thenReturn(allTodos);

		todoBuissnessImpl.deleteTodoNotRelatedToSpring("Ranga");
		verify(todoService).deleteTodo(argumentCaptor.capture());

		assertEquals("Learn to Dance", argumentCaptor.getValue());
	}	
}
