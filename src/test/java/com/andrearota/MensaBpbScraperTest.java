package com.andrearota;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.andrearota.dto.Canteen;
import com.andrearota.dto.WeeklyMenu;

public class MensaBpbScraperTest {
	
	@Test
	public void testScrapeSalex() throws IOException {
		MensaBpbScraper scraper = new MensaBpbScraperImpl();
		WeeklyMenu menu = scraper.getMenu(Canteen.SANT_ALESSANDRO);
		assertNotNull(menu);
	}
	
	@Test
	public void testScrapePalazzolo() throws IOException {
		MensaBpbScraper scraper = new MensaBpbScraperImpl();
		WeeklyMenu menu = scraper.getMenu(Canteen.PALAZZOLO);
		assertNotNull(menu);
	}

}
