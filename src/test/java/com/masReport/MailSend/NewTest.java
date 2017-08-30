package com.masReport.MailSend;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class NewTest {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Date date=new Date();

	@Test
	public void report()
	{
		//report=new ExtentReports("./Reports/TestReport.html");
		logger=report.startTest("report", "Basic testing");
		logger.log(LogStatus.INFO,"Test Started First");
		
		String element=driver.getCurrentUrl();
		String URL=element;
		//String URL="dbdjkhbkjsndsd";
		System.out.println("Second Test"+URL);
		System.out.println(element);
		try{
			Assert.assertEquals(element, URL);
			logger.log(LogStatus.PASS,"Test Verified");
		}catch(Throwable e){
			logger.log(LogStatus.FAIL,element +" "+ e.getMessage() +" "+URL);
		}	
		//report.endTest(logger);
	}
	@Test
	public void reportTwo()
	{
		
		logger=report.startTest("reportTwo", "Basic NOt testing");
		logger.log(LogStatus.INFO,"Test Started First");
		
		String element=driver.getCurrentUrl();
		//String URL=element;
		String URL="dbdjkhbkjsndsd";
		System.out.println("Second Test"+URL);
		System.out.println(element);
		try{
			Assert.assertEquals(element, URL);
			logger.log(LogStatus.PASS,"Test Verified");
		}catch(Throwable e){
			logger.log(LogStatus.FAIL,element +" "+ e.getMessage() +" "+URL);
		}		
		//report.endTest(logger);
	}

	@AfterMethod
  public void afterMethod() {
		report.endTest(logger);
		driver.quit();
  }
	@AfterSuite
	public void Last()
	{
		report.flush();
		report.close();
		
	}
 
	@BeforeMethod
	@Parameters({"URL"})
  public void beforeTest(String url) {
		System.setProperty("webdriver.chrome.driver","D://Jars//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("Before Method");
  }
	/*	@BeforeTest
	public void befor()
	{
		System.out.println("@BeforeTest");
	}
	
	@AfterTest
	  public void AfterTest() {
			System.out.println("After Test");
	  }*/
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("@@BeforeSuite");
//		report=new ExtentReports("./Reports/TestReport "+ date.toString().replace(':','_').replace(' ','_') +".html");
		report=new ExtentReports("./Reports/TestReport.html");
	}

}
