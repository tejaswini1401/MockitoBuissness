package com.mockitoDemo.MockitoDemo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class TodoBusinessImplStubTest {

	@Test
	public void usingStub() {
		TodoService todoService = new  TodoServiceStub();
		TodoBusinessImpl todoBuissnessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBuissnessImpl.retrieveToDoRealatedToString("Ranga");
		assertEquals(2,todos.size());
	}

}
