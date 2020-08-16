package com.crm.testcase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactDetailsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;
import com.crm.qa.utility.UtilityPage;

public class ContactPageTest extends TestBase{

	LoginPage login;
	HomePage homepageobj;
	UtilityPage util;
	ContactDetailsPage ContactPage;
    String sheetName = "Newcontact";
	
	public ContactPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initlization();
		login = new LoginPage();
		homepageobj = login.login();
		util = new UtilityPage();
		ContactPage = new ContactDetailsPage();
		UtilityPage.switchtoFrame("mainpanel");
		ContactPage = homepageobj.clickoncontactlink();
		
	}
	@Test
	public void verifycontactpagelable()
	{
			
		Assert.assertTrue(ContactPage.verifycontactslable(),"contact label missing");
	}
	
	@Test
	public void selectcontacts()
	{
		
		
		ContactPage.selectContacts();
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException, IOException
	{
		Object data [][] = UtilityPage.readExcel(sheetName);
		return data;
		
	}
	
	
	
	
	@Test(dataProvider="getCRMTestData")
	public void validatecreatenewcontact(String title, String firstName, String lastName, String company)
	{
		homepageobj.Clickonhomepagelink();
		homepageobj.clickonnewcontact();
		
		
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		ContactPage.createnewcontact(title,firstName,lastName,company);
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
