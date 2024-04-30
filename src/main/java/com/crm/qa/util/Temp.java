package com.crm.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class Temp {

	    public static void main(String[] args) 
	    {
	        // Step 1: Create a WebDriver instance (e.g., ChromeDriver)
	       

	        // Step 2: Create an instance of your WebEventListener
	        WebEventListener eventListener = new WebEventListener();

	        // Step 3: Create an instance of EventFiringDecorator and decorate the WebDriver with it
	       // WebDriver decoratedDriver = new EventFiringDecorator<WebDriver>(eventListener).decorate(driver);
	       WebDriver decoratedDriver = new EventFiringDecorator<WebDriver>(eventListener).decorate(new  FirefoxDriver());
	        
	        // Step 4: Use the decorated WebDriver instance for your tests
	        decoratedDriver.get("https://www.google.com");
	        

	        System.out.println("------->"+decoratedDriver.getTitle());
	        
	        decoratedDriver.manage().window().maximize();
	        // Other test steps...
	        // Step 5: Close the WebDriver instance
	        decoratedDriver.quit();
	    }

}
