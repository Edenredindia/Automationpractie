package com.crm.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactDetailsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;
import com.crm.qa.utility.UtilityPage;

public class HomePageTest extends TestBase {

	LoginPage login;
	HomePage homepageobj;
	UtilityPage util;
	ContactDetailsPage ContactPage;
	public HomePageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initlization();
		login = new LoginPage();
		homepageobj = login.login();
		util = new UtilityPage();
		ContactPage = new ContactDetailsPage();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

	@Test
	public void homepagetitle() {
		String homepagetitle = homepageobj.verifyhomepagetitle();
		Assert.assertEquals(homepagetitle, "CRMPRO",
				"HomePagetitle not matched");
	}

	@Test
	public void verifyloggedinusername() {
		util.switchtoFrame("mainpanel");
		Assert.assertTrue(homepageobj.verifyloggedinusername());
	}
	
	@Test
	public void verifycontactlinktest()
	{
		util.switchtoFrame("mainpanel");
		ContactPage = homepageobj.clickoncontactlink();
	}
}
