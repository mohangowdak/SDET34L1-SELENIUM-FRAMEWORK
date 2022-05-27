package com.vtiger.objectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.WebDriverUtility;

public class CreateNewDocumentPage {
	
	@FindBy(xpath ="//input[@name='notes_title']")
	private WebElement documentTitleTxt;
	
	@FindBy(xpath ="//body[@class='cke_show_borders']")
	private WebElement bodyText;
	
	@FindBy(id ="cke_5")
	private WebElement boldBtn;
	
	@FindBy(id ="cke_6")
	private WebElement italicBtn;
	
	@FindBy(xpath ="//input[@id='filename_I__']")
	private WebElement documentFileUpload;
	
	@FindBy(xpath ="//b[.='File Information']/../../following-sibling::tr[4]//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewDocumentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
		
		
		public void createContact(String documentTitle, String documentDescription, String documentPath, WebDriverUtility webDriverUtility) {
			documentTitleTxt.sendKeys(documentTitle);
			webDriverUtility.swithToFrame(0);
			bodyText.sendKeys(documentDescription, Keys.CONTROL+"a");
			webDriverUtility.swithBackToHomeWebPage();
			boldBtn.click();
			italicBtn.click();
			documentFileUpload.sendKeys(documentPath);
			saveBtn.click();
			
		}
}
