package com.vtiger.practice;


import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(com.sdet34l1.genericUtility.ListenerImplementation.class)
public class TestNgPractice2Test extends TestNgBasicConfigAnnotationPracticeTest{

	@Test(groups="sanity")
	public void mohan1() {
		Reporter.log("mohan", true);
	}
	
	
	@Test(groups="sanity")
	public void mohan() {
		Reporter.log("Sanjay", true);
}

@Test(groups="sanity")
public void practice1Test() {
	Reporter.log("TestNgPractice2Test --> Test1", true);
}
@Test(groups="regression")
public void practice2Test() {
	Reporter.log("TestNgPractice2Test --> Test2", true);
}
@Test(groups="regression")
public void practice3Test() {
	Reporter.log("TestNgPractice2Test --> Test3", true);
}

@Test(groups="sanity")
public void practice4Test() {
	Reporter.log("TestNgPractice2Test --> Test4", true);
}

@Test(groups={"sanity","regression"})
public void practice5Test() {
	Reporter.log("TestNgPractice2Test --> Test5", true);
}

}
