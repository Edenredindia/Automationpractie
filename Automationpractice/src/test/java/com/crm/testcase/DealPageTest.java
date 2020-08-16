package com.crm.testcase;


import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.TestBase;
import com.crm.qa.utility.UtilityPage;

public class DealPageTest extends TestBase{
	
	LoginPage login;
	DealsPage deals;
	
	String sheetName = "NewDeal";
	public DealPageTest(){
		
		super();
		
	}
	
 @BeforeMethod
 public void setup()
 {
	 initlization();
	 login = new LoginPage();
	 login.login();
	 deals = new DealsPage();
	 //this is git cooment
	 UtilityPage.switchtoFrame("mainpanel");
	 
	 
	 
 }
 
 @Test(priority = 1)
 public void verifyloginpage()
 {
	 
	 deals.clickondeallink(); 
	 Assert.assertTrue(deals.verifynewdealpage());
 }

 @DataProvider
 public Object[][] newdealdataprovider()
 {
	 return UtilityPage.getTestData(sheetName);
	 
 }

 
 
 @Test(dataProvider = "newdealdataprovider")
 public void Createnewcontact(String tit,String comp,String contact, String id,String product)
 {
	 
	 deals.clickondeallink(); 
	 deals.creatnewdeal(tit, comp, contact, id,product);
	 Assert.assertTrue(deals.verifynewdealpage());
 }
  
 
 @AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
