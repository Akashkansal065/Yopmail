package com.masReport.Configuration;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

public class ExtentManager {
	private static ExtentReports instance;
	public static Date date = new Date();
	public static String filename="ExtentReport"+date.toString().replace(':','_').replace(' ','_')+".html";
	public static String reportPath= "./Reports/extent_reports/"+ (date.getMonth()+1) +"/"+date.getDate()+"/"+filename;


	public static synchronized ExtentReports getInstance() {
		if (instance == null) {
			//System.out.println(System.getProperty("user.dir"));
			//			instance = new ExtentReports("./Reports/TestReport.html");
			instance = new ExtentReports(reportPath,true,DisplayOrder.OLDEST_FIRST,NetworkMode.ONLINE);
			//			instance.loadConfig(new File(System.getProperty("user.dir")+"\\Enter the Config file name"));
		}

		return instance;
	}

	public static void flush(){

		//instance.flush();
		File source = new File(reportPath);
		File dest = new File("./Reports/");
		File[] fileToDelete = dest.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".html");
			}
		}); 

		for(File f:fileToDelete){
			f.delete();

		}


		try {
			
			FileUtils.copyFileToDirectory(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}