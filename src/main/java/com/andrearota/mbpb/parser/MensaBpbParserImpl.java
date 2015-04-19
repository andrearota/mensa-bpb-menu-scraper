package com.andrearota.mbpb.parser;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.andrearota.mbpb.domain.Course;
import com.andrearota.mbpb.domain.DailyMenu;
import com.andrearota.mbpb.domain.WeeklyMenu;
import com.andrearota.mbpb.domain.WorkWeekDay;
import com.andrearota.mbpb.utils.SelectorFactory;

public class MensaBpbParserImpl implements MensaBpbParser {

	private SelectorFactory selectorFactory;

	public MensaBpbParserImpl() throws IOException {
		this.selectorFactory = new SelectorFactory();
		selectorFactory.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("selectors.properties"));
	}

	@Override
	public WeeklyMenu getMenu(Document doc) {

		WeeklyMenu result = new WeeklyMenu();
		Map<WorkWeekDay, DailyMenu> menus = new HashMap<WorkWeekDay, DailyMenu>();

		for (WorkWeekDay day : WorkWeekDay.values()) {
				DailyMenu dm = new DailyMenu();
				dm.setFirstCourses(parse(doc, day, Course.FIRST_COURSES));
				dm.setSecondCourses(parse(doc, day, Course.SECOND_COURSES));
				dm.setSideDishes(parse(doc, day, Course.SIDE_DISHES));
				dm.setSpecialCourses(parse(doc, day, Course.SPECIAL_COURSES));
				menus.put(day, dm);
		}
		result.setDailyMenus(menus);

		return result;
	}

	private List<String> parse(Document doc, WorkWeekDay day, Course course) {
		
		List<String> result = new LinkedList<String>();
		
		Elements rs = doc.select(selectorFactory.getSelector(day, course));
				
		for (Element element : rs) {
			result.add(sanitizeString(element.text()));
		}
		
		return result;
	}
	
	private String sanitizeString(String s) {
		return s.replaceAll("[^-\\w\\s]","").trim();
	}

}
