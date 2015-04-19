package com.andrearota;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import com.andrearota.dto.Course;
import com.andrearota.dto.WorkWeekDay;
import com.andrearota.utils.SelectorFactory;

public class SelectorFactoryTest {

	private static SelectorFactory sf;
	
	@BeforeClass
	public static void setupTests() throws IOException {
		sf =  new SelectorFactory();
		sf.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("test-selectors.properties"));
	}
	
	@Test
	public void testGetSelectorMondayFirstCourses() {
		final String expectedSelector = "#table2 > tbody:nth-child(1)";
		
		WorkWeekDay day = WorkWeekDay.MONDAY;
		Course course = Course.FIRST_COURSES;
		
		String result = sf.getSelector(day, course);
		assertEquals(expectedSelector, result);
	}
	
	@Test
	public void testGetSelectorTuesdaySecondCourses() {
		final String expectedSelector = "#table2 > tbody";
		
		WorkWeekDay day = WorkWeekDay.TUESDAY;
		Course course = Course.SECOND_COURSES;
		
		String result = sf.getSelector(day, course);
		assertEquals(expectedSelector, result);
	}
	
	@Test
	public void testGetSelectorWednesdaySpecialCourses() {
		final String expectedSelector = "#table3";
		
		WorkWeekDay day = WorkWeekDay.WEDNESDAY;
		Course course = Course.SPECIAL_COURSES;
		
		String result = sf.getSelector(day, course);
		assertEquals(expectedSelector, result);
	}
	
	@Test
	public void testGetSelectorThursdaySideDish() {
		final String expectedSelector = "#table5 > p";
		
		WorkWeekDay day = WorkWeekDay.THURSDAY;
		Course course = Course.SIDE_DISHES;
		
		String result = sf.getSelector(day, course);
		assertEquals(expectedSelector, result);
	}
	
}
