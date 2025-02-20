package com.testserve.utils;

import java.net.InetAddress;
import java.util.Date;

import org.testng.Assert;

public class Web_Constants {
	


	public static String URL = "https://qa.testserv.ai/";
	public static String ENV = "QA";
	
	
	
	static boolean KLOV_FLAG=false;

	static String  webBuildVersion="1.50.59";

	public static String USERTYPE = "nonPremium";

	/** WEB Configured Browsers and Platforms **/
	public static String PROJECT = "WEB", OS = "Windows", PLATFORM_NAME = "Desktop", browser = "chrome";
//	public static String PROJECT= "WEB", OS = "Windows", PLATFORM_NAME = "Desktop", browser = "firefox";

	public static final int INNVOCATION_COUNT = 1;

	public static final int SYSTEM_PORT = 8298;
	
	/** ScreenShot and Report Paths **/
	public final static String REPORT_PATH = "Spark.html";
	public final static String SCREENSHOT_PATH = "C:\\Users\\iFocus\\OneDrive\\Desktop";
	public final static String REPORT_PATH_MAC = "/Users/"+System.getProperty("user.name")+"FailTestcaseReports";
	public final static String SCREENSHOT_PATH_MAC = "/Users/"+System.getProperty("user.name")+"iFocus\\FailTestcaseReports";
	public final static String CucumberReportPath = "Reports/cucumberHtmlReport";
	public static final String HUB_URL = "http://localhost:4723/wd/hub";
	
//	public static final String REPORT_EMAIL_SUBJECT = "[Automation] meWatch Reports";
	
	public static String ExtentReportPath="";

//	public static final boolean SCREENSHOT_TO_FOLDER = true;
	public static final boolean SCREENSHOT_TO_FOLDER = false;

	// Windows
	public static String NODEJS_PATH = "C:\\Program Files\\nodejs\\node.exe";
	
	public void Web_ConstantsConfiguration(String OS,String browser,String project,String Environment , String platformName ) {
		
		if (project!=null) {
			this.PROJECT=project;
		}
		if (OS!=null) {
			this.OS=OS;
		}
		if (Environment!=null) {
			this.ENV=Environment;
		}
		 
		if (platformName!=null) {
			this.PLATFORM_NAME=platformName;
		}
		 

		if (OS.equalsIgnoreCase("windows")) {
			if (PROJECT.equalsIgnoreCase("web")) {
				Web_Constants.OS = "Windows";
				switch (browser.toLowerCase()) {
				case "chrome":
					Web_Constants.browser = "Chrome";
					break;
				case "firefox":
					Web_Constants.browser = "Firefox";
					break;
				case "edge":
					Web_Constants.browser = "edge";
					break;
				default:
					Assert.assertTrue(false, "Selected Browser not Applicable:-" + browser);
					break;
				}
			}

		} 
		
		switch (ENV.toLowerCase()) {
		case "prod":{
			URL="https://qa.testserv.ai/";
			break;
		}

		default:
			break;
		}
		
		System.out.println("[INFO] Project - "+project);
		
		System.out.println("[INFO] OS - "+OS);
		
		System.out.println("[INFO] Environment - "+Environment);

		System.out.println("[INFO] Browser - "+browser);
		
		System.out.println("[INFO] URL - "+URL);
	}
	
	// To get current time
		public static String getTimeStamp() {
			Date d = new Date();
			return d.toString().replace(":", "_").replace(" ", "_");
		}

}
