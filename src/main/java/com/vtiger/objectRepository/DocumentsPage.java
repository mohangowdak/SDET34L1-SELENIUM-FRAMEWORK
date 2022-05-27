package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentsPage {
	
	@FindBy(xpath="//img[@title='Create Document...']")
	private WebElement createDocumentLookUpImg;
	
	public DocumentsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickCreateDocumentLookUpImg() {
		createDocumentLookUpImg.click();
	}
}
