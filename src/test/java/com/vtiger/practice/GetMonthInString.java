package com.vtiger.practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class GetMonthInString {
public static void main(String[] args) {
	

	String date="10:01:2023";
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd:MM:yyyy");
	LocalDate localDate = LocalDate.parse(date, format);
	System.out.println(localDate.getMonth().toString());
	
	
}
}
