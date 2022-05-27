package com.vtiger.oganizationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.GetterandSetterForListener;
import com.vtiger.objectRepository.CreateNewOrganizationPage;
import com.vtiger.objectRepository.OrganizationInformationPage;
import com.vtiger.objectRepository.OrganizationsPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CreateOrganizationTest extends BaseClass{

	@Test(groups="sanity", description = "testng:- CreateOrganizationTest")
	@Description("Description:- CreateOrganizationTest")
	@Epic("Epic:- CreateOrganizationTest")
	@Story("Story:- CreateOrganizationTest")
	@Step("Step:- CreateOrganizationTest")
	@Severity(SeverityLevel.CRITICAL)
	public void createOrganizationTest() {
		String organizationName = excelUtility.getDataFromExcel("organization", 2, 1)+randomNumber;
		
		OrganizationsPage organizationsPage=new OrganizationsPage(driver);
		CreateNewOrganizationPage createNewOrganizationPage=new CreateNewOrganizationPage(driver);
		OrganizationInformationPage organizationInformationPage=new OrganizationInformationPage(driver);
		
		homePage.clickOrganizations();
		organizationsPage.clickCreateOrganizationLookUpImg();
		createNewOrganizationPage.createOrgnization(organizationName);
		
		Assert.assertTrue(organizationInformationPage.getorganizationName().equalsIgnoreCase(organizationName));
		GetterandSetterForListener.getInstance().getTest().log(Status.INFO, "Organization is Created Successfully");
		
			excelUtility.setDataIntoExcel("organization", 18, 5, "All data validate successfully");
			excelUtility.setDataIntoExcel("organization", 18, 6, "pass");
	}
	
}
