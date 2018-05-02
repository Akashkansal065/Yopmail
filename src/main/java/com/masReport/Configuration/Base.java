package com.masReport.Configuration;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

public class Base {
	
	public WebDriver driving = Driver.getDriver();
		
	public void openUrl(String URL)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, "Url Opened", URL);
		driving.get(URL);
		driving.manage().window().maximize();
	}
	
	
	
	
	
	
	
	
	

}
