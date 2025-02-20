package com.testserv.smoke.stepDefination;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.testserve.pages.APIEnvironmentPage;
import com.testserve.pages.APInewRunReportPage;
import com.testserve.pages.CompanyPage;
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

public class ModuleStepdefination extends BaseTest{
	EventUtils eventUtils;
	LoginPage loginPage;
	HomePage homePage;
	CompanyPage comp;
	Project pro;
	APIEnvironmentPage API;
	UserPage Us;
	APInewRunReportPage Run;
	ProfilePage Prof;
	 ModulePage module;
	SoftAssert softAssert;
	Utilities utilities;
	
@Before("@Module")
	
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
		softAssert = new SoftAssert();
		utilities = new Utilities();
}
	@Given("^Launch the application login with super admin credentials$")
	public void launch_the_application_login_with_super_admin_credentials() throws Throwable{
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
@And("^Click on Module button and click on create new module button$")
public void click_on_Module_button_and_click_on_create_new_module_button()throws Throwable {
	createNode("info", "User click on the module button and lands on the create new module page");
	eventUtils.waitUntilElementIsPresent(driver, module.Modulebutton, 20);
	eventUtils.clickOnElement(driver, module.Modulebutton, "Module", 20);
	WebDriverWait wa=new WebDriverWait(driver, Duration.ofSeconds(20));
	wa.until(ExpectedConditions.urlToBe("https://qa.testserv.ai/Module/ManageModules"));
	String Act=driver.getCurrentUrl();
	if(Act.equals("https://qa.testserv.ai/Module/ManageModules")) {
		logStatus("info", "users lands on manage module page");
	}
	else {
		logStatus("error", "users fails to lands on manage module page");
	}
	eventUtils.waitUntilElementIsPresent(driver, module.CreateNewModule,20);
	eventUtils.clickOnElement(driver, module.CreateNewModule, "Create Module", 20);
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.urlToBe("https://qa.testserv.ai/Module/CreateModule"));
	String ActURL=driver.getCurrentUrl();
	if(ActURL.equals("https://qa.testserv.ai/Module/CreateModule")) {
		logStatus("info", "Users lands on create module page");
	}
	else {
		logStatus("error", "Users fails to lands on create module page");
	}
}
@And("Enter all valid credentials")
public void enter_all_valid_credentials() throws Throwable {
    createNode("And", "Users enter all valid credentials and all fields accept the values");
    
    String Name = utilities.generateRandomname();
   // String no = utilities.getCredentialsFromPropertyFile("orderId");
    //String Modulepath = utilities.getCredentialsFromPropertyFile("Modulepath");
    //String Desc = utilities.getCredentialsFromPropertyFile("Description");
    //String Icons = utilities.getCredentialsFromPropertyFile("Icon");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    if (eventUtils.waitUntilElementIsPresent(driver, module.ModuleName, 20)) {
        eventUtils.enterValue(driver, module.ModuleName, Name, "RandomName", 20, test);
        logStatus("info", "Entered Module Name");

      eventUtils.waitUntilElementIsPresent(driver, module.OrderId, 20);
        	JavascriptExecutor js = (JavascriptExecutor) driver;
        	js.executeScript("document.getElementById('OrderId').value='5';");

        // Module Path
        eventUtils.waitUntilElementIsPresent(driver, module.ModulePath, 30);
        JavascriptExecutor j1 = (JavascriptExecutor) driver;
    	j1.executeScript("document.getElementById('ModuleURL').value='test/apirun';");
            logStatus("info", "Entered Module Path");
        

        // Description
      eventUtils.waitUntilElementIsPresent(driver, module.Description, 30);
      JavascriptExecutor j2 = (JavascriptExecutor) driver;
  	j2.executeScript("document.getElementById('ModuleDescription').value='test/apirun';");            
  	logStatus("info", "Entered Description");
        

        // Icons
       eventUtils.waitUntilElementIsPresent(driver, module.Icons, 30);
        	JavascriptExecutor j3 = (JavascriptExecutor) driver;
          	j2.executeScript("document.getElementById('Icons').value='icon';");     
        

        // Click Save Button
        if (eventUtils.waitUntilElementIsPresent(driver, module.Save, 30)) {
            eventUtils.ClickOnElement(driver, module.Save, "Savebutton", 30, test);
            logStatus("info", "Clicked on Save button");

            
    } else {
        logStatus("error", "Module Name field not found. Test failed.");
    
}

    }
}

@Then("Click on edit icon edit the module")
public void click_on_edit_icon_edit_the_module() throws Throwable{
createNode("Then", "user edit the module scussfully");
//String ModuleName =utilities.generateRandomname();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
WebElement editIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table//tr[1]//td[5]//a[1]")));
if (editIcon != null) {
editIcon.click();
System.out.println("Clicked on edit icon");
} else {
System.out.println("Edit icon is not clickable");
}

if (eventUtils.waitUntilElementIsPresent(driver, module.ModuleName, 20)) {
JavascriptExecutor j4 = (JavascriptExecutor) driver;

j4.executeScript("document.getElementById('ModuleName').value='Module';");
logStatus("info", "users enter the new name");

eventUtils.waitUntilElementIsPresent(driver, module.UpdateButton, 20);

WebElement updateButton = driver.findElement(By.xpath("//button[.='Update']"));


if (updateButton != null && updateButton.isDisplayed() && updateButton.isEnabled()) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    
    
    js.executeScript("arguments[0].scrollIntoView(true);", updateButton);
    
   
    js.executeScript("arguments[0].click();", updateButton);
    
    logStatus("info", "Update button clicked successfully.");
} else {
    logStatus("error", "Update button is not visible or enabled.");
}
}
if(eventUtils.waitUntilElementIsPresent(driver, module.Delete, 20)) {
eventUtils.clickOnElement(driver, module.Delete, "delete icon", 20);
eventUtils.waitUntilElementIsPresent(driver, module.deleteButton, 20);
eventUtils.clickOnElement(driver, module.deleteButton, "delete button", 20);
logStatus("info", "Module deleted sucssfully");
}

else
{
logStatus("error", "Fail to delete the module");
}

}
@After("@Module")
public void teardown() {

try {
		killBrowser();
	} catch (IOException e) {
	e.printStackTrace();
	}
}
}









	
	

