package com.andrearota;

import java.io.IOException;

import com.andrearota.dto.Canteen;
import com.andrearota.dto.WeeklyMenu;

public interface MensaBpbScraper {

	WeeklyMenu getMenu(Canteen canteen) throws IOException;
	WeeklyMenu getMenu(Canteen canteen, int timeout) throws IOException;
}
