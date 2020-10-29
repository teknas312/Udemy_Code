package org.automation.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.automation.Reporting.ExtentReportsWithTestNG;
import org.automation.base.BaseClass;
import org.automation.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_001_Validate_Login extends BaseClass

{

	@Test(dataProvider="TestData")
	public void execute(String username,String password) throws IOException
	{
//		LoginPage login=new LoginPage(we);
//		login.enterUsername("sanket.dalvi11@gmail.com");
//		login.enterPassword("96Kshatriya");
//		login.clickSignin();
		//ExtentReportsWithTestNG.setUp();
		ExtentReportsWithTestNG.reportGenerationMethod("TC_001_Validate_Login", "TC_001_Validate_Login");
		//ExtentReportsWithTestNG.endReport();
		LoginPage login=new LoginPage(we);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickSignin();
	}
	
	@DataProvider(name="TestData")

	public Object[][] testDataGenerator() throws IOException
	{
		FileInputStream fis=new FileInputStream("./TestData/Data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("Login");
		int numrow=sh.getPhysicalNumberOfRows();
		System.out.println("Total number of rows are:"+numrow);
		Object [][] facebookData=new Object[numrow][2];
		for(int i=0;i<numrow;i++)
		{
			XSSFRow r=sh.getRow(i);
			int colCount=r.getPhysicalNumberOfCells();
			for(int j=0;j<colCount;j++)
			{	
			XSSFCell username=r.getCell(j);
			XSSFCell password=r.getCell(j);
			facebookData[i][j]=username.getStringCellValue();
			facebookData[i][j]=password.getStringCellValue();
		}
		
		}
		return facebookData;
	}

	
}
