package com.vtiger.practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class MonthConverter {
	public static void main(String[] args) {
		//convertMonthFromString();
		getDateInString();
	}

	public static void convertMonthFromString() {
		String month="December";
		int dtf = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH)
				.parse(month).get(ChronoField.MONTH_OF_YEAR);
		System.out.println(dtf);
	}
	public static void getDateInString() {
		String reqDateInString="20-05-2022";
		System.out.println(LocalDate.parse(reqDateInString, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		
	}

}
