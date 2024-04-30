package com.crm.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
	LoginPage loginPage;
	
	HomePage homePage;
	
	ContactsPage contactPage;
	
	String sheetName="Contacts";
		

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() 
	{
		initialization();
		
		loginPage = new LoginPage();
		
		homePage = new HomePage();
		
		contactPage = new ContactsPage();
		
		homePage = loginPage.login("kmsalve@gmail.com", "Rohan123@");
		
		contactPage = homePage.clickOnContactsLink();
	}
	
	
	//@Test(priority=1)
	public  void verifyContactsPageLabel()
	{
		AssertJUnit.assertTrue(contactPage.verifyConactsPage());
	}
	
	//@Test(priority=2)
	public  void verifyContactsTest()
	{
		contactPage.selectContactsByName("test test ghodeswar");
	
	}
	
	@Test(priority=3, dataProvider="getTestData")
	public  void validateCreateNewContactTest(String fname,String lname,String company)
	{	
		contactPage.createNewContact(fname,lname,company);
		
		//you can validate here if contacts are created or not
	}
	
	//Data provider to read from excel file
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		
		return data;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
