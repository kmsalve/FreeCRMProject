package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

//@Listeners(com.crm.qa.testcases.ListenerClass.class)
public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	
	HomePage homePage;
	
	ContactsPage contactsPage;
	
	//constructor
	public HomePageTest() 
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		
		loginPage = new LoginPage();
		
		homePage = new HomePage();
		
		homePage = loginPage.login("kmsalve@gmail.com","Rohan123@");	
		//homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	//@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String HomePageTitle = homePage.verifyHomePageTitle();
		
		AssertJUnit.assertEquals(HomePageTitle, "Cogmento CRM","Home Page Title Not matched");
		
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		
		AssertJUnit.assertTrue(homePage.verifyCorrectUserName());
	}
	
	 @Test(priority=3)
	public void verifyConactsLinkPageTest()
	{
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
}
