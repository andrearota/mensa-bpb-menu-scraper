package com.andrearota.mbpb.utils;

import com.andrearota.mbpb.domain.Canteen;

public class ConfigUtils {
	
	public static String getUrlConfigKeyForCanteen(Canteen c) {
		return c.name().concat("_PAGE_URL").toLowerCase();
	}

}
