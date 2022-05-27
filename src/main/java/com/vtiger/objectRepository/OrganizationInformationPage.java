package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.WebDriverUtility;

public class OrganizationInformationPage {
	@FindBy(id="dtlview_Organization Name")
	private WebElement organizationNameText;
	
	@FindBy(xpath="//span[@id='dtlview_Industry']/font")
	private WebElement indstryText;
	
	@FindBy(xpath="//span[@id='dtlview_Type']/font")
	private WebElement typeText;
	
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getorganizationName() {
		return organizationNameText.getText();
	}
	
	public String getIndustryName() {
		return indstryText.getText();
	}
	
	public String getTypeName() {
		return typeText.getText();
	}
	
	public String getHeaderText(WebDriverUtility webDriverUtility) {
		webDriverUtility.waitUntillElementVisible(headerText);
		return headerText.getText();
	}
}
