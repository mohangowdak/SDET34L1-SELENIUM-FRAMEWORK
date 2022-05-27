package com.vtiger.practice;

import java.io.IOException;

import com.sdet34l1.genericUtility.FileUtility;
import com.sdet34l1.genericUtility.IconstantPath;

public class FetchDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		FileUtility fileUtility=new FileUtility();
		fileUtility.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
	String url = fileUtility.getDataFromPropertyFile("url");
	String timeout = fileUtility.getDataFromPropertyFile("timeout");
	String username =fileUtility.getDataFromPropertyFile("userName");
	String password = fileUtility.getDataFromPropertyFile("password");
	
	System.out.println(url);
	System.out.println(timeout);
	System.out.println(username);
	System.out.println(password);
	}
}
