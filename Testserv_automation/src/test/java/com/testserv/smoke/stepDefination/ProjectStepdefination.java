package com.testserv.smoke.stepDefination;

import java.io.IOException;

import org.testng.asserts.SoftAssert;

import com.testserv.smoke.pages.ProjectSmokePage;
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

public class ProjectStepdefination extends BaseTest {
	EventUtils eventUtils;
	LoginPage loginPage;
	HomePage homePage;
	CompanyPage comp;
	ProjectSmokePage pro;
	SoftAssert softAssert;
	Utilities utilities;
	
	@Before("@Project")
	
	public void setUp(Scenario scenario) {
		String scenarioName = getScenario(scenario);
		createTest(scenarioName);
		System.out.println("Launching the Application");
		launchApplication();

		loginPage = new LoginPage(driver);
		eventUtils = new EventUtils();
		homePage = new HomePage(driver);
		comp=new CompanyPage(driver);
	    pro=new ProjectSmokePage(driver);
		softAssert = new SoftAssert();
		utilities = new Utilities();
	}
	@Given("Launch the browser enter test url")
	public void Launch_the_browser_enter_test_url()throws Throwable{
	    createNode("Given", "users will launch the browser and enter the url");
	    String ExpectedUrl="https://qa.testserv.ai/";
	    String actaulurl=driver.getCurrentUrl();
	    if(ExpectedUrl.equals(actaulurl)) {
	    	logStatus("info", "users lands on loginpage");
	    }
	    else {
	    	logStatus("error", "users fails to lands on loginpage");
	    }
	}

	@When("Enter username and password and click on login button home page should displayed")
	public void enter_username_and_password_and_click_on_login_button_home_page_should_displayed()  throws Throwable{
		createNode("When", "users lands on homepage");
	    String username=utilities.getCredentialsFromPropertyFile("SmokeCompanyadminUsername");
	    String Password=utilities.getCredentialsFromPropertyFile("SmokeCompanyadminPassword");
	    if(eventUtils.waitUntilElementIsPresent(driver, loginPage.userName_field, 10)) {
	    	eventUtils.enterValue(driver, loginPage.userName_field, username, "Usernamefield", 10, test);
	    	logStatus("info", "usersname field accept the username");
	    }
	    else {
	    	logStatus("error", "usernamefield not accept");
	    }
	    if(eventUtils.waitUntilElementIsPresent(driver, loginPage.password_field, 10)) {
	    	eventUtils.enterValue(driver, loginPage.password_field, Password, "Password", 10, test);
	    	logStatus("info", "password field accept the username");
	    }
	    else {
	    	logStatus("error", "password field not accept");
	    }
	    if(eventUtils.waitUntilElementIsPresent(driver, loginPage.loginButton, 10)) {
	    	eventUtils.clickOnElement(driver, loginPage.loginButton, "loginbutton", 10);
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


@And("Click on project button index page displayed")
public void click_on_project_button_index_page_displayed()throws Throwable {
	    createNode("Then", "users lands on index page");
	    if(eventUtils.waitUntilElementIsPresent(driver, pro.projectmodule, 10))
	    {
	    	eventUtils.clickOnElement(driver, pro.projectmodule, "Projectbutton", 10);
	    	String expectedUrl="https://qa.testserv.ai/Project/Index";
	    	String ActualURL=driver.getCurrentUrl();
	    	if(expectedUrl.equals(ActualURL))
	    	{
	    		logStatus("info", "User land on index page");
	    	}
	    	else {
	    		logStatus("error", "User not able to lands on index page");
	    	}
	    }
	}

@And("Click on create new project button the create project pop up displayed")
public void Click_on_create_new_project_button_the_create_project_pop_up_displayed()throws Throwable {
	    createNode("When", "User land on create new project pop up");
	    if(eventUtils.waitUntilElementIsPresent(driver, pro.createnewProject, 10)) {
	    	eventUtils.clickOnElement(driver, pro.createnewProject, "Create New Project Button", 10);
	    	logStatus("info", "users will lands on create new project pop up");
	    	}
	    else {
	    	logStatus("error", "users fails lands on create new project pop up");
	    }
	}

@And("Enter project name and select checkboxes")
public void enter_project_name_and_select_checkboxes() throws Throwable{
	    createNode("Then", "Users able to enetr projectname");
	    String projectname=utilities.generateRandomProjectName();
	    if(eventUtils.waitUntilElementIsPresent(driver, pro.projectName, 10)) {
	    	eventUtils.enterValue(driver, pro.projectName, projectname, "projectname", 10, test);
	    	logStatus("info", "Project should be accept");
	    }
	    else {
	    	logStatus("error", "project name filed should not accept the project name");
	    }
	    if(eventUtils.waitUntilElementIsPresent(driver, pro.checkbox, 10)) {
	    	eventUtils.clickOnElement(driver, pro.checkbox, "API automation checkbox", 10);
	    	logStatus("info", "User select the APi automation checkbox");
	    }
	    else
	    {
	    	logStatus("error", "User are not able to sleect the api automation checkbox");
	    }
	    if(eventUtils.waitUntilElementIsPresent(driver, pro.savebutton, 10)) {
	    	eventUtils.clickOnElement(driver, pro.savebutton, "Savebutton", 10);
	    	logStatus("info", "users click on the save button");
	    }
	    else {
	    	logStatus("error", "users are not able to click on savebutton");
	    }
	}

@And("Click on save button toast message will appear navigates to the index page")
public void click_on_save_button_toast_message_will_appear_navigates_to_the_index_page()throws Throwable {
	    createNode("And", "Users will see the sucssfull toast message");
	    String EXPECTEDURL="https://qa.testserv.ai/Project/Index";
	    String ACTUALURL=driver.getCurrentUrl();
	    if(EXPECTEDURL.equals(ACTUALURL)) {
	    	logStatus("info","Sucssfully users create the project");
	    }
	    else {
	    	logStatus("error","Error message will appears");
	    }
	    eventUtils.waitUntilElementIsPresent(driver,pro.AddUser, 20);
	    eventUtils.clickOnElement(driver, pro.AddUser, "Adduser Icon", 20);
	     eventUtils.waitUntilElementIsPresent(driver, pro.AddUserCheckbox, 20);
	     eventUtils.clickOnElement(driver, pro.AddUserCheckbox, "Checkbox", 20);
	     eventUtils.waitUntilElementIsPresent(driver, pro.AssignUsers, 20);
	     eventUtils.clickOnElement(driver, pro.AssignUsers, "Users", 20);
	     
	     
	}
@And("^Click on edit icon edit the project$")
public void  click_on_edit_icon_edit_the_project() {
	createNode("Then", "User edit the project sucssfully");
	String edit=utilities.generateRandomProjectName();
	if(eventUtils.waitUntilElementIsPresent(driver, pro.Editicon, 20)) {
		eventUtils.clickOnElement(driver, pro.Editicon, "edit icon", 20);
		 eventUtils.waitUntilElementIsPresent(driver, pro.Editprojectname, 20);
		 eventUtils.enterValue(driver, pro.Editprojectname, edit, "Random Name", 20, test);
		 eventUtils.waitUntilElementIsPresent(driver, pro.Update, 20);
				eventUtils.clickOnElement(driver, pro.Update, "update button", 20);
		 logStatus("info", "Users edit project name sucssfully");
		 }
	else
	{
		logStatus("error", "Users fails to edit project name sucssfully");
	}
}
@Then("^Click on projectId details icon and deleteicon$")
public void click_on_projectId_details_icon_and_deleteicon() {
	createNode("Then", "User are see the project id details and they deleted the projects");
	if(eventUtils.waitUntilElementIsPresent(driver, pro.ProjectID, 20)) {
		eventUtils.clickOnElement(driver, pro.ProjectID, "ProjectID", 20);
		
		eventUtils.waitUntilElementIsPresent(driver, pro.CloseIcon, 20);
		eventUtils.clickOnElement(driver, pro.CloseIcon, "Close pop up", 20);
		
		eventUtils.waitUntilElementIsPresent(driver, pro.Delete, 20);
		eventUtils.clickOnElement(driver, pro.Delete, "DeleteIcon", 20);
		
		eventUtils.waitUntilElementIsPresent(driver, pro.DeleteButton, 20);
		eventUtils.clickOnElement(driver, pro.DeleteButton, "Deletebutton", 20);
		
		logStatus("info", "The project deleted sucssfully");
	}
	else
	{
		logStatus("error", "Error toast message is displayed");
	}
}
@After("@Project")
public void teardown() {
	
	try {
			killBrowser();
		} catch (IOException e) {
			e.printStackTrace();
		}
}


}

	
	
	
	
	
	

