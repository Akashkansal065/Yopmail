package com.masReport.Configuration;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public abstract class Start {

	protected WebDriver driver;
	Date date=new Date();
	SoftAssert softassert = new SoftAssert();
	SendMail send =new SendMail();

	/*	@BeforeSuite(alwaysRun=true)
	public void beforeSuite()
	{
		System.out.println("@BeforeSuite");
//		report=new ExtentReports("./Reports/TestReport "+ date.toString().replace(':','_').replace(' ','_') +".html");
		report=new ExtentReports("./Reports/TestReport.html");

	}*/

	/*	@BeforeTest
	public void befor()
	{
		System.out.println("@BeforeTest");
	}*/


	@BeforeMethod(alwaysRun=true)
	@Parameters({"URL"})
	public void beforeMethod(String url,Method method,ITestContext itcontext) {

		Driver.setDriver(itcontext).get(url);			//Setting up driver for First Time Creating Thread id
		driver=Driver.getDriver();						//Fetching the created Thread Id.


		Test test = method.getAnnotation(Test.class);	/*Getting all Annotaion Data of TestCases in Java Class*/
		if(test==null)
		{
			return;
		}

		/*Started Creating of Extent Report*/
		ExtentTestManager.startTest(method.getDeclaringClass().getSimpleName()+"."+method.getName(), test.description());
		//		logger=report.startTest(method.getDeclaringClass().getSimpleName()+"."+method.getName(), test.description()).assignCategory(itcontext.getName());

		ExtentTestManager.getTest().assignCategory(itcontext.getName());

		driver.manage().window().maximize();
	}

	@SuppressWarnings("deprecation")
	@AfterMethod(alwaysRun=true)
	public void afterMethod(ITestResult result) throws IOException {

		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshot=ScreenShots.ShotCaptured(Driver.getDriver(),result.getMethod().getMethodName()+date.getSeconds());
			ExtentTestManager.getTest().log(LogStatus.FAIL,result.getThrowable());
			ExtentTestManager.getTest().log(LogStatus.FAIL,ExtentTestManager.getTest().addScreenCapture(screenshot));
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			ExtentTestManager.getTest().log(LogStatus.PASS,result.getMethod().getMethodName() +" Completed");
		}else if(result.getStatus()==ITestResult.SUCCESS_PERCENTAGE_FAILURE)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL,result.getMethod().getMethodName() +" Completed");
		}else if(result.getStatus()==ITestResult.SKIP)
		{
			ExtentTestManager.getTest().log(LogStatus.WARNING,result.getMethod().getMethodName() +" Skipped");
		}

		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
		Driver.TheEnd();
		//		Driver.toBeContinued();
	}

	/*@AfterTest
	  public void AfterTest() {
			System.out.println("After Test");
	  }*/

	@AfterSuite(alwaysRun=true)
	public void Last() throws IOException
	{
		//report.flush();
		//send.mail(Constant.to, Constant.cc, Constant.username, Constant.password, Constant.filename);
		ExtentManager.getInstance().close();
		ExtentManager.flush();
		send.mail(Constant.to, Constant.cc, Constant.username, Constant.password, Constant.filename);
		//WindowsUtils.killByName("chrome.exe");
	}

}
