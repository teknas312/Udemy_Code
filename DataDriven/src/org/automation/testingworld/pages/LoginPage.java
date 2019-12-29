package org.automation.testingworld.pages;

import java.io.IOException;

import org.automation.testingworld.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterUsername(String username) throws IOException
	{
		driver.findElement(By.id(Utility.fetchLocatorValue("login_username_id"))).sendKeys(username);
		
	}
	
	public void enterPassword(String password) throws IOException
	{
		driver.findElement(By.id(Utility.fetchLocatorValue("login_password_id"))).sendKeys(password);
	}
	
	public void clickSignin() throws IOException
	{
		driver.findElement(By.xpath(Utility.fetchLocatorValue("login_button_xpath"))).click();
	}

}
