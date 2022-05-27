package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.WebDriverUtility;

public class ContactInformationPage {
	@FindBy(id="dtlview_Last Name")
	private WebElement lastNameText;
	
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	@FindBy(xpath="//td[@id='mouseArea_Organization Name']/a")
	private WebElement organizationNameText;
	
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getLastName() {
		return lastNameText.getText();
	}
	
	public String getOrgnizationName() {
		return organizationNameText.getText();
	}
	public String getHeaderText(WebDriverUtility webDriverUtility) {
		webDriverUtility.waitUntillElementVisible(headerText);
		return headerText.getText();
	}
	
}
