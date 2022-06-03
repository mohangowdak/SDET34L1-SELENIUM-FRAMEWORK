package com.vtiger.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.ExcelUtility;
import com.sdet34l1.genericUtility.JavaUtility;
import com.sdet34l1.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTheGoldCountInOlampicWebsite {
	
	@Test
	public void getGoldCount() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.clinique.in/products/13659/skin-care/minis");
		 WebElement ele = driver.findElement(By.xpath("//div[@class='outer-wrap signup jquery-once-1-processed']/div[@class='popup-offer-close jquery-once-1-processed']"));
		JavaUtility jutil=new JavaUtility();
		jutil.customWait(ele, 1000, 10);
		WebDriverUtility webUtils=new WebDriverUtility(driver);
		webUtils.intiallizeJs();
		webUtils.scrollTillElement(driver.findElement(By.xpath("//span[@class='breadcrumbs__level breadcrumbs__level--1']")));
		webUtils.explicitlyWait(10);
		Thread.sleep(12000);
		ExcelUtility excel=new ExcelUtility();
		excel.openExcel("./src/test/resources/Book1.xlsx");
		 String reqElement = excel.getDataFromExcel("Sheet1", 12, 0);
		List<WebElement> elements = driver.findElements(By.xpath("//h1[@class='sc-qOjXG eQihqJ elc-product-display-name-link js-product-display-name-link elc-heading--3']"));
		
		for(WebElement element:elements)
		{
			if(element.getText().equalsIgnoreCase(reqElement))
			{
				element.click();
				break;
			}
		}
		String name="Eliud KIPCHOGE";
		
		driver.findElement(By.xpath("//span[.='"+name+"']/ancestor::div[@class='featured-athlete__wrapper d-flex']/preceding-sibling::div[@class='featured-athlete__medals text-body-sm']/span[@class='result-medal result-medal--gold']"));
		
	}

}
