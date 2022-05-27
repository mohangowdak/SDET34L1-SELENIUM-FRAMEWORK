package com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestNgBasicConfigAnnotationPracticeTest {

	@BeforeSuite(groups="baseclass")
	public void beforesuite1Test() {
		Reporter.log("beforesuite1"+Thread.currentThread().getId(), true);
	}
	@AfterSuite(groups="baseclass")
	public void aftersuite1Test() {
		Reporter.log("aftersuite1"+Thread.currentThread().getId(), true);
	}
	
	@BeforeClass(groups="baseclass")
	public void beforeClass1Test() {
		Reporter.log("beforeClass1"+Thread.currentThread().getId(), true);
	}
	@AfterClass(groups="baseclass")
	public void afterCass1Test() {
		Reporter.log("afterClass1"+Thread.currentThread().getId(), true);
	}
	
	@BeforeTest(groups="baseclass")
	public void beforeTest1Test() {
		Reporter.log("beforeTest1"+Thread.currentThread().getId(), true);
	}
	@AfterTest(groups="baseclass")
	public void afterTest1Test() {
		Reporter.log("afterTest1"+Thread.currentThread().getId(), true);
	}
	
	
	@BeforeMethod(groups="baseclass")
	public void beforeMethod1Test() {
		Reporter.log("beforeMethod1"+Thread.currentThread().getId(), true);
	}
	@AfterMethod(groups="baseclass")
	public void afterMethod1Test() {
		Reporter.log("afterMethod1"+Thread.currentThread().getId(), true);
	}
	
	
	
}
