package com.testserv.smoke.stepDefination;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.testserv.smoke.pages.ProfileSmokePage;
import com.testserve.pages.APIEnvironmentPage;
import com.testserve.pages.APInewRunReportPage;
import com.testserve.pages.CompanyPage;
import com.testserve.pages.FileUploadUtils;
import com.testserve.pages.HomePage;
import com.testserve.pages.LoginPage;
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

public class ProfileUserInfoStep extends BaseTest
{

	EventUtils eventUtils;
	LoginPage loginPage;
	HomePage homePage;
	CompanyPage comp;
	Project pro;
	APIEnvironmentPage API;
	UserPage Us;
	APInewRunReportPage Run;
	ProfileSmokePage Prof;
	SoftAssert softAssert;
	Utilities utilities;

	
	@Before("@ProfileUserinfo")
	
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
		  Prof=new ProfileSmokePage(driver);
		softAssert = new SoftAssert();
		utilities = new Utilities();
}
	

	@Given("^Login to the application by entering valid credentials$")
	public void login_to_the_application_by_entering_valid_credentials() {
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
	    
		
		
	
	@When("^Click on the profile button$")
	public void click_on_the_profile_button() {
		 createNode("When", "Users lands on profile page");
		 if(eventUtils.waitUntilElementIsPresent(driver, Prof.Profile, 20)) {
			 eventUtils.clickOnElement(driver, Prof.Profile, "Profile Button", 20);
			 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			 wait.until(ExpectedConditions.urlToBe("https://qa.testserv.ai/Profile/ManageProfiles"));
			 String ActualURL=driver.getCurrentUrl();
			 if(ActualURL.equals("https://qa.testserv.ai/Profile/ManageProfiles")) {
				 logStatus("info", "User lands on manage profile page");
			 }
			 else {
				 logStatus("error", "Users fails to lands on profile page");
			 }
		 }
	}
	
@And("^Click on the create new profile button$")
public void click_on_the_create_new_profile_button() {
	createNode("And", "The profile created succssfully");
	eventUtils.waitUntilElementIsPresent(driver, Prof.CreateNewProfile, 20);
	eventUtils.clickOnElement(driver, Prof.CreateNewProfile, "Create Profile", 20);
	WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(20));
	w.until(ExpectedConditions.urlToBe("https://qa.testserv.ai/Profile/EnrollProfile"));
String	url=driver.getCurrentUrl();
if(url.equals("https://qa.testserv.ai/Profile/EnrollProfile")) {
	logStatus("info", "users lands on the create profile page");
}
else {
	logStatus("error", "users fails to lands on the create profile page");
}
         String Profilename=utilities.generateRandomProfileName();
         String Desc=utilities.generateRandomDescription();
eventUtils.waitUntilElementIsPresent(driver, Prof.ProfileName, 20);
eventUtils.enterValue(driver, Prof.ProfileName, Profilename, "RandomName", 20, test);

eventUtils.waitUntilElementIsPresent(driver, Prof.APITesting, 20);
eventUtils.clickOnElement(driver, Prof.APITesting, "API Checkbox", 20);

eventUtils.waitUntilElementIsPresent(driver, Prof.Project, 20);
eventUtils.clickOnElement(driver, Prof.Project, "ProjectCheckBox", 20); 
eventUtils.waitUntilElementIsPresent(driver, Prof.Feedback, 20);
eventUtils.clickOnElement(driver, Prof.Feedback, "Feedback", 20); 

eventUtils.waitUntilElementIsPresent(driver, Prof.ProfileName, 20);
eventUtils.enterValue(driver, Prof.Des, Desc, "RandomName", 20, test);





}
@And("^Click on save button the succssfully message and manage profile page displayed$")
public void click_on_save_button_the_succssfully_message_and_manage_profile_page_displayed() {
	createNode("Then", "User profile created succssfully");
	eventUtils.waitUntilElementIsPresent(driver, Prof.SaveProfile, 20);
	eventUtils.clickOnElement(driver, Prof.SaveProfile, "SaveProfile", 20); 
	
	WebDriverWait wa=new WebDriverWait(driver, Duration.ofSeconds(20));
	wa.until(ExpectedConditions.urlToBe("https://qa.testserv.ai/Profile/ManageProfiles"));
	 String Act=driver.getCurrentUrl();
	 if(Act.equals("https://qa.testserv.ai/Profile/ManageProfiles")) {
		 logStatus("info", "The manage profile page is displayed and profile created succssfully toast message is displayed");
	 }
	 else {
		 logStatus("error", "The manage profile page is not displayed and profile created succssfully toast message not displayed");
	 }
}
@And("^Click on edit icon update the profile$")
public void click_on_edit_icon_update_the_profile() {
	createNode("And", "Users Update the profile sucssfully");
	String prof=utilities.generateRandomProfileName();
	String Description=utilities.generateRandomDescription();
	eventUtils.waitUntilElementIsPresent(driver, Prof.EditIcon, 20);
	eventUtils.clickOnElement(driver, Prof.EditIcon, "editprofile", 20);
	WebDriverWait wa=new WebDriverWait(driver, Duration.ofSeconds(20));
	wa.until(ExpectedConditions.urlContains("https://qa.testserv.ai/Profile/ModifyProfile"));
	String Ac=driver.getCurrentUrl();
	if(Ac.startsWith("https://qa.testserv.ai/Profile/ModifyProfile")) {
		logStatus("info", "Users lands on edit profile page");
	}
	else {
		logStatus("error", "users fails to lands on edit profile page");
	}
	if(eventUtils.waitUntilElementIsPresent(driver, Prof.ProfileName, 20)) {
		eventUtils.enterValue(driver, Prof.ProfileName, prof, "RandomName", 20, test);
		eventUtils.waitUntilElementIsPresent(driver, Prof.Des, 20);
		eventUtils.enterValue(driver, Prof.Des, Description, "Description", 20, test);
		eventUtils.waitUntilElementIsPresent(driver, Prof.Update, 20);
		eventUtils.clickOnElement(driver, Prof.Update, "UpdateButton", 20);
		logStatus("info", "Sucssfull toast message is displayed and it navigates to the manage profile page");
		}
	else
	{
		logStatus("error", "error toast message is displayed and it fails to navigates to the manage profile page");
	}
	
	
	
}
@And("^Click on profile image and upload the image$")
public void click_on_profile_image_and_upload_the_image() throws Exception {
    createNode("Then", "User uploaded image successfully");
    eventUtils.waitUntilElementIsPresent(driver, comp.logo, 20);
    eventUtils.mouseHoverToElement(driver, comp.logo, 20, test);
    
    if(eventUtils.waitUntilElementIsPresent(driver, Prof.ProfileImage, 30)) {
        eventUtils.clickOnElement(driver, Prof.ProfileImage, "Image click", 30);
        
        WebDriverWait wa = new WebDriverWait(driver, Duration.ofSeconds(20));
        wa.until(ExpectedConditions.urlToBe("https://qa.testserv.ai/userinfo/Userinfo"));
        String Actual = driver.getCurrentUrl();
        
        if(Actual.equals("https://qa.testserv.ai/userinfo/Userinfo")) {
            logStatus("info", "User lands on the user info page");
        } else {
            logStatus("error", "User fails to land on the info page");
        }
        
       eventUtils.waitUntilElementIsPresent(driver, Prof.CameraIcon, 20);
        eventUtils.clickOnElement(driver, Prof.CameraIcon, "camera", 20);
        
        
      
        
      eventUtils.waitUntilElementIsPresent(driver, Prof.Browse, 20);
      String uploadvalue = utilities.getCredentialsFromPropertyFile("path");
            eventUtils.clickOnElement(driver, Prof.Browse, "Browse", 20);
        	FileUploadUtils.uploadFile(uploadvalue);
        	
        	
        	eventUtils.waitUntilElementIsPresent(driver, Prof.Updatebutton, 20);
        	eventUtils.clickOnElement(driver, Prof.Updatebutton, "Update",20);
        	
        	logStatus("info", "User upload the image sucssfully");
            
       
    }
    else
    {
    	logStatus("error", "User fail to upload the image sucssfully");
    }
}

@Then("^Click on update password button update the password$")
public void click_on_update_password_button_update_the_password() {
	createNode("Then", "User update the password sucssfully");
String pass=utilities.generateRandomPassword();
String Confirm=utilities.generateRandomConfirmPassword();
String old=utilities.getCredentialsFromPropertyFile("CompanyadminPassword");

	if(eventUtils.waitUntilElementIsPresent(driver, Prof.EditPassword, 20)) {
		eventUtils.clickOnElement(driver, Prof.EditPassword, "Editpassword", 20);
		eventUtils.waitUntilElementIsPresent(driver, Prof.oldPassword, 20);
		eventUtils.enterValue(driver, Prof.oldPassword, old, "Pasword", 20, test);
		
		eventUtils.waitUntilElementIsPresent(driver, Prof.NewPassword, 20);
		eventUtils.enterValue(driver, Prof.NewPassword, pass, "Randompassword", 20, test);
		
		eventUtils.waitUntilElementIsPresent(driver, Prof.ConfirmPasword, 20);
		eventUtils.enterValue(driver, Prof.ConfirmPasword, Confirm, "Random", 20, test);
		
		logStatus("info", "password updated sucssfully toast message is displayed");
	}
	else
	{
		logStatus("error", "Error toast message is displayed");
	}
}


        
@After("@ProfileUserinfo")
public void teardown() {
	
	try {
			killBrowser();
		} catch (IOException e) {
			e.printStackTrace();
	}
}
}






	
	

