package com.vtiger.campaignsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.GetterandSetterForListener;
import com.vtiger.objectRepository.CampaignInformationPage;
import com.vtiger.objectRepository.CampaignPage;
import com.vtiger.objectRepository.CreateNewCampaignPage;
import com.vtiger.objectRepository.CreateNewProductPage;
import com.vtiger.objectRepository.ProductPage;
import com.vtiger.objectRepository.SearchProductsPage;

public class CreateCampaignWithProductTest extends BaseClass {
	
	@Test(groups = "regression")
	public void createCampaignWithProductTest(){
		String productName=excelUtility.getDataFromExcel("campaign", 5, 1)+randomNumber; 
		String campaignname=excelUtility.getDataFromExcel("campaign", 5, 2)+randomNumber; 

		ProductPage productPage=new ProductPage(driver);
		CreateNewProductPage createNewProductPage=new CreateNewProductPage(driver);
		SearchProductsPage searchProductPage=new SearchProductsPage(driver);
		CampaignPage campaignPage=new CampaignPage(driver);
		CreateNewCampaignPage createNewCampaignPage=new CreateNewCampaignPage(driver);
		CampaignInformationPage campaignInformationPage=new CampaignInformationPage(driver);
	
		homePage.clickProduct();
		productPage.clickCreateProductLookUpImg();
		createNewProductPage.enterProductNameAndSave(productName);
		webDriverUtility.waitUntillElementVisible(commonpage.getHeaderText());
		homePage.clickCampaign(driver, webDriverUtility);
        campaignPage.clickCreateCampainLookUpImg();
		createNewCampaignPage.enterCampaignNameAndSwitchToSearchProduct(campaignname);
		searchProductPage.selectProduct(productName, driver, webDriverUtility);
		webDriverUtility.switchToWindowBasedOnTitle("Campaigns");
		createNewCampaignPage.saveCampaign();
			

		Assert.assertTrue(campaignInformationPage.getCampainName().equalsIgnoreCase(campaignname));
		GetterandSetterForListener.getInstance().getTest().log(Status.INFO, "Compaign is Created with Product Successfully");

	}

}
