package com.vtiger.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtiger.objectRepository.ContactsPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class DynamicWebTableVtiger {
	
	@Test
	public void test1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		
		LoginPage loginPage=new LoginPage(driver);
		HomePage homePage=new HomePage(driver);
		
		loginPage.loginAction("admin", "admin");
		homePage.clickOrganizations();
		
		String xpath="//table[@class='lvt small']/tbody//td[3]";
		List<WebElement> columnNames = driver.findElements(By.xpath(xpath));
		
		for(int i=0; i<columnNames.size();i++)
		{
			if(columnNames.get(i).getText().equals("Organization Name"))
			{
				List<WebElement> allOrgnization = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td["+(i+1)+"]"));
				for(WebElement orgName:allOrgnization)
				{
					System.out.println(orgName.getText());
				}
			}
		}
		
	}
}
