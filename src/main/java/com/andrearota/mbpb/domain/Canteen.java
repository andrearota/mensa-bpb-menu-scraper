package com.andrearota.mbpb.domain;

public enum Canteen {

	PALAZZOLO("Via Palazzolo"), SANT_ALESSANDRO("Via Sant'Alessandro");
	
	private String fullname;
	
	private Canteen(String fullname) {
		this.fullname = fullname;
	}
	
	public String toString() {
		return fullname;
	}
	
}
