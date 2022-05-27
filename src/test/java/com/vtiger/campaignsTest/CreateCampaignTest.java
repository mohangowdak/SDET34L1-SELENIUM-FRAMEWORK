package com.vtiger.campaignsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.GetterandSetterForListener;
import com.vtiger.objectRepository.CampaignInformationPage;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.CreateNewCampaignPage;

public class CreateCampaignTest extends BaseClass{
	String campaignname;
	CampaignPage campaignPage;
	CreateNewCampaignPage createNewCampaignPage;
	CampaignInformationPage campaignInformationPage;
	

	@Test(groups = "sanity")
	public  void createCampaignTest() {
		campaignname=excelUtility.getDataFromExcel("campaign", 2, 1)+randomNumber; 
		
		campaignPage=new CampaignPage(driver);
		createNewCampaignPage=new CreateNewCampaignPage(driver);
		campaignInformationPage=new CampaignInformationPage(driver);

		homePage.clickCampaign(driver, webDriverUtility);
		campaignPage.clickCreateCampainLookUpImg();
		createNewCampaignPage.enterCampaignNameAndSave(campaignname);
		Assert.assertTrue(campaignInformationPage.getCampainName().equalsIgnoreCase(campaignname));
		GetterandSetterForListener.getInstance().getTest().log(Status.INFO, "Compaign is Created Successfully");
		
	}

}
