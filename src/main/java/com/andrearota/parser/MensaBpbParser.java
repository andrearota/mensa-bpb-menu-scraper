package com.andrearota.parser;

import org.jsoup.nodes.Document;

import com.andrearota.dto.WeeklyMenu;

public interface MensaBpbParser {
	
	public WeeklyMenu getMenu(Document doc);

}
