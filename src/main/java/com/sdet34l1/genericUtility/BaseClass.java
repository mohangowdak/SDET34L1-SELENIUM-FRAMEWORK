package com.sdet34l1.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.objectRepository.CommonInformationElementPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains implementation of all basic configuration annotations
 * @author MOHAN GOWDA
 *
 */
public class BaseClass {
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public CommonInformationElementPage commonpage;
	public FileUtility	fileUtility;
	public ExcelUtility excelUtility;
	public JavaUtility javaUtility;
	public WebDriverUtility webDriverUtility;
	public int randomNumber;
	public static String username;
	public static String password;
	//public String browser;
	public String url;
	public long longTimeOut;

	/**
	 * In this annotation we open the database
	 * open the property file
	 * open the excel sheet
	 * @throws IOException
	 */
	@BeforeSuite(groups = "baseclass")
	public void beforesuite1Test() throws IOException {
		
	}

	/**
	 * In this annotation we fetch the common data from the property file 
	 * create the instance for all generic utility
	 * launch browser
	 * do the browser setting (maximize, implicit wait, action class initialization, explicit wait instance initialization)
	 * create the instance for common object repository class
	 * @throws IOException 
	 */
	@Parameters("browser")
	@BeforeClass(groups = "baseclass")
	public void beforeClass1Test(String browser) throws IOException {
		fileUtility=new FileUtility();
		excelUtility=new ExcelUtility();
		javaUtility=new JavaUtility();
	
		
		excelUtility.openExcel(IconstantPath.EXCELFILEPATH);
		//crate instance for all generic utility

		fileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		//read the data from propery file
		 url = fileUtility.getDataFromPropertyFile("url");
		String timeout = fileUtility.getDataFromPropertyFile("timeout");
		username = fileUtility.getDataFromPropertyFile("userName");
		password = fileUtility.getDataFromPropertyFile("password");
		// browser=fileUtility.getDataFromPropertyFile("browser");
		longTimeOut = javaUtility.stringToLong(timeout);
		randomNumber = javaUtility.getRandomNumber(1000);


		

		//launch browser instance
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		default:
			javaUtility.printStatement("please specify proper browser key");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		}

		webDriverUtility=new WebDriverUtility(driver);
		
		//navigate to the application
		webDriverUtility.navigateApp(url);
		//browser settings(maximize, implicit wait, action class initialization, explicit wait instance initialization)
		webDriverUtility.maximizeBrowser();
		webDriverUtility.waitTillPageLoad(longTimeOut);
		webDriverUtility.intiallizeActions(driver);
		webDriverUtility.explicitlyWait(longTimeOut);

		//create the instance for common object repository class
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		commonpage = new CommonInformationElementPage(driver);
	    
		
	}



	/**
	 * In this annotation we will do login action
	 * @throws IOException 
	 */
	@BeforeMethod(groups = "baseclass")
	public void beforeMethod1Test() throws IOException {
		//open database if it is required
		loginPage.loginAction(username, password);
	}

	/**
	 * In this annotation we will do signout action
	 */

	@AfterMethod(groups = "baseclass")
	public void afterMethod1Test() {
		webDriverUtility.waitUntillElementVisible(commonpage.getHeaderText());
		homePage.signout(driver, webDriverUtility);
		
		
		
		
	}

	/**
	 * In this annotation we will close the browser instance
	 */
	@AfterClass(groups = "baseclass")
	public void afterCass1Test() {
		webDriverUtility.quitBrowser();


	}

	/**
	 * In this annotation close database
	 * close excel sheet
	 * save excel data
	 */
	@AfterSuite(groups = "baseclass")
	public void aftersuite1Test() {
		//close database connection code
				excelUtility.saveExcelData(IconstantPath.EXCELFILEPATH);
				excelUtility.closeExcel();

	}


}
