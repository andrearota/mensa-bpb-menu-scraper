package com.andrearota.mbpb;

import static org.junit.Assert.*;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.andrearota.mbpb.domain.Canteen;
import com.andrearota.mbpb.domain.DailyMenu;
import com.andrearota.mbpb.domain.WeeklyMenu;
import com.andrearota.mbpb.domain.WorkWeekDay;
import com.andrearota.mbpb.scraper.MensaBpbScraper;
import com.andrearota.mbpb.scraper.MensaBpbScraperImpl;

public class MensaBpbScraperTest {
	
	@Test
	public void testScrapeSalex() throws IOException {
		MensaBpbScraper scraper = new MensaBpbScraperImpl();
		WeeklyMenu menu = scraper.getMenu(Canteen.SANT_ALESSANDRO);
		assertNotNull(menu);
		
		List<String> mondayFirstCourses = menu.getDailyMenus().get(WorkWeekDay.MONDAY).getFirstCourses();
		
		System.out.println(mondayFirstCourses);
		
	}
	
	@Test
	public void testScrapePalazzolo() throws IOException {
		MensaBpbScraper scraper = new MensaBpbScraperImpl();
		WeeklyMenu menu = scraper.getMenu(Canteen.PALAZZOLO);
		assertNotNull(menu);
	}

}
