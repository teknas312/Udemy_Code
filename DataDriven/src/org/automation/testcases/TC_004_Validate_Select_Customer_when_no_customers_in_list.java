package org.automation.testcases;

import java.io.IOException;
import java.util.List;

import org.automation.Reporting.ExtentReportsWithTestNG;
import org.automation.base.BaseClass;
import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class TC_004_Validate_Select_Customer_when_no_customers_in_list extends BaseClass
{
	@Test
	
	public void validateSelectCustomerScreen() throws IOException, InterruptedException
	{
		ExtentReportsWithTestNG.reportGenerationMethod("TC_004", "Validate select customer when no customers present");
		LinkText(Utility.fetchLocatorValue("QH_link"));
		Thread.sleep(3000);
		Xpathlocator(Utility.fetchLocatorValue("Add_New_Hire_button"));
		/*boolean status=we.findElement(By.xpath("//input[@type='text' and @name='QuickhireCustomerListControllercustomer_number']")).isDisplayed();
		System.out.println(status);*/
		Thread.sleep(4000);
		XpathElementIsDisplayed(Utility.fetchLocatorValue("select_Customer_Number_Search_Field"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("select_Customer_Name_Search_Field"));
		XpathSendText(Utility.fetchLocatorValue("select_Customer_Number_Search_Field"), "test");
		Xpathlocator(Utility.fetchLocatorValue("select_customer_filter"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("0_results_found"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("return_to_new_hire_list_button"));
		test.log(Status.PASS, "Validated the fields on the page");
		
		
		
	}
	}

