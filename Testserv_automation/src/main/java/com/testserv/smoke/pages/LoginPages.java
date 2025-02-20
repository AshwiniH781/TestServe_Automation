package com.testserv.smoke.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.testserve.pages.BasePage;
import com.testserve.utils.EventUtils;
import com.testserve.utils.RepositoryUtils;
import com.testserve.utils.Utilities;

public class LoginPages {
	RemoteWebDriver driver;
	String page = "LoginPages";

	public LoginPages(RemoteWebDriver driver) {
		this.driver = driver;
		// page = "LoginPage";
	}

	EventUtils eventUtils = new EventUtils();
	RepositoryUtils repo = new RepositoryUtils(page);

	public By loginPage =repo.getBy("loginpage");
	
	public By userName_field = repo.getBy("userName_field");
	public By password_field = repo.getBy("password_field");
	
	public By loginButton = repo.getBy("loginButton");
	
	public By error_message = repo.getBy("error_message");
	
	
	
	
	
				
	
	public void loginToTheApplication(String email, String password, ExtentTest test) {
	
		Utilities utilities = new Utilities();
		BasePage basePage = new BasePage(driver, test);
		String userName = utilities.getCredentialsFromPropertyFile("SuperadminUserName");
		String Password = utilities.getCredentialsFromPropertyFile("SuperadminPassword");

		if (eventUtils.waitUntilElementIsVisible(driver, loginPage, 3)) {
			eventUtils.enterValue(driver,userName_field, userName, "Username field", 20, test);
			eventUtils.enterValue(driver,password_field, Password, "Password field", 20, test);
			eventUtils.sleep(5);
			eventUtils.clickOnElement(driver, loginButton, "login button", 20, test);
			basePage.logStatus("info", "User  able to logged in with valid credentials");
		} else {
			basePage.logStatus("error", "User unable to logged in with valid credentials");
		}

	}
	
	
}


