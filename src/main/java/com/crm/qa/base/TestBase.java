package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.events.EventFiringDecorator;

import com.crm.qa.util.Constants;
import com.crm.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	//initialize all properties
	//also all common methods which will be used in all pages and testcases
	//new driver
	//maximize
	//implicitwait
	//
	
	public static WebDriver old_driver, driver;
	
	public static Properties prop;

	public static WebEventListener eventListener;
	
	
	//constructor
	public TestBase() 
	{
		try
		{
			prop = new Properties();
			
			FileInputStream ip = new FileInputStream("/Users/kappu/eclipse-workspace/FreeCRMTestProject/src/main/java/com/crm/qa/config/config.properties");
			
			prop.load(ip);
		} 
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void initialization() 
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("firefox"))
		{
			//WebDriverManager.firefoxdriver().setup();
			old_driver = new FirefoxDriver();
		}
		
		if(browserName.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "/Users/kappu/Downloads/chromedriver_mac64/chromedriver");
			old_driver = new ChromeDriver();
			
		}	
		
		//---------------------- Fire for log  -------------------------

		eventListener = new WebEventListener();
		
		System.out.println("Listener*****************");
		
		driver = new EventFiringDecorator<WebDriver>(eventListener).decorate(old_driver);
		
		
		//new EventFiringDecorator<>(eventListener).decorate(driver);
		//--------------------------------------------------
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(Constants.PAGE_LOAD_IMPLICIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}
