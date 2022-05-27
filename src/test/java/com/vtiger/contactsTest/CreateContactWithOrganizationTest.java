package com.vtiger.contactsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.GetterandSetterForListener;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactsPage;
import com.vtiger.objectRepository.CreateNewContactPage;
import com.vtiger.objectRepository.CreateNewOrganizationPage;
import com.vtiger.objectRepository.OrganizationsPage;

public class CreateContactWithOrganizationTest extends BaseClass{

	@Test(groups = "regression")
	public void createContactWithOrganizationTest() throws InterruptedException{

		String organizationName = excelUtility.getDataFromExcel("contacts",5, 1)+randomNumber;
		String contactLastName=excelUtility.getDataFromExcel("contacts",5, 2)+randomNumber;
		
		OrganizationsPage organizationsPage=new OrganizationsPage(driver);
		CreateNewOrganizationPage createNewOrganizationPage=new CreateNewOrganizationPage(driver);
		ContactsPage contactPage=new ContactsPage(driver);
		CreateNewContactPage createNewContactPage=new CreateNewContactPage(driver);
		ContactInformationPage contactInformationPage=new ContactInformationPage(driver);


		homePage.clickOrganizations();
		organizationsPage.clickCreateOrganizationLookUpImg();
		createNewOrganizationPage.createOrgnization(organizationName);
		javaUtility.customWait(homePage.getContacts(), 1000, 10);
		contactPage.clickCreateContactLookUpImg();
		createNewContactPage.createContact(contactLastName, organizationName, driver, webDriverUtility);

		Assert.assertTrue(contactInformationPage.getLastName().equalsIgnoreCase(contactLastName) 
				&& contactInformationPage.getOrgnizationName().equalsIgnoreCase(organizationName));
		
		GetterandSetterForListener.getInstance().getTest().log(Status.INFO, "contact created with organization Successfully");
	}

}
