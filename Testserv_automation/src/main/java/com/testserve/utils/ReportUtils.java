package com.testserve.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.entity.ReportEntity;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mongodb.MongoClientURI;

import io.cucumber.java.Scenario;
import io.reactivex.rxjava3.core.Observer;

public class ReportUtils {

	public ExtentSparkReporter reporter;
	public static ExtentReports report;
	protected ExtentTest mainTest;
	public static ExtentTest test;
	public InetAddress systemAddress;
	public String suiteName;
	public String testName;
	public String Report_Name;
	private String report_folder;
	public static String className;
	public static String methodName;
	public static String testCaseName;
	public static String hour;
	public Status status;
	public ExtentKlovReporter klovReporter;
	public Observer<ReportEntity> reporterEntity;

	public static String screenShotFolderPath;
	public static String screenShotFilePath;

	public static String scenarioName;

	public void initializeReport(String suiteName) {

		Utilities utils = new Utilities();
		
		report_folder = Web_Constants.REPORT_PATH + Web_Constants.PROJECT + "_Reports" + "\\";
		

		utils.createFolder(report_folder);

		suiteName = suiteName.replace(".", "_").replace(":", "_");

		Report_Name = report_folder + suiteName + "#" + getTimeStamp() + ".html";
		reporter = new ExtentSparkReporter(Report_Name);
		reporter.config().setDocumentTitle("testServeReport");
		reporter.config().setReportName("testServe" + Web_Constants.PROJECT + "_" + Web_Constants.browser);

		report = new ExtentReports();
		
		reporter.config().setTheme(Theme.STANDARD);


		if (Web_Constants.KLOV_FLAG) {
			try {
				    String name="a1e2fc36-af35-49f0-afea-ee6168e1e479#"+suiteName;
					klovReporter = new ExtentKlovReporter(name);
					MongoClientURI mcURI = new MongoClientURI("mongodb://superuser:ifocus123@122.166.253.58:27017");
					klovReporter.initMongoDbConnection(mcURI);
					klovReporter.setProjectName(name);
					klovReporter.initKlovServerConnection("http://136.233.79.116:8077/");
                    report.attachReporter(reporter, klovReporter);
					createTest("Klov Server Connected for: " + Web_Constants.PROJECT);
					System.out.println("[INFO] KLOV Server is up");

			} catch (Exception e) {
				System.out.println("[INFO] KLOV Server is down");
				report = new ExtentReports();
				report.attachReporter(reporter);
			}
		} else {
			report.attachReporter(reporter);
		}
		
		
	
		Web_Constants.ExtentReportPath = Report_Name;

		try {
			systemAddress = Inet4Address.getLocalHost();
		} catch (UnknownHostException e) {
			test.log(Status.INFO, "Unable to get the local host");
		}

		report.setSystemInfo("IP Address", systemAddress.getHostAddress());
		report.setSystemInfo("Host Name", systemAddress.getHostName());
		report.setSystemInfo("UserName", System.getProperty("user.name"));
		report.setSystemInfo("Operating System", System.getProperty("os.name"));

		report.flush();

	}

	public void createTest(String name) {
			mainTest = report.createTest(name);
		
	}

	public void createNode(String stepName, String stepDefinitionName) {
		test = mainTest.createNode(stepName + " : " + stepDefinitionName);
		System.out.println("Executing the Step Definition   -   " + stepName + " : " + stepDefinitionName);
	}

	public String getDateStamp() {
		DateFormat dfor = new SimpleDateFormat("ddMMyyyy");
		Date obj = new Date();
		String date = dfor.format(obj);
		return date;
	}

	public String hourStamp() {
		Date d = new Date();
		String hour = String.valueOf(d.getHours());
		return hour;
	}

	// To get current time
	public String getTimeStamp() {
		Date d = new Date();
		return d.toString().replace(":", "_").replace(" ", "_");
	}

	public String getFeature(String featureFile) {
		int count = 0;
		for (int i = 0; i < featureFile.length() - 1; i++) {

			char ch = featureFile.charAt(featureFile.length() - (i + 1));

			String str = String.valueOf(ch);

			if (str.equals("/")) {
				break;
			}
			count++;
		}

		featureFile = featureFile.substring(featureFile.length() - count);

		return featureFile;
	}

	public String getScenario(Scenario scenario) {

		System.out.println("Fetching the Scenario Name");

		String name = getFeature(scenario.getUri().toString()) + " : " + scenario.getName();

		System.out.println(name);
		mainTest = report.createTest(name);

		return name;
	}
}
