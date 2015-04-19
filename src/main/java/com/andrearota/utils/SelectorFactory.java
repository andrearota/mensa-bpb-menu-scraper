package com.andrearota.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.andrearota.dto.Course;
import com.andrearota.dto.WorkWeekDay;

public class SelectorFactory {
	
	private Properties selectors;
	
	public SelectorFactory() {
		this.selectors = new Properties();
	}
	
	public void load(InputStream is) throws IOException {
		selectors.load(is);
	}
	
	public String getSelector(WorkWeekDay day, Course course) {
		String key = getSelectorKey(day, course);
		return selectors.getProperty(key);
	}

	private String getSelectorKey(WorkWeekDay day, Course course) {
		return day.getShortCode().concat("_").concat(course.name());
	}
	
		
}
