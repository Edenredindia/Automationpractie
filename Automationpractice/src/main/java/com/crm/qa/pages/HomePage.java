package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testbase.TestBase;
import com.crm.qa.utility.UtilityPage;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(),'User: Demo User')]") WebElement usernamlable;
	
	@FindBy (xpath="////a[contains(text(),'Deals')]") WebElement dealspagelink;
	@FindBy (xpath="////a[contains(text(),'Tasks')]") WebElement tasklink;
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]") WebElement newContactLink;
	@FindBy(xpath = "//a[text()='Home']") WebElement Homepagelink;
	@FindBy(xpath = "//a[contains(text(),'Docs')]") WebElement documenlink;
	@FindBy(xpath = "//a[contains(text(),'New Document')]") WebElement Newdocumenlink;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public String verifyhomepagetitle()
	{
		return driver.getTitle();
	}
	
	public ContactDetailsPage clickoncontactlink()
	
	{
		
		
		contactsLink.click();
		 
		 return new ContactDetailsPage();
	}
	
    public TaskPage clickontask()
	
	{
    	tasklink.click();
		 
		 return new TaskPage();
	}
    
    public DealsPage clickondealslink()
	
	{
    	dealspagelink.click();
		 
		 return new DealsPage();
	}
    
    
    public boolean verifyloggedinusername()
    {
    	 return usernamlable.isDisplayed();
    }
    
    public void clickonnewcontact()
    {
    	Actions action = new Actions(driver);
    	action.moveToElement(contactsLink).build().perform();
    	newContactLink.click();
    		
    }
    public void Clickonhomepagelink()
    {
    	Homepagelink.click();
    }
    
    public void Clicknewdocumentpagelink()
    {
    	Actions action = new Actions(driver);
    	action.moveToElement(documenlink).build().perform();
    	Newdocumenlink.click();
    }
}
