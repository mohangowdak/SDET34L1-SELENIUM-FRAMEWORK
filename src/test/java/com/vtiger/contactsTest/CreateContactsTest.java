package com.vtiger.contactsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.GetterandSetterForListener;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactsPage;
import com.vtiger.objectRepository.CreateNewContactPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CreateContactsTest extends BaseClass{
	@Test(groups = "sanity", description = "testng:- CreateContactsTest")
	@Description("Description:- CreateContactsTest")
	@Epic("Epic:- CreateContactsTest")
	@Story("Story:- CreateContactsTest")
	@Step("Step:- CreateContactsTest")
	@Severity(SeverityLevel.BLOCKER)
	public  void createContactsTest()  {
		

		String lastName=excelUtility.getDataFromExcel("contacts", 2, 1)+randomNumber; 
		
		ContactsPage contactPage=new ContactsPage(driver);
		CreateNewContactPage createNewContactPage=new CreateNewContactPage(driver);
		ContactInformationPage contactInformationPage=new ContactInformationPage(driver);


		Assert.assertTrue(webDriverUtility.getTitle().contains("Home"));
			excelUtility.setDataIntoExcel("contacts", 14, 5, "HomePage is Displayed");
			excelUtility.setDataIntoExcel("contacts", 14, 6, "pass");


		//testcase step2==> clik on contact
		homePage.clickContacts();
		
		Assert.assertTrue(webDriverUtility.getTitle().contains("Contacts"));
			excelUtility.setDataIntoExcel("contacts", 15, 5,"Contacts page is Displayed");
			excelUtility.setDataIntoExcel("contacts", 15, 6, "pass");
		

		//testcase step3==> clik on create contact
		contactPage.clickCreateContactLookUpImg();
		
		Assert.assertTrue(createNewContactPage.getHeaderText().equalsIgnoreCase("Creating New Contact"));
			excelUtility.setDataIntoExcel("contacts", 16, 5,"Create Contact page is Displayed");
			excelUtility.setDataIntoExcel("contacts", 16, 6, "pass");


		//testcase step4==> Enter lastname and click on save
		createNewContactPage.createContact(lastName);

		Assert.assertTrue(contactInformationPage.getHeaderText(webDriverUtility).contains("Contact Information"));
			excelUtility.setDataIntoExcel("contacts", 17, 5,"Contact Information page is Displayed");
			excelUtility.setDataIntoExcel("contacts", 17, 6, "pass");


		//testcase step5==> Validate the contact
			Assert.assertTrue(contactInformationPage.getLastName().equalsIgnoreCase(lastName));
			GetterandSetterForListener.getInstance().getTest().log(Status.INFO, "Contact is Created Successfully");
			
			excelUtility.setDataIntoExcel("contacts", 18, 5,"All data validate successfully");
			excelUtility.setDataIntoExcel("contacts", 18, 6, "pass");
				
	}

}
