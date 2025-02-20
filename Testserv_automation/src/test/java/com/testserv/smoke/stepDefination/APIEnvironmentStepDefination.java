package com.testserv.smoke.stepDefination;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.testserve.pages.APIEnvironmentPage;
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

public class APIEnvironmentStepDefination extends BaseTest {
	EventUtils eventUtils;
	LoginPage loginPage;
	HomePage homePage;
	CompanyPage comp;
	Project pro;
	APIEnvironmentPage API;
	SoftAssert softAssert;
	Utilities utilities;
	
	@Before("@APIEnvironment")
	
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
		softAssert = new SoftAssert();
		utilities = new Utilities();
	}
	
	@Given("Launch the browser login to the application")
	public void launch_the_browser_login_t0_the_application()throws Throwable{
	    createNode("Given", "users will launch the browser and enter the url");
	    String username=utilities.getCredentialsFromPropertyFile("SmokeCompanyadminUsername");
	    String Password=utilities.getCredentialsFromPropertyFile("SmokeCompanyadminPassword");
	   
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

 @And("Click on the API Environment button the ManageEnvironments page")
	public void click_on_the_API_Environment_button_the_ManageEnvironments_page() throws Throwable{
	    createNode("When","Users will see the drop down options");
	    if(eventUtils.waitUntilElementIsPresent(driver, API.APItestingbutton, 20)) {
	    	eventUtils.clickOnElement(driver, API.APItestingbutton, "API Testing", 20);
	    	logStatus("info", "drop down option will appears");
	    }
	    else {
	    logStatus("error", "option will not displayed");
	    
	    }
	    
	    if(eventUtils.waitUntilElementIsPresent(driver, API.APIEnvironmentbutton, 10)) {
	    	eventUtils.clickOnElement(driver, API.APIEnvironmentbutton, "API Environment", 10);
	     }
	    else {
	    	logStatus("error", "users are not able to click on API testing button");
	    }
	    
	    }
 @And("Click on the Add New Environment button index page is displayed")
	public void click_on_the_Add_New_Environment_button_index_page_is_displayed() {
	   createNode("Then","users lands on index page");
	   String ExpectedUrl="https://qa.testserv.ai/TestEnvironments/ManageEnvironments";
	   String actualURL=driver.getCurrentUrl();
		  eventUtils.waitUntilElementIsPresent(driver, API.Addnewenvironment, 10);
		   eventUtils.clickOnElement(driver, API.Addnewenvironment, "AddEnvironment", 10);
		   
		   if(ExpectedUrl.equals(actualURL)) {
			   logStatus("info", "users will lands on Manage enviornment page is displayed");
		   }
		   else
		   {
			   logStatus("error", "users will fails to lands on Manage enviornment page is displayed");
		   
		   }
		   }
	
	   
	@And("Enter all valid credentials into create environment screen")
	public void Enter_all_valid_credentials_into_create_environment_screen() throws Throwable{
		  createNode("And", "The all project will appears in the drop down");
		  String env1=utilities.getCredentialsFromPropertyFile("Environmnetname");
		  String post=utilities.getCredentialsFromPropertyFile("PostmanCollectionUrl");
		  
		  if(eventUtils.waitUntilElementIsPresent(driver, API.Selectprojectdropdown, 10)) {
			  eventUtils.clickOnElement(driver, API.Selectprojectdropdown, "Selectproject", 10);
			  eventUtils.waitUntilElementIsPresent(driver, API.MicrosoftProject, 10);
			  eventUtils.clickOnElement(driver, API.MicrosoftProject, "Projectname", 20);
			  eventUtils.waitUntilElementIsPresent(driver, API.Environmentname, 10);
			  eventUtils.enterValue(driver, API.Environmentname, env1, "Env Name", 10, test);
			  eventUtils.waitUntilElementIsPresent(driver, API.postmancollexctionurl, 10);
			  eventUtils.enterValue(driver, API.postmancollexctionurl, post, "Postmancollection", 10, test);
			  logStatus("info", "The fields accepted the values");
			  }
		  else
		  {
			  logStatus("error", "fields will not accept the values");
		  }
		  
	}			  


	@And("Click on the save button manage variable screen is displayed")
	public void click_on_the_save_button_manage_variable_screen_is_displayed()throws Throwable {
	   createNode("And", "User will click on the save button");
	   if(eventUtils.waitUntilElementIsPresent(driver, API.savebutton, 10)) {
		   eventUtils.clickOnElement(driver, API.savebutton, "Save", 10);
		   logStatus("info", "The Manage variable screen is displayed");
	   }
	   else {
		   logStatus("error", "The Manage variable screen should not be displayed");
	   }
	}

	@And("Click on pickfrom API and enter response")
	public void click_on_pickfrom_API_and_enter_repsonse()throws Throwable {
	   createNode("And", "click on pickfrom API drop down");
	   if(eventUtils.waitUntilElementIsPresent(driver, API.pickfromapi, 20)) {
		   
		   eventUtils.clickOnElement(driver, API.pickfromapi, "Pickapi", 20);
		   logStatus("info", "users click the pick from api");
	   }
	   else
	   {
		   logStatus("error", "users not able to click");
	   }
	   if(eventUtils.waitUntilElementIsPresent(driver, API.selctapi, 30)) {
			  eventUtils.clickOnElement(driver, API.selctapi, "Login", 30);
			  eventUtils.waitUntilElementIsPresent(driver, API.selectPickAPI, 20);
			  eventUtils.clickOnElement(driver, API.selectPickAPI, "Pick the API", 20, test);
			  eventUtils.waitUntilElementIsPresent(driver, API.login, 30);
			  eventUtils.clickOnElement(driver, API.login, "Login API", 30);
			  logStatus("info", "users will selct the login api");
		  }
		  else
		  {
			  logStatus("error", "users not abel to select the login api");
		  }
		  if(eventUtils.waitUntilElementIsPresent(driver, API.whatfiledfromresponse, 40)) {
			  String Response=utilities.getCredentialsFromPropertyFile("Whatfieldreposnse");
			  eventUtils.enterValue(driver, API.whatfiledfromresponse, Response, "Response", 40, test);
			  logStatus("info", "users will enter the key value from response");
		  }
		  else {
			  logStatus("error", "users failed to enter thekeyvalues");
		  }
	
	    if(eventUtils.waitUntilElementIsPresent(driver, API.managesave, 30)) {
	    	eventUtils.clickOnElement(driver, API.managesave, "Save", 30);
	    	logStatus("info", "once per request pop up is displayed");
	    }
	    else {
	    	logStatus("error", "users failed to click on save button");
	    }
	
	    if(eventUtils.waitUntilElementIsPresent(driver, API.Nobutton, 40)) {
	    	
	    	eventUtils.clickOnElement(driver, API.Nobutton, "No button", 40);
	    	//eventUtils.waitUntilElementIsPresent(driver, API.helathtext, 20);
	    	//String ExpectedText="Health Test API";
	    	//String Actualtext=driver.getTitle();
	    	//if(ExpectedText.equals(Actualtext)) {
	    	logStatus("info", "Helath Test API screen is displayed");
	    	
	    }
	    else {
	    	logStatus("error","users fails to and the heslth test api screen");
	    }
	    	if(eventUtils.waitUntilElementIsPresent(driver, API.startButton, 20)) {
	    		eventUtils.clickOnElement(driver, API.startButton, "Startbutton", 20);
	    		logStatus("info", "users see the pass,fail,not run API");
	    	}
	    	else {
	    		logStatus("error", "users fails to see the pass,fail,not run api");
	    	}
	}
		
	    
	
	@And("Click on save button data rule screen displayed")
	public void click_on_save_button_data_rule_screen_displayed() {
		
		String RelationName=utilities.getCredentialsFromPropertyFile("ResponseName");
		String save=utilities.generateRandomname();
		if(eventUtils.waitUntilElementIsPresent(driver, API.saveHealthTestAPI, 20)) {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			for(int i=0; i<2; i++) {
				js.executeScript("Window.scrollBy, (0,-500)");
			}
			eventUtils.clickOnElement(driver, API.saveHealthTestAPI, "SaveHealth", 20);
			eventUtils.waitUntilElementIsPresent(driver, API.NextButton, 30);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			for (int i = 0; i < 2; i++) {
			    js1.executeScript("window.scrollBy(0,500);");
			}

			eventUtils.clickOnElement(driver, API.NextButton, "Nextbutton", 30);
	
		eventUtils.waitUntilElementIsPresent(driver, API.ClickNode, 20);
			driver.switchTo().frame(1);
			
			eventUtils.clickOnElement(driver, API.ClickNode, "Login", 20);
			eventUtils.clickOnElement(driver, API.createprojectnode, "Project", 20);
			
			WebElement createProject = driver.findElement(By.xpath("//div[contains(text(),'CREATE PROJECT')]"));

	        // Perform drag and drop
	        Actions act = new Actions(driver);
	        act.clickAndHold(createProject)
	           .moveByOffset(100, 50) // Adjust offset as per your need
	           .release()
	           .perform();

	        System.out.println("Element dragged and dropped successfully!");
	        System.out.println("Element dragged and dropped successfully!");
	        eventUtils.waitUntilElementIsPresent(driver, API.Arrowmark, 20);
	        eventUtils.waitUntilElementIsPresent(driver, API.Arrowmark2, 20);

	        // Locate elements before performing drag and drop
	        WebElement arrowmark = driver.findElement(API.Arrowmark);
	        WebElement arrowmark2 = driver.findElement(API.Arrowmark2);

	        // Perform drag and drop
	        Actions act1 = new Actions(driver);
	        act1.dragAndDrop(arrowmark, arrowmark2).perform();
	        eventUtils.waitUntilElementIsPresent(driver, API.node, 20);
	        eventUtils.mouseHoverToElement(driver, API.node, 20, test);
	        eventUtils.clickOnElement(driver, API.node, "Nodeclick", 20);
	        
  eventUtils.waitUntilElementIsPresent(driver, API.responsebutton, 30);
  eventUtils.clickOnElement(driver, API.responsebutton, "button", 30);
  //eventUtils.waitUntilElementIsPresent(driver, API.Requestdropdown, 20);
  
  eventUtils.waitUntilElementIsPresent(driver, API.ResponseValue, 20);
  eventUtils.enterValue(driver, API.ResponseValue,RelationName,"UserValue",20, test);
  
  eventUtils.waitUntilElementIsPresent(driver, API.Requestdropdown, 20);
  eventUtils.clickOnElement(driver, API.Requestdropdown, "CreateBy", 20);
  
  
  eventUtils.waitUntilElementIsPresent(driver, API.SelectOptions, 20);
  eventUtils.clickOnElement(driver, API.SelectOptions, "CreateBy", 10, test);
  
  
  eventUtils.waitUntilElementIsPresent(driver, API.SaveIcon, 10);
  eventUtils.clickOnElement(driver, API.SaveIcon, "saveicon", 10);
  
  eventUtils.waitUntilElementIsPresent(driver, API.MasterSave, 20);
  eventUtils.clickOnElement(driver, API.MasterSave, "Button", 20);
  
  eventUtils.waitUntilElementIsPresent(driver, API.SaveRelationAPI, 20);
  eventUtils.enterValue(driver, API.SaveRelationAPI, save, "Graph", 20, test);
  
  eventUtils.waitUntilElementIsPresent(driver, API.SubmitRelation, 30);
  eventUtils.clickOnElement(driver, API.SubmitRelation, "Submit", 30);
		}
		else {
			logStatus("error", "The grapg saved sucssfully");
		}
	}
	@And("Click on back button the index page is displayed")
	public void click_on_back_button_the_index_page_is_displayed() {
	    createNode("Then", "User lands on the index page");

	    // Switch back to the main content in case an iframe was used
	    driver.switchTo().defaultContent();

	    // Wait for the page to refresh and the breadcrumb element to be present
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	        WebElement breadcrumb = wait.until(ExpectedConditions.elementToBeClickable(API.BreadCrumbAPI));
	        breadcrumb.click();
	        String ExpecetedURL="https://qa.testserv.ai/TestEnvironments/ManageEnvironments";
	        String CurrentURL=driver.getCurrentUrl();
	        if(ExpecetedURL.equals(CurrentURL)) {
	        logStatus("info", "User clicked on breadcrumbs successfully and lands on index page");
	       }
	        else
	        {
	        	logStatus("error", "Users fails to lands on index page");
	        }
}
	@Then("Click on ellipse the option is displayed and click genarte button")
	public void click_on_ellipse_the_option_is_displayed_and_click_genarte_button() { {
	    createNode("Then", "User generates the test cases successfully");
	    if(eventUtils.waitUntilElementIsPresent(driver, API.ellipse, 20)) {
	    	eventUtils.clickOnElement(driver, API.ellipse, "icon", 20);
	    	eventUtils.waitUntilElementIsPresent(driver, API.Genarte, 30);
	    		eventUtils.clickOnElement(driver, API.Genarte, "Genarte test data", 30);
	    		 
	    		eventUtils.waitUntilElementIsPresent(driver, API.button, 20);
	    		eventUtils.clickOnElement(driver, API.button, "Genarte button", 20);
	    		driver.navigate().refresh();

	    }
	    else
	    {
	    	logStatus("error", "User not genarted test data");
	    	softAssert.assertTrue(false, " Verify that user are able to click on the genarte test case button");
	    }
	    eventUtils.waitUntilElementIsPresent(driver, API.ellipse, 20);
	    eventUtils.clickOnElement(driver, API.ellipse, "Ellipse", 20);
	    eventUtils.waitUntilElementIsPresent(driver, API.Manage, 20);
	    eventUtils.clickOnElement(driver, API.Manage, "Manage", 20);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("document.querySelector(\"input[name='email']\").value='ab3456@ifocussystec.in';");


	    
	    }
	

	}

	
@After("@APIEnvironment")
public void teardown() {
		
	try {
				killBrowser();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}

	
	


	
	

