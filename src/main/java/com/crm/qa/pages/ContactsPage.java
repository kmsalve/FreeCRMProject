package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	
	//Repo - get all elements from page
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement conatctsLabel;
	
	@FindBy(xpath = "//button[contains(text(), 'Create')]")
	WebElement createBtn;
	
	@FindBy(xpath = "//input[@name= 'first_name']")
	WebElement firstNameTxt;
	
	@FindBy(xpath = "//input[@name= 'last_name']")
	WebElement lastNameTxt;
	
	@FindBy(xpath = "//input[@class= 'search']")
	WebElement companyTxt;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyConactsPage()
	{
		return conatctsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name)
	
	{
		/*
		 * //a[contains(text(),'test test ghodeswar')]
		 */
		
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).click();;
	}
	
	public void createNewContact(String fname, String lname, String company)
	{
		createBtn.click();
		firstNameTxt.sendKeys(fname);
		lastNameTxt.sendKeys(lname);
		companyTxt.sendKeys(company);
		saveBtn.click();
	}
}
