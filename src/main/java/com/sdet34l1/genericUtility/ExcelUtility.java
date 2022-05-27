package com.sdet34l1.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is used to maintain all excel specific common methods
 * @author MOHAN GOWDA
 *
 */
public class ExcelUtility {
		Workbook wb; 
	public  void openExcel(String filePath) throws EncryptedDocumentException, IOException {
		FileInputStream fisExcel=new FileInputStream(filePath);
		wb = WorkbookFactory.create(fisExcel);
	}

	/**
	 * This method is used to fetch the data from the excel sheet
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * 
	 */
	public  String getDataFromExcel( String sheetName, int rowNumber, int cellNumber) {

		String data=wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();

		return data;
	}
	/**
	 * This method is used to fetch the multiple data from the excel sheet
	 * @param sheetName
	 * @return
	 */
	public  Object[][] getMultipleDataFromExcel( String sheetName) {

		Sheet sh = wb.getSheet(sheetName);

		Object[][] arr=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for(int i=0; i<sh.getLastRowNum(); i++)
		{
			for(int j=0; j<sh.getRow(i).getLastCellNum(); j++)
			{
				arr[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return arr;
	}

	/**
	 * This method is used to set the value into Excel
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param value
	 */
	public  void setDataIntoExcel(String sheetName, int rowNumber, int cellNumber, String value) {
		wb.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber).setCellValue(value);

	}

	/**
	 * This method is used to save the data 
	 * @param fileSavePath
	 * @throws IOException
	 */
	public  void saveExcelData(String fileSavePath)  {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileSavePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to close the Excel Connection
	 */
	public  void closeExcel() {
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("while closing excel some exception accured.. please check the ExcelUtility");
		}
	}

}
