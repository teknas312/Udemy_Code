package org.automation.testcases;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.automation.Reporting.ExtentReportsWithTestNG;
import org.automation.base.BaseClass;
import org.automation.utility.TakeScreenshot;
import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


public class TC_002_Validate_Creating_New_Hire_Altres extends BaseClass
{

	@Test
	public void setCustomConfig() throws IOException, InterruptedException
	{
		//ExtentReportsWithTestNG.setUp();
		ExtentReportsWithTestNG.reportGenerationMethod("TC_002_Validate_Creating_New_Hire_Altres", "TC_002_Validate_Creating_New_Hire_Altres");
		//ExtentReportsWithTestNG.endReport();
		Xpathlocator(Utility.fetchLocatorValue("customers_tab_xpath"));
		List<WebElement> li=we.findElements(By.tagName("input"));
		System.out.println("Size of the elements are:"+li.size());

		for(int i=0;i<li.size();i++)
		{
			WebElement ele=li.get(i);
			String s1=ele.getAttribute("value");
			System.out.println("Elements located are:"+s1);
			if(s1.equalsIgnoreCase("Filter"))
			{
				System.out.println("Filter button is present");
			}
			else if(s1.equalsIgnoreCase("Reset"))
			{
				System.out.println("Reset button is present");
			}
			else if(s1.equalsIgnoreCase("fromFilterSubmit"))
			{
				System.out.println("Submit button is present");
			}

		}

		//we.findElement(By.xpath(Utility.fetchLocatorValue("select_adv_company1_xpath"))).click();
		Xpathlocator(Utility.fetchLocatorValue("select_adv_company1_xpath"));

		List<WebElement> li1=we.findElements(By.xpath("//input[@type='button']"));
		System.out.println("Size of the elements are:"+li1.size());

		for(int i=0;i<li1.size();i++)
		{
			WebElement ele1=li1.get(i);
			String s2=ele1.getAttribute("value");
			System.out.println("Elements located are:"+s2);
			if(s2.equalsIgnoreCase("Save"))
			{
				System.out.println("Save button is present");
			}
			else if(s2.equalsIgnoreCase("Checklist"))
			{
				System.out.println("Checklist button is present");
			}
			else if(s2.equalsIgnoreCase("SSO Remediation"))
			{
				System.out.println("SSO Remediation is present");
			}
			else if(s2.equalsIgnoreCase("Web User Accounts"))
			{
				System.out.println("Web User Accounts is present");
			}
			else if(s2.equalsIgnoreCase("Hide Check"))
			{
				System.out.println("Web User Accounts is present");
			}
			else if(s2.equalsIgnoreCase("Resync Customer"))
			{
				System.out.println("Resync Customer is present");
			}	

		}

		test.info("Clicking on the Quickhire config button");
		Xpathlocator(Utility.fetchLocatorValue("quickhire_config_button"));
		//Xpathlocator(Utility.fetchLocatorValue("quickhire_config_button"));
		Thread.sleep(5000);

		List<WebElement> li2=we.findElements(By.xpath("//input[@type='radio']"));
		System.out.println("Size of the elements are:"+li2.size());
		for(int i=0;i<li2.size();i++)
		{
			WebElement ele2=li2.get(i);
			String s3=ele2.getAttribute("name");
			System.out.println("Elements located are:"+s3);
			if(s3.equalsIgnoreCase("hasRequireNewHireApproval"))
			{
				ele2.click();
				break;
			}

		}
		for(int j=0;j<li2.size();j++)
		{
			WebElement ele3=li2.get(j);
			String s4=ele3.getAttribute("name");
			System.out.println("Elements located are:"+s4);
			if(s4.equalsIgnoreCase("hasAltresManagedOnboarding"))
			{
				ele3.click();
				break;
			}

		}

		Thread.sleep(5000);
		Xpathlocator(Utility.fetchLocatorValue("hiring_manager_checkbox"));
		Thread.sleep(6000);
		Xpathlocator(Utility.fetchLocatorValue("QH_Config_Save_button"));
		Thread.sleep(2000);
		LinkText(Utility.fetchLocatorValue("QH_link"));
		Thread.sleep(4000);
		Xpathlocator(Utility.fetchLocatorValue("Add_New_Hire_button"));
		Thread.sleep(3000);

		XpathSendText(Utility.fetchLocatorValue("Customer_Number_Search_Field"),"13211");
		Xpathlocator(Utility.fetchLocatorValue("select_customer_filter"));
		Xpathlocator(Utility.fetchLocatorValue("select_advantage_company"));
		Thread.sleep(4000);

		Random r = new Random();
		int low = 256351245;
		int high = 562513248;
		int ssn = r.nextInt(high-low) + low;
		System.out.println("SSN number generated is:"+ssn);
		XpathSendTextInteger(Utility.fetchLocatorValue("ssn_field"), ssn);
		Random random=new Random();
		String NewHireName="QA";
		NewHireName += Integer.toString(random.nextInt(9999));
		System.out.println("New hire name is:"+NewHireName);
		XpathSendText(Utility.fetchLocatorValue("legal_first_name"), NewHireName);
		XpathSendText(Utility.fetchLocatorValue("legal_last_name"), NewHireName);
		Thread.sleep(5000);

		/*Select s1=new Select(we.findElement(By.xpath(Utility.fetchLocatorValue("HRowner_droplist"))));
		s1.selectByIndex(1);
		 */

		Select s1=new Select(Xpathlocator2(Utility.fetchLocatorValue("HRowner_droplist")));
		s1.selectByIndex(1);
		XpathSendText(Utility.fetchLocatorValue("client_hire_date"),"03/14/2021");
		XpathSendText(Utility.fetchLocatorValue("altres_start_date"),"03/14/2021");
		Random r1=new Random();
		String Email="qatest";
		Email += Integer.toString(random.nextInt(9999))+"@gmail.com";
		System.out.println("Mail generated is:"+Email);
		XpathSendText(Utility.fetchLocatorValue("email_field"),Email);

		XpathSendText(Utility.fetchLocatorValue("residential_address_line1"), "Address1");
		XpathSendTextInteger(Utility.fetchLocatorValue("residential_address_zip"),96782);
		XpathSendText(Utility.fetchLocatorValue("residential_address_city"), "Pearl City");
		XpathSendText(Utility.fetchLocatorValue("residential_address_state"), "HI");
		Xpathlocator(Utility.fetchLocatorValue("MailSameasResidential_checkbox"));

		/*Select s2=new Select(Xpathlocator2(Utility.fetchLocatorValue("employmentType_droplist")));
		s2.selectByVisibleText("Full Time");*/
		selectMethod("employmentType_droplist", "Full Time");
		/*Select s3=new Select(Xpathlocator2(Utility.fetchLocatorValue("jobTitle_droplist")));
		s3.selectByVisibleText("Administrative Assistant");*/
		selectMethod("jobTitle_droplist", "Administrative Assistant");
		/*Select s4=new Select(Xpathlocator2(Utility.fetchLocatorValue("location_droplist")));
		s4.selectByVisibleText("CLUB");*/
		selectMethod("location_droplist", "CLUB");
		/*Select s5=new Select(Xpathlocator2(Utility.fetchLocatorValue("department_droplist")));
		s5.selectByVisibleText("Department 03");*/
		selectMethod("department_droplist", "Department 03");
		/*Select s6=new Select(Xpathlocator2(Utility.fetchLocatorValue("division_droplist")));
		s6.selectByVisibleText("Divison 01");*/
		selectMethod("division_droplist", "Divison 01");
		/*Select s7=new Select(Xpathlocator2(Utility.fetchLocatorValue("shift_droplist")));
		s7.selectByVisibleText("Shift 01");*/
		selectMethod("shift_droplist", "Shift 01");
		/*Select s8=new Select(Xpathlocator2(Utility.fetchLocatorValue("benefit_group_droplist")));
		s8.selectByVisibleText("PRIMARY");*/
		selectMethod("benefit_group_droplist", "PRIMARY");
		/*Select s9=new Select(Xpathlocator2(Utility.fetchLocatorValue("benefits_eligibility_droplist")));
		s9.selectByVisibleText("Eligible (employee will work 20 or more hours per week)");*/
		selectMethod("benefits_eligibility_droplist", "Eligible (employee will work 20 or more hours per week)");
		XpathSendTextInteger(Utility.fetchLocatorValue("payrate_amount"), 900);
		/*Select s10=new Select(Xpathlocator2(Utility.fetchLocatorValue("requestedBy_droplist")));
		s10.selectByVisibleText("Example1, EmployeeAdmin1");*/
		selectMethod("requestedBy_droplist", "Example1, EmployeeAdmin1");
		Xpathlocator(Utility.fetchLocatorValue("saveHire_button"));
		Thread.sleep(5000);
		//ExtentReportsWithTestNG.endReport();
		//BaseClass.endReport();
		

	}
	
	



}

