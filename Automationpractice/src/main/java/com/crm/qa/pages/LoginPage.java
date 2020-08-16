package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testbase.TestBase;

public class LoginPage extends TestBase {
	
	
	@FindBy (name  = "username") WebElement username;
	@FindBy (name  = "password") WebElement pass;
	@FindBy (xpath  = "//input[@class='btn btn-small']") WebElement Loginclick;
    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/a[1]/img[1]") WebElement imagelogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifytitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login()
	{
		username.sendKeys(prop.getProperty("Username"));
		pass.sendKeys(prop.getProperty("Password"));
		Loginclick.click();
		return new HomePage();
	}
	
	public boolean verifylogo()
	{
		return imagelogo.isDisplayed();
	}
	
	
}
