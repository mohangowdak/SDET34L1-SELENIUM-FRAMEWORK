package com.vtiger.documentsTest;

import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.vtiger.objectRepository.CreateNewDocumentPage;
import com.vtiger.objectRepository.DocumentInformationPage;
import com.vtiger.objectRepository.DocumentsPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CreateDocumentsTest extends BaseClass{

	@Test(groups = {"sanity", "regression"}, description = "testng:- CreateDocumentsTest")
	@Description("Description:- CreateDocumentsTest")
	@Epic("Epic:- CreateDocumentsTest")
	@Story("Story:- CreateDocumentsTest")
	@Step("Step:- CreateDocumentsTest")
	@Severity(SeverityLevel.MINOR)
	public void createDocumentsTest(){
		String documentTitle=excelUtility.getDataFromExcel("document", 2, 1)+randomNumber; 
		String documentPath=excelUtility.getDataFromExcel("document", 2, 2); 
		String documentDescription=excelUtility.getDataFromExcel("document", 2, 3); 

		DocumentsPage documentPage=new DocumentsPage(driver);
		CreateNewDocumentPage createNewDocumentPage=new CreateNewDocumentPage(driver);
		DocumentInformationPage documentInformationPage=new DocumentInformationPage(driver);

		homePage.clickDocument();
		documentPage.clickCreateDocumentLookUpImg();
		createNewDocumentPage.createContact(documentTitle, documentDescription, System.getProperty("user.dir")+documentPath,  webDriverUtility);
		webDriverUtility.waitUntillElementVisible(documentInformationPage.getHeader(webDriverUtility));

	}


}
