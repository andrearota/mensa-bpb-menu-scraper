package com.andrearota.dto;

/**
 * A very simple implementation of the days of the week enumeration.
 * 
 * This is a simpler version of the DayOfWeek type introduced in Java 8.
 * 
 * @author Andrea Rota
 *
 */
public enum WorkWeekDay {

	MONDAY("MON"), TUESDAY("TUE"), WEDNESDAY("WED"), THURSDAY("THU"), FRIDAY(
			"FRI");

	private String shortCode;

	private WorkWeekDay(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getShortCode() {
		return this.shortCode;
	}

	/**
	 * @return the ISO value of the day (Monday is 1, Sunday is 7)
	 */
	public int getValue() {
		return this.ordinal() + 1;

	}

}
