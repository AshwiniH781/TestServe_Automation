package com.testserv.smoke.stepDefination;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.testserve.pages.APIEnvironmentPage;
import com.testserve.pages.APInewRunReportPage;
import com.testserve.pages.CompanyPage;
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

public class FeedBackStep extends BaseTest {
	EventUtils eventUtils;
	LoginPage loginPage;
	HomePage homePage;
	CompanyPage comp;
	Project pro;
	APIEnvironmentPage API;
	UserPage Us;
	APInewRunReportPage Run;
	SoftAssert softAssert;
	Utilities utilities;
		
	FeedBackPage fee;
		
		
		@Before("@Feedback")
		
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
			softAssert = new SoftAssert();
			utilities = new Utilities();
	}
		@Given("^Launch the browser login to the company admin credentials$")
		public void launch_the_browser_login_to_the_company_admin_credentials() {
	createNode("Given", "User login to the application");
	String username=utilities.getCredentialsFromPropertyFile("SmokeCompanyadminUsername");
	String Password=utilities.getCredentialsFromPropertyFile("SmokeCompanyadminPassword");

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

			
		
	@When("^Click on feedback button$")
		public void click_on_feedback_button() {
			 createNode("When", "User land on the feedback page and see the all components");
			 eventUtils.waitUntilElementIsPresent(driver, fee.FeedBack, 20);
				 eventUtils.clickOnElement(driver, fee.FeedBack, "Feedback", 20);
				 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
				 wait.until(ExpectedConditions.urlToBe("https://qa.testserv.ai/Feedback/Index"));
				 String Actualurl=driver.getCurrentUrl();
				 if(Actualurl.equals("https://qa.testserv.ai/Feedback/Index")) {
					 logStatus("info", "Users lands on the feedback page");
				 }
				 else
				 {
					 logStatus("error", "Users fails to lands on feedback pages");
				 }
			 }
		
		@And("^Enter all the credentials$")
		public void enter_all_the_credentials() {
			createNode("And", "User enter all the credentials and all the fields are accepted");
			String Name=utilities.generateRandomUserName();
			String Role=utilities.generateRandomRole();
			String Comm=utilities.generateRandomDescription();
			if(eventUtils.waitUntilElementIsPresent(driver, fee.Ratings, 20)) {
				eventUtils.clickOnElement(driver, fee.Ratings, "Rating Button", 20);
				
				eventUtils.waitUntilElementIsPresent(driver, fee.Name, 20);
				eventUtils.enterValue(driver, fee.Name, Name, "Random Name", 20, test);
				
				eventUtils.waitUntilElementIsPresent(driver, fee.Role, 20);
				eventUtils.enterValue(driver, fee.Role, Role, "Random Role", 20, test);
				
				eventUtils.waitUntilElementIsPresent(driver, fee.Comments, 20);
				eventUtils.enterValue(driver, fee.Comments, Comm, "Comments", 20, test);
			}
		}
	@And("^Click on Sumbit button$")
	public void click_on_submit_button() {
		
		    createNode("Then", "the successful message is displayed");

		    if(eventUtils.waitUntilElementIsPresent(driver, fee.Submit, 20)) {
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        
		        WebElement submitButton = driver.findElement(fee.Submit);
		        
		     
		        for (int i = 0; i < 3; i++) {
		            js.executeScript("window.scrollBy(0, -500)");
		            try {
		                Thread.sleep(500); 
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        }

		       js.executeScript("arguments[0].scrollIntoView(true);", submitButton);

		       eventUtils.clickOnElement(driver, fee.Submit, "submit", 20);
		        logStatus("info", "lands on index page");
		    } else {
		        logStatus("error", "fails to land on index page");
		        return;
		    }

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		    wait.until(ExpectedConditions.urlToBe("https://qa.testserv.ai/Feedback/Index"));
		    String url = driver.getCurrentUrl();
		    if (url.equals("https://qa.testserv.ai/Feedback/Index")) {
		        logStatus("info", "User lands on index page successfully");
		    } else {
		        logStatus("error", "User fails to land on index page successfully");
		    }
		}

	@And("^Click on logout icon login with superadmin$")
	public void  click_on_logout_icon_login_with_superadmin() {
		createNode("And", "User login with the superadmin credentials");
	String user	=utilities.getCredentialsFromPropertyFile("SuperadminUserName");
	String pass	=utilities.getCredentialsFromPropertyFile("SuperadminPassword");
	eventUtils.waitUntilElementIsPresent(driver, fee.Dashboard,20);
	eventUtils.clickOnElement(driver, fee.Dashboard, "Dashboard", 20);
	if(eventUtils.waitUntilElementIsPresent(driver,comp.logo, 10)) {
		eventUtils.mouseHoverToElement(driver, comp.logo, 10, test);
		logStatus("info", "users performed mouse over action");
	}
		else {
			logStatus("error", "users failed to perform mouse over action");
		}
		
		if(eventUtils.waitUntilElementIsPresent(driver, fee.Logout, 10)) {
		eventUtils.clickOnElement(driver, fee.Logout, "Logout", 10);
		logStatus("info", "users clicked the logout icon and lands on login page");
		}
		else
		{
			logStatus("error", "users not able to click on logout icon");
		}
		if(eventUtils.waitUntilElementIsPresent(driver, loginPage.userName_field, 20)) {
			eventUtils.enterValue(driver, loginPage.userName_field, user, "Superadmin", 20, test);
			eventUtils.waitUntilElementIsPresent(driver, loginPage.password_field, 20);
			eventUtils.enterValue(driver, loginPage.password_field,  pass, "Testing@1234", 20,test);
			eventUtils.waitUntilElementIsPresent(driver, loginPage.loginButton, 20);
			eventUtils.clickOnElement(driver, loginPage.loginButton, "Button", 20);
			logStatus("info", "user lands on superadmin dashboard page");
		}
		else
		{
			logStatus("error", "users fails to lands on super admin dashboard page");
		}
	}

	@And("^Click on feedback button and download the feedbacks$")
	public void click_on_feedback_button_and_download_the_feedbacks() {
		createNode("And", "users lannds on superadmin feedback page");

		if(eventUtils.waitUntilElementIsPresent(driver, comp.logo, 20)) {
		eventUtils.mouseHoverToElement(driver, comp.logo, 20, test);
		 
		eventUtils.waitUntilElementIsPresent(driver, fee.FeedBack, 20);
		eventUtils.clickOnElement(driver, fee.FeedBack, "SuperadminFeedback", 20);
		eventUtils.waitUntilElementIsPresent(driver, fee.Download, 20);
		eventUtils.clickOnElement(driver, fee.Download, "Download", 20, test);
		logStatus("info", "Users download the feedback succssfully");
	}
	else
	{
		logStatus("error", "Users fails to download the feedback succssfully");

		
	}
	}
	@Then("^Click on sort the ratings$")
	public void click_on_sort_the_ratings() {
		createNode("And", "users sort the rating and publish the feedback");
		if(eventUtils.waitUntilElementIsPresent(driver, fee.SortBy, 20)) {
			eventUtils.clickOnElement(driver, fee.SortBy, "Sort the feedbacks", 20);
			
			eventUtils.waitUntilElementIsPresent(driver, fee.HighttoLow, 20);
			eventUtils.clickOnElement(driver, fee.HighttoLow, "High to low", 20);
			
			eventUtils.waitUntilElementIsPresent(driver, fee.Toggle, 20);
			eventUtils.clickOnElement(driver, fee.Toggle, "Toggle", 20);
			
			logStatus("info", "User will download the feedacks and published the feedbacks");
			}
		else
		{
			logStatus("error", "Users fail to download and publish ed the feedbacks");
		}
	}
	@After("@Feedback")
	public void teardown() {
		
		try {
				killBrowser();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	}
		


	
	

