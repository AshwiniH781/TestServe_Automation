package com.testserv.smoke.stepDefination;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.testserve.pages.APIEnvironmentPage;
import com.testserve.pages.APInewRunReportPage;
import com.testserve.pages.CompanyPage;
import com.testserve.pages.ForgotPasswordandReportPages;
import com.testserve.pages.HomePage;
import com.testserve.pages.LoginPage;
import com.testserve.pages.ModulePage;
import com.testserve.pages.ProfilePage;
import com.testserve.pages.Project;
import com.testserve.pages.UserPage;
import com.testserve.utils.BaseTest;
import com.testserve.utils.EventUtils;
import com.testserve.utils.Utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordReportStepDefination extends BaseTest
{
	EventUtils eventUtils;
	LoginPage loginPage;
	HomePage homePage;
	CompanyPage comp;
	Project pro;
	APIEnvironmentPage API;
	UserPage Us;
	APInewRunReportPage Run;
	ProfilePage Prof;
	ForgotPasswordandReportPages FR;
	 ModulePage module;
	SoftAssert softAssert;
	Utilities utilities;
	
@Before("@ForgotPasswordReports")
	
	public void setUp(Scenario scenario) {
		String scenarioName = getScenario(scenario);
		createTest(scenarioName);
		System.out.println("Launching the Application");
		launchApplication();

		loginPage = new LoginPage(driver);
		eventUtils = new EventUtils();
		homePage = new HomePage(driver);
		comp=new CompanyPage(driver);
		pro=new Project(driver);
		API=new APIEnvironmentPage(driver);
		Run=new APInewRunReportPage(driver);
		 Us=new UserPage(driver);
	   module=new ModulePage(driver);
		 Prof=new ProfilePage(driver);
		 FR=new ForgotPasswordandReportPages(driver);
		softAssert = new SoftAssert();
		utilities = new Utilities();
}
	
	@Given("^Launch the browser enter test url login page displayed$")
	public void launch_the_browser_enter_test_url_login_page_displayed() throws Throwable{
	    createNode("Given", "Users lands on the login page");
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.urlToBe("https://qa.testserv.ai/"));
	    String Actual=driver.getCurrentUrl();
	    if(Actual.equals("https://qa.testserv.ai/")) {
	    	logStatus("info", "User lands on the login page");
	    }
	    else
	    {
	    	logStatus("error", "Users fails to lands on the login page");
	    }
	}

	@When("^Click on forgot password link$")
	public void click_on_forgot_password_link() throws Throwable{
	    createNode("When", "User lands on the forgot password page");
	    eventUtils.waitUntilElementIsPresent(driver, FR.ForgotPassword, 20);
	    eventUtils.clickOnElement(driver, FR.ForgotPassword, "ForgotpasswordLink", 20);
	    String Exp="https://qa.testserv.ai/Account/ForgotPassword";
	    String URL=driver.getCurrentUrl();
	    if(Exp.equals(URL)) {
	    	logStatus("info", "users lands on the forgot password page");
	    }
	    else {
	    	logStatus("error","users fails to lands on the forgot password page");
	    }
	}

	@And("^Enter Username or Email and click on Resend reset link sucssfull toast message displayed$")
	public void enter_Username_or_Email_and_click_on_Resend_reset_link_sucssfull_toast_message_displayed() {
	    createNode("Then", "The succssfull toast message is displayed");
	 String  Username =utilities.getCredentialsFromPropertyFile("SuperadminUserName");
	    if(eventUtils.waitUntilElementIsPresent(driver, FR.Filed, 20)) {
	    	eventUtils.enterValue(driver, FR.Filed, Username, "Superadmin", 20, test);
	    	
	    	eventUtils.waitUntilElementIsPresent(driver, FR.Resend, 20);
	    	eventUtils.clickOnElement(driver, FR.Resend, "ResendLink", 20);
	    	
	    	
	    	eventUtils.waitUntilElementIsPresent(driver, FR.BackLogin, 20);
	    	eventUtils.clickOnElement(driver, FR.BackLogin, "Backtologin", 20);
	    	
	    	logStatus("info", "The sucssfull toast message is displayed and it is navigates to the login page");
	    }
	    else
	    {
	    	logStatus("error", "The Error toast message is displayed and fails to navigates to the login page");
	    	
	    }
	}
	@And("^Launch the browser login to the application homepage is displayed$")
	public void launch_the_browser_login_to_the_application_homepage_is_displayed() {
		createNode("Given", "users will launch the browser and enter the url");
	    String username=utilities.getCredentialsFromPropertyFile("SuperadminUserName");
	    String Password=utilities.getCredentialsFromPropertyFile("SuperadminPassword");
	   
	    if(eventUtils.waitUntilElementIsPresent(driver, loginPage.userName_field, 20)) {
	    	eventUtils.enterValue(driver, loginPage.userName_field, username, "Usernamefield", 20, test);
	    	logStatus("info","usersname field accept the username");
	    eventUtils.waitUntilElementIsPresent(driver, loginPage.password_field, 20);
	    	eventUtils.enterValue(driver, loginPage.password_field, Password, "Password", 20, test);
	    eventUtils.waitUntilElementIsPresent(driver, loginPage.loginButton, 20);
	    	eventUtils.clickOnElement(driver, loginPage.loginButton, "loginbutton", 20);
	    	if(eventUtils.waitUntilElementIsPresent(driver,comp.logo, 20)) {
		    	eventUtils.mouseHoverToElement(driver, comp.logo, 20, test);
	    	logStatus("info", "lands on homepage");
	    }
	    else {
	    	logStatus("error", "users will not lands on homepage");
	    }
	}
	}
		
	
	@And("^Click on the Reports dropdown all the options displayed$")
	public void click_on_the_Reports_dropdown_all_the_options_displayed() {
	    createNode("When", "users see the reports");
	    if(eventUtils.waitUntilElementIsPresent(driver, FR.Reports, 20)) {
	    	eventUtils.clickOnElement(driver, FR.Reports, "Reports", 20);
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("window.scrollBy(0,-500);");

	    	logStatus("info", "Th Reports options are displayed");
	    }
	    else {
	    	logStatus("error", "Report options not displayed");
	    }
	}

	@And("^Click on the Login Activity button the page is displayed$")
	public void click_on_the_Login_Activity_button_the_page_is_displayed() {
		createNode("And", "users lands on the  Login Activity page");
	    eventUtils.waitUntilElementIsPresent(driver, FR.LoginActivity, 20);
	    	eventUtils.clickOnElement(driver, FR.LoginActivity, "Reports", 20);
	    	String exp="https://qa.testserv.ai/User/LoginActivity";
	    	String A=driver.getCurrentUrl();
	    		if(A.equals(exp)) {
	    	logStatus("info", "The LoginActivity page displayed");
	    }
	    else {
	    	logStatus("error", "The LoginActivity page not displayed");
	    }
	}
	

	@Then("^Click on the Trace User Activity button the page is displayed$")
	public void click_on_the_Trace_User_Activity_button_the_page_is_displayed() {
		createNode("And", "users lands on the  Login Activity page");
		eventUtils.mouseHoverToElement(driver, comp.logo, 20, test);
	    eventUtils.waitUntilElementIsPresent(driver, FR.TrcaeserActivity, 20);
	    	eventUtils.clickOnElement(driver, FR.TrcaeserActivity, "Reports", 20);
	    	String exp="https://qa.testserv.ai/%20User/TraceUserActivity";
	    	String A=driver.getCurrentUrl();
	    		if(A.equals(exp)) {
	    	logStatus("info", "The TraceUserActivity page displayed");
	    }
	    else {
	    	logStatus("error", "The TraceUserActivity page not displayed");
	    }
	}
	
	@After("@ForgotPasswordReports")
	public void teardown() {
		
		try {
				killBrowser();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	}





