package com.masReport.TestObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.masReport.Configuration.Base;

public class SampleTestPageObject extends Base{

	public String data = driving.getCurrentUrl();
	
	public WebElement userName = driving.findElement(By.id("userName"));

	public WebElement userMobile = driving.findElement(By.id("userMobile"));

//	public WebElement otpValue1 = driving.findElement(By.id("otpValue1"));
	
	
}