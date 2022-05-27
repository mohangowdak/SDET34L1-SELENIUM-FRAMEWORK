package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.WebDriverUtility;

public class ProductInformationPage {
	@FindBy(id="dtlview_Product Name")
	private WebElement productNameText;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getProductName() {
		return productNameText.getText();
	}
	
	
	
	public String getHeaderText(WebDriverUtility webDriverUtility) {
		webDriverUtility.waitUntillElementVisible(headerText);
		return headerText.getText();
	}
	
}
