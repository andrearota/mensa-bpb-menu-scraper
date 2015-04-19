package com.andrearota.utils;

import com.andrearota.dto.Canteen;

public class ConfigUtils {
	
	public static String getUrlConfigKeyForCanteen(Canteen c) {
		return c.name().concat("_PAGE_URL").toLowerCase();
	}

}
