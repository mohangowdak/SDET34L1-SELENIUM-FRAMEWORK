package com.vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.ExcelUtility;
import com.sdet34l1.genericUtility.IconstantPath;

public class TestNgPractice1Test{
	

@Test(dataProvider = "loginData")
public void practice1Test(String username, String password) {
	Reporter.log(username+"    ---->    "+ password, true);
	
}

@DataProvider
public Object[][] loginData() throws EncryptedDocumentException, IOException{
	ExcelUtility excelUtility=new ExcelUtility();
	excelUtility.openExcel(IconstantPath.EXCELFILEPATH);
	return excelUtility.getMultipleDataFromExcel("loginData");
}
}
