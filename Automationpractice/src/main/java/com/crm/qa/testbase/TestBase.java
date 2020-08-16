package com.crm.qa.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;





import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.crm.qa.utility.UtilityPage;
import com.crm.qa.utility.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	//ExtentReports report;
	public ExtentTest logger;
	public TestBase() {

		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"./Config/Config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void initlization() 
	{
		String browsername = prop.getProperty("Browser");

		if (browsername.equals("Chrome"))
				
		{

			System.setProperty("webdriver.chrome.driver",
					"./Drivers/chromedriver.exe");
			driver = new ChromeDriver();


		}
		
		else
		{
			System.out.println("Browsername " +browsername + " not present in config file");
		}

		e_driver = new EventFiringWebDriver(driver);
		// Create object of event listener handler to register with event
		// EventFiringDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));

	}

}
