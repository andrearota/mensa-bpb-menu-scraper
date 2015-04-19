package com.andrearota.mbpb;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import com.andrearota.mbpb.domain.Canteen;
import com.andrearota.mbpb.domain.WeeklyMenu;
import com.andrearota.mbpb.scraper.MensaBpbScraper;
import com.andrearota.mbpb.scraper.MensaBpbScraperImpl;

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
