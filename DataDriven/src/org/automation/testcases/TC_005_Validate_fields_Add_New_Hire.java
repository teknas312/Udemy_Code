package org.automation.testcases;

import java.io.IOException;

import org.automation.Reporting.ExtentReportsWithTestNG;
import org.automation.base.BaseClass;
import org.automation.utility.Utility;
import org.testng.annotations.Test;

public class TC_005_Validate_fields_Add_New_Hire extends BaseClass
{
	@Test
	
	public void validateFields() throws IOException, InterruptedException
	{
		ExtentReportsWithTestNG.reportGenerationMethod("TC_005_Validate_fields_Add_New_Hire", "TC_005_Validate_fields_Add_New_Hire");
		LinkText(Utility.fetchLocatorValue("QH_link"));
		Thread.sleep(4000);
		Xpathlocator(Utility.fetchLocatorValue("Add_New_Hire_button"));
		Thread.sleep(3000);
		XpathSendText(Utility.fetchLocatorValue("Customer_Number_Search_Field"),"13211");
		Xpathlocator(Utility.fetchLocatorValue("select_customer_filter"));
		Xpathlocator(Utility.fetchLocatorValue("select_advantage_company"));
		Thread.sleep(4000);
		XpathElementIsDisplayed(Utility.fetchLocatorValue("customer_number_label"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("customer_name_label"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("ssn_field"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("legal_first_name"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("legal_last_name"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("primary_client_contact_label"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("secondary_client_contact_label"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("HRowner_droplist"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("client_hire_date"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("altres_start_date"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("primary_phone_number_label"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("alternative_phone_number_label"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("email_field"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("residential_address_line1"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("residential_address_zip"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("residential_address_city"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("residential_address_state"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("MailSameasResidential_checkbox"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("mailing_address_line1"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("mailing_address_zip"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("mailing_address_city"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("mailing_adress_state"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("residential_address_state"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("emergency_contact_full_name"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("emergency_contact_relationship"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("emergency_contact_phone"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("employmentType_droplist"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("jobTitle_droplist"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("location_droplist"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("department_droplist"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("division_droplist"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("shift_droplist"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("pay_group_label"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("benefit_group_droplist"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("benefits_eligibility_droplist"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("payrate_amount"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("union_member_checkbox"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("hours_worked_per_week_label"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("verify_case_number_label"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("special_instruction_label"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("requestedBy_droplist"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("saveHire_button"));
		XpathElementIsDisplayed(Utility.fetchLocatorValue("return_to_select_customer_button"));
		
		
		
		
		
		
		
		
		

	}
	

}
