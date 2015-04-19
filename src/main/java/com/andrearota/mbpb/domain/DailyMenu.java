package com.andrearota.mbpb.domain;

import java.util.LinkedList;
import java.util.List;

public class DailyMenu {

	private List<String> firstCourses;
	private List<String> secondCourses;
	private List<String> sideDishes;
	private List<String> specialCourses;

	public DailyMenu() {
		this.firstCourses = new LinkedList<String>();
		this.secondCourses = new LinkedList<String>();
		this.sideDishes = new LinkedList<String>();
		this.specialCourses = new LinkedList<String>();
	}
	
	public List<String> getFirstCourses() {
		return firstCourses;
	}

	public void setFirstCourses(List<String> firstCourses) {
		this.firstCourses = firstCourses;
	}

	public List<String> getSecondCourses() {
		return secondCourses;
	}

	public void setSecondCourses(List<String> secondCourses) {
		this.secondCourses = secondCourses;
	}

	public List<String> getSideDishes() {
		return sideDishes;
	}

	public void setSideDishes(List<String> sideDishes) {
		this.sideDishes = sideDishes;
	}

	public List<String> getSpecialCourses() {
		return specialCourses;
	}

	public void setSpecialCourses(List<String> specialCourses) {
		this.specialCourses = specialCourses;
	}

}
