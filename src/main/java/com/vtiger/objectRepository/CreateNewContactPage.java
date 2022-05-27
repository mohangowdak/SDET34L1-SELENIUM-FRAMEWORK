package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet34l1.genericUtility.WebDriverUtility;

public class CreateNewContactPage {
	
	@FindBy(name ="lastname")
	private WebElement lastNameTxt;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	

	@FindBy(xpath ="//span[@class='lvtHeaderText']")
	private WebElement headerText;
	
	@FindBy(xpath ="//td[contains(.,'Organization Name') and @class='dvtCellLabel']/following-sibling::td[1]/img")
	private WebElement organizationSerchLookupImg;

	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
		
		public void createContact(String contactName) {
			lastNameTxt.sendKeys(contactName);
			saveBtn.click();
		}
		
		public void createContact(String contactName, String organizationName, WebDriver driver, WebDriverUtility webDriverUtility) {
			lastNameTxt.sendKeys(contactName);
			organizationSerchLookupImg.click();
			new SearchOrganizationsPage(driver).selectProduct(organizationName, driver, webDriverUtility);
			webDriverUtility.switchToWindowBasedOnTitle("Contacts");
			saveBtn.click();
		}
		public String getHeaderText() {
			return headerText.getText();
		}
}
