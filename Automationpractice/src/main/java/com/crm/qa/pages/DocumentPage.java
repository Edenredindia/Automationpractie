package com.crm.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.testbase.TestBase;

public class DocumentPage extends TestBase{
	
	@FindBy (name = "title") WebElement  doctitle;
	@FindBy (name = "description")WebElement description;
	@FindBy (name = "file")WebElement fileupload;
	@FindBy (xpath = "//input[@type = 'submit']")WebElement save;
	@FindBy (xpath = "//strong[text()= 'Version']") WebElement version;
	
	
	
	
	public DocumentPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
   public void createnewdocument(String title,String descr)
   {
	   
	   
	   doctitle.sendKeys(title);
	   description.sendKeys(descr);
	   //fileupload.sendKeys("C://Users//Swapnil Joshi//workspace//FreeCRMTeste//src//main//java//TestDocuementtoupload//1797_InvoicePDF.pdf");
	   fileupload.sendKeys(System.getProperty("user.dir")+"./TestDocuementtoupload/1797_InvoicePDF.pdf");
	   save.click();
	   
   }
   
   public void checkdocumentvalidation(String title,String descr) throws InterruptedException
   {
	   doctitle.sendKeys(title);
	   description.sendKeys(descr);
	   save.click();
       Thread.sleep(5000);
	   Alert alert = driver.switchTo().alert();
       alert.accept();
       fileupload.sendKeys(System.getProperty("user.dir")+"./TestDocuementtoupload/1797_InvoicePDF.pdf");
       save.click();
       String versiontext = version.getText();
      Assert.assertEquals(version.getText(), versiontext, "validation failed");
       
   }
   
   
   
}
