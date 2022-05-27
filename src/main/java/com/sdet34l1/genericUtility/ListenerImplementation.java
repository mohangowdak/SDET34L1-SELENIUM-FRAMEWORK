package com.sdet34l1.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * 
 * @author MOHAN GOWDA
 *
 */
public class ListenerImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart");
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentReport.html");
			spark.config().setDocumentTitle("DocumentTitle");
			spark.config().setTheme(Theme.DARK);
			spark.config().setReportName("ReportName");
		
		
		report=new ExtentReports();
		
			report.attachReporter(spark);
			
			report.setSystemInfo("Envirnoment", "Testing Envirnoment");
			report.setSystemInfo("Reporter Name", "MOHAN GOWDA");
			report.setSystemInfo("Platform", "Windows 10");
			report.setSystemInfo("Unit testing tool", "TESTNG");
			report.setSystemInfo("Build Management Tool", "Maven");
			report.setSystemInfo("Automation Tool", "Selenium");
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		
		 test = report.createTest(result.getMethod().getMethodName());
		 GetterandSetterForListener.getInstance().setTest(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		
		test.log(Status.PASS, result.getMethod().getMethodName()+" is pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getThrowable());
		
		
		try {
			test.addScreenCaptureFromPath(new WebDriverUtility(BaseClass.class.cast(result.getMethod().getInstance()).driver)
					.takeScreenShot(result.getMethod().getMethodName(), BaseClass.class.cast(result.getMethod().getInstance()).javaUtility));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP, result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			
	}


	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
		
		report.flush();
		
	}
	

}
