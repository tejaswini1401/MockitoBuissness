package com.mockitoDemo.MockitoDemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

class ListTest {

	@Test
	public void letsMockListSize() {
		List list = mock(List.class);
		when(list.size()).thenReturn(10);
		assertEquals(10,list.size());
	}
	
	@Test
	public void letsMockListSizeWithMultipleRetuenValues() {
		List list = mock(List.class);
		when(list.size()).thenReturn(10).thenReturn(20);
		assertEquals(10,list.size());
		assertEquals(20,list.size());
	}
	
	@Test
	public void letsMockListGet() {
		List<String> list = mock(List.class);
		when(list.get(0)).thenReturn("Hello");
		assertEquals("Hello",list.get(0));
		assertNull(list.get(1));
	}
	
	@Test
	public void letsMockListGetWithAny() {
		List<String> list = mock(List.class);
		when(list.get(anyInt())).thenReturn("Hello");
		assertEquals("Hello", list.get(0));
		assertEquals("Hello",list.get(1));
	}
}
