package com.andrearota;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.andrearota.dto.Canteen;
import com.andrearota.dto.WeeklyMenu;
import com.andrearota.parser.MensaBpbParser;
import com.andrearota.parser.MensaBpbParserImpl;
import com.andrearota.utils.ConfigUtils;

public class MensaBpbScraperImpl implements MensaBpbScraper {

	private final static int DEFAULT_TIMEOUT = 30000;
	private final Properties urls = new Properties();
	private final MensaBpbParser parser = new MensaBpbParserImpl();

	public MensaBpbScraperImpl() throws IOException {
		InputStream in = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("page_urls.properties");
		urls.load(in);
	}

	@Override
	public WeeklyMenu getMenu(Canteen canteen, int timeout) throws IOException {
		String pageUrl = getPageUrlString(canteen);
		Document page = Jsoup.connect(pageUrl).timeout(timeout).get();
		return parser.getMenu(page);
	}

	@Override
	public WeeklyMenu getMenu(Canteen canteen) throws IOException {
		return getMenu(canteen, DEFAULT_TIMEOUT);
	}

	private String getPageUrlString(Canteen canteen) {
		String key = ConfigUtils.getUrlConfigKeyForCanteen(canteen);
		return (String) urls.get(key);
	}

}
