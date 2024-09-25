package com.mockitoDemo.MockitoDemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class HamcrestMatcherTest {

	@Test
	public void basicHamcrestMatchers() {
		List<Integer> scores = Arrays.asList(90,80,70,50);
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(80,70));
		assertThat(scores, everyItem(greaterThan(40)));
		assertThat(scores, everyItem(lessThan(100)));
		
		assertThat("", empty() != null);
		assertThat(null, anyOf(nullValue()));
		
		Integer[] marks = {1,2,3};
		assertThat(marks, arrayWithSize(3));
		assertThat(marks, arrayContainingInAnyOrder(2,3,1));
	}
}
