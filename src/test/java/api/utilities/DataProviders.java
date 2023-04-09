package api.utilities;

import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException{
		String path = System.getProperty("user.dir")+"//testData//UserData.xlsx";
		ExcelUtility excelUtility = new ExcelUtility(path);
		
		int rownum = excelUtility.getRowCount("Sheet1");
		int colCount = excelUtility.getCellCount("Sheet1", 1);
		
		String apiData[][] = new String[rownum][colCount];
		
		for(int i=1;i<rownum;i++) {
			for(int j=0;j<colCount;j++) {
				apiData[i-1][j] = excelUtility.getCellData("Sheet1", i, j);
			}
		}
		return apiData;
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException{
		String path = System.getProperty("user.dir")+"//testData//UserData.xlsx";
		ExcelUtility excelUtility = new ExcelUtility(path);
		
		int rownum = excelUtility.getRowCount("Sheet1");
		
		String apiData[] = new String[rownum];
		
		for(int i=1;i<rownum;i++) {
				apiData[i-1] = excelUtility.getCellData("Sheet1", i, 1);
		}
		return apiData;
	}
}
