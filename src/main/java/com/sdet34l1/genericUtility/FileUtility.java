package com.sdet34l1.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains only Property file Specific common methods
 * @author MOHAN GOWDA
 * It is file Utility
 */
public class FileUtility {
	 Properties property;
	/**
	 * This method is used to open the property File
	 * @throws IOException
	 */
	public void openPropertyFile(String filePath) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		property=new Properties();
		property.load(fis);
	}
	
	/**
	 * This method is used to fetch the data from the Property File
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public  String getDataFromPropertyFile(String key) {
		String value = property.getProperty(key);
		return value;
	}
	
	

	
}
