package org.automation.testingworld.base;

import java.io.IOException;

import org.automation.testingworld.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverInstance 
{
	public WebDriver we;
	
	@BeforeMethod
	public void initiateDriverInstance() throws IOException
	{
		if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("chrome"))
				{
					System.setProperty("webdriver.chrome.driver","C:\\Users\\dalvi\\eclipse-workspace\\chromedriver_win32 (1)\\chromedriver.exe");
					we=new ChromeDriver();	
					we.get("https://facebook.com");
					we.manage().window().maximize();
					
				}
		
	}

	@AfterMethod
	
	public void closeDriverInstance()
	{
		we.close();
	}
}
