package com.andrearota.mbpb.scraper;

import java.io.IOException;

import com.andrearota.mbpb.domain.Canteen;
import com.andrearota.mbpb.domain.WeeklyMenu;

public interface MensaBpbScraper {

	WeeklyMenu getMenu(Canteen canteen) throws IOException;
	WeeklyMenu getMenu(Canteen canteen, int timeout) throws IOException;
}
