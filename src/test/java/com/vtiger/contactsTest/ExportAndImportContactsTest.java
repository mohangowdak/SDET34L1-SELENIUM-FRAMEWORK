package com.vtiger.contactsTest;

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

public class ExportAndImportContactsTest extends BaseClass{
	@Test(groups = "sanity", description = "testng:- ExportAndImportContactsTest")
	@Description("Description:- ExportAndImportContactsTest")
	@Epic("Epic:- ExportAndImportContactsTest")
	@Story("Story:- ExportAndImportContactsTest")
	@Step("Step:- ExportAndImportContactsTest")
	@Severity(SeverityLevel.BLOCKER)
	public  void createContactsTest()  {
		

		ContactsPage contactPage=new ContactsPage(driver);
		CreateNewContactPage createNewContactPage=new CreateNewContactPage(driver);
		ContactInformationPage contactInformationPage=new ContactInformationPage(driver);




		//testcase step2==> clik on contact
		homePage.clickContacts();
		contactPage.clickExport();
		

			GetterandSetterForListener.getInstance().getTest().log(Status.INFO, "Contact export and import Successfully");
			
				
	}

}
