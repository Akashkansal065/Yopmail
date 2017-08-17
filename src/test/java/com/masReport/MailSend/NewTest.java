package com.masReport.MailSend;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class NewTest {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
  
	@Test
  public void f() {
		String element=driver.getCurrentUrl();
		System.out.println(element);
	  
  }
	@Test
	public void report()
	{
		report=new ExtentReports("./Reports/TestReport.html");
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
		report.endTest(logger);
		report.flush();
		
	}

	@AfterTest
  public void afterMethod() {
		driver.quit();
  }

 
	@BeforeTest
  public void beforeTest() {
		System.setProperty("webdriver.chrome.driver","D://Jars//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
  }

}
