package com.sdet34l1.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is class is used to maintain all webdriver common actions 
 * @author MOHAN GOWDA
 *
 */
public class WebDriverUtility {
	 WebDriverWait wait;
	 Actions act;
	 WebDriver driver;
	 Select select;
	 JavascriptExecutor js;
	//static WebDriver driver;
	/**
	 * This method is used to initialize and launch the browser
	 * @param browser

	public static void launchBrowser(String browser) {
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
			System.out.println("please specify proper browser key");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		}
	}
	 */
	/**
	 * This method is used to return driver instance
	 * @param driver
	 * @return

	public static WebDriver getDriver(WebDriver driver) {
		return driver;
	}
	 */


	public WebDriverUtility(WebDriver driver) {
		this.driver=driver;
	}

	/**
	 * This method is used to navigate to the application
	 * @param url
	 */
	public  void navigateApp(String url) {
		driver.get(url);
	}

	/**
	 * This method is used to return/fetch the title of the webpage
	 * @param driver
	 * @return
	 */
	public  String getTitle() {
		return driver.getTitle();
	}

	

	/**
	 * This method is used to maximize the browser
	 * 
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to implicitly wait till page Load
	 * @param longTimeOut
	 */
	public  void waitTillPageLoad(long longTimeOut) {
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
	}

	/**
	 * This method is used to intiallize the actions class variable
	 * @param driver
	 */
	public  void intiallizeActions(WebDriver driver) {
		act=new Actions(driver);
	}

	/**
	 * This method is used to mouse hover on the element
	 * @param moreLink
	 */
	public  void mouseHoverOntheElement(WebElement moreLink, WebDriver driver) {

		act.moveToElement(moreLink).perform();
	}

	/**
	 * Perform double click action on  webelement
	 * @param moreLink
	 */
	public  void doubleClick(WebElement moreLink) {

		act.doubleClick(moreLink).perform();
	}

	/**
	 * Perform double click action on  webpage
	 */
	public  void doubleClick() {

		act.doubleClick().perform();
	}


	/**
	 * This method is used to close the browser instance
	 * @param driver
	 */
	public void quitBrowser() {
		driver.quit();
	}

	/**
	 * This method is used to wait the control till the particular element is clickable
	 * @param driver
	 * @param timeOut
	 * @param element
	 */
	public  void waitUntillElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}


	/**
	 * This method is used to wait the control till the particular element is visible
	 * @param driver
	 * @param timeOut
	 * @param element
	 */
	public  void waitUntillElementVisible( WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to intiallize wait instance
	 * @param driver
	 * @param timeOut
	 */
	public  void explicitlyWait(long timeOut) {
		wait=new WebDriverWait(driver, timeOut);
	}

	/**
	 * This method is used to switch the window based on title
	 * @param driver
	 * @param partialText
	 */
	public  void switchToWindowBasedOnTitle(String partialText) {
		Set<String> sessionIDs = driver.getWindowHandles();
		for(String id:sessionIDs)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText))
			{
				break;
			}

		}
	}

	/**
	 * This method is used to handle dropdown by value
	 * @param element
	 * @param value
	 */
	public  void selectDropDown(WebElement element, String value) {
		select=new Select(element);
		select.selectByValue(value);
	}

	/**
	 * This method is used to handle dropdown by index
	 * @param element
	 * @param index
	 */
	public  void selectDropDown(WebElement element, int index) {
		select=new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method is used to handle dropdown by visible text
	 * @param visibleText
	 * @param element
	 */
	public  void selectDropDown(String visibleText, WebElement element) {
		select=new Select(element);
		select.selectByVisibleText(visibleText);
	}

	/**
	 * This method is used to switch the frame by index
	 * @param driver
	 * @param index
	 */
	public  void swithToFrame( int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch the frame by nameOrId
	 * @param driver
	 * @param nameOrId
	 */
	public void swithToFrame( String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * This method is used to switch the frame by frame Element
	 * @param driver
	 * @param element
	 */
	public  void swithToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * This method is used to switch Back to main Web page
	 * @param driver
	 */
	public void swithBackToHomeWebPage() {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to intiallize the javascriptexecutor interface variable
	 * @param driver
	 */
	public void intiallizeJs() {
		
		js=(JavascriptExecutor) driver;
	}
	
	/**
	 * This method is used to enter the data inside the textfield through the javascript executor
	 * @param element
	 * @param data
	 */
	public void enterDataThroughJs( WebElement element, String data) {

		js.executeScript("arguments[0].value=arguments[1]", element, data);
	}

	/**
	 * This method is used to click on the element through javascript excecutor
	 * @param element
	 */
	public void clickThroughJs( WebElement element) {

		js.executeScript("arguments[0].click()", element);
	}

	/**
	 * This method is used to navigate the application through the javascript
	 * @param url
	 */
	public void navigateApplicationThroughJs(String url) {

		js.executeScript("window.location=arguments[0]", url);
	}

	/**
	 * This method is used to scroll the webpage till specified height
	 * @param height
	 */
	public  void scroolToSpecifiedHeight(String height) {
		js.executeScript("window.scrollBy(0,"+height+")");
	}
	
	/**
	 * This method is used to scroll till the bottom of the page
	 */
	public void scroolToBottom() {
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	/**
	 * This method is used to scroll till the element is alligned to top
	 * @param element
	 */
	public void scrollTillElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView()",element);
	}

	
	/**
	 * This method is used to take the screen shot
	 * @param fileName
	 * @param driver
	 * @return 
	 * @throws IOException
	 */
	public String takeScreenShot(String fileName, JavaUtility jutil) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./screenshot/"+fileName+"_"+jutil.getDateTimeInFormat()+".png");
		
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	
	/**
	 * This method is used to accept the alert popup
	 * @param driver
	 */
	public void alertAccept() {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to dismiss/close the alert popup
	 * @param driver
	 */
	public void alertDismiss() {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to send the data to the alert popup
	 * @param driver
	 */
	public void alertsendData(String data) {
		driver.switchTo().alert().sendKeys(data);
	}
	
	/**
	 * This method is used to get/fetch the text from the alert popup
	 * @param driver
	 */
	public String getalertText() {
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method is used to perform right click action on webpage
	 * @param driver
	 */
	public  void rightClick() {
		act.contextClick().perform();
	}
	/**
	 * This method is used to perform right click action on element
	 * @param driver
	 */
	public  void rightClick(WebElement element) {
		act.contextClick(element).perform();
	}

}
