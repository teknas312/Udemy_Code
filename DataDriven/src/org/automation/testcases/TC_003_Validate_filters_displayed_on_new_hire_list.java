package org.automation.testcases;

import java.io.IOException;
import java.util.List;

import org.automation.Reporting.ExtentReportsWithTestNG;
import org.automation.base.BaseClass;
import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_003_Validate_filters_displayed_on_new_hire_list extends BaseClass
{
	@Test

	public void FiltersDisplay() throws IOException, InterruptedException
	{
		//ExtentReportsWithTestNG.setUp();
		ExtentReportsWithTestNG.reportGenerationMethod("TC_003", "Validate filters displayed when no records");
		LinkText(Utility.fetchLocatorValue("QH_link"));
		Thread.sleep(2000);
		//ExtentReportsWithTestNG.endReport();
		//BaseClass.endReport();
		List<WebElement> li=we.findElements(By.xpath("//input[@type='text']"));
		System.out.println("Total number of elements are:"+li.size());
		for(int i=0;i<li.size();i++)
		{
			WebElement ele=li.get(i);
			String s1=ele.getAttribute("name");
			System.out.println("Filters located are:"+s1);
			if(s1.equalsIgnoreCase("QuickhireNewHireListControllercustomer_number"))
			{
				System.out.println("Customer number filter is present");
			}
			if(s1.equalsIgnoreCase("QuickhireNewHireListControllercustomer"))
			{
				System.out.println("Customer name filter is present");
			}
			if(s1.equals("QuickhireNewHireListControllerlast_name###first_name####first_name###last_name"))
			{
				System.out.println("New hire name filter is present");
			}
		}
		
		List<WebElement> li1=we.findElements(By.xpath("//select"));
		System.out.println("Total number of elements are:"+li1.size());
		for(int i=0;i<li1.size();i++)
		{
			WebElement ele1=li1.get(i);
			String s2=ele1.getAttribute("name");
			System.out.println("Dropdowns located are:"+s2);
			if(s2.equalsIgnoreCase("QuickhireNewHireListControllerstatus"))
			{
				System.out.println("Status droplist is present");
			}
			if(s2.equalsIgnoreCase("QuickhireNewHireListControlleris_new_hire_authorized"))
			{
				System.out.println("NHA droplist is present");
			}
			
		}

	}
}




