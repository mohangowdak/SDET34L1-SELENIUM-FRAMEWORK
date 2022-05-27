package com.rmgyantra.projectTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.sdet34l1.genericUtility.DatabaseUtility;
import com.sdet34l1.genericUtility.FileUtility;
import com.sdet34l1.genericUtility.IconstantPath;
import com.sdet34l1.genericUtility.JavaUtility;
import com.sdet34l1.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateProjectNameInDatabaseWRTGUI {

	public static void main(String[] args) throws InterruptedException, SQLException, IOException  {
		JavaUtility jutil=new JavaUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverUtility webDriverUtility=new WebDriverUtility(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8084");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		String projectName="SDET34L1-"+jutil.getRandomNumber(1000);
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		FileUtility fileUtility=new FileUtility();
		
		driver.findElement(By.name("createdBy")).sendKeys("Deepak");
		
		WebElement projectStatusDropDown = driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select"));
		
		Select select=new Select(projectStatusDropDown);
		select.selectByVisibleText("Created");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		fileUtility.openPropertyFile(IconstantPath.RMGYANTRA_PROPERTYFILE_PATH);
		DatabaseUtility.openDBConnection(IconstantPath.DATABASEURL+fileUtility.getDataFromPropertyFile("dbName"), fileUtility.getDataFromPropertyFile("dbUserName"),fileUtility.getDataFromPropertyFile("dbPassword"));
		boolean status = DatabaseUtility.validateDataInDatabase("select project_name from project;", "project_name", projectName);
		if(status== true)
		{
			System.out.println("TC pass");
		}
		else{
			System.out.println("TC fail");
		}
		
		DatabaseUtility.closeDBConnection();
		webDriverUtility.quitBrowser();
		}
		
		
	}
	

