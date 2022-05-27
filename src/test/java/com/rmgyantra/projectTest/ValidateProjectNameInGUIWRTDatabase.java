package com.rmgyantra.projectTest;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sdet34l1.genericUtility.DatabaseUtility;
import com.sdet34l1.genericUtility.ExcelUtility;
import com.sdet34l1.genericUtility.FileUtility;
import com.sdet34l1.genericUtility.IconstantPath;
import com.sdet34l1.genericUtility.JavaUtility;
import com.sdet34l1.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateProjectNameInGUIWRTDatabase {

	public static void main(String[] args) throws SQLException, Throwable  {
		JavaUtility jutil=new JavaUtility();
		FileUtility fileUtility=new FileUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		fileUtility.openPropertyFile(IconstantPath.RMGYANTRA_PROPERTYFILE_PATH);
		excelUtility.openExcel(IconstantPath.RMGYANTRA_EXCELFILE_PATH);
		int randomNumber = jutil.getRandomNumber(1000);
		String projectName=excelUtility.getDataFromExcel("projects", 1, 1)+"_"+randomNumber;
		System.out.println(projectName);
		DatabaseUtility.openDBConnection(IconstantPath.DATABASEURL+fileUtility.getDataFromPropertyFile("dbName"), fileUtility.getDataFromPropertyFile("dbUserName"),fileUtility.getDataFromPropertyFile("dbPassword"));
		DatabaseUtility.setDataInDataBase("insert into project values('TY_PROJ_"+randomNumber+"', 'Sanjay', '28/04/2022','"+projectName+"', 'on Going', 12);");
DatabaseUtility.closeDBConnection();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverUtility webDriverUtility=new WebDriverUtility(driver);
		webDriverUtility.maximizeBrowser();
		webDriverUtility.waitTillPageLoad(10);
		webDriverUtility.navigateApp("http://localhost:8084");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		
		List<WebElement> listOfProjects = driver.findElements(By.xpath("//table//tbody/tr/td[2]"));
		
		for(WebElement project:listOfProjects)
		{
			if(project.getText().equalsIgnoreCase(projectName)) {
				System.out.println("Project Name is visible in GUI");
				System.out.println("TC Pass");
				break;
			}
		}

		webDriverUtility.quitBrowser();

	}
	
}
