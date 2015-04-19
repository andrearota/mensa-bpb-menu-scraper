package com.andrearota;

import org.junit.Test;

import com.andrearota.dto.Canteen;
import com.andrearota.utils.ConfigUtils;

import static org.junit.Assert.*;

public class ConfigUtilsTest {

	@Test
	public void getUrlConfigKeyForCanteenTest() {
		
		String key = ConfigUtils.getUrlConfigKeyForCanteen(Canteen.SANT_ALESSANDRO);
		assertEquals("sant_alessandro_page_url", key);
		
	}
	
}
