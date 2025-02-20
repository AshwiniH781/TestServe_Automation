package com.testserv.smoke.stepDefination;

import java.io.IOException;

import org.testng.asserts.SoftAssert;

import com.testserv.smoke.pages.LoginPages;
import com.testserve.pages.HomePage;
import com.testserve.pages.LoginPage;
import com.testserve.utils.BaseTest;
import com.testserve.utils.EventUtils;
import com.testserve.utils.Utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSmoke extends BaseTest

{

	EventUtils eventUtils;
	LoginPages loginPage;
	HomePage homePage;
	SoftAssert softAssert;
	Utilities utilities;
	
	int err_TS_001 = 0;


	@Before("@Login")
	
	public void setUp(Scenario scenario) {
		String scenarioName = getScenario(scenario);
		createTest(scenarioName);
		System.out.println("Launching the Application");
		launchApplication();

		 loginPage = new LoginPages(driver);
		eventUtils = new EventUtils();
		homePage = new HomePage(driver);
		softAssert = new SoftAssert();
		utilities = new Utilities();
	

	}	
	@Given("Launch the browser enter test url login page is displayed")
	public void launch_the_browser_enter_test_url_login_page_is_displayed() throws Throwable
{
	createNode("Given","Launch the browser enter test url");

	if (eventUtils.waitUntilElementIsPresent(driver, loginPage.loginPage, 20)) {
		logStatus("info","User is able to lands on loginpage");
	} else {
		logStatus("error","User not able to lands on loginpage");
	}

}
	@When("enter username and password")
	public void enter_username_and_password() throws Throwable
{
	createNode("When","enter username and password");

	String userName = utilities.getCredentialsFromPropertyFile("SuperadminUserName");
	String password = utilities.getCredentialsFromPropertyFile("SuperadminPassword");
	System.out.println(userName);
	if (eventUtils.waitUntilElementIsPresent(driver, loginPage.userName_field, 30)) {
		eventUtils.enterValue(driver, loginPage.userName_field, userName, "Username field", 30, test);
		logStatus("info","User is able to enter the Username in Username field");
	} else {
		logStatus("error","User not able to enter the Username in Username field");
		err_TS_001++;
	}
	if (eventUtils.waitUntilElementIsPresent(driver, loginPage.password_field, 30)) {
		eventUtils.enterValue(driver, loginPage.password_field, password, "Password field", 30, test);
		logStatus("info","User is able to enter the Password in password field");
	} else {
		logStatus("error","User not able to enter the Password in password field");
		err_TS_001++;
	}
	
	if(err_TS_001==0) {
		logStatus("info", "The valid mail/username and valid password should accept");
		logStatus("pass", "TS_001 Verify that users are abe to login with valid credentials.");
	} else {
		logStatus("error", "The valid mail/username and valid password should accept");
		logStatus("fail", "TS_001 Verify that users are abe to login with valid credentials.");
		softAssert.assertTrue(false, "TS_001 Verify that users are abe to login with valid credentials.");
	}

}


	@Then("click on login button home page is displayed")
	public void click_on_login_button_home_page_is_displayed()  throws Throwable {
    createNode("Then", "User is navigated to the home page");

    eventUtils.waitUntilElememtIsClickable(driver, loginPage.loginButton, 20);
    eventUtils.clickOnElement(driver, loginPage.loginButton, "loginButton", 20, test);


    eventUtils.waitUntilElementIsPresent(driver, homePage.homePage, 20);


    String expectedUrl = "https://qa.testserv.ai/Home/dashboard";
    String actualUrl = driver.getCurrentUrl();
    if (actualUrl.equals(expectedUrl)) {
        logStatus("info", "The \"Dashboard\" page should be displayed.");
    } else {
        logStatus("error", "The \"Dashboard\" page is not displayed.");
        softAssert.assertTrue(false, "TS_001 Verify that users are able to land on the \"Home\" page.");
    }
}


@After("@Login")
public void tearDown() {
	
	try {
		killBrowser();
	} catch (IOException e) {
		e.printStackTrace();
	}
}		
}




