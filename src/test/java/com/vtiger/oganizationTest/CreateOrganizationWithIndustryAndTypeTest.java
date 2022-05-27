package com.vtiger.oganizationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.GetterandSetterForListener;
import com.vtiger.objectRepository.CreateNewOrganizationPage;
import com.vtiger.objectRepository.OrganizationInformationPage;
import com.vtiger.objectRepository.OrganizationsPage;

public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass{

	@Test(groups="regression")
	public void createOrganizationWithIndustryAndTypeTest(){
		String organizationName = excelUtility.getDataFromExcel("organization", 4, 1)+randomNumber;
		String industryName = excelUtility.getDataFromExcel("organization", 4, 2);
		String typeName = excelUtility.getDataFromExcel("organization", 4, 3);
		
		OrganizationsPage organizationsPage=new OrganizationsPage(driver);
		CreateNewOrganizationPage createNewOrganizationPage=new CreateNewOrganizationPage(driver);
		OrganizationInformationPage organizationInformationPage=new OrganizationInformationPage(driver);
		
		homePage.clickOrganizations();
		organizationsPage.clickCreateOrganizationLookUpImg();
		createNewOrganizationPage.createOrgnization(organizationName, industryName, typeName, webDriverUtility);
		

			Assert.assertTrue(organizationInformationPage.getorganizationName().equalsIgnoreCase(organizationName)
					&& organizationInformationPage.getIndustryName().equalsIgnoreCase(industryName)
					&&organizationInformationPage.getTypeName().equalsIgnoreCase(typeName)
					);
			
			GetterandSetterForListener.getInstance().getTest().log(Status.INFO, "Organization created with Industry and type Successfully");
			
			excelUtility.setDataIntoExcel("organization", 18, 5, "All data validate successfully");
			excelUtility.setDataIntoExcel("organization", 18, 6, "pass");

	}
	
}
