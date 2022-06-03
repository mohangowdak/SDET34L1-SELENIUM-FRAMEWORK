package com.vtiger.oganizationTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sdet34l1.genericUtility.BaseClass;
import com.vtiger.objectRepository.CreateNewOrganizationPage;
import com.vtiger.objectRepository.OrganizationsPage;

public class DeleteOrganizationTest extends BaseClass{

	@Test
	public void deleteOrganizationTest() throws InterruptedException {
String organizationName = excelUtility.getDataFromExcel("organization", 2, 1)+randomNumber;
		
		OrganizationsPage organizationsPage=new OrganizationsPage(driver);
		CreateNewOrganizationPage createNewOrganizationPage=new CreateNewOrganizationPage(driver);
		
		homePage.clickOrganizations();
		organizationsPage.clickCreateOrganizationLookUpImg();
		createNewOrganizationPage.createOrgnization(organizationName);
		
		webDriverUtility.explicitlyWait(10);
		webDriverUtility.waitUntillElementVisible(driver.findElement(By.xpath("//span[@class='small']")));
		organizationsPage.clickOrganizationHeaderLink();
		
		int pageCount = Integer.parseInt(driver.findElement(By.xpath("//span[@name='Accounts_listViewCountContainerName']")).getText().split(" ")[1]);
		System.out.println(pageCount);
		for(int j=1;j<=pageCount; j++) {
		List<WebElement> orgNames = driver.findElements(By.xpath("//table[@class='lvt small']/tbody//td[3]"));
		int count=0;
		for(int i=1;i<orgNames.size(); i++)
		{
			if(orgNames.get(i).getText().equals(organizationName)) {
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+(i+2)+"]/td/input")).click();
				System.out.println("product selected");
				count++;
				break;
			}
		}
		if(count>=1) {
			break;
		}
		driver.findElement(By.xpath("//a[@title='Next']")).click();
		Thread.sleep(2000);
		}
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		driver.switchTo().alert().accept();
		
		
		
	}
}
