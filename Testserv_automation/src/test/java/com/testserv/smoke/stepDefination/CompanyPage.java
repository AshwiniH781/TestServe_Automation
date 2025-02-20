package com.testserv.smoke.stepDefination;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.testserv.smoke.pages.CompanyPageSmoke;
import com.testserve.pages.HomePage;
import com.testserve.pages.LoginPage;
import com.testserve.pages.ProfilePage;
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

public class CompanyPage extends BaseTest{


	EventUtils eventUtils;
	LoginPage loginPage;
	HomePage homePage;
	CompanyPageSmoke comp;
	ProfilePage Prof;
	SoftAssert softAssert;
	Utilities utilities;
	
	@Before("@company")
	
	public void setUp(Scenario scenario) {
		String scenarioName = getScenario(scenario);
		createTest(scenarioName);
		System.out.println("Launching the Application");
		launchApplication();

		loginPage = new LoginPage(driver);
		eventUtils = new EventUtils();
		homePage = new HomePage(driver);
	  comp=new CompanyPageSmoke(driver);
		Prof=new ProfilePage(driver);
		softAssert = new SoftAssert();
		utilities = new Utilities();
	}
	@Given("launch the browser login to the application")
	public void launch_the_browser_login_to_the_application() throws Throwable {
	    createNode("given", "Users are able to launch the browser");

	    String userName = utilities.getCredentialsFromPropertyFile("SuperadminUserName");
	    String password = utilities.getCredentialsFromPropertyFile("SuperadminPassword");

	    if (eventUtils.waitUntilElementIsPresent(driver, loginPage.loginPage, 10)) {
	    	String expectedurl="https://qa.testserv.ai/";
	    	String Ctualurl=driver.getCurrentUrl();
	    	if(expectedurl.equals(Ctualurl)) {
	    		logStatus("info","users lands on login page");
	    		}
	    	else
	    	{
	    		logStatus("error", "users will not land on loginpage");
	    	}
	    }
	    	if (eventUtils.waitUntilElementIsVisible(driver, loginPage.userName_field, 10)){
				eventUtils.enterValue(driver, loginPage.userName_field, userName, "Username field", 10, test);
				logStatus("info", "users will enter the username");
	    	}
	    	else {
	    		logStatus("error", "users will not enter username");
	    	
	    }
	    	if(eventUtils.waitUntilElementIsPresent(driver, loginPage.password_field, 10)) {
	    		eventUtils.enterValue(driver, loginPage.password_field, password, "password", 10, test);
	    		logStatus("info", "the password is enterd");
	    	}
	    	else {
	    		logStatus("error", "password is not enterd");
	    	}
	    	if(eventUtils.waitUntilElementIsPresent(driver, loginPage.loginButton, 10)) {
	    		eventUtils.clickOnElement(driver, loginPage.loginButton, "button", 10);
	    		logStatus("info", "users click on the login button");
	    	}
	    	else {
	    		logStatus("error", "users click not  the login button");
	    	}
	    }
	
	    
 @When("click on testserv logo") 
public void click_on_testserv_logo() throws Throwable {
    createNode("When", "users will click on testserv logo");
    if(eventUtils.waitUntilElementIsPresent(driver, comp.logo, 10)) {
    	eventUtils.mouseHoverToElement(driver, comp.logo, 10, test);
    }
}

@And("click on company button")
public void click_on_company_button() throws Throwable{
    createNode("Then", "click on company button");
    if(eventUtils.waitUntilElementIsPresent(driver, comp.companybutton, 10)){
    	eventUtils.clickOnElement(driver, comp.companybutton, "company", 10);
    String ExpuRll="https://qa.testserv.ai/Company/ManageCompanies";
    String acturl=driver.getCurrentUrl();
    if(ExpuRll.equals(acturl))
    {
    	logStatus("info", "Users are able to click on the company button");
    }
    else
    {
    	logStatus("error", "Users are not able to click on the company button" );
    	softAssert.assertTrue(false, "Verify that users are able to click on the \"Company\" button.");
    }
    }
}

@And("click on create new company button")
public void click_on_create_new_company_button() throws Throwable{
    createNode("Then", "users will click on create new company button");
    String ExpectedUrl="https://qa.testserv.ai/Company/ManageCompanies";
   String actualurl =driver.getCurrentUrl();
   if(ExpectedUrl.equals(actualurl)) {
	   logStatus("info", "users is on managecompanies page");
   }
   else
   {
	   logStatus("error", "users are not in on managecompanies page");
   }
    if(eventUtils.waitUntilElementIsPresent(driver, comp.createnewcompanybutton,10)) {
    	eventUtils.clickOnElement(driver, comp.createnewcompanybutton, "cretenewcompany", 10);
    	logStatus("info", "users will able to click on the create new company button");
    }
    else
    {
    	logStatus("error","users will able to click on the create new company button");
    }
    String expectedUrl="https://qa.testserv.ai/Company/CreateCompanyNew";
    String actualresult=driver.getCurrentUrl();
    if(expectedUrl.equals(actualresult))
    {
    	logStatus("info", "users in the create new company page");
    }
    else
    {
    	logStatus("error", "users not in the create new company page");
    }
}


@And("Enter valid credntials into the create company screen")
public void enter_valid_credntials_into_the_create_company_screen()throws Throwable {
    createNode("When", "enter the valid a credentials into the create new company screen");
String companyname=utilities.generateRandomCompanyName();
String Username=utilities.generateRandomUserName();
String Email=utilities.generateEmailid();
String pass=utilities.generateRandomPassword();

if(eventUtils.waitUntilElementIsPresent(driver, comp.companynamefiled,20)) {
	eventUtils.enterValue(driver, comp.companynamefiled, companyname,"companyname", 20, test);
logStatus("info", "users are able to enter the credentials into the create company screen");
}
else{
}
if(eventUtils.waitUntilElementIsPresent(driver, comp.usernamefield, 20)) {
	eventUtils.enterValue(driver, comp.usernamefield, Username, "usernamefield", 20, test);
	logStatus("info", "users enter the username");
}
else
{
	logStatus("error", "users will not enter the username");
}
if(eventUtils.waitUntilElementIsPresent(driver, comp.passwordfield, 20)) {
	eventUtils.enterValue(driver, comp.passwordfield, pass, "password", 20, test);
	logStatus("info", "users enter the passwordfield");
}
else
{
	logStatus("error", "users will not enter the passwordfield");
}
if(eventUtils.waitUntilElementIsPresent(driver, comp.emailidfield, 20)) {
	eventUtils.enterValue(driver, comp.emailidfield, Email, "emailidfield", 20, test);
	logStatus("info", "users enter the email");
}
else
{
	logStatus("error", "users will not enter the email");
}
}


@And("click on the save button")
public void click_on_the_save_button() throws Throwable {
    createNode("Then", "users click on save button");
    if(eventUtils.waitUntilElementIsVisible(driver, comp.savebutton, 20)){
    	eventUtils.clickOnElement(driver, comp.savebutton, "Createcompanysave", 20);
    	logStatus("info", "users will click on save button");
    }
    else
    {
    	logStatus("error", "users will not able to click on the save button");
    }
    
}

@And("Enter valid credentias into the profile screen")
public void enter_valid_credentias_into_the_profile_screen() {
    createNode("when", "users land on the create profile screen");
    String profilename=utilities.generateRandomProfileName();
    String descrip=utilities.generateRandomDescription();
    if(eventUtils.waitUntilElementIsPresent(driver, comp.profilefield,20)) {
    	eventUtils.enterValue(driver, comp.profilefield, profilename,"Profilename", 20, test);
    	logStatus("info", "users enter the profile name");
    }
    else {
    	logStatus("error", "users cant able to enter the profile name");
    }
    if(eventUtils.waitUntilElementIsPresent(driver, comp.descriptionprofile, 20)) {
    	eventUtils.enterValue(driver, comp.descriptionprofile, descrip, "Description", 20, mainTest);
    logStatus("info","users will enter the profile name");
    }
    else
    {
    	logStatus("error", "users are not able to enter the description");
    }
    if(eventUtils.waitUntilElementIsPresent(driver, comp.Assignmodule, 20)) {
    	eventUtils.clickOnElement(driver, comp.Assignmodule, "Checkbox", 20);
    	eventUtils.clickOnElement(driver, comp.projectbutton, "projectcheckbox", 20);
    	eventUtils.clickOnElement(driver, comp.usercheckbox, "usercheckbox", 20);
    	eventUtils.clickOnElement(driver, comp.profilecheckbox, "Profile", 20);
    	logStatus("info", "users are able to check the assign module");
    }
    else
    {
    	logStatus("error","usser are not able to click on the assign module checkbox");
    }
}

@And("Click on save button")
public void click_on_save_button() throws Throwable {
    createNode("Then", "users are able to click on the save button");
    if(eventUtils.waitUntilElementIsPresent(driver, comp.savebuttonprofile, 20)) {
    	eventUtils.clickOnElement(driver, comp.savebuttonprofile, "Savebutton",20);
    	logStatus("info","users will click on save&Next button");
    }
    else
    {
    	logStatus("error", "users will not able to click on the save&next button");
    }
}

@And("Enter valid credentials into the create credit screen")
public void enter_valid_credentials_into_the_create_credit_screen() {
    createNode("When", "users lands on the create credit page");
    String creditname=utilities.generateRandomCreditName();
    String des=utilities.generateRandomDescription();
    String Apinewrun=utilities.generateNo();
    String user=utilities.generateNo();
    String dashboardlimit=utilities.generateNo();
    String excessAPI=utilities.generateNo();
    
    //String creditexpiry=utilities.getCredentialsFromPropertyFile("expirydate");
    if(eventUtils.waitUntilElementIsPresent(driver, comp.creditnamefield, 20)) {
    	eventUtils.enterValue(driver, comp.creditnamefield, creditname, "creditnamefield", 20, test);
    	logStatus("info","users enter the creditname");
    }
    else {
    	logStatus("error", "users are not able to enter the credit name");
    }
    if(eventUtils.waitUntilElementIsPresent(driver, comp.creditdescription, 20)) {
    	eventUtils.enterValue(driver, comp.creditdescription, des, "creditdescription", 20, test);
    	logStatus("info", "users enter the description");
    }
    else
    {
    	logStatus("error", "users will not enter the description");
    }
    if(eventUtils.waitUntilElementIsPresent(driver, comp.LicensedAPIRuns, 20)) {
    	
    	eventUtils.enterValue(driver, comp.LicensedAPIRuns, Apinewrun, "Licensed_API_Runs", 20, test);
    	logStatus("info", "users will enter the api new run limit");
    }
    else
    {
    	logStatus("error", "users will enter the api new run limit");
    }
    if(eventUtils.waitUntilElementIsPresent(driver, comp.LicensedUsers, 20)) {
    	eventUtils.enterValue(driver, comp.LicensedUsers, user, "User_limit", 20, test);
    	logStatus("info", "users will enter the userlimit");
    }
    else
    {
    	logStatus("error", "users will not enter the userlimit");
    }
    if(eventUtils.waitUntilElementIsPresent(driver, comp.dashboardusage, 20)) {
    	eventUtils.enterValue(driver, comp.dashboardusage, dashboardlimit, "dashboardusagelimit", 20, test);
    	logStatus("info", "users will enter the dashboardusage");
    }
    else
    {
    	logStatus("error", "users will not enter the dashboardusage");
    }
    if(eventUtils.waitUntilElementIsPresent(driver, comp.excessapinewrun, 20)) {
    	eventUtils.enterValue(driver, comp.excessapinewrun, excessAPI, "excessapinewrun", 20, test);
    	logStatus("info", "users will enter the excessapinewrun");
    }
    else
    {
    	logStatus("error", "users will not enter the excessapinewrun");
    }
    if(eventUtils.waitUntilElementIsPresent(driver, comp.creditexpirydata, 20)) {
    	eventUtils.clickOnElement(driver, comp.creditexpirydata, "expiry", 20);
    	eventUtils.clickOnElement(driver, comp.creditexpirydata, " credit Expiry date", 20, test);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('validTill').value = '2025-10-15'");
    	logStatus("info", "users will enter the creditexpirydata");
    }
    else
    {
    	logStatus("error", "users will not enter the creditexpirydata");
    }
}

@And("Click on the create button and click on information icon")
public void click_on_the_create_button_and_click_on_information_icon()throws Throwable {
    createNode("then", "users will land on the managecompaniespage and toast messgae will appears");
    if(eventUtils.waitUntilElementIsPresent(driver, comp.createbutton, 10)) {
    	eventUtils.clickOnElement(driver, comp.createbutton, "createbutton", 10);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.urlToBe("https://qa.testserv.ai/Company/ManageCompanies"));

		  String actualurl=driver.getCurrentUrl();
    	if(actualurl.equals("https://qa.testserv.ai/Company/ManageCompanies"))
    		
    	logStatus("info", "The manage companies page displayed and company created sucssfull toast message is displayed");
    }
    else
    {
    	logStatus("error", "The manage companies page not displayed and company created sucssfull toast message is not displayed");
    }
    //AI Genartion Acess
   if(eventUtils.waitUntilElementIsPresent(driver, comp.TestData, 20)){
    eventUtils.clickOnElement(driver, comp.TestData, "AI Option", 20, test);
    eventUtils.waitUntilElementIsPresent(driver, comp.AIGenartion, 20);
    eventUtils.clickOnElement(driver, comp.AIGenartion, "AI test Data", 20);
    eventUtils.waitUntilElementIsPresent(driver, comp.Sumbit, 20);
    eventUtils.clickOnElement(driver, comp.Sumbit, "Submit button", 20);
    logStatus("info", "The succssfull toast message is displayed");
}
   else
   {
	   logStatus("error", "error toast message is displayed");
	   
   }
}
//Edit Company
@And("^Click on edit icon update the company$")
public void click_on_edit_icon_update_the_company()
{
	createNode("And", "User updated the company successfully");
	String Company=utilities.generateRandomCompanyName();
	String user=utilities.generateRandomUserName();
	String profile=utilities.generateRandomProfileName();
	String Credit=utilities.generateRandomCreditName();
	if(eventUtils.waitUntilElementIsPresent(driver, comp.EditIcon, 20)) {
		eventUtils.clickOnElement(driver, comp.EditIcon, "ediicon", 20);
	eventUtils.waitUntilElementIsPresent(driver, comp.companynamefiled, 20);
	eventUtils.enterValue(driver, comp.companynamefiled, Company, "Random Name", 20, test);
	
	eventUtils.waitUntilElementIsPresent(driver, comp.usernamefield, 20);
	eventUtils.enterValue(driver, comp.usernamefield, user, "Random userName", 20, test);
	
	eventUtils.waitUntilElementIsPresent(driver, comp.savebutton, 20);
	eventUtils.ClickOnElement(driver, comp.savebutton, "edit Save", 20, test);
	
	eventUtils.waitUntilElementIsPresent(driver, comp.profilefield, 20);
	eventUtils.enterValue(driver, comp.profilefield, profile, "Random profilefield", 20, test);
	 
	eventUtils.waitUntilElementIsPresent(driver, comp.savebuttonprofile, 20);
	eventUtils.ClickOnElement(driver, comp.savebuttonprofile, "edit profile Save", 20, test);
	
	eventUtils.waitUntilElementIsPresent(driver, comp.creditnamefield, 20);
	eventUtils.enterValue(driver, comp.creditnamefield, Credit, "Random Credit", 20, test);
	 
	eventUtils.waitUntilElementIsPresent(driver, comp.Update, 20);
	eventUtils.ClickOnElement(driver, comp.Update, "Update", 20, test);
	
	logStatus("info", "The manage companies page displayed and company edit sucssfull toast message is displayed");
	
	}
else
{
	logStatus("error", "The manage companies page displayed and error toast message is displayed");
}


}
//view company details
@And("^Click on view icon$")
public void click_on_view_icon() {
	createNode("And", "User will see the company deatils" );
	if(eventUtils.waitUntilElementIsPresent(driver, comp.ViewIcon, 20)) {
		eventUtils.clickOnElement(driver, comp.ViewIcon, "View", 20);
		//WebDriverWait wa=new WebDriverWait(driver, Duration.ofSeconds(20));
		//wa.until(ExpectedConditions.urlToBe("https://qa.testserv.ai/Company/ViewCompanyNew?id=MDQxNWMxNDItM2NlZC00N2RiLThkMDItYTIxMGE1YzRkNWNl"));
				//String ACTUALURL=driver.getCurrentUrl();
				//if(ACTUALURL.equals("https://qa.testserv.ai/Company/ViewCompanyNew?id=MDQxNWMxNDItM2NlZC00N2RiLThkMDItYTIxMGE1YzRkNWNl")) {
					//logStatus("info", "View Company detials page is displayed");
	//}
				//else
				//{
					//logStatus("error", "Fails to lands on the view company page");
				//}
				
				eventUtils.waitUntilElementIsPresent(driver, comp.NextButton, 30);
				eventUtils.clickOnElement(driver, comp.NextButton, "NextButton", 30);
				
				eventUtils.waitUntilElementIsPresent(driver, comp.ProfileNext, 20);
				eventUtils.clickOnElement(driver, comp.ProfileNext, "Next", 20);
				
				eventUtils.waitUntilElementIsPresent(driver, comp.Back, 20);
				eventUtils.clickOnElement(driver, comp.Back, "BackButton", 20);
				
				
				logStatus("info", "Users lands on the manage companies page");
}
	else
	{
		logStatus("error", "Users fails to lands on manage companies page");
	}
}
    
@Then("Click on profile and credit button")
public void click_on_profile_and_credit_button() throws Throwable {
    
   {
	   createNode("Then", "User clik the profile users and credit buttons");
	   eventUtils.waitUntilElementIsPresent(driver, Prof.Profile,10);
	   eventUtils.waitUntilElementIsPresent(driver, comp.logo, 20);
		  eventUtils.mouseHoverToElement(driver, comp.logo, 20, test);
	   eventUtils.clickOnElement(driver, Prof.Profile, "profile button",20);
	  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	  wait.until(ExpectedConditions.urlToBe("https://qa.testserv.ai/Profile/ManageProfiles"));
	   String currentcurl=driver.getCurrentUrl();
	   if(currentcurl.equals("https://qa.testserv.ai/Profile/ManageProfiles"))
	   {
		   logStatus("info", "users click on profile button and see the profile");
	   }
	   else
	   {
		   logStatus("error", "Users not able to click profile button");
	   }
	  eventUtils.waitUntilElementIsPresent(driver, comp.Credit, 20);
	  eventUtils.waitUntilElementIsPresent(driver, comp.logo, 20);
	  eventUtils.mouseHoverToElement(driver, comp.logo, 20, test);
		   eventUtils.clickOnElement(driver, comp.Credit, "credit button", 20);
		   WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(20));
		   w.until(ExpectedConditions.urlToBe("https://qa.testserv.ai/packages/Index"));
		   String Url=driver.getCurrentUrl();
		   if(Url.equals("https://qa.testserv.ai/packages/Index")) {
			   logStatus("info", "users lands on credit page");
		   }
		   else
		   {
			   logStatus("error", "users fails to lads on the credit page");
		   
		   }
   }
	   
   }

    

@After("@company")
public void tearDown() {
	try {
		killBrowser();
	} catch (IOException e) {
		e.printStackTrace();
	}
}	
}	





