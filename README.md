# Mensa BPB Menu Scraper

[![Build Status](https://travis-ci.org/andrearota/mensa-bpb-menu-scraper.svg?branch=master)](https://travis-ci.org/andrearota/mensa-bpb-menu-scraper)

Mensa BPB Menu Scraper is a Java library that fetches weekly menus from my company canteens website.

At each invocation, the library download the requested HTML menu from the [BPB CV canteen website](http://www.mensabpb.it/) and parses it into a Java object using [Jsoup](http://jsoup.org/).

## How to compile

The project comes with a standard Maven POM file. To compile it, run its tests and create the library jar, run:

    mvn packgage

## How to use this library

The usage of this library is pretty straightforward:

	// Create the scraper instance
	MensaBpbScraper scraper = new MensaBpbScraperImpl();
	
	// Fetch the menu for a canteen
	WeeklyMenu menu = scraper.getMenu(Canteen.PALAZZOLO);
	
	// Browse the menu
	List<String> mondayFirstCourses = menu.getDailyMenus().get(WorkWeekDay.MONDAY).getFirstCourses();
	
