package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{

	//Object repository
	
	////*[@id="ui"]/div/div/form/div/div[1]/div/input
	
	@FindBy(xpath ="//input[@name='email']")
	WebElement username;
	
	@FindBy(xpath ="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath ="//div[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath ="//button[contains(text(),'Sign Up')]")
	WebElement SignupBtn;
	
	@FindBy(xpath ="//img[contains(@class,'img-resposive')]")
	WebElement crmLogo;		
	
	
	//constructor - inittialize page object
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}

	//Actions : method to return title
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMLogoImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String ps)
	{
		username.sendKeys(un);
		password.sendKeys(ps);
		loginBtn.click();
		
		return new HomePage();
	}
}

