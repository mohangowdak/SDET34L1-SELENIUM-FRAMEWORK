package com.sdet34l1.genericUtility;

import com.aventstack.extentreports.ExtentTest;

public class GetterandSetterForListener {

	private ExtentTest test;
	
	private static GetterandSetterForListener instance;
	
	private GetterandSetterForListener() {}
	
	public static GetterandSetterForListener getInstance() {
		if(instance==null) {
			instance=new GetterandSetterForListener();
		}
		return instance;
	}

	

	public ExtentTest getTest() {
		return test;
	}

	public void setTest(ExtentTest test) {
		this.test = test;
	}

	
	
}
