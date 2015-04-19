package com.andrearota.mbpb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import com.andrearota.mbpb.domain.WeeklyMenu;
import com.andrearota.mbpb.domain.WorkWeekDay;
import com.andrearota.mbpb.parser.MensaBpbParser;
import com.andrearota.mbpb.parser.MensaBpbParserImpl;

public class MensaBpbParserTest {

	protected Document readWebpage(String htmlFile) throws IOException {

		InputStream in = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(htmlFile);
		try {
			return Jsoup.parse(in, "Windows-1252", "http://www.mensabpb.it/");
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	@Test
	public void testParseFirstCoursesMondaySalex() throws IOException {

		Document doc = readWebpage("BPBCVAMenu.htm");
		MensaBpbParser parser = new MensaBpbParserImpl();
		WeeklyMenu weeklyMenu = parser.getMenu(doc);

		assertNotNull(weeklyMenu);
		List<String> courses = weeklyMenu.getDailyMenus()
				.get(WorkWeekDay.MONDAY).getFirstCourses();

		assertEquals(3, courses.size());
		assertEquals("Risotto al limone e timo", courses.get(0));
		assertEquals("Maccheroncini al tonno e basilico", courses.get(1));
		assertEquals("Zuppa di verdure", courses.get(2));

	}
	
	@Test
	public void testParseSecondCoursesTuesdayPal() throws IOException {

		Document doc = readWebpage("BPBCVPMenu.htm");
		MensaBpbParser parser = new MensaBpbParserImpl();
		WeeklyMenu weeklyMenu = parser.getMenu(doc);

		assertNotNull(weeklyMenu);
		List<String> courses = weeklyMenu.getDailyMenus()
				.get(WorkWeekDay.TUESDAY).getSecondCourses();

		assertEquals(2, courses.size());
		assertEquals("Asparagi con uova e bacon", courses.get(0));

	}
	
	@Test
	public void testParseSideDishesThursdayPal() throws IOException {

		Document doc = readWebpage("BPBCVPMenu.htm");
		MensaBpbParser parser = new MensaBpbParserImpl();
		WeeklyMenu weeklyMenu = parser.getMenu(doc);

		assertNotNull(weeklyMenu);
		List<String> courses = weeklyMenu.getDailyMenus()
				.get(WorkWeekDay.THURSDAY).getSideDishes();

		assertEquals(1, courses.size());
		assertEquals("Patatine fritte", courses.get(0));
	}
	
	@Test
	public void testParseSpecialDishesFridayPal() throws IOException {

		Document doc = readWebpage("BPBCVPMenu.htm");
		MensaBpbParser parser = new MensaBpbParserImpl();
		WeeklyMenu weeklyMenu = parser.getMenu(doc);

		assertNotNull(weeklyMenu);
		List<String> courses = weeklyMenu.getDailyMenus()
				.get(WorkWeekDay.FRIDAY).getSpecialCourses();

		assertEquals(1, courses.size());
		
		// The BPBCVMenu contains an error: the entry is defined over two spans
		assertEquals("Oratina", courses.get(0));
	}
	
	@Test
	public void testParseFirstCoursesMondayPal() throws IOException {

		Document doc = readWebpage("BPBCVPMenu.htm");
		MensaBpbParser parser = new MensaBpbParserImpl();
		WeeklyMenu weeklyMenu = parser.getMenu(doc);

		assertNotNull(weeklyMenu);
		List<String> courses = weeklyMenu.getDailyMenus()
				.get(WorkWeekDay.MONDAY).getFirstCourses();

		assertEquals(3, courses.size());
		assertEquals("Spaghetti alla carbonara", courses.get(0));
		assertEquals("Fusilli al pomodoro e basilico", courses.get(1));
		assertEquals("Riso alla greca", courses.get(2));

	}
	
	@Test
	public void testParseSecondCoursesTuesdaySalex() throws IOException {

		Document doc = readWebpage("BPBCVAMenu.htm");
		MensaBpbParser parser = new MensaBpbParserImpl();
		WeeklyMenu weeklyMenu = parser.getMenu(doc);

		assertNotNull(weeklyMenu);
		List<String> courses = weeklyMenu.getDailyMenus()
				.get(WorkWeekDay.TUESDAY).getSecondCourses();

		assertEquals(2, courses.size());
		assertEquals("Salsiccia con patate e peperoni", courses.get(0));
		assertEquals("Carpaccio di salmone al pepe rosa", courses.get(1));

	}
	
	@Test
	public void testParseSideDishesThursdaySalex() throws IOException {

		Document doc = readWebpage("BPBCVAMenu.htm");
		MensaBpbParser parser = new MensaBpbParserImpl();
		WeeklyMenu weeklyMenu = parser.getMenu(doc);

		assertNotNull(weeklyMenu);
		List<String> courses = weeklyMenu.getDailyMenus()
				.get(WorkWeekDay.THURSDAY).getSideDishes();

		assertEquals(1, courses.size());
		assertEquals("Patatine fritte", courses.get(0));
	}
	
	@Test
	public void testParseSpecialDishesFridaySalex() throws IOException {

		Document doc = readWebpage("BPBCVAMenu.htm");
		MensaBpbParser parser = new MensaBpbParserImpl();
		WeeklyMenu weeklyMenu = parser.getMenu(doc);

		assertNotNull(weeklyMenu);
		List<String> courses = weeklyMenu.getDailyMenus()
				.get(WorkWeekDay.FRIDAY).getSpecialCourses();

		assertEquals(1, courses.size());
		assertEquals("Torta rustica", courses.get(0));
	}
}
