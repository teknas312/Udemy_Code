package org.automation.base;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.automation.Utilities.Constants;
import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass
{
	public static WebDriver we;
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	private static Date date = new Date();
	private static String d=dateFormat.format(date);
	private static String filename="Summary"+d+".html";
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public void setUp()
	{
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(Constants.reportPath+filename);
		//htmlReporter.setAppendExisting(true);
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName","https://mumqa.altres.com:8443/hrsqa1/admin/");
		extent.setSystemInfo("Tester Name","Sanket");
		extent.setSystemInfo("Browser","Chrome");
	}
	
	@BeforeMethod
	public void initiateDriverInstance() throws IOException, InterruptedException
	{
		if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("chrome"))
				{
					System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
					we=new ChromeDriver();
					we.manage().window().maximize();
					we.get(Utility.fetchPropertyValue("applicationURL"));
					//we.get(Utility.fetchPropertyValue("clientURL"));
					Thread.sleep(3000);
					/*int x=we.findElements(By.tagName("iframe")).size();
			        System.out.println(x);
			        we.switchTo().frame(0);*/
					
				}
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
			   String screenshotPath = BaseClass.getScreenshot(we, result.getName());
			   test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
			  } else if (result.getStatus() == ITestResult.SKIP) {
			   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
			  }
			  else if (result.getStatus() == ITestResult.SUCCESS) {
			   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
			   String screenshotPath = BaseClass.getScreenshot(we, result.getName());
			   test.addScreenCaptureFromPath(screenshotPath);
			  }
		we.close();
	}

	/*@AfterTest
	public void closeDriverInstance()
	{
		we.close();
	}
	*/

	@AfterSuite
	public void endReport()
	{
		extent.flush();
	}
	
	public void Xpathlocator(String xpath)
	{
		we.findElement(By.xpath(xpath)).click();
			
	}
	
	public WebElement Xpathlocator2(String xpath)
	{
		return we.findElement(By.xpath(xpath));
			
	}
	
	public void Idlocator(String Id)
	{
		we.findElement(By.id(Id)).click();
		
	}
	
	public void LinkText(String linkText)
	{
		we.findElement(By.linkText(linkText)).click();
		
	}
	
	public void XpathSendText(String xpath,String parameter)
	{
		we.findElement(By.xpath(xpath)).sendKeys(parameter);
	}
	
	public void XpathSendTextInteger(String xpath,int parameter)
	{
		we.findElement(By.xpath(xpath)).sendKeys(""+parameter);
	}
	
	public void selectMethod(String locator, String text) throws IOException
	{
		Select s1=new Select(Xpathlocator2(Utility.fetchLocatorValue(locator)));
		s1.selectByVisibleText(text);	
	}
	
	public void XpathElementIsDisplayed(String xpath) throws IOException
	{
		boolean status=we.findElement(By.xpath(xpath)).isDisplayed();
		System.out.println("Status is:"+status);
		if(status==true)
		{
			System.out.println("Required element is displayed:"+xpath);
			test.log(Status.PASS,"Required element is present:"+xpath);
			
		}
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException 
	{
		  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  
		  // after execution, you could see a folder "FailedTestsScreenshots" under src folder
		  String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		  File finalDestination = new File(destination);
		  FileUtils.copyFile(source, finalDestination);
		  return destination;
	}
}
