package com.vtiger.practice;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopupWay3 {

	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/");
		driver.manage().window().maximize();
		WebElement textField = driver.findElement(By.xpath("//input[@name='bdaytime']"));
		textField.sendKeys("08102023",Keys.TAB);
		textField.sendKeys("1205AM");
	}
}
