package com.vtiger.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	@Test
	public void test1() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		List<String> brokenLinks = new ArrayList<>();
		
		for(WebElement link:allLinks) {
			String url = link.getAttribute("href");
			URL urlInstance = new URL(url);
			 HttpURLConnection httpconnection = (HttpURLConnection) urlInstance.openConnection();
			httpconnection.setConnectTimeout(5000);
			 int statusCode = httpconnection.getResponseCode();
			 String msg= httpconnection.getResponseMessage();
			 if(statusCode!=200) {
				 brokenLinks.add(url + "--> " + statusCode + "---> "+ msg);
			 }	 
		}
		for(String brokenLink:brokenLinks) {
			System.err.println(brokenLink );
		}
	}
}
