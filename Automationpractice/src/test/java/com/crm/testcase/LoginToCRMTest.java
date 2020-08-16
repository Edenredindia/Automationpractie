package com.crm.testcase;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;

public class LoginToCRMTest extends TestBase {
	LoginPage login;
	HomePage Hompepage;
	
	
	public LoginToCRMTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initlization();
		 login = new LoginPage();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
	@Test(priority=1)
	public void logintoapplication() {
		System.out.println("check login application");
		Hompepage = login.login();
	}
	
	@Test(priority=2)
	public void verifypagetitle()
	{
		
		String title  = login.verifytitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");	
	}
	
	
	@Test(priority=3)
	public void verifylogopresent()
	{
		Boolean logo = login.verifylogo();
		Assert.assertTrue(logo);
	}
	
	
}
