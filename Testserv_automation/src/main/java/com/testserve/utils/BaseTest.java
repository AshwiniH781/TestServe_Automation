package com.testserve.utils;

import java.io.IOException;

import java.net.URL;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.appium.java_client.android.options.UiAutomator2Options;


public class BaseTest extends ReportUtils {

	public RemoteWebDriver driver;

	public void launchApplication() {

		Utilities utilities = new Utilities();

		EventUtils eventUtils = new EventUtils();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("disable-infobars");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		try {
			if (Web_Constants.browser.equalsIgnoreCase("chrome")) {
				driver.navigate().to(Web_Constants.URL);
			} else {
				driver.get(Web_Constants.URL);
			}
		} catch (NullPointerException e) {

			driver.get(Web_Constants.URL);

		}
	}
		
	public void logStatus(String status, String Message) {

		switch (status.toLowerCase()) {
		case "info":
			System.out.println("[" + status.toUpperCase() + "]" + " : " + Message);
			test.info(MarkupHelper.createLabel(Message, ExtentColor.WHITE));
			break;
		case "warning":
			System.err.println("[" + status.toUpperCase() + "]" + " : " + Message);
			test.warning(MarkupHelper.createLabel(Message, ExtentColor.RED));
			break;
		case "error":
			System.err.println("[" + status.toUpperCase() + "]" + " : " + Message);
			test.warning(MarkupHelper.createLabel(Message, ExtentColor.RED));
			logScreenShot(Status.INFO, "");
			break;
		case "pass":
			System.out.println("[" + status.toUpperCase() + "]" + " : " + Message);
			test.pass(MarkupHelper.createLabel(Message, ExtentColor.GREEN));
			break;
		case "fail":
			System.err.println("[" + status.toUpperCase() + "]" + " : " + Message);
			test.fail(MarkupHelper.createLabel(Message, ExtentColor.RED));
			logScreenShot(Status.INFO, "");
			break;
		case "skip":
			test.skip(Message);
			break;
		default:
			test.warning(Message);
			break;
		}

		report.flush();

	}//

	// To Kill the crome browser
	public void killBrowser() throws IOException {
		if (driver != null) {
			if (Web_Constants.OS.equalsIgnoreCase("windows")) {
				try {
					driver.quit();
					logStatus("INFO", "Quit Browser Successfully");
				} catch (Exception e) {
				}
			}
		}
			
	}

	public void clearCookies() {
		((JavascriptExecutor) driver)
				.executeScript(" var cookies = document.cookie.split(';');								"
						+ " for (var i = 0; i < cookies.length; i++) {							"
						+ " var cookie = cookies[i];      										"
						+ " var eqPos = cookie.indexOf('=');  									"
						+ " var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;			"
						+ " document.cookie = name + '=;expires=Thu, 01 Jan 1970 00:00:00 GMT';	" + " };");
	}

	public void logScreenShot(Status status, String details) {

		Utilities utilities = new Utilities();

		if (Web_Constants.SCREENSHOT_TO_FOLDER) {
			try {
				test.log(status, details,
						MediaEntityBuilder
								.createScreenCaptureFromBase64String(
										utilities.captureScreenshot(driver, Web_Constants.SCREENSHOT_TO_FOLDER))
								.build());
			} catch (Exception e) {
				e.printStackTrace();
				test.log(Status.INFO, "Unable to take a screenshot");
			}
		} else if (!Web_Constants.SCREENSHOT_TO_FOLDER) {
			try {
				test.log(status, details,
						MediaEntityBuilder
								.createScreenCaptureFromBase64String(
										utilities.captureScreenshot(driver, Web_Constants.SCREENSHOT_TO_FOLDER))
								.build());
			} catch (Exception e) {
				e.printStackTrace();
				test.log(Status.INFO, "Unable to take a screenshot");
			}
		}
	}

	public void logScreenShot() {

		Utilities utilities = new Utilities();
		try {
			test.log(Status.INFO, "", MediaEntityBuilder
					.createScreenCaptureFromBase64String(utilities.captureScreenshot(driver, false)).build());
		} catch (IOException e) {

		}

	}

}