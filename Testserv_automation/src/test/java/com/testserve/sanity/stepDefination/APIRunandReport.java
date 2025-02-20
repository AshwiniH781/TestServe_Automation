package com.testserve.sanity.stepDefination;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.testserve.pages.APIEnvironmentPage;
import com.testserve.pages.APInewRunReportPage;
import com.testserve.pages.CompanyPage;
import com.testserve.pages.HomePage;
import com.testserve.pages.LoginPage;
import com.testserve.pages.Project;
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

public class APIRunandReport extends BaseTest
{
	EventUtils eventUtils;
	LoginPage loginPage;
	HomePage homePage;
	CompanyPage comp;
	Project pro;
	APIEnvironmentPage API;
	APInewRunReportPage Run;
	SoftAssert softAssert;
	Utilities utilities;
	
	@Before("@APINewRun")
	
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
		softAssert = new SoftAssert();
		utilities = new Utilities();
}
	 @Given("^Login to the application using companyadmin credentials$")
	 public void Login_to_the_application_using_companyadmin_credentials()throws Throwable {
		 createNode("Given", "user logged in succssfully");
		 String username=utilities.getCredentialsFromPropertyFile("CompanyadminUsername");
		    String Password=utilities.getCredentialsFromPropertyFile("CompanyadminPassword");
		   
		    if(eventUtils.waitUntilElementIsPresent(driver, loginPage.userName_field, 20)) {
		    	eventUtils.enterValue(driver, loginPage.userName_field, username, "Usernamefield", 20, test);
		    	logStatus("info","usersname field accept the username");
		    eventUtils.waitUntilElementIsPresent(driver, loginPage.password_field, 20);
		    	eventUtils.enterValue(driver, loginPage.password_field, Password, "Password", 20, test);
		    eventUtils.waitUntilElementIsPresent(driver, loginPage.loginButton, 20);
		    	eventUtils.clickOnElement(driver, loginPage.loginButton, "loginbutton", 20);
		    	logStatus("info", "lands on homepage");
		    }
		    else {
		    	logStatus("error", "users will not lands on homepage");
		    }
		    if(eventUtils.waitUntilElementIsPresent(driver,comp.logo, 10)) {
		    	eventUtils.mouseHoverToElement(driver, comp.logo, 10, test);
		    	logStatus("info", "Users perform the mouse over action");
		    }
		    else
		    {
		    	logStatus("error", "users not able to perform mouse over action");
		    }
		}
	 @When("^Click on API New Run button$")
	 public void click_on_API_New_Run_button()throws Throwable {
		 
		 createNode("When","Users will run API sucssfully");
			if(eventUtils.waitUntilElementIsPresent(driver, API.APItestingbutton, 10)) {
				eventUtils.clickOnElement(driver, API.APItestingbutton, "APIbutton", 10);
		   eventUtils.waitUntilElementIsPresent(driver, Run.Singlenev, 10);
			 
			 eventUtils.clickOnElement(driver, Run.Singlenev, Report_Name, 10);
			 eventUtils.waitUntilElementIsPresent(driver, Run.APInewRun, 10);
			 eventUtils.clickOnElement(driver, Run.APInewRun, "New Run", 10);
			String ExpecetdURl="https://qa.testserv.ai/Test/ApiRun";
			String ActualUrl=driver.getCurrentUrl();
			if(ExpecetdURl.equals(ActualUrl)) {
				logStatus("info", "Users lands on API run page");
			}
			else {
				logStatus("error", "users fails to lands on API run page");
			}
			 if(eventUtils.waitUntilElementIsPresent(driver, Run.APInewRunbutton, 10)) {
			 eventUtils.clickOnElement(driver, Run.APInewRunbutton, "Add API New Run", 10);
			 eventUtils.waitUntilElementIsPresent(driver, Run.LiveAPITest, 20);
			 eventUtils.clickOnElement(driver, Run.LiveAPITest, "Live API", 20);
			 String expectedUrl="https://qa.testserv.ai/Test/LiveApi";
			 String ActualUrl1=driver.getCurrentUrl();
			 if(expectedUrl.equals(ActualUrl1)) {
			 logStatus("info", "User lands on the api new run page");
		 }
		 else {
			 logStatus("error", "Users fails to lands on new run page");
		 }
	 }
	 }
}
	 @And("^Select the environment and project$")
	 public void Select_the_environment_and_project()throws Throwable {
		 createNode("And", "Users will run API scussfully");
		 
	
		
		 if(eventUtils.waitUntilElementIsPresent(driver, Run.SelectProject, 20)) {
		 eventUtils.clickOnElement(driver, Run.SelectProject, "Project filed", 20);
		 
		 eventUtils.waitUntilElementIsPresent(driver, Run.selectprojectoption, 10);
		 eventUtils.clickOnElement(driver, Run.selectprojectoption, "Project", 10);
		 eventUtils.waitUntilElementIsPresent(driver, Run.clickanywhere, 10);
		 eventUtils.clickOnElement(driver, Run.clickanywhere, "Clickanywhere", 10);

		 eventUtils.waitUntilElementIsPresent(driver, Run.SelectEnv, 10);
		 eventUtils.clickOnElement(driver, Run.SelectEnv, "env", 10);

		 eventUtils.clickOnElement(driver, Run.SelectEnv, "Env", 10);
		 
		 eventUtils.waitUntilElementIsPresent(driver, Run.SelectEnvOption, 10);
		 eventUtils.clickOnElement(driver, Run.SelectEnvOption, "Env option", 10);
		 
		 eventUtils.waitUntilElementIsPresent(driver, Run.Savebutton, 20);
		 eventUtils.clickOnElement(driver, Run.Savebutton, "Save", 20);
		 driver.navigate().refresh();
		String ExpectedUrl="https://qa.testserv.ai/Test/ApiRun";
		String ActualURl=driver.getCurrentUrl();
		//driver.navigate().refresh();
		if(ExpectedUrl.equals(ActualURl)) {
			logStatus("Info", "Users lands on api new run page sucssfully");
		}
		else {
			logStatus("Error", "Users lands on api new run page sucssfully");
			
		}
		  
			eventUtils.waitUntilElementIsPresent(driver, Run.dashboard, 10);
			eventUtils.clickOnElement(driver, Run.dashboard, "Dashboard", 10);
			JavascriptExecutor js = (JavascriptExecutor) driver;


	        // Scroll down by 500 pixels
	        for (int i = 0; i < 1; i++) {
	            js.executeScript("window.scrollBy(0,500)");
			}
			logStatus("info", "lands on dashboard and seeing the live stram chat");
			
		}
	 }
		
	@And("^Click on API Report button$")
	public void click_on_API_Report_button() throws Throwable {
	    createNode("And", "User is able to see the reports");
	    System.out.println("Inside click_on_API_Report_button()"); // Debug log

	    if (eventUtils.waitUntilElementIsPresent(driver, comp.logo, 30)) {
	        System.out.println("Logo is present, performing mouse hover...");
	        eventUtils.mouseHoverToElement(driver, comp.logo, 30, test);
	        logStatus("info", "Performed mouse over action");
	    } else {
	        
	        logStatus("error", "User fails to perform mouse over action");
	    }
	

		 eventUtils.waitUntilElementIsPresent(driver, API.APItestingbutton, 10);
		 eventUtils.clickOnElement(driver, API.APItestingbutton, "Drop down", 10);
		 
		 eventUtils.waitUntilElementIsPresent(driver, Run.Singlenev, 10);
		 eventUtils.clickOnElement(driver, Run.Singlenev, "Singlenev", 10);
		 
		 eventUtils.waitUntilElementIsPresent(driver, Run.APIReport, 10);
		 eventUtils.clickOnElement(driver, Run.APIReport, "Report", 10);
		 
String Exp="https://qa.testserv.ai/Report/ApiReport";
String Act=driver.getCurrentUrl();
if(Exp.equals(Act)) {
	logStatus("info", "Users lands on the API Report page");
}
else {
	logStatus("error", "Fails to lands on the API Report page");
}
	 }
	 
	 
	 @And("^Click on ellipse and  View testcases options$")
	 public void click_on_ellipse_and_View_testcases_options() throws Throwable{
	     createNode("And", "Users see the Reports");
	     String Expect="https://qa.testserv.ai/Report/AllApiRepor";
	     String Actual=driver.getCurrentUrl();
	     //driver.navigate().refresh();
	     if(eventUtils.waitUntilElementIsPresent(driver, Run.APIReportellipse, 30)) {
	    	 if(Expect.equals(Actual)) {
	     }
	    	 Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	    	            .withTimeout(Duration.ofSeconds(20))  // Max wait time
	    	            .pollingEvery(Duration.ofSeconds(1))  // Polling interval (every second)
	    	            .ignoring(NoSuchElementException.class);  // Ignore NoSuchElementException during polling

	    	    // Example of waiting for a specific dynamic element (page loading indication)
	    	    WebElement dynamicElement = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(API.ellipse));

	    	    // Wait until the document is fully loaded (optional)
	    	    fluentWait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

	    	    // Now click on the element after ensuring the page is loaded
	    	    dynamicElement.click();
	            // Click on the element once it's available
	            dynamicElement.click();
	            System.out.println("Element clicked successfully!");
	    	 eventUtils.clickOnElement(driver, Run.APIReportellipse, "Ellipse", 30);
	    	 eventUtils.waitUntilElementIsPresent(driver, Run.TestCase, 30);
	    	 eventUtils.clickOnElement(driver, Run.TestCase, "Tc", 30);
	    	 
	    	 eventUtils.waitUntilElementIsPresent(driver, Run.negativeTc, 30);
	    	 eventUtils.clickOnElement(driver, Run.negativeTc, "Negative Test Case", 30);
	    	 
	    	 eventUtils.waitUntilElementIsPresent(driver, Run.TCBack, 30);
	    	 eventUtils.clickOnElement(driver, Run.TCBack, "Back", 30);
	    	
	    	 
	    	 eventUtils.waitUntilElementIsPresent(driver, Run.APIReportellipse, 30);
		    	 eventUtils.clickOnElement(driver, Run.APIReportellipse, "Ellipse", 30);
		    	 
		    	 
		    	 eventUtils.waitUntilElementIsPresent(driver, Run.View, 30);
		    	 String expectedurl="https://qa.testserv.ai/SingleEnvApiTest/DetailedApiReport";
		    	 String Actualurl=driver.getCurrentUrl();
		    	 eventUtils.clickOnElement(driver, Run.View, "Run.View", 30);
		    	 if(expectedurl.equals(Actualurl)) {
		    		 logStatus("info", "users lannds on the Detailed Report page");
		    	 }
		    	 else {
		    		 logStatus("error", "users fails to lands on detailed report page");
		    	 }
		    	 eventUtils.waitUntilElementIsPresent(driver, Run.ViewReport, 30);
		    	 eventUtils.clickOnElement(driver, Run.ViewReport, "Fail API Report", 30);
		    	 
		    	 eventUtils.waitUntilElementIsPresent(driver, Run.Okay, 30);
		    	 eventUtils.clickOnElement(driver, Run.Okay, "Okay", 30);
		    	 
		    	 eventUtils.waitUntilElementIsPresent(driver, Run.DetailedBack, 30);
		    	 eventUtils.clickOnElement(driver, Run.DetailedBack, " Report Back", 30);
		    	 logStatus("info", "User see the test case and view report");
	     }
	     else {
	    	 logStatus("error", "users not able to see the reports");
	     }
	 }

	 @Then("^Click on edit option update the test cases fail to pass$")
	 public void click_on_edit_option_update_the_test_cases_fail_to_pass()throws Throwable {
	     createNode("Then", "Users update the test case from fail to pass");
	     eventUtils.waitUntilElementIsPresent(driver, Run.APIReportellipse, 60);
    	 eventUtils.clickOnElement(driver, Run.APIReportellipse, "Ellipse", 60);
    	 
    	eventUtils.waitUntilElementIsPresent(driver, Run.Edit, 20);
    	eventUtils.clickOnElement(driver, Run.Edit, "EDit Option", 20);
    	
    	eventUtils.waitUntilElementIsPresent(driver, Run.checkBox, 40);
    	eventUtils.clickOnElement(driver, Run.checkBox, "CheckBox", 40);
    	
    	eventUtils.waitUntilElementIsPresent(driver, Run.bulkupdate, 20);
    	eventUtils.clickOnElement(driver, Run.bulkupdate, "BulkUpdatebutton", 20);
    	
    	
    	eventUtils.waitUntilElementIsPresent(driver, Run.Actionstatus, 10);eventUtils.clickOnElement(driver, Run.Actionstatus, "Actionstatus", 20);

    	
        eventUtils.waitUntilElementIsPresent(driver, Run.CommentBox, 20);
    	String com=utilities.generateRandomname();
    	
    	eventUtils.enterValue(driver, Run.CommentBox, com, "Bug id 56", 20, test);
    	
    	eventUtils.waitUntilElementIsPresent(driver, Run.Updatebutton, 20);
    	eventUtils.clickOnElement(driver, Run.Updatebutton, "updateded", 20, test);
    	
    	eventUtils.waitUntilElementIsPresent(driver, Run.BackButton, 20);
    	eventUtils.clickOnElement(driver, Run.BackButton, "back", 20, test);
    	
    	eventUtils.waitUntilElementIsPresent(driver, Run.History, 30);
    	eventUtils.clickOnElement(driver, Run.History, "historyOption", 30);
    	
    	eventUtils.waitUntilElementIsPresent(driver, Run.History, 30);
    	eventUtils. clickOnElement(driver, Run.History, "Back", 30);
    
	 }
	 @After("APINewRun")
	 public void teardown() {
			
			try {
					killBrowser();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		 
	 }
		
	


