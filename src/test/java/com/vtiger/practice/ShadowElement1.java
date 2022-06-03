package com.vtiger.practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowElement1 {
	
	@Test
	public void practice() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://books-pwakit.appspot.com/explore?q=");
		driver.manage().window().maximize();
		
		 WebElement shadowElement = (WebElement)((JavascriptExecutor) driver).executeScript("return document.querySelector(\"body > book-app\").shadowRoot.querySelector(\"#input\")");
	shadowElement.sendKeys("TYSS");
		}

}
