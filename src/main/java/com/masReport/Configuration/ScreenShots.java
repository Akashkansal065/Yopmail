package com.masReport.Configuration;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {

	public static String ShotCaptured(WebDriver driver,String image) throws IOException
	{
		//TakesScreenshot ts=(TakesScreenshot) driver;
		File captureScreenShot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imageName=image+".png";
		File destination=new File("./Reports/",imageName);
		FileUtils.copyFile(captureScreenShot, destination);
		
		return imageName;
	}
}
