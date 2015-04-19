package com.andrearota.dto;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class WeeklyMenu {

	private Calendar fromDate;
	private Calendar toDate;
	private Map<WorkWeekDay, DailyMenu> dailyMenus;

	public WeeklyMenu() {
		this.dailyMenus = new HashMap<WorkWeekDay, DailyMenu>();
	}
	
	public Calendar getFromDate() {
		return fromDate;
	}

	public void setFromDate(Calendar fromDate) {
		this.fromDate = fromDate;
	}

	public Calendar getToDate() {
		return toDate;
	}

	public void setToDate(Calendar toDate) {
		this.toDate = toDate;
	}

	public Map<WorkWeekDay, DailyMenu> getDailyMenus() {
		return dailyMenus;
	}

	public void setDailyMenus(Map<WorkWeekDay, DailyMenu> dailyMenus) {
		this.dailyMenus = dailyMenus;
	}

}
