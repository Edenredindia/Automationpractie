package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.testbase.TestBase;

public class ContactDetailsPage extends TestBase {
	
	public ContactDetailsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="surname") WebElement contactlastname;
	@FindBy (name="client_lookup") WebElement companyname;
	@FindBy (name="first_name") WebElement contactfirstname;
	@FindBy (xpath="//td[contains(text(),'Contacts')]") WebElement contactlabel;
	@FindBy (xpath="//a[contains(text(),'Ajay Sharma')]") WebElement contactvalues;
	@FindBy (xpath="//input[@type='submit' and @value ='Save']") WebElement contactsave;
	
	
	public boolean verifycontactslable()
	{
		return contactlabel.isDisplayed();
	}
    
	
	public void selectContacts()
	{
		contactvalues.click();
	}
	
	public void createnewcontact(String title, String fname, String lname, String Compname)
	{
	Select select= new Select(driver.findElement(By.name("title")));
	
	select.selectByValue(title);
	contactfirstname.sendKeys(fname);
	contactlastname.sendKeys(lname);
	companyname.sendKeys(Compname);
	contactsave.click();
	}
}
