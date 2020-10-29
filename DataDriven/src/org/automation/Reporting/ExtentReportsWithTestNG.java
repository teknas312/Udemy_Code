package org.automation.Reporting;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.automation.Utilities.Constants;
import org.automation.base.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReportsWithTestNG extends BaseClass
{
	/*static DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	static Date date = new Date();

	static String d=dateFormat.format(date);
	static String filename="Summary"+d+".html";
	static ExtentReports extent;
	public static ExtentTest test;
*/
	/*public static void setUp()
	{
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(Constants.reportPath+filename);
		//htmlReporter.setAppendExisting(true);
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName","https://mumqa.altres.com:8443/hrsqa1/admin/");
		extent.setSystemInfo("Tester Name","Sanket");
		extent.setSystemInfo("Browser","Chrome");
	}*/

	public static void reportGenerationMethod(String TestcaseName,String TestCaseDescription)
	{
		test=extent.createTest(TestcaseName, "Execution started for:"+TestCaseDescription);
		
	}

	/*public static void endReport()
	{
		extent.flush();
	}*/
	
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

	/*public static void tearDown(ITestResult result) throws IOException
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
	}*/
	
	}

