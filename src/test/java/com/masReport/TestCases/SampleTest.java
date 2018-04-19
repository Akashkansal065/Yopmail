package com.masReport.TestCases;

import org.testng.annotations.Test;

import com.masReport.Configuration.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class SampleTest extends Start {

	@Test(groups={"b"}, description="Method Two")
	public void reportTwo()
	{
		ExtentTestManager.getTest().log(LogStatus.INFO,"Test Started First");

		String element=driver.getCurrentUrl();
		String URL=element;
		//		String URL="dbdjkhbkjsndsd";
		//		System.out.println("Second Test"+URL);
		//		System.out.println(element);
		//		URL="dbdjkhbkjsndsd";
		ExtentTestManager.getTest().log(LogStatus.PASS,"Test assert");

		try {Thread.sleep(5000);} catch (InterruptedException e){e.printStackTrace();}

		Assert.assertEquals(element, URL);
		ExtentTestManager.getTest().log(LogStatus.PASS,"Test assert");

		/*URL="dbdjkhbkjsndsd";

			softassert.assertEquals(element, URL);
			ExtentTestManager.getTest().log(LogStatus.PASS,"Failed");

			URL="element";

			softassert.assertEquals(element, URL);
			ExtentTestManager.getTest().log(LogStatus.PASS,"Pass");
			softassert.assertAll();*/
	}

	/*@Test(description="Method One")
	public void report()
	{
		logger.log(LogStatus.INFO,"Test Started First");

		String element=driver.getCurrentUrl();
		String URL=element;
		//String URL="dbdjkhbkjsndsd";
		System.out.println("Second Test"+URL);
		System.out.println(element);
			Assert.assertEquals(element, URL);
			logger.log(LogStatus.PASS,"Test Verified");

		//report.endTest(logger);
	}*/
	/*@Test(groups={"a"})
	public void reportThree()
	{
		ExtentTestManager.getTest().log(LogStatus.INFO,"Test Started First");
		String element=Driver.getDriver().getCurrentUrl();
		String URL=element;
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String URL="dbdjkhbkjsndsd";
		System.out.println("Second Test"+URL);
		System.out.println(element);
			Assert.assertEquals(element, URL);
			ExtentTestManager.getTest().log(LogStatus.PASS,"Test Verified");

		//report.endTest(logger);
	}*/
}
