package com.crm.testcase;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.DocumentPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;
import com.crm.qa.utility.UtilityPage;

public class DocumentTest extends TestBase{
	LoginPage login;
	HomePage Home;
	UtilityPage utility;
	DocumentPage doc;
	String sheetname = "NewDocument";
	
	
	public DocumentTest()
	{
		super();
	}
	
	@BeforeMethod 
	public void setup()
	{
		
		initlization();
		login  = new LoginPage();
		login.login();
		Home = new HomePage();
		UtilityPage.switchtoFrame("mainpanel");
		 doc = new DocumentPage();
		 Home.Clicknewdocumentpagelink();
		
	}
	
	
	@DataProvider 
	public Object[][] getcrmtestdata()
	{
		return UtilityPage.getTestData(sheetname);
		}
	
	
	@Test(dataProvider = "getcrmtestdata")
	public void Createnewdocuement(String title, String descptionentered )
	{
		doc.createnewdocument(title,descptionentered);
	}
	
	@Test(dataProvider = "getcrmtestdata")
	public void Checkdocumenvalidation(String title, String descptionentered ) throws InterruptedException
	{
		doc.checkdocumentvalidation(title,descptionentered);
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}