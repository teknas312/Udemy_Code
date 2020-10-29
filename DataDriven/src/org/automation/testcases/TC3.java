package org.automation.testcases;

import java.io.IOException;

import org.automation.Reporting.ExtentReportsWithTestNG;
import org.automation.base.BaseClass;
import org.automation.utility.Utility;
import org.testng.annotations.Test;

public class TC3 extends BaseClass
{
	@Test
	
	public void FirstTest() throws IOException, InterruptedException
	{
		//ExtentReportsWithTestNG.setUp();
		ExtentReportsWithTestNG.reportGenerationMethod("TC_003", "TC3");
		Xpathlocator(Utility.fetchLocatorValue("customers_tab_xpat"));
		Thread.sleep(4000);
		//ExtentReportsWithTestNG.endReport();
		//BaseClass.endReport();
		
	}

	
}
