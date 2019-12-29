package org.automation.testingworld.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.automation.testingworld.base.DriverInstance;
import org.automation.testingworld.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_001_Validate_Login extends DriverInstance

{

	@Test(dataProvider="TestData")
	public void execute(String username,String Password) throws IOException
	{
//		LoginPage login=new LoginPage(we);
//		login.enterUsername("sanket.dalvi11@gmail.com");
//		login.enterPassword("96Kshatriya");
//		login.clickSignin();
		LoginPage login=new LoginPage(we);
		login.enterUsername(username);
		login.enterPassword(Password);
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
			XSSFCell username=r.getCell(0);
			XSSFCell password=r.getCell(1);
			facebookData[i][0]=username.getStringCellValue();
			facebookData[i][1]=username.getStringCellValue();
		}
		
		return facebookData;
	}

	
}
