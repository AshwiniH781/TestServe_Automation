package com.testserv.smoke.stepDefination;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.testserv.smoke.pages.UserSmokePage;
import com.testserve.pages.APIEnvironmentPage;
import com.testserve.pages.APInewRunReportPage;
import com.testserve.pages.CompanyPage;
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

public class UserStep extends BaseTest
{
	EventUtils eventUtils;
	LoginPage loginPage;
	HomePage homePage;
	CompanyPage comp;
	Project pro;
	APIEnvironmentPage API;
	UserSmokePage Us;
	APInewRunReportPage Run;
	SoftAssert softAssert;
	Utilities utilities;
	
	@Before("@User")
	
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
		Us=new UserSmokePage(driver);
		softAssert = new SoftAssert();
		utilities = new Utilities();
}
	@Given("^Launch the application login by using the company credentials$")
	public void  launch_the_application_login_by_using_the_company_credentials() {
		
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
	    	if(eventUtils.waitUntilElementIsPresent(driver,comp.logo, 20)) {
		    	eventUtils.mouseHoverToElement(driver, comp.logo, 20, test);
	    	logStatus("info", "lands on homepage");
	    }
	    else {
	    	logStatus("error", "users will not lands on homepage");
	    }
	}
	}
	    
	

	@When("^Click on user button$")
	public void click_on_user_button() {
		createNode("When", "users lands on manage user page");
		
	    	if(eventUtils.waitUntilElementIsPresent(driver, Us.Userbutton, 20)) {
	    	eventUtils.clickOnElement(driver, Us.Userbutton, "User", 20);
	    	
	    	String Ex="https://qa.testserv.ai/User/ManageUsers";
	    	String Ac=driver.getCurrentUrl();
	    	if(Ex.equals(Ac)) {
	  
	    	logStatus("info", "Users lands on manage user page");
	    }
	    else
	    {
	    	logStatus("error", "Users fails to lands on manage user page");
	    }
	}
	}
	

	@And("^Click on create new user button enter all credentials$")
	public void click_on_create_new_user_button_enter_all_credentials() {
	    createNode("And", "User created new  users sucssfully");
	    String Username=utilities.generateRandomUserName();
	    String Email=utilities.generateEmailid();
	    String Password=utilities.generateRandomPassword();
	    
	    if(eventUtils.waitUntilElementIsPresent(driver, Us.CreateNewUser, 30)) {
	    	eventUtils.clickOnElement(driver, Us.CreateNewUser, "Create", 30);
	    	String Expect="https://qa.testserv.ai/User/UserEnroller";
		    String Actual=driver.getCurrentUrl();
	    	if(Actual.equals(Expect)) {
	    		logStatus("info", "users lands on the createnewuser page");
	    	}
	    	else
	    	{
	    		logStatus("error", "users fails to lands on creat new user page");
	    	}
	    	eventUtils.waitUntilElementIsPresent(driver, Us.UserName, 30);
	    	eventUtils.enterValue(driver, Us.UserName,Username , "User", 30, test);
	    	
	    	eventUtils.waitUntilElementIsPresent(driver, Us.Email, 30);
	    	eventUtils.enterValue(driver, Us.Email,Email , "Email", 30, test);
	    	
	    	eventUtils.waitUntilElementIsPresent(driver, Us.Password, 30);
	    	eventUtils.enterValue(driver, Us.Password,Password , "Password", 30, test);
	    	
	    	eventUtils.waitUntilElememtIsClickable(driver, Us.SelectRole, 30);
	    	eventUtils.clickOnElement(driver, Us.SelectRole, "Click field", 30);
	    	
	    	eventUtils.waitUntilElememtIsClickable(driver, Us.SelectOption, 30);
	    	eventUtils.clickOnElement(driver, Us.SelectOption, "User", 30);
	    	
	    	eventUtils.waitUntilElememtIsClickable(driver, Us.Profiledp, 30);
	    	eventUtils.clickOnElement(driver, Us.Profiledp, "Profile", 30);
	    	

	    	eventUtils.waitUntilElememtIsClickable(driver, Us.ProfileOption, 30);
	    	eventUtils.clickOnElement(driver, Us.ProfileOption, "Profileoption", 30);
	    	
	    	logStatus("info", "user enter valid credentials, and filed accept the values");
	    }
	    else {
	    	logStatus("error", "user not enter valid credentials, and filed not accept the values");
	    }
	}

	@And("^Click on the save button$")
	public void click_on_the_save_button() {
	    createNode("Then", "User lands on manage user page");
	  
	    if(eventUtils.waitUntilElementIsPresent(driver, Us.Save, 30)) {
			  eventUtils.clickOnElement(driver, Us.Save, "Save",30);
			  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			  wait.until(ExpectedConditions.urlToBe("https://qa.testserv.ai/User/ManageUsers"));

			  String  actualURI = driver.getCurrentUrl();
			  if (actualURI.equals("https://qa.testserv.ai/User/ManageUsers")) {
			      logStatus("info", "Navigated to the Manage User page successfully. Toast message displayed");
			  } else {
			      logStatus("error", "Failed to navigate to the Manage User page. Toast message not displayed");
			  }
	    }

	  }
//edit User
@And("^Click on edit icon update$")
public void click_on_edit_icon_update() {
	
	createNode("And", "User updated sucssfully");
	
	eventUtils.waitUntilElementIsPresent(driver, Us.EditIcon, 20);
	eventUtils.clickOnElement(driver, Us.EditIcon, "Edit", 20);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.urlContains("https://qa.testserv.ai/User/ModifyUser"));

	String ActualUrl=driver.getCurrentUrl();
	String currentUrl = driver.getCurrentUrl();
	if (currentUrl.startsWith("https://qa.testserv.ai/User/ModifyUser")) {
	

		logStatus("info", "User lands on the modify users page");
	}
	else {
		logStatus("error", "Users fails to lands on the modify user page");
	}
	String First=utilities.generateRandomname();
	String Last=utilities.generateRandomDescription();
	if(eventUtils.waitUntilElementIsPresent(driver, Us.FirstName, 20)) {
	eventUtils.enterValue(driver, Us.FirstName, First, "Random name",20, test);
	
	eventUtils.waitUntilElementIsPresent(driver, Us.LastName, 20);
	eventUtils.enterValue(driver, Us.LastName, Last, "Random name",20, test);
	
	eventUtils.waitUntilElementIsPresent(driver, Us.SelectRole, 20);
	eventUtils.clickOnElement(driver, Us.SelectRole, "Client", 20);
	
	eventUtils.waitUntilElementIsPresent(driver, Us.Client, 20);
	eventUtils.clickOnElement(driver, Us.Client, "ClientName", 20);
	
	eventUtils.waitUntilElementIsPresent(driver, Us.Update, 20);
	eventUtils.clickOnElement(driver, Us.Update, "Updatebutton", 20);
	
	logStatus("info","Sucssfull Toast message is displayed along with manage user page");
	}
	else {
		logStatus("error", "error Toast message is displayed");
		
	}
	
}
//VIEW USERS 
@Then("^Click on view icon see the details$")
public void click_on_view_icon_see_the_details() {
	createNode("Then", "users see the users details");
	eventUtils.waitUntilElementIsPresent(driver, Us.ViewIcon, 20);
	eventUtils.clickOnElement(driver, Us.ViewIcon, "View Icon", 20);
	WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(20));
	w.until(ExpectedConditions.urlContains("https://qa.testserv.ai/User/UserDetailsView"));
	String A=driver.getCurrentUrl();
	if (A.startsWith("https://qa.testserv.ai/User/UserDetailsView") && eventUtils.waitUntilElementIsVisible(driver, Us.Back, 20)) {
	    eventUtils.clickOnElement(driver, Us.Back, "Backbutton", 20);
		logStatus("info", "User lands on the manage users page");
	}

	
	else {
		logStatus("error", "users fails to lands on the mange users page");
	}
	if(eventUtils.waitUntilElementIsPresent(driver, Us.Delete, 20)) {
		eventUtils.clickOnElement(driver, Us.Delete, "DeleteIcon", 20);
		logStatus("info", "Are you sure delete this users pop up? is displayed");
		eventUtils.waitUntilElementIsPresent(driver, Us.DeleteButton, 20);
		eventUtils.clickOnElement(driver, Us.DeleteButton, "DeleteButton", 20);
		logStatus("info", "User Deleted succssfully toast message is displayed");
	}
	else {
		logStatus("error", "error toast message is displayed");
	}
	
}
	
	@After("@User")
	public void teardown() {
		
		try {
				killBrowser();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	}



