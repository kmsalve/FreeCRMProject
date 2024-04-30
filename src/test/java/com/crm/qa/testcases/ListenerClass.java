package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ListenerClass extends TestBase implements ITestListener
{
	@Test
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test is failed");
		try {
			TestUtil.takeScreenshotAtEndofTest(driver, result.getName());
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}

}
