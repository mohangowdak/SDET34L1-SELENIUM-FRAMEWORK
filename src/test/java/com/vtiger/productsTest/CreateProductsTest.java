package com.vtiger.productsTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sdet34l1.genericUtility.BaseClass;
import com.sdet34l1.genericUtility.GetterandSetterForListener;
import com.vtiger.objectRepository.CreateNewProductPage;
import com.vtiger.objectRepository.ProductInformationPage;
import com.vtiger.objectRepository.ProductPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CreateProductsTest extends BaseClass{

	@Test(groups="sanity", description = "testng:- CreateProductsTest")
	@Description("Description:- CreateProductsTest")
	@Epic("Epic:- CreateProductsTest")
	@Story("Story:- CreateProductsTest")
	@Step("Step:- CreateProductsTest")
	@Severity(SeverityLevel.CRITICAL)
	public void createProductsTest() {
		String productName=excelUtility.getDataFromExcel("products", 2, 1)+randomNumber; 

		ProductPage productPage=new ProductPage(driver);
		CreateNewProductPage createNewProductPage=new CreateNewProductPage(driver);
		ProductInformationPage productInformationPage=new ProductInformationPage(driver);

		homePage.clickProduct();
		productPage.clickCreateProductLookUpImg();
		createNewProductPage.enterProductNameAndSave(productName);
		Assert.assertTrue(productInformationPage.getProductName().equalsIgnoreCase(productName));
		GetterandSetterForListener.getInstance().getTest().log(Status.INFO, "Product created Successfully");
		
	}
}
