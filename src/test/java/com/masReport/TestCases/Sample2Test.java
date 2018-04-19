package com.masReport.TestCases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.masReport.Configuration.Start;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class Sample2Test extends Start {
	@Test
	public void testApp4(){
		AssertJUnit.assertTrue(false);
	}
	
	@Test
	public void testApp5(){
		AssertJUnit.assertTrue(true);
	}
	
	@Test
	public void testApp6(){
		AssertJUnit.assertTrue(false);
	}
	
	
	@Test
	public void testApp7(){
		AssertJUnit.assertTrue(true);
	}
	/*@Test
	public void reportSamp()
	{
		ExtentTestManager.getTest().log(LogStatus.INFO,"Test Started First");
		String element=Driver.getDriver().getCurrentUrl();
		String URL=element;
		//String URL="dbdjkhbkjsndsd";
		System.out.println("Second Test"+URL);
		System.out.println(element);
			Assert.assertEquals(element, URL);
			ExtentTestManager.getTest().log(LogStatus.PASS,"Test Verified");
		
		//report.endTest(logger);
	}*/
}
