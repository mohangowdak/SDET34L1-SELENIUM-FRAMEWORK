package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonInformationElementPage {
	@FindBy(xpath = "//span[@class='small']")
	private WebElement headerText;
	
	public CommonInformationElementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderText() {
		return headerText;
	}
	
	

}
