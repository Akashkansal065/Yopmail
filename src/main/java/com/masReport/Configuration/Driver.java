package com.masReport.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

public class Driver {
	
//	private static String browserName=null;
	static Map<Integer,WebDriver> driver=new HashMap<Integer,WebDriver>();

	public synchronized static WebDriver getDriver() {
		return driver.get((int) (long) Thread.currentThread().getId());		
	}

	public synchronized static void setDriver(ITestContext context) {
		WebDriver driveme = BrowserSelection.browserType(context);
		driveme.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.put((int) (long) Thread.currentThread().getId(),driveme);
//		return driveme;
	}
	
	public synchronized static void TheEnd()
	{
		driver.get((int) (long) Thread.currentThread().getId()).quit();
		BrowserSelection.browserName=null;
	}
	public synchronized static void toBeContinued()
	{
		driver.get((int) (long) Thread.currentThread().getId()).close();
		BrowserSelection.browserName=null;
	}
	
	
}
