package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.WebDriverUtility;

public class SearchOrganizationsPage {

	@FindBy(xpath  = "//input[@name='search_text']")
	private WebElement searchTxt;
	
	@FindBy(xpath  = "//input[@class='crmbutton small create']")
	private WebElement searchBtn;
	
	//intiallize the driver address to all the elements through constructors and make it as pubilc
	public SearchOrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//business lib
	public void selectProduct(String  OrganizationName, WebDriver driver, WebDriverUtility webDriverUtility) {
		webDriverUtility.switchToWindowBasedOnTitle("Accounts");
		searchTxt.sendKeys(OrganizationName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='"+OrganizationName+"']")).click();
	}
	
}
