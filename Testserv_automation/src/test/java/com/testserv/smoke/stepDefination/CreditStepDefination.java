package com.testserv.smoke.stepDefination;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.testserve.pages.APIEnvironmentPage;
import com.testserve.pages.APInewRunReportPage;
import com.testserve.pages.CompanyPage;
import com.testserve.pages.CreditPage;
import com.testserve.pages.FeedBackPage;
import com.testserve.pages.HomePage;
import com.testserve.pages.LoginPage;
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

public class CreditStepDefination extends BaseTest   {

	EventUtils eventUtils;
	LoginPage loginPage;
	HomePage homePage;
	CompanyPage comp;
	Project pro;
	APIEnvironmentPage API;
	UserPage Us;
	APInewRunReportPage Run;
	CreditPage cr;
	SoftAssert softAssert;
	Utilities utilities;
		
	FeedBackPage fee;
		
		
		@Before("@Credit")
		
		public void setUp(Scenario scenario) {
			String scenarioName = getScenario(scenario);
			createTest(scenarioName);
			System.out.println("Launching the Application");
			launchApplication();

			loginPage = new LoginPage(driver);
			eventUtils = new EventUtils();
			homePage = new HomePage(driver);
			comp=new CompanyPage(driver);
		    fee=new FeedBackPage(driver);
		    cr=new CreditPage(driver);
			softAssert = new SoftAssert();
			utilities = new Utilities();
	}
		
@Given("^Launch the application login to the super admin$")
public void launch_the_application_login_to_the_super_admin()throws Throwable {
	
createNode("Given", "User login to the application");
String username=utilities.getCredentialsFromPropertyFile("SuperadminUserName");
String Password=utilities.getCredentialsFromPropertyFile("SuperadminPassword");

if(eventUtils.waitUntilElementIsPresent(driver, loginPage.userName_field, 20)) {
	eventUtils.enterValue(driver, loginPage.userName_field, username, "Usernamefield", 20, test);
	logStatus("info", Password);
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

	
@When("^Click on credit button$")
public void click_on_credit_button() throws Throwable{
	createNode("When", "User lands on the credit page");
	eventUtils.waitUntilElementIsPresent(driver, cr.CreditButton, 20);
	eventUtils.clickOnElement(driver, cr.CreditButton, "Button", 20);
	String ExpectedUrl="https://qa.testserv.ai/packages/Index";
	String ActualUrl=driver.getCurrentUrl();
	if(ActualUrl.equals(ExpectedUrl)) {
		logStatus("info", "Users lands on the index page");
	}
	else
	{
		logStatus("error", "Users fails to lands on the index page");
	}
	
}
@And("^Click on edit icon update the Credit$") 
	public void click_on_edit_icon_update_the_profile()throws Throwable {
	
	createNode("And", "User update the edit succssfully");
	String Credit=utilities.generateRandomCreditName();
	String API=utilities.generateNo();
	String Dashboard=utilities.generateNo();
	String User=utilities.generateNo();
	
	
	eventUtils.waitUntilElementIsPresent(driver, cr.EditIcon, 30);
	eventUtils.clickOnElement(driver, cr.EditIcon, "Edit", 30);
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.urlContains("https://qa.testserv.ai/Packages/Edit"));
	String Ac=driver.getCurrentUrl();
	if(Ac.startsWith("https://qa.testserv.ai/Packages/Edit")) {
		logStatus("info", "users lands on the edit pages");
	}
	else {
		logStatus("error", "users fails to lands on the edit pages");
	}
	
	eventUtils.waitUntilElementIsPresent(driver, cr.CreditName, 20);
	eventUtils.enterValue(driver, cr.CreditName, Credit, "RandomName", 20, test);

	eventUtils.waitUntilElementIsPresent(driver, cr.liccensedAPI, 20);
	eventUtils.enterValue(driver, cr.liccensedAPI, API, "API NEW RUN", 20, test);
	
	eventUtils.waitUntilElementIsPresent(driver, cr.DasboardUsage, 20);
	eventUtils.enterValue(driver, cr.DasboardUsage, Dashboard, "Dashboard", 20, test);
	
	eventUtils.waitUntilElementIsPresent(driver, cr.LicensedUser, 20);
	eventUtils.enterValue(driver, cr.LicensedUser,User , "User", 20, test);
	
	eventUtils.waitUntilElementIsPresent(driver, cr.Update, 30);
	eventUtils.clickOnElement(driver, cr.Update, "Update", 30);
	logStatus("info", "The sucssfull toast message is displayed and it is navigates to the oindex page");
	
	
	
	}
@Then("^Click on view icon see the details about the credit$")
public void click_on_view_icon_see_the_details_about_the_credit() {
	createNode("Then", "Users are able to see the details about the credit");
	if(eventUtils.waitUntilElementIsPresent(driver, cr.ViewIcon, 30)) {
		eventUtils.clickOnElement(driver, cr.ViewIcon, "ViewIcon", 30);
		
		eventUtils.waitUntilElementIsPresent(driver, cr.Close, 20);
		eventUtils.clickOnElement(driver, cr.Close, "Close", 20);
	}
}
@After("@Credit")
public void teardown() {
	
	try {
			killBrowser();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
}
	
}
