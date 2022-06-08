package com.vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopupWay1 {

	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("datepicker")).click();
		String reqDate="30";
		String reqMonth="February";
		String reqYear="2025";
		String[] currentMonthYear = driver.findElement(By.className("ui-datepicker-title")).getText().split(" ");
		String currentMonth=currentMonthYear[0];
		String currentYear=currentMonthYear[1];
		
		while(!(currentMonth.equals(reqMonth) && currentYear.equals(reqYear))) {
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			currentMonthYear = driver.findElement(By.className("ui-datepicker-title")).getText().split(" ");
			currentMonth=currentMonthYear[0];
			 currentYear=currentMonthYear[1];
		}
		try {
		driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='"+reqDate+"']")).click();
		}
		catch(Exception e) {
			System.out.println("Invalid Date Input "+reqDate+"/"+reqMonth+"/"+reqYear);
		}

		
	}

}
