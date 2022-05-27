package com.vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sdet34l1.genericUtility.JavaUtility;
import com.sdet34l1.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExecutor {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverUtility webDriverUtility=new WebDriverUtility(driver);
		webDriverUtility.intiallizeJs();
		driver.manage().window().maximize();
		webDriverUtility.navigateApplicationThroughJs("http://localhost:8888");
		webDriverUtility.enterDataThroughJs(driver.findElement(By.name("user_name")), "admin");
		webDriverUtility.enterDataThroughJs(driver.findElement(By.name("user_password")), "admin");
		webDriverUtility.clickThroughJs(driver.findElement(By.id("submitButton")));
		webDriverUtility.scrollTillElement(driver.findElement(By.xpath("//b[contains(.,'Upcoming Activities')]")));

		String fileName=new javaScriptExecutor().getClass().getName();
		webDriverUtility.takeScreenShot(fileName, new JavaUtility());

	}

}
