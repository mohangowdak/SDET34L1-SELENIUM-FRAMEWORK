package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.WebDriverUtility;

public class DocumentInformationPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	public DocumentInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getHeader( WebDriverUtility webDriverUtility) {
		webDriverUtility.waitUntillElementVisible(headerText);
		return headerText;
	}
	
	
	public String getHeaderText(WebDriverUtility webDriverUtility) {
		webDriverUtility.waitUntillElementVisible(headerText);
		return headerText.getText();
	}
	
}
