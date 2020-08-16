package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.testbase.TestBase;
import com.crm.qa.utility.UtilityPage;

public class DealsPage extends TestBase {
	
	@FindBy (xpath = "//a[text()='New Deal']") WebElement Newdeallink;
	@FindBy (xpath = "//strong[text()='Deal No.']") WebElement Dealnolable;
	@FindBy (xpath = "//a[text()='Deals']") WebElement Dealtab;
	@FindBy (name = "title") WebElement title;
	@FindBy (name = "client_lookup") WebElement compname;
	@FindBy (name = "contact_lookup") WebElement contactname;
	@FindBy (name = "identifier") WebElement identifier;
	@FindBy (name="product_id") WebElement product;
	
	
	@FindBy (xpath = "//input[@type='submit' and @value ='Save']") WebElement save;
	
	
	public DealsPage()
	{
	  PageFactory.initElements(driver, this);
	}
	
	public void clickondeallink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(Dealtab).build().perform();
		System.out.println("moing downsasasasasssssssssss");
		Newdeallink.click();
	}
	
    public boolean verifynewdealpage()
    {
    	return Dealnolable.isDisplayed();
    }
    
    public void creatnewdeal(String tit,String comp,String contact,String id,String productsel)
    {
    	title.sendKeys(tit);
    	compname.sendKeys(comp);
    	contactname.sendKeys(contact);
    	identifier.sendKeys(id);
    	
    	Select sel = new Select(product);
    	sel.selectByVisibleText(productsel);
    	//sel.selectByVisibleText("");
    	//sel.selectByVisibleText("");
    	//product.sendKeys(sel);
    	
    	save.click();
    	
    }
    
    
    
}
