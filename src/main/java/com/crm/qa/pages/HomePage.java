package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{
	
	//Repository 
	
	@FindBy(xpath ="//span[contains(text(),'Kalpana Ghodeswar')]")
	WebElement userNameLabel;
	
	@FindBy(xpath ="//a[@class='item' and @href='/contacts']")
	WebElement contactsLink;

	@FindBy(xpath ="//a[@class='item' and @href='/deals']")
	WebElement dealsLink;
	
	@FindBy(xpath ="//a[@class='item' and @href='/tasks']")
	WebElement tasksLink;
	
	//Initialize
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() 
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() 
	{
		
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		
		executor.executeScript("arguments[0].click();", contactsLink);	
		
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() 
	{
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() 
	{
		tasksLink.click();
		return new TasksPage();
	}

}
