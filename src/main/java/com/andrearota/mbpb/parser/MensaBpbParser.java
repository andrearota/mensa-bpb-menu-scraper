package com.andrearota.mbpb.parser;

import org.jsoup.nodes.Document;

import com.andrearota.mbpb.domain.WeeklyMenu;

public interface MensaBpbParser {
	
	public WeeklyMenu getMenu(Document doc);

}
